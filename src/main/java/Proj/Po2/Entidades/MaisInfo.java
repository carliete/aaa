package Proj.Po2.Entidades;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

import CbListas.Privacidade;
import CbListas.TipoWeb;
import CbListas.Area;
import CbListas.Idioma;

@Entity
public class MaisInfo {
	@Id
	private String PalaChave;
	private String Nome;
	private String Area;
	private String Idioma;
	private String Privacidade;
	private String Tipo;

	public String getPalaChave() {
		return PalaChave;
	}

	public void setPalaChave(String palaChave) {
		PalaChave = palaChave;
	}

	public String getNome() {
		return Nome;
	}

	public void setNome(String nome) {
		Nome = nome;
	}

	public String getArea() {
		return Area;
	}

	public void setArea(String area) {
		Area = area;
	}

	public String getIdioma() {
		return Idioma;
	}

	public void setIdioma(String idioma) {
		Idioma = idioma;
	}

	public String getPrivacidade() {
		return Privacidade;
	}

	public void setPrivacidade(String privacidade) {
		Privacidade = privacidade;
	}

	public String getTipo() {
		return Tipo;
	}

	public void setTipo(String tipo) {
		Tipo = tipo;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((PalaChave == null) ? 0 : PalaChave.hashCode());
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
		MaisInfo other = (MaisInfo) obj;
		if (PalaChave == null) {
			if (other.PalaChave != null)
				return false;
		} else if (!PalaChave.equals(other.PalaChave))
			return false;
		return true;
	}

	public MaisInfo(String palaChave, String nome, String area, String idioma, String privacidade, String tipo) {
		super();
		PalaChave = palaChave;
		Nome = nome;
		Area = area;
		Idioma = idioma;
		Privacidade = privacidade;
		Tipo = tipo;
	}

	public MaisInfo() {
		super();
	}

	@Override
	public String toString() {
		return ("Dominio =" + getPalaChave() + ", Nome=" + getNome() + ", Area=" + getArea() + ", Tipo=" + getTipo() + "");
	}
	
	
	public String toStringa() {
		return getPalaChave();
	}

}
