package edu.unlam.ventana;

import java.io.IOException;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;

public class Principal extends Application {

	final String css = "/css/principal.css";
	final String principalIconImage = "/images/iconoPrincipal.png";
	final String principalFxml = "/fxml/Principal.fxml";
	
	
	public static void main(String[] args) {
		launch(args);
	}
	
	@Override
	public void start(Stage primaryStage) {
		Parent root;
		try {
			FXMLLoader loader = new FXMLLoader();
			loader.setLocation(getClass().getResource(principalFxml));
			root = loader.load();
			
			Scene scene = new Scene(root, 800, 600);
			scene.getStylesheets().add(css); 

			primaryStage.setTitle("Métricas de Calidad");
			primaryStage.getIcons().add(new Image(principalIconImage));
			primaryStage.setMaximized(true);;
			primaryStage.setScene(scene);
						
			primaryStage.show();
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}		

	}

}
