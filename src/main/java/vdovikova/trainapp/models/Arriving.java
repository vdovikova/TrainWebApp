package vdovikova.trainapp.models;


import java.time.LocalTime;
import java.util.Comparator;

public class Arriving {

    private Integer id;
    private Train train;
    private Station station;
    private LocalTime arrivingTime;
    private LocalTime leavingTime;

    public Arriving(Integer id, Train train, Station station, LocalTime arrivingTime, LocalTime leavingTime) {
        this.id = id;
        this.train = train;
        this.station = station;
        this.arrivingTime = arrivingTime;
        this.leavingTime = leavingTime;
    }

    public LocalTime getLeavingTime() {
        return leavingTime;
    }

    public void setLeavingTime(LocalTime leavingTime) {
        this.leavingTime = leavingTime;
    }

    public LocalTime getArrivingTime() {
        return arrivingTime;
    }

    public void setArrivingTime(LocalTime arrivingTime) {
        this.arrivingTime = arrivingTime;
    }

    public Station getStation() {
        return station;
    }

    public void setStation(Station station) {
        this.station = station;
    }

    public Train getTrain() {
        return train;
    }

    public void setTrain(Train train) {
        this.train = train;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "Arriving{" +
                "id=" + id +
                ", train=" + train.getTrainName() +
                ", station=" + station.getStationName() +
                ", arrivingTime=" + arrivingTime +
                ", leavingTime=" + leavingTime +
                '}';
    }
}