package vdovikova.trainapp.ui.train;

import lombok.RequiredArgsConstructor;
import vdovikova.trainapp.services.TrainService;
import vdovikova.trainapp.ui.Command;

import java.sql.SQLException;
import java.util.Scanner;

@RequiredArgsConstructor
public class GetTrainById implements Command {

    private TrainService trainService;
    public GetTrainById(TrainService trainService) {
        this.trainService = trainService;
    }

    @Override
    public void execute(Scanner scanner) throws SQLException {
        System.out.print("Введите ID поезда: ");
        int id = scanner.nextInt();
        System.out.println(trainService.getById(id).toString());
    }

    @Override
    public String getName() {
        return "Получить поезд по ID";
    }
}
