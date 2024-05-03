package vdovikova.trainapp.ui.train;

import vdovikova.trainapp.services.TrainService;
import vdovikova.trainapp.ui.Command;

import java.sql.SQLException;
import java.util.Scanner;

public class DeleteAllTrains implements Command {
    private TrainService trainService;
    public DeleteAllTrains(TrainService trainService) {
        this.trainService = trainService;
    }

    @Override
    public void execute(Scanner scanner) throws SQLException {
        try {
            trainService.deleteAll();
            System.out.println("Все поездa успешно удалены");
        } catch (NullPointerException e) {
            throw  e;
        }
    }

    @Override
    public String getName() {
        return "Удалить все поезда";
    }
}
