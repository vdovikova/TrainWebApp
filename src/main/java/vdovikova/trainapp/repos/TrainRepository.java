package vdovikova.trainapp.repos;

import org.springframework.data.jpa.repository.JpaRepository;
import vdovikova.trainapp.models.Train;

import java.util.List;
import java.util.Optional;

public interface TrainRepository extends Repository<Train, Integer> {
    Train findByName(String name);
}