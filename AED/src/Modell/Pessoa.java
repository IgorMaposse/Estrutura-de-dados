package Modell;

public class Pessoa {
	private String nome; 
	private String id; 
	private int idade;
	private String numero;
	private String apelido;
	public Pessoa(String nome, String id, int idade, String numero, String apelido) {
		super();
		this.nome = nome;
		this.id = id;
		this.idade = idade;
		this.numero = numero;
		this.apelido = apelido;
	}
	
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public int getIdade() {
		return idade;
	}
	public void setIdade(int idade) {
		this.idade = idade;
	}
	public String getNumero() {
		return numero;
	}
	public void setNumero(String numero) {
		this.numero = numero;
	}
	public String getApelido() {
		return apelido;
	}
	public void setApelido(String apelido) {
		this.apelido = apelido;
	}
	@Override
	public String toString() {
		return "Pessoa [nome=" + nome + ", id=" + id + ", idade=" + idade + ", numero=" + numero + ", apelido="
				+ apelido + "]";
	}
	
	

}
