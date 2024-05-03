package vdovikova.trainapp.ui.train;

import vdovikova.trainapp.models.Train;
import vdovikova.trainapp.services.TrainService;
import vdovikova.trainapp.ui.Command;

import java.sql.SQLException;
import java.util.Scanner;

public class ChangeTrainName implements Command {
    private TrainService trainService;
    public ChangeTrainName(TrainService trainService) {
        this.trainService = trainService;
    }

    @Override
    public void execute(Scanner scanner) throws SQLException {
        System.out.print("Введите ID поезда: ");
        Integer id = scanner.nextInt();
        try {
            System.out.print("Введите новый номер: ");
            String newnum = scanner.next();
            Train train = trainService.getById(id);
            train.setTrainName(newnum);
            trainService.update(train);
            System.out.println("Номер поезда успешно изменен");
        } catch (NullPointerException e) {
            throw  e;
        }
    }

    @Override
    public String getName() {
        return "Изменить номер поезда";
    }
}