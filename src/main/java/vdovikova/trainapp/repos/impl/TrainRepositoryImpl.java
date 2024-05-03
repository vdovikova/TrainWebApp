package vdovikova.trainapp.repos.impl;

import vdovikova.trainapp.models.Arriving;
import vdovikova.trainapp.models.Train;
import vdovikova.trainapp.repos.ArrivingRepository;
import vdovikova.trainapp.repos.TrainRepository;
import vdovikova.trainapp.repos.database.DatabaseManager;
import vdovikova.trainapp.repos.database.DatabaseManagerImpl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class TrainRepositoryImpl implements TrainRepository {

    private static TrainRepositoryImpl instance;
    private final DatabaseManager dbManager;
    private static ArrivingRepository arrivingRepository = ArrivingRepositoryImpl.getInstance();

    private TrainRepositoryImpl() {
        dbManager = DatabaseManagerImpl.getInstance();
    }

    public static TrainRepositoryImpl getInstance() {
        if (instance == null)
            instance = new TrainRepositoryImpl();
        return instance;
    }

    @Override
    public void add(Train train) {
        String query = "INSERT INTO train (trainname) VALUES ('"+ train.getTrainName() + "');";
        dbManager.executeUpdate(query);
    }

    @Override
    public Train getById(Integer id) {
        Train train = null;
        String query = "SELECT * FROM train WHERE idtrain = " + id + ";";
        try (ResultSet resultSet = dbManager.executeQuery(query)) {
            resultSet.next();
            train = new Train(Integer.valueOf(resultSet.getString("idtrain")),
                    resultSet.getString("trainname"));
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return train;
    }

    @Override
    public List<Train> getAll() {
        List<Train> trains = new ArrayList<>();
        String query = "SELECT train.idtrain, train.trainname FROM train";
        try (ResultSet resultSet = dbManager.executeQuery(query)) {
            while (resultSet.next()) {
                int id = resultSet.getInt("idtrain");
                String trainName = resultSet.getString("trainname");
                List<Arriving> arrivings = arrivingRepository.getAllByTrain(id);
                trains.add(new Train(id, trainName, arrivings));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return trains;
    }

    @Override
    public void update(Train train) {
        String query = "UPDATE train SET trainname = '" + train.getTrainName() +
                "' WHERE idtrain = " + train.getId() + ";";
        dbManager.executeUpdate(query);
    }

    @Override
    public void deleteById(Integer id) {
        arrivingRepository.deleteAllByTrain(id);
        String query = "DELETE FROM train WHERE idtrain = " + id + ";";
        dbManager.executeUpdate(query);
    }

    @Override
    public void deleteAll() {
        arrivingRepository.deleteAll();
        String query = "DELETE FROM train;";
        dbManager.executeUpdate(query);
    }

    @Override
    public Train findByName(String name) {
        Train train = null;
        String query = "SELECT * FROM train WHERE trainname = " + name + ";";
        try (ResultSet resultSet = dbManager.executeQuery(query)) {
            resultSet.next();
            train = new Train(Integer.valueOf(resultSet.getString("idtrain")),
                    resultSet.getString("trainname"));
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return train;
    }
}
