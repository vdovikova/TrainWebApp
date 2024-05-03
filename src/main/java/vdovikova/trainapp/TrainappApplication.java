package vdovikova.trainapp;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import vdovikova.trainapp.repos.database.DatabaseManager;
import vdovikova.trainapp.repos.database.DatabaseManagerImpl;
import vdovikova.trainapp.ui.Menu;

import java.sql.SQLException;

@SpringBootApplication
public class TrainappApplication {

	public static void main(String[] args) throws SQLException {
		DatabaseManager dbManager = DatabaseManagerImpl.getInstance();
		dbManager.connect();
		Menu.run();
	}

}
