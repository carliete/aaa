package Proj.Po2.Entidades;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class FContato {
	
	@Id
	private String Assunto;
	private String Mensagem;
	
	public String getAssunto() {
		return Assunto;
	}
	public void setAssunto(String assunto) {
		Assunto = assunto;
	}
	public String getMensagem() {
		return Mensagem;
	}
	public void setMensagem(String mensagem) {
		Mensagem = mensagem;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((Assunto == null) ? 0 : Assunto.hashCode());
		result = prime * result + ((Mensagem == null) ? 0 : Mensagem.hashCode());
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
		FContato other = (FContato) obj;
		if (Assunto == null) {
			if (other.Assunto != null)
				return false;
		} else if (!Assunto.equals(other.Assunto))
			return false;
		if (Mensagem == null) {
			if (other.Mensagem != null)
				return false;
		} else if (!Mensagem.equals(other.Mensagem))
			return false;
		return true;
	}
	
	
	@Override
	public String toString() {
	    return "Assunto: " + Assunto + " " + "Mensagem: " +  Mensagem;
	}
	public FContato(String assunto, String mensagem) {
		super();
		Assunto = assunto;
		Mensagem = mensagem;
	}
	public FContato() {
		super();
	}
	
	

}
