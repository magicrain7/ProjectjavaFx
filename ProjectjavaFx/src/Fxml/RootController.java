package Fxml;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

//Main: ButtonMain.java
//Control: ButtonControl.fxml 버튼호출 UI
//Controller: ButtonColtroller.java 


//Main class : AppRoot.java
//	start() -> promaryStage
//Control class: Root.fxml
//fxml => UI
//Controller class: RootController.java
// Controller(event)

public class RootController implements Initializable {
	@FXML
	TextField textField;
	@FXML
	Button btnOk;

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		textField.setText("초기화 됩니다");
		btnOk.setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent event) {
				Platform.exit();
			}

		});
	}

}
