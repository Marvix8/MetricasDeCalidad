package edu.unlam.ventana;

import java.io.File;
import java.io.IOException;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Principal extends Application {

	public static void main(String[] args) {
		launch(args);
	}
	
	@Override
	public void start(Stage primaryStage) {
		Parent root;
		try {
			File css = new File("frontend/resources/css/principal.css");
			File principalFxml = new File("frontend/resources/fxml/Principal.fxml");
			root = FXMLLoader.load(principalFxml.toURI().toURL());
			Scene scene = new Scene(root, 800, 600);
			scene.getStylesheets().add(css.toURI().toURL().toString()); 

			primaryStage.setTitle("Métricas de Calidad");
			primaryStage.setMaximized(true);;
			primaryStage.setScene(scene);
						
			primaryStage.show();
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}		

	}

}
