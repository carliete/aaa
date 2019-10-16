package Dao;

import java.util.List;

import javax.persistence.EntityManager;

import ConexaoBd.Conection;
import Proj.Po2.Entidades.MaisInfo;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class MaisInfoDao  implements InterfaceDAO<MaisInfo>  {

	private static ObservableList<MaisInfo> MaisInfos;
	
	@Override
	public MaisInfo get(String id) {
		if (MaisInfos != null)
			for (MaisInfo infos : MaisInfos)
				if (infos.getPalaChave().contentEquals(id))
					return infos;

		EntityManager entityMng = Conection.getEntityManager();
		MaisInfo infos = entityMng.find(MaisInfo.class, id);
		entityMng.close();
		return infos;
	}

	@Override
	public List<MaisInfo> getAll() {
		if (MaisInfos == null) {
			EntityManager entityMng = Conection.getEntityManager();
			MaisInfos = FXCollections.observableArrayList(
					entityMng.createQuery("select MaisInfos from MaisInfo as MaisInfos", MaisInfo.class).getResultList());
			entityMng.close();
		}
		return MaisInfos;
	}

	@Override
	public void add(MaisInfo MaisInfo) {
		EntityManager entityMng = Conection.getEntityManager();
		entityMng.getTransaction().begin();
		entityMng.persist(MaisInfo);
		entityMng.getTransaction().commit();
		entityMng.close();
		if (MaisInfos != null)
			MaisInfos.add(MaisInfo);
		
	}

	@Override
	public void delete(MaisInfo obj) {
		EntityManager entityMng = Conection.getEntityManager();
		entityMng.getTransaction().begin();
		MaisInfo infosDb = entityMng.find(MaisInfo.class, obj.getPalaChave());
		entityMng.remove(infosDb);
		entityMng.getTransaction().commit();
		entityMng.close();

		MaisInfo found = null;
		if (MaisInfos != null)
			for (MaisInfo infos : MaisInfos)
				if (infos.getPalaChave().contentEquals(obj.getPalaChave()))
					found = infos;
		if (found != null)
			MaisInfos.remove(found);
		
	}

	@Override
	public void update(MaisInfo obj) {
		EntityManager entityMng = Conection.getEntityManager();
		entityMng.getTransaction().begin();
		MaisInfo infosDB = entityMng.find(MaisInfo.class, obj.getPalaChave());
		infosDB.setNome(obj.getNome());
		infosDB.setTipo(obj.getTipo());
		infosDB.setArea(obj.getArea());
		infosDB.setIdioma(obj.getIdioma());
		infosDB.setPrivacidade(obj.getPrivacidade());
		entityMng.getTransaction().commit();
		entityMng.close();

		if (MaisInfos != null) {
			for (MaisInfo infos : MaisInfos) {
				if (infos.getPalaChave().contentEquals(obj.getPalaChave())) {
					infos.setNome(obj.getNome());
					infos.setTipo(obj.getTipo());
					infos.setArea(obj.getArea());
					infos.setIdioma(obj.getIdioma());
					infos.setPrivacidade(obj.getPrivacidade());
				}
			}
		}

	}
		

}
