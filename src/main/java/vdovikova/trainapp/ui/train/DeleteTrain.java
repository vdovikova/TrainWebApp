package vdovikova.trainapp.ui.train;

import vdovikova.trainapp.models.Train;
import vdovikova.trainapp.services.TrainService;
import vdovikova.trainapp.ui.Command;

import java.sql.SQLException;
import java.util.Scanner;

public class DeleteTrain implements Command {
    private TrainService trainService;
    public DeleteTrain(TrainService trainService) {
        this.trainService = trainService;
    }

    @Override
    public void execute(Scanner scanner) throws SQLException {
        System.out.print("Введите ID поезда: ");
        Integer id = scanner.nextInt();
        try {
            trainService.deleteById(id);
            System.out.println("Поезд успешно удален");
        } catch (NullPointerException e) {
            throw  e;
        }
    }

    @Override
    public String getName() {
        return "Удалить поезд";
    }
}
