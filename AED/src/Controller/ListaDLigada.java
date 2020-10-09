package Controller;

import javax.swing.JOptionPane;

import java.io.Serializable;
import java.util.Vector;

import Files.FileSave;
import Modell.Clientes;






public class ListaDLigada implements InterfaceGeral, Serializable {
	 //static Vector vector_Cliente=new Vector();
	
		
	 
	private No primeiro;
    private No ultimo;
    private int totalElem;

    
    @Override
    public void adicionaInicio(Object elemento) {
		No novo = new No(this.primeiro, elemento);
		
		if (!eVazia()) {
			primeiro.setAnterior(novo);
			
		} else {
			ultimo = novo;
		}
		primeiro = novo;
		
		
		this.totalElem++;
	}

    @Override
    public void adicionaPosicao(int posicao, Object elemento) {

		if (posicao == 0) { 
			this.adicionaInicio(elemento);
		} else if (posicao == this.totalElem) { 
			this.adicionaFim(elemento);
		} else {
			No anterior = this.pegaNo(posicao - 1);
			No actual = anterior.getProximo();
			No novo = new No(actual, anterior, elemento);
			anterior.setProximo(novo);
			actual.setAnterior(novo);
			this.totalElem++;
			
		}
	}

    @Override
    public void adicionaFim(Object elemento) {
        if (this.eVazia()) {
            this.adicionaInicio(elemento);
        } else {
        	No novo = new No(elemento);
			novo.setAnterior(ultimo);
			ultimo.setProximo(novo);
			ultimo = novo;
            
				
			
            totalElem++;
        }
    }
    
    @Override
    public Object pega(int posicao) {
        if (!posicaoOcupada(posicao)){
            throw new IllegalArgumentException("Posição não ocupada.");
        }
        return pegaNo(posicao).getElemento();
    }

    @Override
    public void removeInicio() {
        if (this.eVazia()){
            throw new IllegalArgumentException("A Lista esta Vazia!");
        }
        primeiro = primeiro.getProximo();
        	totalElem--;
        if (totalElem == 0)
            ultimo = null;
        else
            primeiro.setAnterior(null);
    }

    @Override
    public void removePosicao(int posicao) {
        if (!posicaoOcupada(posicao)){
            throw new IllegalArgumentException("A posicao inserida, nao existe na Lista!");
        }
        if (posicao == 0) {
            removeInicio();
        } else if (posicao == totalElem - 1) {
            removeFim();
        } else {
            No anterior = pegaNo(posicao - 1);
            anterior.setProximo(anterior.getProximo().getProximo());
            anterior.getProximo().setAnterior(anterior);
            totalElem--;
        }
    }

    @Override
    public void removeFim() {
    	
        if (totalElem <= 1) {
            removeInicio();
        } else {
            ultimo = ultimo.getAnterior();
            ultimo.setProximo(null);
            totalElem--;
        }
    }

    @Override
    public boolean contem(Object elemento) {
        No no = primeiro;
        for (int i = 0; i < totalElem; i++) {
            if (no.getElemento().equals(elemento))
                return true;
            no = no.getProximo();
        }
        return false;
    }

    @Override
    public int tamanho() {
        return totalElem;
    }

    private No pegaNo(int posicao) {
    	if (!this.posicaoOcupada(posicao)) {
			JOptionPane.showMessageDialog(null,"Posição não existe");
			throw new IllegalArgumentException("Posicao não existe");
		}

		No actual = primeiro;
		for (int i = 0; i < posicao; i++) {
			actual = actual.getProximo();
		}
		return actual;
    }

    private boolean posicaoOcupada(int posicao) {
        return posicao < totalElem && posicao >= 0;
    }

    private boolean posicaoValida(int posicao) {
        return posicao <= totalElem && posicao >= 0;
    }

    public boolean eVazia() {
        return totalElem == 0;
    }
    
    public Object pegaElemento(int posicao) {
		return this.pegaNo(posicao).getElemento();
	}

    @Override
    public String toString() {
        StringBuilder sB = new StringBuilder("|");
        No no = primeiro;
        for (int i = 0; i < totalElem; i++) {
            sB.append(no.getElemento());
            if (i != totalElem - 1)
                sB.append(", ");
            no = no.getProximo();
        }
        sB.append("|");
        return sB.toString();
    }


}
