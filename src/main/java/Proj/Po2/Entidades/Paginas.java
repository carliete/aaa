package Proj.Po2.Entidades;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Paginas {
	
	@Id
	private String nomePagina;

	public String getNomePagina() {
		return nomePagina;
	}

	public void setNomePagina(String nomePagina) {
		this.nomePagina = nomePagina;
	}

	public Paginas(String nomePagina) {
		super();
		this.nomePagina = nomePagina;
	}
	
	public Paginas() {
		super();
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((nomePagina == null) ? 0 : nomePagina.hashCode());
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
		Paginas other = (Paginas) obj;
		if (nomePagina == null) {
			if (other.nomePagina != null)
				return false;
		} else if (!nomePagina.equals(other.nomePagina))
			return false;
		return true;
	}


	
	
}
