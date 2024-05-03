package vdovikova.trainapp.ui.arriving;

import vdovikova.trainapp.models.Train;
import vdovikova.trainapp.services.ArrivingService;
import vdovikova.trainapp.services.TrainService;
import vdovikova.trainapp.services.impl.TrainServiceImpl;
import vdovikova.trainapp.ui.Command;

import java.sql.SQLException;
import java.util.Scanner;

public class DeleteArriving implements Command {

    private final ArrivingService arrivingService;
    private final TrainService trainService = TrainServiceImpl.getInstance();

    public DeleteArriving(ArrivingService arrivingService) {
        this.arrivingService = arrivingService;
    }

    @Override
    public void execute(Scanner scanner) throws SQLException {
        System.out.print("Введите номер поезда: ");
        String name_train = scanner.next();
        System.out.print("Введите ID станции: ");
        Integer id_station = scanner.nextInt();
        try {
            Train train = trainService.findByName(name_train);
            arrivingService.deleteByTrainAndStation(train.getId(),id_station);
            System.out.println("Станция успешно удалена из маршрута");
        } catch (NullPointerException e) {
            throw  e;
        }
    }

    @Override
    public String getName() {
        return "Удалить станцию из маршрута";
    }
}
