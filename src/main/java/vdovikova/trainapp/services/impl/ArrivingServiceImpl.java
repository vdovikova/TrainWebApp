package vdovikova.trainapp.services.impl;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import vdovikova.trainapp.models.Arriving;
import vdovikova.trainapp.models.Station;
import vdovikova.trainapp.models.Train;
import vdovikova.trainapp.repos.ArrivingRepository;
import vdovikova.trainapp.repos.TrainRepository;
import vdovikova.trainapp.repos.impl.ArrivingRepositoryImpl;
import vdovikova.trainapp.services.ArrivingService;
import vdovikova.trainapp.services.TrainService;

import java.sql.*;
import java.util.Comparator;
import java.util.List;

@RequiredArgsConstructor
@Slf4j
public class ArrivingServiceImpl implements ArrivingService {

    private static ArrivingServiceImpl instance;
    private final ArrivingRepository arrivingRepository;

    private ArrivingServiceImpl(){
        arrivingRepository = ArrivingRepositoryImpl.getInstance();
    }

    public static ArrivingServiceImpl getInstance() {
        if (instance == null)
            instance = new ArrivingServiceImpl();
        return instance;
    }

    @Override
    public void add(Arriving arriving) {
        arrivingRepository.add(arriving);
    }

    @Override
    public Arriving getById(Integer id) throws SQLException {
        return arrivingRepository.getById(id);
    }

    @Override
    public List<Arriving> getAllByTrain(Integer train) {
        return arrivingRepository.getAllByTrain(train);
    }

    @Override
    public List<Arriving> getAllByStation(Integer station) {
        return arrivingRepository.getAllByStation(station);
    }

    @Override
    public Arriving getByTrainAndStation(Integer train_id, Integer station_id) {
        return arrivingRepository.getByTrainAndStation(train_id, station_id);
    }

    @Override
    public List<Arriving> getAll() {
        return arrivingRepository.getAll();
    }

    @Override
    public void update(Arriving arriving) {
        arrivingRepository.update(arriving);
    }

    @Override
    public void deleteById(Integer id) {
        arrivingRepository.deleteById(id);
    }

    @Override
    public void deleteAllByTrain(Integer train_id) {
        arrivingRepository.deleteAllByTrain(train_id);
    }

    @Override
    public void deleteAllByStation(Integer station) {
        arrivingRepository.deleteAllByStation(station);
    }

    @Override
    public void deleteByTrainAndStation(Integer train_id, Integer station_id) {
        arrivingRepository.deleteByTrainAndStation(train_id, station_id);
    }

    @Override
    public void deleteAll() {
        arrivingRepository.deleteAll();
    }
}
