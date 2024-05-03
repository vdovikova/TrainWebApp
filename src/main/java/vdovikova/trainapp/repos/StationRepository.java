package vdovikova.trainapp.repos;

import org.springframework.data.jpa.repository.JpaRepository;
import vdovikova.trainapp.models.Station;
import vdovikova.trainapp.models.Train;

import java.util.List;
import java.util.Optional;

public interface StationRepository extends Repository<Station, Integer> {
    List<Station> findAllByTrain(Train train);
}

