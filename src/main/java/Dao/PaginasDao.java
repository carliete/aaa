package Dao;

import java.util.List;

import javax.persistence.EntityManager;

import ConexaoBd.Conection;
import Proj.Po2.Entidades.Paginas;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class PaginasDao implements InterfaceDAO<Paginas>{
	private static ObservableList<Paginas> paginas;
	
	@Override
	public Paginas get(String id) {
		if (paginas != null)
			for (Paginas pag : paginas)
				if (pag.getNomePagina().contentEquals(id))
					return pag;

		EntityManager entityMng = Conection.getEntityManager();
		Paginas pag = entityMng.find(Paginas.class, id);
		entityMng.close();
		return pag;
	}

	@Override
	public List<Paginas> getAll() {
		if (paginas == null) {
			EntityManager entityMng = Conection.getEntityManager();
			paginas = FXCollections.observableArrayList(
					entityMng.createQuery("select paginas from Paginas as paginas", Paginas.class).getResultList());
			entityMng.close();
		}
		return paginas;
	}

	@Override
	public void add(Paginas pagina) {
		EntityManager entityMng = Conection.getEntityManager();
		entityMng.getTransaction().begin();
		entityMng.persist(pagina);
		entityMng.getTransaction().commit();
		entityMng.close();
		if (paginas != null)
			paginas.add(pagina);
		
	}

	@Override
	public void delete(Paginas obj) {
		EntityManager entityMng = Conection.getEntityManager();
		entityMng.getTransaction().begin();
		Paginas pagDB = entityMng.find(Paginas.class, obj.getNomePagina());
		entityMng.remove(pagDB);
		entityMng.getTransaction().commit();
		entityMng.close();

		Paginas found = null;
		if (paginas != null)
			for (Paginas pagina : paginas)
				if (pagina.getNomePagina().contentEquals(obj.getNomePagina()))
					found = pagina;
		if (found != null)
			paginas.remove(found);
		
	}

	@Override
	public void update(Paginas obj) {
		EntityManager entityMng = Conection.getEntityManager();
		entityMng.getTransaction().begin();
		Paginas pagDB = entityMng.find(Paginas.class, obj.getNomePagina());
		pagDB.setNomePagina(obj.getNomePagina());
		entityMng.getTransaction().commit();
		entityMng.close();

		if (paginas != null) {
			for (Paginas pag : paginas) {
				if (pag.getNomePagina().contentEquals(obj.getNomePagina())) {
					pag.setNomePagina(obj.getNomePagina());
				}
			}
		}

	}

}
