/*
 * @author Sonakshi Grover 2014106 and divam gupta 2014038
 * */


package registrationForm;


import java.io.File;
import java.net.URL;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.StackPane;


public class Main extends Application {
	
	private Stage primaryStage;
	@Override
	public void start(Stage primaryStage) {
		
		this.primaryStage = primaryStage;
		this.primaryStage.setTitle("Login yo ");
		
		try {
			System.out.println("kulli");
			String pathToFxml = "src/registrationForm/registration_form.fxml";
			AnchorPane page = (AnchorPane) FXMLLoader.load( new File(pathToFxml).toURI().toURL() );
	        Scene scene = new Scene(page);
	        primaryStage.setScene(scene);
	        primaryStage.setTitle("Registration Form");
	        primaryStage.show();
	            
		} catch(Exception e) {
			e.printStackTrace();
		}
		
	}

	
	public static void main(String[] args) {
		launch(args);
	}
}
