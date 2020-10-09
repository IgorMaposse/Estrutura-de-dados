package Files;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.Collection;
import java.util.Vector;

import javax.swing.JOptionPane;

import Controller.ListaDLigada;
import Modell.Clientes;
public class FileSave {
	
	public static void saveInfo(String fileName,ListaDLigada dLigada) throws IOException {
		File ficheiro = new File(fileName);
		Vector v =new Vector();
		v.add("Emanuel");
		FileOutputStream stream = new FileOutputStream(ficheiro);
			ObjectOutputStream out = new ObjectOutputStream(stream);
			for (int i = 0; i < dLigada.tamanho(); i++) {;
				out.writeObject(dLigada);
				//out.writeObject(v);
				System.out.println("Salvo com Sucesso");
			}
//			out.writeObject(dLigada);
			stream.close();
			
		
	
	}
	

	
	public static ListaDLigada readInfo(String nomeFicheiro,ListaDLigada dLigada) throws ClassNotFoundException {
		
		File ficheiro = new File("src/Files/Cliente.dat");
		FileInputStream stream;
		
		
		try {
			stream = new FileInputStream(ficheiro);
			ObjectInputStream saver = new ObjectInputStream(stream);	
			
			
			
			dLigada=(ListaDLigada) saver.readObject();
			
		
		} catch (IOException e) {
//			JOptionPane.showMessageDialog(null,e.getMessage());
		}
		return dLigada;
	}
	
	
	
	
	
	public static void readInfoMadodas(String nomeFicheiro, ListaDLigada lista) {
		File ficheiro = new File(nomeFicheiro);
		FileInputStream stream;
		Vector otal = null;
		try {
			stream = new FileInputStream(ficheiro);
			ObjectInputStream saver = new ObjectInputStream(stream);
			otal.addAll((Collection) saver.readObject());
			for (Object object : otal) {
				lista.adicionaInicio(object);
			}
		} catch (IOException | ClassNotFoundException e) {
		}
		
		
	
	}
	
	}


