package vdovikova.trainapp.ui.arriving;

import vdovikova.trainapp.services.ArrivingService;
import vdovikova.trainapp.services.StationService;
import vdovikova.trainapp.services.TrainService;
import vdovikova.trainapp.services.impl.StationServiceImpl;
import vdovikova.trainapp.services.impl.TrainServiceImpl;
import vdovikova.trainapp.ui.Command;

import java.sql.SQLException;
import java.util.Scanner;

public class DeleteAllArrivings implements Command {

    private final ArrivingService arrivingService;
    public DeleteAllArrivings(ArrivingService arrivingService) {
        this.arrivingService = arrivingService;
    }

    @Override
    public void execute(Scanner scanner) throws SQLException {
        try {
            arrivingService.deleteAll();
            System.out.println("Все маршруты успешно удалены");
        } catch (NullPointerException e) {
            throw  e;
        }
    }

    @Override
    public String getName() {
        return "Удалить все маршруты";
    }
}
