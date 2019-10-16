package CbListas;

public class Idioma {


	private String cod;
	private String IdioNome;

	public String getIdioNome() {
		return IdioNome;
	}

	public String getCod() {
		return cod;
	}

	public void setCod(String cod) {
		this.cod = cod;
	}

	public void setIdioNome(String idioNome) {
		IdioNome = idioNome;
	}

	public Idioma(String cod, String idioNome) {
		super();
		this.cod = cod;
		IdioNome = idioNome;
	}

	public Idioma() {
		super();
	}

	@Override
	public String toString() {
		return (getCod() + "    " + getIdioNome());
	}
	
	

}
