package vdovikova.trainapp.ui.station;

import vdovikova.trainapp.models.Station;
import vdovikova.trainapp.models.Train;
import vdovikova.trainapp.services.StationService;
import vdovikova.trainapp.ui.Command;

import java.sql.SQLException;
import java.util.Scanner;

public class ChangeStationName implements Command {
    private final StationService stationService;

    public ChangeStationName(StationService stationService) {
        this.stationService = stationService;
    }

    @Override
    public void execute(Scanner scanner) throws SQLException {
        System.out.print("Введите ID станции: ");
        Integer id = scanner.nextInt();
        try {
            System.out.print("Введите новое название: ");
            String newName = scanner.next();
            Station station = stationService.getById(id);
            station.setStationName(newName);
            stationService.update(station);
            System.out.println("Название станции успешно изменено");
        } catch (NullPointerException e) {
            throw  e;
        }
    }

    @Override
    public String getName() {
        return "Изменить название станции";
    }
}
