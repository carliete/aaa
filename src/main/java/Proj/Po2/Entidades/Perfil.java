package Proj.Po2.Entidades;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Perfil {
	@Id
	private String Cpf;
	private String NamePerfil;
	private String SobrePerfil;
	private String ExibiPublicPerfil;
	private String NasciPerfil;
	private String SexoPerfil;

	public Perfil() {
		super();
	}

	public String getCpf() {
		return Cpf;
	}

	public void setCpf(String cpf) {
		Cpf = cpf;
	}

	public String getNamePerfil() {
		return NamePerfil;
	}

	public void setNamePerfil(String namePerfil) {
		NamePerfil = namePerfil;
	}

	public String getSobrePerfil() {
		return SobrePerfil;
	}

	public void setSobrePerfil(String sobrePerfil) {
		SobrePerfil = sobrePerfil;
	}

	public String getExibiPublicPerfil() {
		return ExibiPublicPerfil;
	}

	public void setExibiPublicPerfil(String exibiPublicPerfil) {
		ExibiPublicPerfil = exibiPublicPerfil;
	}

	public String getNasciPerfil() {
		return NasciPerfil;
	}

	public void setNasciPerfil(String nasciPerfil) {
		NasciPerfil = nasciPerfil;
	}

	public String getSexoPerfil() {
		return SexoPerfil;
	}

	public void setSexoPerfil(String sexoPerfil) {
		SexoPerfil = sexoPerfil;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((Cpf == null) ? 0 : Cpf.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Perfil other = (Perfil) obj;
		if (Cpf == null) {
			if (other.Cpf != null)
				return false;
		} else if (!Cpf.equals(other.Cpf))
			return false;
		return true;
	}

	public Perfil(String cpf, String namePerfil, String sobrePerfil, String exibiPublicPerfil, String string,
			String sexoPerfil) {
		super();
		Cpf = cpf;
		NamePerfil = namePerfil;
		SobrePerfil = sobrePerfil;
		ExibiPublicPerfil = exibiPublicPerfil;
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy");
		this.NasciPerfil = dtf.format(LocalDateTime.now());
		SexoPerfil = sexoPerfil;
	}

}
