package vdovikova.trainapp.ui.station;

import vdovikova.trainapp.models.Station;
import vdovikova.trainapp.services.StationService;
import vdovikova.trainapp.ui.Command;

import java.sql.SQLException;
import java.util.Scanner;

public class DeleteStation implements Command {
    private final StationService stationService;

    public DeleteStation(StationService stationService) {
        this.stationService = stationService;
    }

    @Override
    public void execute(Scanner scanner) throws SQLException {
        System.out.print("Введите ID станции: ");
        Integer id = scanner.nextInt();
        try {
            stationService.deleteById(id);
            System.out.println("Станция успешно удалена");
        } catch (NullPointerException e) {
            throw  e;
        }
    }

    @Override
    public String getName() {
        return "Удалить станцию";
    }
}
