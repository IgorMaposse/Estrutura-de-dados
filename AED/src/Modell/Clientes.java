package Modell;


import java.io.Serializable;

public class Clientes extends Pessoa implements Serializable{

	//private static final long serialVersionUID =6128016096756071380L;

	private String codigo;
	public Clientes(String nome, String id, int idade, String numero,
			String apelido) {
		super(nome, id, idade, numero, apelido);
		// TODO Auto-generated constructor stub
	}
	
	public Clientes(){
		
	}
	public String getCodigo() {
		return codigo;
	}
	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}

	@Override
	public String toString() {
		return "Clientes [codigo=" + codigo + ", getCodigo()=" + getCodigo()
				+ ", getApelido()=" + getApelido() + ", getNome()=" + getNome()
				+ ", getId()=" + getId() + ", getIdade()=" + getIdade()
				+ ", getNumero()=" + getNumero() + ", toString()="
				+ super.toString() + ", getClass()=" + getClass()
				+ ", hashCode()=" + hashCode() + "]";
	}
	

	
	

}


