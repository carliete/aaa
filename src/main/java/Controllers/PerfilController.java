package Controllers;

import java.io.IOException;

import Dao.PerfilDao;
import Proj.Po2.Entidades.Perfil;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class PerfilController {

	ObservableList<Perfil> perfila;
	
	@FXML
	private Label nomeUsuario;
	@FXML
	private Label nomeUsuario2;
	@FXML
	private TextField nomeText;
	@FXML
	private TextField sobrenomeText;
	@FXML
	private TextField Cpf;
	@FXML
	private TextField NomeExibi;
	@FXML
	private DatePicker Nasci;
	@FXML
	private TextField Sexo;

	@FXML
	private void SxVoltar(ActionEvent action) throws IOException {
		App.setRoot("fifth");
	}

	@FXML
	private void Ssalvar(ActionEvent action) throws IOException {

		PerfilDao dao = new PerfilDao();
		perfila = dao.getAll();
		if (perfila.size() <= 0) {
			
			Perfil perfil = new Perfil(Cpf.getText(), nomeText.getText(), sobrenomeText.getText(), NomeExibi.getText(),
					Nasci.getPromptText(), Sexo.getText());
			new Dao.PerfilDao().add(perfil);
			
		} else {
			for (int in = 0; in < perfila.size(); in++) {
				if (perfila.get(in).getCpf().equals(Cpf.getText())) {
					Perfil perfil1 = new Perfil(Cpf.getText(), nomeText.getText(), sobrenomeText.getText(),
							NomeExibi.getText(), Nasci.getPromptText(), Sexo.getText());
					new Dao.PerfilDao().update(perfil1);
				} else {
					Perfil perfil = new Perfil(Cpf.getText(), nomeText.getText(), sobrenomeText.getText(),
							NomeExibi.getText(), Nasci.getPromptText(), Sexo.getText());
					new Dao.PerfilDao().add(perfil);
				}
			}
		}

		String nome = nomeText.getText();
		String sobrenome = sobrenomeText.getText();

		nomeUsuario.setText(nome + " " + sobrenome);
		nomeUsuario2.setText("@" + nome + sobrenome);
	}

}
