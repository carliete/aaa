package CbListas;


public class Privacidade {
	
	private String Cod;
	private String PrivNome;
	public String getCod() {
		return Cod;
	}
	public void setCod(String cod) {
		Cod = cod;
	}
	public String getPrivNome() {
		return PrivNome;
	}
	public void setPrivNome(String privNome) {
		PrivNome = privNome;
	}

	public Privacidade(String cod, String privNome) {
		super();
		Cod = cod;
		PrivNome = privNome;
	}
	public Privacidade() {
		super();
	}
	@Override
	public String toString() {
		return (getCod() + "  " + getPrivNome());
	}


}
