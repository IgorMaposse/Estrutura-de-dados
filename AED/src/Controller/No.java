package Controller;

import java.io.Serializable;


public class No implements Serializable{
	private No proximo;
	private No anterior;
	private Object elemento;

	public No(No proximo, No anterior, Object elemento) {
		super();
		this.proximo = proximo;
		this.anterior = anterior;
		this.elemento = elemento;
	}

	public No(Object elemento) {
		super();
		this.elemento = elemento;
	}

	public No(No proximo, Object elemento) {
		super();
		this.proximo = proximo;
		this.elemento = elemento;
	}

	public No getProximo() {
		return proximo;
	}

	public void setProximo(No proximo) {
		this.proximo = proximo;
	}

	public No getAnterior() {
		return anterior;
	}

	public void setAnterior(No anterior) {
		this.anterior = anterior;
	}

	public Object getElemento() {
		return elemento;
	}

	public void setElemento(Object elemento) {
		this.elemento = elemento;
	}
}
