package stage_pack;


import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

//Root.fxml
//AddForm.fxml
//ScoreChart.fxml
//StageController.java
public class StageMain extends Application{

	@Override
	public void start(Stage stage) throws Exception {
			Parent root = FXMLLoader.load(getClass().getResource("Root.fxml"));
		
//			FXMLLoader loader = new FXMLLoader();
//			Parent root = loader.load(getClass().getResource("Root.fxml"));
//			
			//Controller에 stage 값을 넘겨준다.
//			StageController cont = loader.getController();
//			cont.setprimaryStage(stage);
			
			Scene scene = new Scene(root);
			stage.setScene(scene);
			stage.show();
			
	}
	public static void main(String[] args) {
		launch(args);
	}
}
