package Basic;
import javafx.application.Application;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.stage.Stage;

public class Appmain  extends Application{
	
	public Appmain(){
		System.out.println(Thread.currentThread().getName() + " : AppMain() 실행."); //현재 정보를 볼수있다.
	}
	
	@Override
	public void init() throws Exception {
		System.out.println(Thread.currentThread().getName() + " : Init() 실행."); //현재 정보를 볼수있다.
	}

	@Override
	public void start(Stage primaryStage) throws Exception { //start매소드 정의 해줘야됨
		System.out.println(Thread.currentThread().getName() + " : Start() 실행."); //현재 정보를 볼수있다.
		VBox root = new VBox(); //컨트롤들을 여러개를 담는다
		root.setPrefWidth(500);
		root.setPrefHeight(300);
		root.setAlignment(Pos.CENTER);
		root.setSpacing(20);
		
		//컨트롤
		Label label = new Label();
		label.setText("Hello, JavaFx");
		label.setFont(new Font(50));
		//컨트롤
		Button button = new Button();
		button.setText("확인");
		button.setFont(new Font(20));
		button.setOnAction(new EventHandler<ActionEvent>() {  //Interface EventHandler<T extends Event> 구현해야될 매소드가 1개만있다.
			@Override
			public void handle(ActionEvent event) { //handle 이라는 매소드 호출
				Platform.exit();
			}
		});
//		button.setOnAction(event -> Platform.exit());	//람다 표현식											  

		
		//컨트롤 2를 add라는 매소드를 자식매소드로 붙임.
		root.getChildren().add(label);
		root.getChildren().add(button);
		
		Scene scene = new Scene(root);
		primaryStage.setScene(scene);
		primaryStage.show(); //primaryStage을 띄우겠다 창은 stage라 말함.	
	}
	
	@Override
	public void stop() throws Exception{
		System.out.println(Thread.currentThread().getName() + " : Stop() 실행."); //현재 정보를 볼수있다.
	}
	
	
	public static void main(String[] args) {
		Application.launch(args);
	}

}
