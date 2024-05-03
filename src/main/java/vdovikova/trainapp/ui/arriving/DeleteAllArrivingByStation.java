package vdovikova.trainapp.ui.arriving;

import vdovikova.trainapp.models.Station;
import vdovikova.trainapp.models.Train;
import vdovikova.trainapp.services.ArrivingService;
import vdovikova.trainapp.services.StationService;
import vdovikova.trainapp.services.TrainService;
import vdovikova.trainapp.services.impl.StationServiceImpl;
import vdovikova.trainapp.services.impl.TrainServiceImpl;
import vdovikova.trainapp.ui.Command;

import java.sql.SQLException;
import java.util.Scanner;

public class DeleteAllArrivingByStation implements Command {

    private final ArrivingService arrivingService;
    private final StationService stationService = StationServiceImpl.getInstance();
    public DeleteAllArrivingByStation(ArrivingService arrivingService) {
        this.arrivingService = arrivingService;
    }

    @Override
    public void execute(Scanner scanner) throws SQLException {
        System.out.print("Введите ID станции: ");
        Integer id = scanner.nextInt();
        try {
            Station station = stationService.getById(id);
            arrivingService.deleteAllByStation(station.getId());
            System.out.println("Все прибытия на станцию " + station.getStationName()
                    + " успешно удалены");
        } catch (NullPointerException e) {
            throw  e;
        }
    }

    @Override
    public String getName() {
        return "Удалить маршрут поезда";
    }
}