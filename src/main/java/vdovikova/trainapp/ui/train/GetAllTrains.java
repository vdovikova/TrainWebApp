package vdovikova.trainapp.ui.train;

import lombok.RequiredArgsConstructor;
import vdovikova.trainapp.services.TrainService;
import vdovikova.trainapp.ui.Command;

import java.sql.SQLException;
import java.util.Scanner;

@RequiredArgsConstructor
public class GetAllTrains implements Command {
    private TrainService trainService;

    public GetAllTrains(TrainService trainService) {
        this.trainService = trainService;
    }

    @Override
    public void execute(Scanner scanner) throws SQLException {
        trainService.getAll().forEach(System.out::println);
    }

    @Override
    public String getName() {
        return "Все поезда";
    }
}
