package Controllers;

import java.io.IOException;
import Proj.Po2.Entidades.User;
import javafx.fxml.FXML;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

public class LoginController {
	// Cadastro
	@FXML
	private TextField name;
	@FXML
	private TextField email;
	@FXML
	private PasswordField pass;

	// Login
	@FXML
	private TextField nameLog;

	@FXML
	private PasswordField passLog;

	@FXML
	private void Logar() throws IOException {

		try {
			App.setRoot("fifth");
		} catch (Exception e) {

		}
	}

	@FXML
	private void Continuar() throws IOException {
		User users = new User(name.getText(), email.getText(), pass.getText());
		new Dao.UserDao().add(users);
		App.setRoot("TipoWebSite");
	}

	@FXML
	private void Termos() throws IOException {
		App.setRoot("Termos");
	}

}
