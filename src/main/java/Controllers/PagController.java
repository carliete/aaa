package Controllers;

import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class PagController {

	@FXML
	private TextField TFnome;
	@FXML
	private TextField TFsubtitulo;
	@FXML
	private TextField TFtexto;

	@FXML
	private Label Lnome;
	@FXML
	private Label Lsubtitulo;
	@FXML
	private Label Ltexto;
	
	
	
	@FXML
	public void alteraNome(ActionEvent event) {
		String nome = TFnome.getText();
		Lnome.setText(nome);
	}
	
	@FXML
	public void alteraSubtitulo(ActionEvent event) {
		String subtitulo = TFsubtitulo.getText();
		Lsubtitulo.setText(subtitulo);
	}
	
	@FXML
	public void alteraTexto(ActionEvent event) {
		String texto = TFsubtitulo.getText();
		Ltexto.setText(texto);
	}
	
	@FXML
	private void SVoltar(ActionEvent event) throws IOException {
		App.setRoot("fifth");
	}
}
