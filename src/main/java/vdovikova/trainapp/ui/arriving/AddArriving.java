package vdovikova.trainapp.ui.arriving;

import vdovikova.trainapp.models.Arriving;
import vdovikova.trainapp.models.Station;
import vdovikova.trainapp.services.ArrivingService;
import vdovikova.trainapp.services.StationService;
import vdovikova.trainapp.services.TrainService;
import vdovikova.trainapp.services.impl.StationServiceImpl;
import vdovikova.trainapp.services.impl.TrainServiceImpl;
import vdovikova.trainapp.ui.Command;

import java.sql.SQLException;
import java.time.LocalTime;
import java.util.Scanner;

public class AddArriving implements Command {

    private final ArrivingService arrivingService;
    private final TrainService trainService = TrainServiceImpl.getInstance();
    private final StationService stationService = StationServiceImpl.getInstance();
    public AddArriving(ArrivingService arrivingService) {
        this.arrivingService = arrivingService;
    }
    @Override
    public void execute(Scanner scanner) throws SQLException {
        try {
            System.out.print("Введите номер поезда: ");
            String trainname = scanner.next();
            System.out.print("Введите ID станции: ");
            Integer stationId = scanner.nextInt();
            System.out.print("Введите время прибытия: ");
            LocalTime a_time = LocalTime.parse(scanner.next());
            System.out.print("Введите время отправления: ");
            LocalTime l_time = LocalTime.parse(scanner.next());
            arrivingService.add(new Arriving(null, trainService.findByName(trainname),
                    stationService.getById(stationId), a_time, l_time));
            System.out.println("Станция " + stationService.getById(stationId).getStationName() +
                    " успешно добавлена в маршрут поезда " + trainname);
        } catch (NullPointerException e) {
            throw  e;
        }
    }

    @Override
    public String getName() {
        return "Добавление станции в маршрут поезда";
    }
}
