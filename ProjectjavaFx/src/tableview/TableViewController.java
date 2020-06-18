package tableview;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TableCell;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableColumn.CellEditEvent;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.util.Callback;

public class TableViewController implements Initializable {

	@FXML
	TableView<User> tableView;

	@FXML
	Button btnSave;

	ObservableList<User> userList;

	@Override
	public void initialize(URL location, ResourceBundle resources) {

		btnSave.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent event) {
				for (User user : userList) {
					System.out.println(user.getFirstName());
				}
			}
		});

		tableView.setEditable(true);

		userList = FXCollections.observableArrayList();
		userList.add(new User("id1", "firstName1", "lastName1", "email1", "Men", "2010/01/01"));
		userList.add(new User("id2", "firstName2", "lastName2", "email2", "Men", "2015/01/01"));
		userList.add(new User("id3", "firstName3", "lastName3", "email3", "Women", "2020/01/01"));

		TableColumn<User, String> tcId = new TableColumn<>("Id");
		tcId.setCellValueFactory(new PropertyValueFactory("id"));

		TableColumn<User, String> tcFName = new TableColumn<>("FName");
		tcFName.setCellValueFactory(new PropertyValueFactory("firstName"));
		tcFName.setCellFactory(new Callback<TableColumn<User, String>, TableCell<User, String>>() {
			@Override
			public TableCell<User, String> call(TableColumn<User, String> param) {
				return new EditingCell();
			}
		});
		tcFName.setOnEditCommit(new EventHandler<CellEditEvent<User, String>>() {
			@Override
			public void handle(CellEditEvent<User, String> event) {
				((User) event.getTableView().getItems().get(event.getTablePosition().getRow()))
						.setFirstName(event.getNewValue());
				;
			}
		});

		TableColumn<User, String> tcLName = new TableColumn<>("LName");
		tcLName.setCellValueFactory(new PropertyValueFactory("lastName"));

		TableColumn<User, String> tcEmail = new TableColumn<>("Email");
		tcEmail.setCellValueFactory(new PropertyValueFactory("email"));

		TableColumn<User, String> tcGender = new TableColumn<>("Gender");
		tcGender.setCellValueFactory(new PropertyValueFactory("gender"));

		TableColumn<User, String> tcBirth = new TableColumn<>("BirthDate");
		tcBirth.setCellValueFactory(new PropertyValueFactory("birthDate"));

		tableView.getColumns().addAll(tcId, tcFName, tcLName, tcEmail, tcGender, tcBirth);

		tableView.setItems(userList);
	} // end of initialize

	class EditingCell extends TableCell<User, String> {

		private TextField textField;

		public EditingCell() {
			super();
		}

		@Override
		public void startEdit() {
			System.out.println("startEdit()");
			if (!isEmpty()) {
				super.startEdit();
				createTextField();
				setText(null);
				setGraphic(textField);
				textField.selectAll();
			}
		}

		@Override
		public void cancelEdit() {
			System.out.println("cancelEdit()");
			super.cancelEdit();

			setText(getItem());
			setGraphic(null);
		}

		@Override
		protected void updateItem(String item, boolean empty) {
			System.out.println("updateItem() => " + item);
			super.updateItem(item, empty);
			if (empty) {
				setText(null);
				setGraphic(null);
			} else {
				if (isEditing()) {
					if (textField != null) {
						textField.setText(getString());
					}
					setText(null);
					setGraphic(textField);
				} else {
					setText(getString());
					setGraphic(null);
				}
			}
		}

		private void createTextField() {
			System.out.println("createTextField()");
			textField = new TextField(getString());
			textField.setMinWidth(this.getWidth() - this.getGraphicTextGap() * 2);
			textField.focusedProperty().addListener(new ChangeListener<Boolean>() {
				@Override
				public void changed(ObservableValue<? extends Boolean> observable, Boolean oldValue, Boolean newValue) {
					if (!newValue) {
						commitEdit(textField.getText());
					}
				}
			});
		}

		private String getString() {
			return getItem() == null ? "" : getItem().toString();
		}
	}
}