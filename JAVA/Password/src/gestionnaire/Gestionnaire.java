package gestionnaire;

import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class Gestionnaire extends Application {

	@Override
	public void start(Stage primaryStage) {
		Text text = new Text(10,40,"Hello world");
		text.setFont(new Font(40));
		Scene scene = new Scene(new Group(text));
		primaryStage.setTitle("Hello");
		primaryStage.setScene(scene);
		primaryStage.sizeToScene();
		primaryStage.show();
	}

	public static void main(String[] args) {
		Application.launch(args);
	}
}
