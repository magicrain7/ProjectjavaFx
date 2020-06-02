package button_pack;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.CheckBox;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class ButtonController implements Initializable {
	@FXML
	CheckBox chk1;
	@FXML
	CheckBox chk2;
	@FXML
	ImageView imageView;

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {

	}

	public void handleCheckAction(ActionEvent event) {
		String imageName = "";
		if (chk1.isSelected() && chk2.isSelected()) {
			imageName = "geek-glasses-hair.gif";
		} else if (chk1.isSelected()) {
			imageName = "geek-hair.gif";
		} else if (chk2.isSelected()) {
			imageName = "geek-glasses.gif";
		} else {
			imageName = "geek.gif";
		}
		imageView.setImage(new Image("/images/" + imageName));
	}
}
