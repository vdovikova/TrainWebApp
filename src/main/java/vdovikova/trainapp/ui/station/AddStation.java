package vdovikova.trainapp.ui.station;

import vdovikova.trainapp.models.Station;
import vdovikova.trainapp.services.StationService;
import vdovikova.trainapp.ui.Command;

import java.sql.SQLException;
import java.util.Scanner;

public class AddStation implements Command {
    private final StationService stationService;

    public AddStation(StationService stationService) {
        this.stationService = stationService;
    }

    @Override
    public void execute(Scanner scanner) throws SQLException {
        System.out.print("Введите название станции: ");
        String name = scanner.next();
        try {
            stationService.add(new Station(null, name));
            System.out.println("Станция " + name +
                    " успешно добавлена");
        } catch (NullPointerException e) {
            throw  e;
        }
    }

    @Override
    public String getName() {
        return "Добавить станцию";
    }
}
