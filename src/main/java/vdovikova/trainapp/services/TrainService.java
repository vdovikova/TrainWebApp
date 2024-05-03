package vdovikova.trainapp.services;

import jakarta.persistence.criteria.CriteriaBuilder;
import vdovikova.trainapp.models.Train;

public interface TrainService extends Service<Train, Integer> {
    Train findByName(String name);
}
