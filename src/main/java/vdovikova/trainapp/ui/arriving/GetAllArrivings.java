package vdovikova.trainapp.ui.arriving;

import vdovikova.trainapp.services.ArrivingService;
import vdovikova.trainapp.ui.Command;
import java.sql.SQLException;
import java.util.Scanner;

public class GetAllArrivings implements Command {

    private final ArrivingService arrivingService;

    public GetAllArrivings(ArrivingService arrivingService) {
        this.arrivingService = arrivingService;
    }

    @Override
    public void execute(Scanner scanner) throws SQLException {
        arrivingService.getAll().forEach(System.out::println);
    }

    @Override
    public String getName() {
        return "Все прибытия и отправления";
    }
}
