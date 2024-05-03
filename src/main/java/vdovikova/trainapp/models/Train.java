package vdovikova.trainapp.models;

import java.util.ArrayList;
import java.util.List;

public class Train {
    private Integer id;
    private String trainName;
    private List<Arriving> arrivings = new ArrayList<>();

    public Train(Integer id, String trainName, List<Arriving> arrivings) {
        this.id = id;
        this.trainName = trainName;
        this.arrivings = arrivings;
    }

    public Train(Integer id, String trainName) {
        this.id = id;
        this.trainName = trainName;
        this.arrivings = null;
    }

    public List<Arriving> getArrivings() {
        return arrivings;
    }

    public void setArrivings(List<Arriving> arrivings) {
        this.arrivings = arrivings;
    }

    public String getTrainName() {
        return trainName;
    }

    public void setTrainName(String trainName) {
        this.trainName = trainName;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "Train{" +
                "id=" + id +
                ", trainName='" + trainName + '\'' +
                ", arrivings=" + arrivings +
                '}';
    }
}