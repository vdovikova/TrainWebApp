package vdovikova.trainapp.ui.train;

import vdovikova.trainapp.models.Station;
import vdovikova.trainapp.models.Train;
import vdovikova.trainapp.services.TrainService;
import vdovikova.trainapp.ui.Command;

import java.sql.SQLException;
import java.util.Scanner;

public class AddTrain implements Command {
    private TrainService trainService;
    public AddTrain(TrainService trainService) {
        this.trainService = trainService;
    }

    @Override
    public void execute(Scanner scanner) throws SQLException {
        System.out.print("Введите номер поезда: ");
        String name = scanner.next();
        try {
            trainService.add(new Train(null, name));
            System.out.println("Поезд " + name + " успешно добавлен");
        } catch (NullPointerException e) {
            throw  e;
        }
    }

    @Override
    public String getName() {
        return "Добавить поезд";
    }
}
