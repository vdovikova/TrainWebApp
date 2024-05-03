package vdovikova.trainapp.repos.impl;

import lombok.RequiredArgsConstructor;
import vdovikova.trainapp.models.Arriving;
import vdovikova.trainapp.models.Station;
import vdovikova.trainapp.models.Train;
import vdovikova.trainapp.repos.ArrivingRepository;
import vdovikova.trainapp.repos.StationRepository;
import vdovikova.trainapp.repos.database.DatabaseManager;
import vdovikova.trainapp.repos.database.DatabaseManagerImpl;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@RequiredArgsConstructor
public class StationRepositoryImpl implements StationRepository {

    private static StationRepositoryImpl instance;
    private final DatabaseManager dbManager;
    private static ArrivingRepository arrivingRepository = ArrivingRepositoryImpl.getInstance();

    private StationRepositoryImpl() {
        dbManager = DatabaseManagerImpl.getInstance();
    }

    public static StationRepositoryImpl getInstance() {
        if (instance == null)
            instance = new StationRepositoryImpl();
        return instance;
    }

    @Override
    public void add(Station station) {
        String query = "INSERT INTO station (stationname) VALUES ('"+ station.getStationName() + "');";
        dbManager.executeUpdate(query);
    }

    @Override
    public Station getById(Integer id) {
        Station station = null;
        String query = "SELECT * FROM station WHERE idstation = " + id + ";";
        try (ResultSet resultSet = dbManager.executeQuery(query)) {
            resultSet.next();
            station = new Station(Integer.valueOf(resultSet.getString("idstation")),
                    resultSet.getString("stationname"));

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return station;
    }

    @Override
    public List<Station> getAll() {
        List<Station> stations = new ArrayList<>();
        String query = "SELECT * FROM station;";
        try (ResultSet resultSet = dbManager.executeQuery(query)) {
            while (resultSet.next()) {
                int id = resultSet.getInt("idstation");
                String stationName = resultSet.getString("stationname");
                List<Arriving> arrivings = arrivingRepository.getAllByStation(id);
                stations.add(new Station(id, stationName, arrivings));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return stations;
    }

    @Override
    public void update(Station station) {
        String query = "UPDATE station SET stationname = '"+ station.getStationName() +
                "' WHERE idstation = " + station.getId() + ";";
        dbManager.executeUpdate(query);
    }

    @Override
    public void deleteById(Integer id) {
        arrivingRepository.deleteAllByStation(id);
        String query = "DELETE FROM station WHERE idstation = " + id + ";";
        dbManager.executeUpdate(query);
    }

    @Override
    public void deleteAll() {
        arrivingRepository.deleteAll();
        String query = "DELETE FROM station;";
        dbManager.executeUpdate(query);
    }

    @Override
    public List<Station> findAllByTrain(Train train) {
        List<Station> stations = new ArrayList<>();
        String query = "SELECT * FROM station JOIN arriving ON station.idstation = " +
                "arriving.idstation WHERE arriving.idtrain = " + train.getId() + ";";
        try (ResultSet resultSet = dbManager.executeQuery(query)) {
            while (resultSet.next()) {
                stations.add(new Station(Integer.valueOf(resultSet.getString("idstation")),
                        resultSet.getString("stationname")));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return stations;
    }
}
