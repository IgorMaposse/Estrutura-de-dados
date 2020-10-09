package Controller;

import java.io.IOException;
import java.io.Serializable;

import Files.FileSave;
import Modell.Clientes;

public class Hotel_Controller  implements Serializable{
	ListaDLigada dLigada = new ListaDLigada();
	FileSave fileSave = new FileSave();
	
	public Hotel_Controller() {
	try {
		dLigada=fileSave.readInfo("src/Files/Cliente.dat",dLigada);
	} catch (ClassNotFoundException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	}
	
	
	public void registarCliente(Clientes clientes) throws IOException {
		dLigada.adicionaInicio(clientes);
		fileSave.saveInfo("src/Files/Cliente.dat", dLigada);
	}
	
	
	public Clientes buscarCliente(Clientes cliente) {
		for (int i = 0; i < dLigada.tamanho(); i++) {
			Clientes clientes = (Clientes) dLigada.pega(i);
			if(clientes.getId().equals(cliente.getId())){
				return clientes;
			}
		}
		return null;
	}
	
	public String EliminarCliente(Clientes cliente) {
		for (int i = 0; i < dLigada.tamanho(); i++) {
			Clientes clientes = (Clientes) dLigada.pega(i);
			if(clientes.getId().equals(cliente.getId())){
				dLigada.removePosicao(i);
				//fileSave.saveInfo("src/Files/Cliente.dat", dLigada);
				return "Usuario removido com sucesso";
			}
		}
		return null;
	}
	public ListaDLigada ordenaIdade() {
			for (int i = 0; i < dLigada.tamanho(); i++) {
				Clientes cliente1= (Clientes) dLigada.pega(i);
				Clientes cliente2= (Clientes) dLigada.pega(i+1);
			if(cliente1.getIdade()<cliente2.getIdade()){
				dLigada.adicionaPosicao(i, cliente2);
				dLigada.adicionaPosicao((i+1), cliente1);
			}else{
				dLigada.adicionaPosicao(i, cliente2);
				dLigada.adicionaPosicao((i+1), cliente1);
			}
		}
			return dLigada;
	}
	
}
