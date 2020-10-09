package Controller;

import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Vector;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import Files.FileSave;
import Modell.Clientes;

public class Paine_Segundo extends JPanel implements ActionListener {

	private JPanel painel_Primeiro;
	private JLabel label_nome;
	private JLabel label_Apelido;
	private JLabel label_Idade;
	private JLabel label_id,label_Sexo;
	private JTextField text_nome;
	private JTextField text_Apelido;
	private JTextField  text_Sexo,text_idade;
	private JTextField text_id;
	private JPanel painelCima,painelCima2,painelBaixo,painel1,painel2,painel3,painel4,painel5;
	private JRadioButton radioMasculino;
	private JButton botaoRegistar,botaoPesqusarInicio,botaoPesqusarFim;
	private JButton botaoPesquisar;
	private Vector colunas;
	private   Vector boss;
	private JTable tabela;
	private JRadioButton radioFemenino;
	private ButtonGroup grupo;
	private DefaultTableModel modelo;
	private JScrollPane scrollPane;
	private FileSave fs=new FileSave();
	private ListaDLigada dLigada=new ListaDLigada();
	Vector<Clientes> vector=new Vector<Clientes>();
	Hotel_Controller hotalController=new Hotel_Controller();
	
	public Paine_Segundo() {
	
		setBounds(10, 11, 764, 469);
		
		painelCima=new JPanel();
		painelBaixo=new JPanel();
		

		modelo=new DefaultTableModel();
		modelo.addColumn("Nome:");
		modelo.addColumn("Apelido");
		modelo.addColumn("Id");
		modelo.addColumn("Idade");
		
		

		
		painelCima2=new JPanel();
		painelCima2.setLayout(new FlowLayout(FlowLayout.LEFT));
		
		painelBaixo.setLayout(new GridLayout(2,1));
		painel1=new JPanel();
		painel2=new JPanel();
		painel3=new JPanel();
		painel4=new JPanel();
		painel5=new JPanel();
		radioMasculino =new JRadioButton("Masculino");
		radioFemenino =new JRadioButton("Femenino");
		setLayout(new GridLayout(2,1));
		
		
		add(painelCima);
		
		add(painelBaixo);
		
		botaoPesquisar=new JButton("Pesquisar Cliente");
		botaoPesqusarInicio=new JButton("Pesqusar Inicio");
		botaoPesqusarFim=new JButton("Pesquisar Fim");
		//painelCima2.add(botaoPesquisar);
		painelCima2.add(botaoPesqusarInicio);
		painelCima2.add(botaoPesqusarFim);
		painelCima2.add(botaoPesquisar);
		painelBaixo.add(painelCima2);
		tabela=new  JTable(modelo);
		tabela.setPreferredScrollableViewportSize(new Dimension(730,55));
		
		scrollPane=new JScrollPane(tabela);
		
		scrollPane.setBounds(10, 11, 764, 469);
		
		painelCima2.add(scrollPane);
		grupo=new ButtonGroup();
		
		label_nome = new JLabel(" Nome :");
		label_Apelido = new JLabel("Apelido:");
		label_Idade = new JLabel(" Idade : ");
		label_id = new JLabel("     Id:       ");
		label_Sexo=new JLabel("   Sexo:    ");
		
	
		text_nome =new JTextField(20);
		text_Apelido =new JTextField(20);
		text_idade =new JTextField(20);
		text_id =new JTextField(20);
		
		grupo.add(radioMasculino);
		grupo.add(radioFemenino);
		
		painelCima.setLayout(new GridLayout(5,1));
		
		
		painelCima.add(painel1);
		
		painelCima.add(painel2);
	
		painelCima.add(painel3);
		painel3.add(label_Idade);
		painel3.add(text_idade);
		
		painelCima.add(painel4);
		painel4.add(label_id);
		painel4.add(text_id);
		
		painelCima.add(painel5);
		visualizar(dLigada);
		
		setVisible(true);
		
		
		
		
	}

public void visualizar(ListaDLigada dLigada){


		
		try {
			
		//	System.out.println(fs.readInfo("src/Files/Cliente.dat",dLigada));
			dLigada=fs.readInfo("src/Files/Cliente.dat",dLigada);
			
			//JOptionPane.showMessageDialog(null, dLigada.tamanho());
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//DefaultTableModel modelo=(DefaultTableModel)tabela.getModel();
		
		Clientes cliente=new Clientes();
	
		for(int i=0;i<dLigada.tamanho();i++){
			
		//cliente=(Clientes)dLigada.pega(i);
			//System.out.println(cliente.getNome());
			String array[]=new String[4];
			array[0]=((Clientes) dLigada.pega(i)).getNome().toString();
			array[1]=((Clientes) dLigada.pega(i)).getApelido().toString();
			array[2]=((Clientes) dLigada.pega(i)).getId().toString();
			array[3]=((Clientes) dLigada.pega(i)).getIdade()+"";
			
				modelo.addRow(array);
				
			
			
			
		}
		
		
}
	
	

	@Override
	public void actionPerformed(ActionEvent accao) {
		// TODO Auto-generated method stub
		Hotel_Controller hotel=new Hotel_Controller();
		String []array=new String[4];
		DefaultTableModel modelo2 =(DefaultTableModel)tabela.getModel();
		Clientes cliente=new Clientes();
		try {
			dLigada=fs.readInfo("src/Files/Cliente.dat",dLigada);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		boolean vadidar_Idade; 
		if(botaoPesquisar==accao.getSource()){
				
					for (int i = 0; i < dLigada.tamanho(); i++) {
						if(text_idade.getText().equals((((Clientes) dLigada.pega(i)).getIdade()+"")) && text_id.getText().equals("")){
							array[0]=((Clientes) dLigada.pega(i)).getNome().toString();
							array[1]=((Clientes) dLigada.pega(i)).getApelido().toString();
							array[2]=((Clientes) dLigada.pega(i)).getId().toString();
							array[3]=(((Clientes) dLigada.pega(i)).getIdade()+"");
							modelo2.addRow(array);
							
						}else if(text_id.getText().equals((((Clientes) dLigada.pega(i)).getId()+"")) && text_idade.getText().equals("")){
							array[0]=((Clientes) dLigada.pega(i)).getNome().toString();
							array[1]=((Clientes) dLigada.pega(i)).getApelido().toString();
							array[2]=((Clientes) dLigada.pega(i)).getId().toString();
							array[3]=(((Clientes) dLigada.pega(i)).getIdade()+"");
							modelo2.addRow(array);
						}else if(text_idade.getText().equals((((Clientes) dLigada.pega(i)).getIdade()+"")) && text_id.getText().equals((((Clientes) dLigada.pega(i)).getId()+""))){
							array[0]=((Clientes) dLigada.pega(i)).getNome().toString();
							array[1]=((Clientes) dLigada.pega(i)).getApelido().toString();
							array[2]=((Clientes) dLigada.pega(i)).getId().toString();
							array[3]=(((Clientes) dLigada.pega(i)).getIdade()+"");
							modelo2.addRow(array);
						}else{
							JOptionPane.showMessageDialog(null,"Clientes nao enconrtados");
						}
					}
			
			
			text_nome.setText("");
			text_Apelido.setText("");
			text_id.setText("");
			text_idade.setText("");
			
			
		}

		if(botaoPesqusarFim==accao.getSource()){
			for (int i = 0; i < 1; i++) {
				try {
					dLigada=fs.readInfo("src/Files/Cliente.dat",dLigada);
				} catch (ClassNotFoundException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				int tamanho=dLigada.tamanho();
				array[0]=((Clientes) dLigada.pega(tamanho-1)).getNome().toString();
				array[1]=((Clientes) dLigada.pega(tamanho-1)).getApelido().toString();
				array[2]=((Clientes) dLigada.pega(tamanho-1)).getId().toString();
				array[3]=(((Clientes) dLigada.pega(tamanho-1)).getIdade()+"");
				modelo.addRow(array);
			}
			text_nome.setText("");
			text_Apelido.setText("");
			text_id.setText("");
			text_idade.setText("");
			
			
		}
		if(botaoPesqusarInicio==accao.getSource()){
			try {
				dLigada=fs.readInfo("src/Files/Cliente.dat",dLigada);
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			for (int i = 0; i < 1; i++) {
				((Clientes) dLigada.pega(0)).getNome().toString();
				array[1]=((Clientes) dLigada.pega(0)).getApelido().toString();
				array[2]=((Clientes) dLigada.pega(0)).getId().toString();
				array[3]=((Clientes) dLigada.pega(0)).getIdade()+"";
				for (int k = 0; k < dLigada.tamanho(); k++) {
					//dLigada.removePosicao(k);;
				}
				modelo.addRow(array);
			}
			
			
			text_nome.setText("");
			text_Apelido.setText("");
			text_id.setText("");
			text_idade.setText("");
						
		}
	}

}
