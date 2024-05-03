package vdovikova.trainapp.services;

import vdovikova.trainapp.models.Arriving;
import vdovikova.trainapp.models.Station;
import vdovikova.trainapp.models.Train;

import java.util.List;

public interface ArrivingService extends Service <Arriving, Integer> {
    List<Arriving> getAllByTrain(Integer train);
    List<Arriving> getAllByStation(Integer station);
    void deleteAllByTrain(Integer train_id);;
    void deleteAllByStation(Integer station);
    Arriving getByTrainAndStation(Integer train_id, Integer station_id);
    void deleteByTrainAndStation(Integer train_id, Integer station_id);
}
