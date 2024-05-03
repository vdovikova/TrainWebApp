package vdovikova.trainapp.repos.impl;

import vdovikova.trainapp.models.Arriving;
import vdovikova.trainapp.models.ArrivingComparator;
import vdovikova.trainapp.repos.ArrivingRepository;
import vdovikova.trainapp.repos.StationRepository;
import vdovikova.trainapp.repos.TrainRepository;
import vdovikova.trainapp.repos.database.DatabaseManager;
import vdovikova.trainapp.repos.database.DatabaseManagerImpl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

public class ArrivingRepositoryImpl implements ArrivingRepository {

    private static ArrivingRepositoryImpl instance;
    private final DatabaseManager dbManager;
    private final StationRepository stationRepository = StationRepositoryImpl.getInstance();
    private final TrainRepository trainRepository = TrainRepositoryImpl.getInstance();

    private ArrivingRepositoryImpl() {
        dbManager = DatabaseManagerImpl.getInstance();
    }

    public static ArrivingRepositoryImpl getInstance() {
        if (instance == null)
            instance = new ArrivingRepositoryImpl();
        return instance;
    }

    @Override
    public void add(Arriving arriving) {
        String query = "INSERT INTO arriving (idtrain, idstation, arriving_time, leaving_time) VALUES ("
                + arriving.getTrain().getId() + ", " + arriving.getStation().getId() + ", '"
                + arriving.getArrivingTime() + "', '" + arriving.getLeavingTime() + "')";
        try {
            dbManager.executeUpdate(query);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public Arriving getById(Integer id) {
        Arriving arriving = null;
        String query = "SELECT * FROM arriving WHERE idarriving = " + id + ";";
        try (ResultSet rs = dbManager.executeQuery(query)) {
            rs.next();
            arriving = new Arriving(Integer.valueOf(rs.getString("idarriving")),
                    trainRepository.getById(Integer.valueOf(rs.getString("idtrain"))),
                    stationRepository.getById(Integer.valueOf(rs.getString("idstation"))),
                    LocalTime.parse(rs.getString("arriving_time")),
                    LocalTime.parse(rs.getString("leaving_time")));
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return arriving;
    }

    @Override
    public List<Arriving> getAllByTrain(Integer train_id) {
        List<Arriving> arrivings = new ArrayList<>();
        String query = "SELECT * FROM arriving WHERE idtrain = " + train_id + ";";
        try (ResultSet rs = dbManager.executeQuery(query)) {
            while (rs.next()){
                arrivings.add(new Arriving(Integer.valueOf(rs.getString("idarriving")),
                        trainRepository.getById(train_id),
                        stationRepository.getById(Integer.valueOf(rs.getString("idstation"))),
                        LocalTime.parse(rs.getString("arriving_time")),
                        LocalTime.parse(rs.getString("leaving_time"))));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        arrivings.sort(new ArrivingComparator());
        return arrivings;
    }

    @Override
    public List<Arriving> getAllByStation(Integer station) {
        List<Arriving> arrivings = new ArrayList<>();
        String query = "SELECT * FROM arriving WHERE idtrain = " + station + ";";
        try (ResultSet rs = dbManager.executeQuery(query)) {
            while (rs.next()) {
                arrivings.add(new Arriving(Integer.valueOf(rs.getString("idarriving")),
                        trainRepository.getById(Integer.valueOf(rs.getString("idtrain"))),
                        stationRepository.getById(station),
                        LocalTime.parse(rs.getString("arriving_time")),
                        LocalTime.parse(rs.getString("leaving_time"))));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return arrivings;
    }

    @Override
    public Arriving getByTrainAndStation(Integer train_id, Integer station_id) {
        Arriving arriving = null;
        String query = "SELECT * FROM arriving WHERE idtrain = " + train_id
                + " AND idstation = " + station_id + ";";
        try (ResultSet rs = dbManager.executeQuery(query)) {
            rs.next();
            arriving = new Arriving(Integer.valueOf(rs.getString("idarriving")),
                    trainRepository.getById(train_id),
                    stationRepository.getById(station_id),
                    LocalTime.parse(rs.getString("arriving_time")),
                    LocalTime.parse(rs.getString("leaving_time")));
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return arriving;
    }

    @Override
    public List<Arriving> getAll() {
        List<Arriving> arrivings = new ArrayList<>();
        String query = "SELECT * FROM arriving;";
        try (ResultSet rs = dbManager.executeQuery(query)) {
            while (rs.next()) {
                arrivings.add(new Arriving(Integer.valueOf(rs.getString("idarriving")),
                        trainRepository.getById(Integer.valueOf(rs.getString("idtrain"))),
                        stationRepository.getById(Integer.valueOf(rs.getString("idstation"))),
                        LocalTime.parse(rs.getString("arriving_time")),
                        LocalTime.parse(rs.getString("leaving_time"))));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return arrivings;
    }

    @Override
    public void update(Arriving arriving) {
        String query = "UPDATE arriving SET arriving_time = '"+ arriving.getArrivingTime() +
                "', leaving_time = '"+ arriving.getLeavingTime() +  "' WHERE idarriving = "
                + arriving.getId() + ";";
        dbManager.executeUpdate(query);
    }

    @Override
    public void deleteById(Integer id) {
        String query = "DELETE FROM arriving WHERE idarriving = " + id + ";";
        dbManager.executeQuery(query);
    }

    @Override
    public void deleteAllByTrain(Integer train_id) {
        String query = "DELETE FROM arriving WHERE idtrain = " + train_id + ";";
        dbManager.executeUpdate(query);
    }

    @Override
    public void deleteAllByStation(Integer station_id) {
        String query = "DELETE FROM arriving WHERE idstation = " + station_id + ";";
        dbManager.executeUpdate(query);
    }

    @Override
    public void deleteByTrainAndStation(Integer train_id, Integer station_id) {
        Arriving arriving = null;
        String query = "DELETE FROM arriving WHERE idtrain = " + train_id
                + " AND idstation = " + station_id + ";";
        dbManager.executeQuery(query);
    }

    @Override
    public void deleteAll() {
        String query = "DELETE FROM arriving;";
        dbManager.executeUpdate(query);
    }
}
