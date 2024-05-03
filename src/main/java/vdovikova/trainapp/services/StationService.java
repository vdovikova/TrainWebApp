package vdovikova.trainapp.services;

import vdovikova.trainapp.models.Station;
import vdovikova.trainapp.models.Train;

import java.util.List;
import java.util.UUID;

public interface StationService extends Service<Station, Integer> {
    List<Station> getAllByTrain(Train train);
}
