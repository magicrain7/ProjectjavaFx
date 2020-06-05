package chart_pack;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.chart.AreaChart;
import javafx.scene.chart.BarChart;
import javafx.scene.chart.PieChart;
import javafx.scene.chart.XYChart;

public class ChartController implements Initializable {
	@FXML PieChart pieChart;
	@FXML BarChart<String, Integer> barChart; 
	@FXML AreaChart<String, Integer> areaChart;
	
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		pieChart.setData(FXCollections.observableArrayList(
				new PieChart.Data("AWT", 10.0),
				new PieChart.Data("Swing", 30.0),
				new PieChart.Data("SWT", 25.0),
				new PieChart.Data("JavaFX", 35.0),
				new PieChart.Data("Others", 35.0)
				));
		
		XYChart.Series<String, Integer> series1 = new XYChart.Series<>();
		series1.setData(FXCollections.observableArrayList(
				new XYChart.Data("2015",70),
				new XYChart.Data("2016",60),
				new XYChart.Data("2017",50),
				new XYChart.Data("2018",40)
				));
		series1.setName("Cart1");
		XYChart.Series<String, Integer> series2 = new XYChart.Series<>();
		series2.setData(FXCollections.observableArrayList(
				new XYChart.Data("2015",40),
				new XYChart.Data("2016",90),
				new XYChart.Data("2017",10),
				new XYChart.Data("2018",70)
				));
		series2.setName("Cart2");
		barChart.setData(FXCollections.observableArrayList(series1,series2));
		
		XYChart.Series<String, Integer> series3 = new XYChart.Series<>();
		series3.setData(FXCollections.observableArrayList(
				new XYChart.Data("2015",10),
				new XYChart.Data("2016",20),
				new XYChart.Data("2017",30),
				new XYChart.Data("2018",40)
				));
		series3.setName("Cart3");
		areaChart.setData(FXCollections.observableArrayList(series3));
		
	}

}
