package CbListas;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Area {
	@Id
	private String cod;
	private String AreaNome;

	public String getCod() {
		return cod;
	}

	public void setCod(String cod) {
		this.cod = cod;
	}

	public String getAreaNome() {
		return AreaNome;
	}

	public void setAreaNome(String areaNome) {
		AreaNome = areaNome;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((cod == null) ? 0 : cod.hashCode());
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
		Area other = (Area) obj;
		if (cod == null) {
			if (other.cod != null)
				return false;
		} else if (!cod.equals(other.cod))
			return false;
		return true;
	}

	public Area(String cod, String areaNome) {
		super();
		this.cod = cod;
		AreaNome = areaNome;
	}

	public Area() {
		super();
	}

	@Override
	public String toString() {
		return (getCod() +"  "+ getAreaNome());
	}
	
	

}
