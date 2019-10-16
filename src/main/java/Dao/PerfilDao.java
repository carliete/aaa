package Dao;

import javax.persistence.EntityManager;

import ConexaoBd.Conection;
import Proj.Po2.Entidades.Perfil;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class PerfilDao implements InterfaceDAO<Perfil>{

	private static ObservableList<Perfil> perfis;
	
	@Override
	public Perfil get(String id) {
		if (perfis != null)
			for (Perfil perfil : perfis)
				if (perfil.getCpf().contentEquals(id))
					return perfil;

		EntityManager entityMng = Conection.getEntityManager();
		Perfil perfil = entityMng.find(Perfil.class, id);
		entityMng.close();
		return perfil;
	}

	@Override
	public ObservableList<Perfil> getAll() {
		if (perfis == null) {
			EntityManager entityMng = Conection.getEntityManager();
			perfis = FXCollections.observableArrayList(
					entityMng.createQuery("select perfil from Perfil as perfil", Perfil.class).getResultList());
			entityMng.close();
		}
		return perfis;
	}

	@Override
	public void add(Perfil perfil) {
		EntityManager entityMng = Conection.getEntityManager();
		entityMng.getTransaction().begin();
		entityMng.persist(perfil);
		entityMng.getTransaction().commit();
		entityMng.close();
		if (perfis != null)
			perfis.add(perfil);
		
	}

	@Override
	public void delete(Perfil obj) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void update(Perfil obj) {
		EntityManager entityMng = Conection.getEntityManager();
		entityMng.getTransaction().begin();
		Perfil perfilDB = entityMng.find(Perfil.class, obj.getCpf());
		perfilDB.setNamePerfil(obj.getNamePerfil());
		perfilDB.setExibiPublicPerfil(obj.getExibiPublicPerfil());
		perfilDB.setNasciPerfil(obj.getNasciPerfil());
		perfilDB.setSexoPerfil(obj.getSexoPerfil());
		perfilDB.setSobrePerfil(obj.getSobrePerfil());
		entityMng.getTransaction().commit();
		entityMng.close();

		if (perfis != null) {
			for (Perfil perfil : perfis) {
				if (perfil.getCpf().contentEquals(obj.getCpf())) {
					perfil.setNamePerfil(obj.getNamePerfil());
					perfil.setExibiPublicPerfil(obj.getExibiPublicPerfil());
					perfil.setNasciPerfil(obj.getNasciPerfil());
					perfil.setSexoPerfil(obj.getSexoPerfil());
					perfil.setSobrePerfil(obj.getSobrePerfil());
					
				}
			}
		}

	}
		
	}

