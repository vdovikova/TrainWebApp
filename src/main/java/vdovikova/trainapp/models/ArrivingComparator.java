package vdovikova.trainapp.models;

import java.util.Comparator;

public class ArrivingComparator implements Comparator<Arriving> {

    @Override
    public int compare(Arriving arriving1, Arriving arriving2) {
        return arriving1.getArrivingTime().compareTo(arriving2.getArrivingTime());
    }
}
