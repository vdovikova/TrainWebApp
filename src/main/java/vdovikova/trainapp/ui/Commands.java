package vdovikova.trainapp.ui;

import vdovikova.trainapp.services.impl.ArrivingServiceImpl;
import vdovikova.trainapp.services.impl.StationServiceImpl;
import vdovikova.trainapp.services.impl.TrainServiceImpl;
import vdovikova.trainapp.ui.arriving.*;
import vdovikova.trainapp.ui.station.*;
import vdovikova.trainapp.ui.train.*;

public class Commands {
    static Command[] getCommands() {
        return new Command[] {
                new GetTrainById(TrainServiceImpl.getInstance()),
                new GetAllTrains(TrainServiceImpl.getInstance()),
                new AddTrain(TrainServiceImpl.getInstance()),
                new ChangeTrainName(TrainServiceImpl.getInstance()),
                new DeleteTrain(TrainServiceImpl.getInstance()),
                new DeleteAllTrains(TrainServiceImpl.getInstance()),
                new GetAllStations(StationServiceImpl.getInstance()),
                new AddStation(StationServiceImpl.getInstance()),
                new ChangeStationName(StationServiceImpl.getInstance()),
                new DeleteStation(StationServiceImpl.getInstance()),
                new DeleteAllStations(StationServiceImpl.getInstance()),
                new GetAllArrivings(ArrivingServiceImpl.getInstance()),
                new AddArriving(ArrivingServiceImpl.getInstance()),
                new ChangeArrivingTimetable(ArrivingServiceImpl.getInstance()),
                new DeleteArriving(ArrivingServiceImpl.getInstance()),
                new DeleteAllArrivingByTrain(ArrivingServiceImpl.getInstance()),
                new DeleteAllArrivingByStation(ArrivingServiceImpl.getInstance()),
                new DeleteAllArrivings(ArrivingServiceImpl.getInstance())
        };
    }
}
