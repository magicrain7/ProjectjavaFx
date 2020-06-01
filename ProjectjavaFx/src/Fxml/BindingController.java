package Fxml;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.beans.binding.Bindings;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.Slider;
import javafx.scene.control.TextArea;
import javafx.scene.text.Font;

public class BindingController implements Initializable {
	@FXML
	TextArea txtArea1;
	@FXML
	TextArea txtArea2;
	@FXML
	Label label;
	@FXML
	Slider slider;

	@Override
	public void initialize(URL arg0, ResourceBundle agr1) {
		slider.valueProperty().addListener(new ChangeListener<Number>() {

			@Override
			public void changed(ObservableValue<? extends Number> arg0, Number oldVal, Number newVal) {
				System.out.println(newVal);
				label.setFont(new Font(newVal.doubleValue()));
			}

		});
//		txtArea2.textProperty().bind(txtArea1.textProperty()); //텍스트2속성을 텍스트속성1에 묶어주겠다.
//		txtArea2.textProperty().bindBidirectional(txtArea1.textProperty());
		Bindings.bindBidirectional(txtArea1.textProperty(), txtArea2.textProperty());
	}

}
