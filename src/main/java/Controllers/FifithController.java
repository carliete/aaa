package Controllers;

import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;

public class FifithController {

	// Quinta tela

	@FXML
	private void QIPerfil(ActionEvent action) throws IOException {
		App.setRoot("Perfil");
	}

	@FXML
	private void QSite(ActionEvent action) throws IOException {
		App.setRoot("ListPagin");
	}
	@FXML
	private void CriarWeb(ActionEvent action) throws IOException {
		App.setRoot("TipoWebSite");
	}
		
	@FXML
	private void QFerramentas(ActionEvent action) throws IOException {
		App.setRoot("Ferramentas");
	}

	@FXML
	private void QVoltar(ActionEvent action) throws IOException {
		App.setRoot("Login");
	}

	@FXML
	private void Contato(ActionEvent action) throws IOException {
		App.setRoot("Contato");

	}
	
}
