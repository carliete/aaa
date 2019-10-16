package Controllers;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import Dao.MaisInfoDao;
import Proj.Po2.Entidades.MaisInfo;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ListView;

public class ListPag implements Initializable {

	@FXML
	private ListView<MaisInfo> Lista;

	public ObservableList<MaisInfo> list;

	static public String cod;

	@FXML
	private void delete() {
		new MaisInfoDao().delete(Lista.getSelectionModel().getSelectedItem());
	}

	@FXML
	private void Voltar(ActionEvent action) throws IOException {
		App.setRoot("fifth");
	}

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		updateList();
	}

	public void updateList() {
		MaisInfoDao dao = new MaisInfoDao();
		Lista.setItems(null);
		list = (ObservableList<MaisInfo>) dao.getAll();
		Lista.setItems(list);
	}

	@FXML
	public void editarSite() throws IOException {
		cod = Lista.getSelectionModel().getSelectedItem().getPalaChave();
		App.setRoot("UpMaisInfo");
	}
}
