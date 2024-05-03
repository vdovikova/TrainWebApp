package vdovikova.trainapp.models;

import java.util.ArrayList;
import java.util.List;

public class Station {

    private Integer id;
    private String stationName;
    private List<Arriving> arrivings = new ArrayList<>();

    public Station(Integer id, String stationName) {
        this.id = id;
        this.stationName = stationName;
        this.arrivings = null;
    }

    public Station(Integer id, String stationName, List<Arriving> arrivings) {
        this.id = id;
        this.stationName = stationName;
        this.arrivings = arrivings;
    }

    public List<Arriving> getArrivings() {
        return arrivings;
    }

    public void setArrivings(List<Arriving> arrivings) {
        this.arrivings = arrivings;
    }

    public String getStationName() {
        return stationName;
    }

    public void setStationName(String stationName) {
        this.stationName = stationName;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "Station{" +
                "id=" + id +
                ", stationname='" + stationName + '\'' +
                ", arrivings=" + arrivings +
                '}';
    }
}