package vdovikova.trainapp.ui;

import vdovikova.trainapp.services.TrainService;

import java.sql.SQLException;
import java.util.Scanner;

public class Menu {
    private static TrainService trainService;

    public static void run() throws SQLException {
//        String encoding = System.getProperty("console.encoding", "utf-8");
//        System.setProperty("console.encoding","utf-8");
        Scanner scn = new Scanner(System.in);
        Command[] commands = Commands.getCommands();
        while (true) {
            for (int i = 0; i < commands.length; i++)
                System.out.println(i + 1 + ". " + commands[i].getName());
            System.out.println("0. Выход из программы");
            int k = scn.nextInt();
            if (k == 0)
                return;
            if (k > 0 && k <= commands.length)
                commands[k - 1].execute(scn);
            else {
                System.out.println("Некорректный ввод!");
            }
        }
    }
}
