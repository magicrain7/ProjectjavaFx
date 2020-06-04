package media_pack;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ProgressBar;
import javafx.scene.control.ProgressIndicator;
import javafx.scene.control.Slider;
import javafx.scene.image.ImageView;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.media.MediaView;

public class MediaController implements Initializable {
	@FXML
	ImageView imageView;
	@FXML
	MediaView mediaView;
	@FXML
	Button btnPlay, btnPause, btnStop;
	@FXML ProgressIndicator progressIndicator;
	@FXML ProgressBar progressBar;
	@FXML Slider sliderVolumn;
	@FXML Label labelTime;
	
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		Media media = new Media(getClass().getResource("/media/video.mp4").toString());
		MediaPlayer player = new MediaPlayer(media);
		mediaView.setMediaPlayer(player);

		player.setOnReady(new Runnable() {
			@Override
			public void run() {
				btnPlay.setDisable(false);
				btnStop.setDisable(true);
				btnPause.setDisable(true);
			}
		});

		player.setOnPlaying(new Runnable() {
			@Override
			public void run() {
				btnPlay.setDisable(true);
				btnStop.setDisable(false);
				btnPause.setDisable(false);
			}
		});
		player.setOnPaused(new Runnable() {
			@Override
			public void run() {
				btnPlay.setDisable(false);
				btnStop.setDisable(true);
				btnPause.setDisable(true);
			}
		});
		player.setOnStopped(new Runnable() {
			@Override
			public void run() {
				btnPlay.setDisable(false);
				btnStop.setDisable(false);
				btnPause.setDisable(true);
			}
		});	

		player.setOnEndOfMedia(new Runnable() {
			@Override
			public void run() {
				btnPlay.setDisable(false);
				btnStop.setDisable(false);
				btnPause.setDisable(true);
			}
		});

//		btnPlay.setOnAction(new EventHandler<ActionEvent>() {
//			@Override
//			public void handle(ActionEvent arg0) {
//				player.play();
//			}
//		});
		btnPlay.setOnAction((e) -> player.play());
		btnStop.setOnAction((e) -> player.stop());
		btnPause.setOnAction((e) -> player.pause());

	}
}
