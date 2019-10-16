package CbListas;


public class TipoWeb {

	private String cod;
	private String tipo;

	public String getCod() {
		return cod;
	}

	public void setCod(String cod) {
		this.cod = cod;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public TipoWeb(String cod, String tipo) {
		super();
		this.cod = cod;
		this.tipo = tipo;
	}

	public TipoWeb() {
		super();
	}

	@Override
	public String toString() {
		return (getCod() + "   " + getTipo());
	}
	
	

}
