package vdovikova.trainapp.ui.arriving;

import vdovikova.trainapp.models.Arriving;
import vdovikova.trainapp.models.Train;
import vdovikova.trainapp.services.ArrivingService;
import vdovikova.trainapp.services.StationService;
import vdovikova.trainapp.services.TrainService;
import vdovikova.trainapp.services.impl.StationServiceImpl;
import vdovikova.trainapp.services.impl.TrainServiceImpl;
import vdovikova.trainapp.ui.Command;
import java.sql.SQLException;
import java.time.LocalTime;
import java.util.Scanner;

public class ChangeArrivingTimetable implements Command {

    private final ArrivingService arrivingService;
    private final TrainService trainService = TrainServiceImpl.getInstance();
    private final StationService stationService = StationServiceImpl.getInstance();
    public ChangeArrivingTimetable(ArrivingService arrivingService) {
        this.arrivingService = arrivingService;
    }
    @Override
    public void execute(Scanner scanner) throws SQLException {
        System.out.print("Введите номер поезда: ");
        String trainName = scanner.next();
        System.out.print("Введите ID станции: ");
        Integer stationId = scanner.nextInt();
        Train train = trainService.findByName(trainName);
        Arriving arriving = arrivingService.getByTrainAndStation(train.getId(), stationId);
        try {
            System.out.print("Введите обновленное время прибытия: ");
            LocalTime a_time = LocalTime.parse(scanner.next());
            arriving.setArrivingTime(a_time);
            System.out.print("Введите обновленное время отправления: ");
            LocalTime l_time = LocalTime.parse(scanner.next());
            arriving.setLeavingTime(l_time);
            arrivingService.update(arriving);
            System.out.println("Расписание прибытия поезда " + trainName + " на станцию"
                    + stationService.getById(stationId).getStationName() + " успешно обновлено");
        } catch (NullPointerException e) {
            throw  e;
        }
    }

    @Override
    public String getName() {
        return "Обновление расписания прибытия поезда на станцию";
    }
}