package stage_pack;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.chart.BarChart;
import javafx.scene.chart.XYChart;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

public class StageController implements Initializable {
	@FXML
	TableView<Student> tableView;
	@FXML
	Button btnAdd, btnChart;

	ObservableList<Student> scores;

//	Stage primaryStage;
//	void setprimaryStage(Stage primaryStage) {
//		this.primaryStage = primaryStage;
//	}

	@Override
	public void initialize(URL location, ResourceBundle resources) {

		scores = FXCollections.observableArrayList();

		btnAdd.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent arg0) {
				buttonAddAction(arg0);
			}
		});

		// Addform에서 cart 버튼
		btnChart.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent arg0) {
				buttonChartAction(arg0);
			}
		});

		TableColumn<Student, ?> tcName = tableView.getColumns().get(0);
		tcName.setCellValueFactory(new PropertyValueFactory("name"));

		TableColumn<Student, ?> tcKorean = tableView.getColumns().get(1);
		tcKorean.setCellValueFactory(new PropertyValueFactory("korean"));

		TableColumn<Student, ?> tcMath = tableView.getColumns().get(2);
		tcMath.setCellValueFactory(new PropertyValueFactory("math"));

		TableColumn<Student, ?> tcEnglish = tableView.getColumns().get(3);
		tcEnglish.setCellValueFactory(new PropertyValueFactory("english"));

		tableView.setItems(scores);
	}

	public void buttonAddAction(ActionEvent ae) {
		Stage addStage = new Stage(StageStyle.UTILITY);
		addStage.initModality(Modality.WINDOW_MODAL);
		addStage.initOwner(btnAdd.getScene().getWindow()); // 새로운 윈도우에 뿌리겠다.

		try {
			Parent parent = FXMLLoader.load(getClass().getResource("AddForm.fxml"));
			Scene scene = new Scene(parent);
			addStage.setScene(scene);
			addStage.setResizable(false);
			addStage.show();

			Button btnFromAdd = (Button) parent.lookup("#btnFormAdd");

			// 버튼 add를 했을때 이벤트 발생
			btnFromAdd.setOnAction(new EventHandler<ActionEvent>() {

				@Override // 버튼눌렀을때 생기는 것을 안에넣으면됨
				public void handle(ActionEvent event) {
					TextField txtName = (TextField) parent.lookup("#txtName");
					TextField txtKorean = (TextField) parent.lookup("#txtKorean");
					TextField txtMath = (TextField) parent.lookup("#txtMath");
					TextField txtEnglish = (TextField) parent.lookup("#txtEnglish");
					Student student = new Student(txtName.getText(), Integer.parseInt(txtKorean.getText()),
							Integer.parseInt(txtMath.getText()), Integer.parseInt(txtEnglish.getText()));

					scores.add(student);
					addStage.close();
				}
			});

		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void buttonChartAction(ActionEvent ae) {
		// 윈도우 하나만듬
		Stage chartStage = new Stage(StageStyle.UTILITY);
		chartStage.initModality(Modality.WINDOW_MODAL);
		chartStage.initOwner(btnAdd.getScene().getWindow());

		try {
			Parent parent = FXMLLoader.load(getClass().getResource("ScoreChart.fxml"));
			BarChart barChart = (BarChart) parent.lookup("#barChart");

			XYChart.Series<String, Integer> seriesKorean = new XYChart.Series<String, Integer>();
			ObservableList<XYChart.Data<String, Integer>> datasKorean = FXCollections.observableArrayList();
			for (int i = 0; i < scores.size(); i++) {
				datasKorean.add(new XYChart.Data(scores.get(i).getName(), scores.get(i).getKorean()));
				// 이름, 국어점수
			}
			seriesKorean.setData(datasKorean);
			seriesKorean.setName("국어");
			XYChart.Series<String, Integer> seriesMath = new XYChart.Series<String, Integer>();
			ObservableList<XYChart.Data<String, Integer>> datasMath = FXCollections.observableArrayList();
			for (int i = 0; i < scores.size(); i++) {
				datasMath.add(new XYChart.Data(scores.get(i).getName(), scores.get(i).getMath()));
				
			}
			seriesMath.setData(datasMath);
			seriesMath.setName("수학");
			XYChart.Series<String, Integer> seriesEnglish = new XYChart.Series<String, Integer>();
			ObservableList<XYChart.Data<String, Integer>> datasEnglish = FXCollections.observableArrayList();
			for (int i = 0; i < scores.size(); i++) {
				datasEnglish.add(new XYChart.Data(scores.get(i).getName(), scores.get(i).getEnglish()));
				
			}
			seriesEnglish.setData(datasEnglish);
			seriesEnglish.setName("영어");
			
			// 점수 받아옴
			barChart.setData(FXCollections.observableArrayList(seriesKorean, seriesMath, seriesEnglish));

			Scene scene = new Scene(parent);
			chartStage.setScene(scene);
			chartStage.show();
			chartStage.setResizable(false);

		} catch (IOException e) {

			e.printStackTrace();
		}
	}

}
