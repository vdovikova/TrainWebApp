package vdovikova.trainapp.ui.station;

import vdovikova.trainapp.models.Station;
import vdovikova.trainapp.services.StationService;
import vdovikova.trainapp.ui.Command;

import java.sql.SQLException;
import java.util.Scanner;

public class GetAllStations implements Command {

    private final StationService stationService;

    public GetAllStations(StationService stationService) {
        this.stationService = stationService;
    }

    @Override
    public void execute(Scanner scanner) throws SQLException {
        stationService.getAll().forEach(System.out::println);
    }

    @Override
    public String getName() {
        return "Все станции";
    }
}
