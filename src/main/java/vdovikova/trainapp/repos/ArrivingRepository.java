package vdovikova.trainapp.repos;

import vdovikova.trainapp.models.Arriving;

import java.util.List;

public interface ArrivingRepository extends Repository<Arriving, Integer> {
    List<Arriving> getAllByTrain(Integer train_id);
    Arriving getByTrainAndStation(Integer train_id, Integer station_id);
    void deleteByTrainAndStation(Integer train_id, Integer station_id);
    void deleteAllByTrain(Integer train_id);
    List<Arriving> getAllByStation(Integer station);
    void deleteAllByStation(Integer station);
}
