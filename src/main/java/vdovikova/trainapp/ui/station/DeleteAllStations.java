package vdovikova.trainapp.ui.station;

import vdovikova.trainapp.services.StationService;
import vdovikova.trainapp.ui.Command;

import java.sql.SQLException;
import java.util.Scanner;

public class DeleteAllStations implements Command {
    private final StationService stationService;

    public DeleteAllStations(StationService stationService) {
        this.stationService = stationService;
    }

    @Override
    public void execute(Scanner scanner) throws SQLException {
        try {
            stationService.deleteAll();
            System.out.println("Все станции успешно удалены");
        } catch (NullPointerException e) {
            throw  e;
        }
    }

    @Override
    public String getName() {
        return "Удалить все станции";
    }
}
