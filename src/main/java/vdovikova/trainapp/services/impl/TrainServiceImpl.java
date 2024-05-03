package vdovikova.trainapp.services.impl;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import vdovikova.trainapp.models.Train;
import vdovikova.trainapp.repos.TrainRepository;
import vdovikova.trainapp.repos.impl.TrainRepositoryImpl;
import vdovikova.trainapp.services.TrainService;

import java.sql.*;
import java.util.List;

@RequiredArgsConstructor
@Slf4j
//@Service
public class TrainServiceImpl implements TrainService {
    private static TrainServiceImpl instance;
    private final TrainRepository trainRepository;

    private TrainServiceImpl (){
        trainRepository = TrainRepositoryImpl.getInstance();
    }

    public static TrainServiceImpl getInstance() {
        if (instance == null)
            instance = new TrainServiceImpl();
        return instance;
    }

    @Override
    public void add(Train train) {
        trainRepository.add(train);
    }

    @Override
    public Train getById(Integer id) throws SQLException {
        return trainRepository.getById(id);
    }

    @Override
    public List<Train> getAll() {
        return trainRepository.getAll();
    }

    @Override
    public void update(Train train) {
        trainRepository.update(train);
    }

    @Override
    public void deleteById(Integer id) {
        trainRepository.deleteById(id);
    }

    @Override
    public Train findByName(String name) {
        return trainRepository.findByName(name);
    }

    @Override
    public void deleteAll() {
        trainRepository.deleteAll();
    }
}

