package Fxml;

import java.awt.event.WindowEvent;
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
		root.setPadding(new Insets(10, 10, 10, 10)); // 컨트롤하고 간격을 패딩 감싸고 있는 H박스 2개가 있는데 버튼박스와의 간격을 패딩
		root.setSpacing(10); // 컨트롤과의 간격
		root.setPrefSize(700, 500);
		TextField textField = new TextField();
		textField.setPrefWidth(200);
		textField.setPrefHeight(200);

		Button button1 = new Button();
		button1.setText("확인");
		button1.setPrefSize(100, 100);
		button1.setOnAction(new EventHandler<ActionEvent>() {
			public void handle(ActionEvent event) {
				textField.setText("확인을 눌렀습니다.");
//				Platform.exit();
			}
		});

		Button button2 = new Button();
		button2.setText("취소");
		button2.setPrefSize(300, 500);
		button2.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent event) {
				textField.setText(null);
//				Platform.exit();
			}
		});

//		ObservableList list = root.getChildren();
		root.getChildren().add(textField);
		root.getChildren().add(button1);
		root.getChildren().add(button2);

		Scene scene = new Scene(root);

		primaryStage.setTitle("AppMain");
		primaryStage.setScene(scene);
		primaryStage.show();
//		primaryStage.setOnCloseRequest(new EventHandler<WindowEvent>() {
//			public void handle(WindowEvent event) {
//				System.out.println(event);
//			}
//		});
	} 

	public static void main(String[] args) {
		launch(args);
	}

}
