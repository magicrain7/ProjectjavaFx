package Fxml;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

public class Appmain extends Application {

	@Override
	public void start(Stage primaryStage) throws Exception {
		HBox root = new HBox();
		root.setPadding(new Insets(50, 50, 50, 50)); // 컨트롤하고 간격을 패딩 감싸고 있는 H박스 2개가 있는데 버튼박스와의 간격을 패딩
		root.setSpacing(200); // 컨트롤과의 간격

		TextField textField = new TextField();
		textField.setPrefWidth(200);
//		textField.setPrefHeight(200);

		Button button = new Button();
		button.setText("확인");
		button.setOnAction(new EventHandler<ActionEvent>() {
			public void handle(ActionEvent event) {
				Platform.exit();
			}
		});

//		ObservableList list = root.getChildren();
		root.getChildren().add(textField);
		root.getChildren().add(button);

		Scene scene = new Scene(root);

		primaryStage.setTitle("AppMain");
		primaryStage.setScene(scene);
		primaryStage.show();
	}

	public static void main(String[] args) {
		launch(args);
	}

}
