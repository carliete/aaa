package Controllers;

import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;

public class TermosController {

	@FXML
	private void SVoltar(ActionEvent action) throws IOException {
		App.setRoot("Login");
	}
}
