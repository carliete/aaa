package Controllers;

import java.io.IOException;

import Dao.FContatoDao;
import Proj.Po2.Entidades.FContato;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class ContatoController {

	@FXML
	private TextField assunto;
	@FXML
	private TextField mensagem;
	@FXML
	private Label text;

	@FXML
	private void Voltar() throws IOException {
		App.setRoot("fifth");
	}

	@FXML
	private void ListMensa() throws IOException {
		App.setRoot("ListMensagens");
	}

	@FXML
	private void Enviar() {

		try {
			FContato contatos = new FContato(assunto.getText(), mensagem.getText());
			new FContatoDao().add(contatos);
			text.setText("Mensagem Enviada com sucesso!");
		} catch (Exception e) {
			text.setText("Não foi possivel enviar a mensagem, por favor tente mais tarde!");
		}
	}
}
