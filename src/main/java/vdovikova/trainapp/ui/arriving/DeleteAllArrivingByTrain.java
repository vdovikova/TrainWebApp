package vdovikova.trainapp.ui.arriving;

import vdovikova.trainapp.models.Train;
import vdovikova.trainapp.services.ArrivingService;
import vdovikova.trainapp.services.TrainService;
import vdovikova.trainapp.services.impl.TrainServiceImpl;
import vdovikova.trainapp.ui.Command;
import java.sql.SQLException;
import java.util.Scanner;

public class DeleteAllArrivingByTrain implements Command {

    private final ArrivingService arrivingService;
    private final TrainService trainService = TrainServiceImpl.getInstance();
    public DeleteAllArrivingByTrain(ArrivingService arrivingService) {
        this.arrivingService = arrivingService;
    }

    @Override
    public void execute(Scanner scanner) throws SQLException {
        System.out.print("Введите номер поезда: ");
        String name = scanner.next();
        try {
            Train train = trainService.findByName(name);
            arrivingService.deleteAllByTrain(train.getId());
            System.out.println("Маршрут поезда успешно удален");
        } catch (NullPointerException e) {
            throw  e;
        }
    }

    @Override
    public String getName() {
        return "Удалить маршрут поезда";
    }
}
