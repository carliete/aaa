package Dao;


import javax.persistence.EntityManager;

import ConexaoBd.Conection;
import Proj.Po2.Entidades.FContato;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class FContatoDao implements InterfaceDAO<FContato> {

	private static ObservableList<FContato> contatos;

	@Override
	public FContato get(String id) {
		if (contatos != null)
			for (FContato cont : contatos)
				if (cont.getAssunto().contentEquals(id))
					return cont;

		EntityManager entityMng = Conection.getEntityManager();
		FContato cont = entityMng.find(FContato.class, id);
		entityMng.close();
		return cont;
	}

	@Override
	public ObservableList<FContato> getAll() {
		if (contatos == null) {
			EntityManager entityMng = Conection.getEntityManager();
			contatos = FXCollections.observableArrayList(
					entityMng.createQuery("select contatos from FContato as contatos", FContato.class).getResultList());
			entityMng.close();
		}
		return contatos;
	}

	@Override
	public void add(FContato contato) {
		EntityManager entityMng = Conection.getEntityManager();
		entityMng.getTransaction().begin();
		entityMng.persist(contato);
		entityMng.getTransaction().commit();
		entityMng.close();
		if (contatos != null)
			contatos.add(contato);
	}

	@Override
	public void delete(FContato obj) {
		EntityManager entityMng = Conection.getEntityManager();
		entityMng.getTransaction().begin();
		FContato cont = entityMng.find(FContato.class, obj.getAssunto());
		entityMng.remove(cont);
		entityMng.getTransaction().commit();
		entityMng.close();

		FContato found = null;
		if (contatos != null)
			for (FContato contato : contatos)
				if (contato.getAssunto().contentEquals(obj.getAssunto()))
					found = contato;
		if (found != null)
			contatos.remove(found);
	}

	@Override
	public void update(FContato obj) {
		EntityManager entityMng = Conection.getEntityManager();
		entityMng.getTransaction().begin();
		FContato cont = entityMng.find(FContato.class, obj.getAssunto());
		cont.setAssunto(obj.getAssunto());
		cont.setMensagem(obj.getMensagem());
		entityMng.getTransaction().commit();
		entityMng.close();

		if (contatos != null) {
			for (FContato cont1 : contatos) {
				if (cont1.getAssunto().contentEquals(obj.getAssunto())) {
					cont1.setAssunto(obj.getAssunto());
					cont1.setMensagem(obj.getMensagem());
				}
			}
		}
	}
}
