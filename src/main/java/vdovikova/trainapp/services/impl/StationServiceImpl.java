package vdovikova.trainapp.services.impl;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import vdovikova.trainapp.models.Train;
import vdovikova.trainapp.models.Station;
import vdovikova.trainapp.repos.StationRepository;
import vdovikova.trainapp.repos.impl.StationRepositoryImpl;
import vdovikova.trainapp.services.StationService;

import java.sql.*;
import java.util.List;

@RequiredArgsConstructor
@Slf4j
//@Service
public class StationServiceImpl implements StationService {
    private static StationServiceImpl instance;
    private final StationRepository stationRepository;

    private StationServiceImpl (){
        stationRepository = StationRepositoryImpl.getInstance();
    }

    public static StationServiceImpl getInstance() {
        if (instance == null)
            instance = new StationServiceImpl();
        return instance;
    }

    @Override
    public void add(Station station) {
        stationRepository.add(station);
    }

    @Override
    public Station getById(Integer id) throws SQLException {
        return stationRepository.getById(id);
    }

    @Override
    public List<Station> getAll() {
        return stationRepository.getAll();
    }

    @Override
    public void update(Station station) {
        stationRepository.update(station);
    }

    @Override
    public void deleteById(Integer id) {
        stationRepository.deleteById(id);
    }

    @Override
    public List<Station> getAllByTrain(Train train) {
        return stationRepository.findAllByTrain(train);
    }

    @Override
    public void deleteAll() {
        stationRepository.deleteAll();
    }
}
