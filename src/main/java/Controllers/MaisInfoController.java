package Controllers;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

import CbListas.Area;
import CbListas.Idioma;
import CbListas.Privacidade;
import Dao.MaisInfoDao;
import Proj.Po2.Entidades.MaisInfo;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;

public class MaisInfoController implements Initializable {

	@FXML
	private TextField Nome;
	@FXML
	private TextField Dominio;
	@FXML
	private ComboBox<Area> area1;
	@FXML
	private ComboBox<Privacidade> privacidade;
	@FXML
	private ComboBox<Idioma> idioma;

	static String tipos;

	private List<Area> ListArea = new ArrayList<Area>();
	private List<Idioma> ListIdioma = new ArrayList<Idioma>();
	private List<Privacidade> ListPrivacidade = new ArrayList<Privacidade>();
	static public ObservableList<Area> ObsArea;
	static public ObservableList<Privacidade> ObsPriv;
	static public ObservableList<Idioma> ObsIdi;

	@FXML
	private void Salvar(ActionEvent action) throws IOException {
		MaisInfo mais = new MaisInfo(Dominio.getText(), Nome.getText(),
				area1.getSelectionModel().getSelectedItem().getAreaNome(),
				privacidade.getSelectionModel().getSelectedItem().getPrivNome(),
				idioma.getSelectionModel().getSelectedItem().getIdioNome(), tipos);
		new MaisInfoDao().add(mais);
		App.setRoot("fifth");
	}

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		AreaA();
		CarregaPriv();
		CarregaIdi();
	}

	private void AreaA() {
		Area area = new Area("1", "Comidas");
		Area area2 = new Area("3", "Anime");
		Area area3 = new Area("2", "Desenho");
		ListArea.add(area);
		ListArea.add(area2);
		ListArea.add(area3);
		ObsArea = FXCollections.observableArrayList(ListArea);
		area1.setItems(ObsArea);

	}

	private void CarregaPriv() {
		Privacidade priva = new Privacidade("1", "Publico");
		Privacidade priva2 = new Privacidade("2", "Privado");
		Privacidade priva3 = new Privacidade("3", "Oculto");
		ListPrivacidade.add(priva);
		ListPrivacidade.add(priva2);
		ListPrivacidade.add(priva3);

		ObsPriv = FXCollections.observableArrayList(ListPrivacidade);
		privacidade.setItems(ObsPriv);

	}

	private void CarregaIdi() {
		Idioma idiom = new Idioma("1", "Ingles");
		Idioma idiom1 = new Idioma("2", "Portugues");
		Idioma idiom2 = new Idioma("3", "Espanhol");
		ListIdioma.add(idiom);
		ListIdioma.add(idiom1);
		ListIdioma.add(idiom2);
		ObsIdi = FXCollections.observableArrayList(ListIdioma);
		idioma.setItems(ObsIdi);
	}

}
