package Controller;

import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.util.Collection;
import java.util.Vector;

import javax.swing.BoxLayout;
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

import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

import javax.swing.ScrollPaneConstants;
import javax.swing.border.SoftBevelBorder;
import javax.swing.border.BevelBorder;

import Files.FileSave;
import Modell.Clientes;
import View.Tela;

public class Paine_Primero extends JPanel implements ActionListener {

	/**

	 * 
	 */
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
	private JButton botaoRegistar,botaoRegistarInicio,botaoRegistarFim,botaoRefresh;
	private JButton botaoAlterar;
	private Vector colunas;
	private   Vector boss;
	private JTable tabela;
	private JRadioButton radioFemenino;
	private ButtonGroup grupo;
	private DefaultTableModel modelo;
	private JScrollPane scrollPane;
	ListaDLigada dLigada;
	Vector<Clientes> vector=new Vector<Clientes>();
	Hotel_Controller hotalController;
	FileSave fs=new FileSave();

	
	@SuppressWarnings("static-access")
	public Paine_Primero() {
	
		setBounds(10, 11, 764, 469);
		
		painelCima=new JPanel();
		painelBaixo=new JPanel();
		/* colunas.add("Nome");
		  colunas.add("Apelido");
		  colunas.add("Id");
		  colunas.add("Idade");
		  */
		 // tabela.add(colunas);
		dLigada=new ListaDLigada();
		hotalController=new Hotel_Controller();
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
		
		botaoRegistar=new JButton("Registar Cliente");
		botaoRegistarInicio=new JButton("Registar Inicio");
		botaoRegistarFim=new JButton("Registar Fim");
		botaoRefresh =new JButton("Refresh");
		painelCima2.add(botaoRegistar);
		painelCima2.add(botaoRegistarInicio);
		painelCima2.add(botaoRegistarFim);
		painelCima2.add(botaoRefresh);
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
		painel1.add(label_nome);
		painel1.add(text_nome);
		
		painelCima.add(painel1);
		
		painelCima.add(painel2);
		painel2.add(label_Apelido);
		painel2.add(text_Apelido);
		
		painelCima.add(painel3);
		painel3.add(label_Idade);
		painel3.add(text_idade);
		
		painelCima.add(painel4);
		painel4.add(label_id);
		painel4.add(text_id);
		
		painelCima.add(painel5);
		painel5.add(label_Sexo);
		painel5.add(radioMasculino);
		painel5.add(radioFemenino);
		botaoRegistar.addActionListener(this);
		botaoRegistarFim.addActionListener(this);
		botaoRegistarInicio.addActionListener(this);
		botaoRefresh.addActionListener(this);
		visualizar(dLigada);
		setVisible(true);
		
		
		
		
	}

	public void visualizar(ListaDLigada dLigada){
		
		try {
			
		//	System.out.println(fs.readInfo("src/Files/Cliente.dat",dLigada));
			dLigada=fs.readInfo("src/Files/Cliente.dat",dLigada);
			
			
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		DefaultTableModel modelo=(DefaultTableModel)tabela.getModel();
		String array[]=new String[4];
		Clientes cliente=new Clientes();
		
		for(int i=0;i<dLigada.tamanho();i++){
		//cliente=(Clientes)dLigada.pega(i);
			
			
			array[0]=((Clientes) dLigada.pega(i)).getNome();
			array[1]=((Clientes) dLigada.pega(i)).getApelido();
			array[2]=((Clientes) dLigada.pega(i)).getId();
			array[3]=((Clientes) dLigada.pega(i)).getIdade()+"";
			
			modelo.addRow(array);
		}
	}
	

	@Override
	public void actionPerformed(ActionEvent accao) {
		// TODO Auto-generated method stub
		
		hotalController = new Hotel_Controller();
		String []array=new String[4];
		DefaultTableModel modelo =(DefaultTableModel)tabela.getModel();
		Clientes cliente=new Clientes();
		
		if(botaoRegistar==accao.getSource()){
		
			
			cliente.setNome(text_nome.getText());
			array[0]=cliente.getNome();
			cliente.setApelido(text_Apelido.getText());
			array[1]=cliente.getApelido();
			
			cliente.setId(text_id.getText());
			array[2]=cliente.getId()+"";
			int passa =Integer.parseInt(text_idade.getText());
			cliente.setIdade(passa);
			array[3]=cliente.getIdade()+"";
			
			try {
				dLigada= fs.readInfo("src/Files/Cliente.dat",dLigada);
			} catch (ClassNotFoundException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			
			modelo.addRow(array);
			int a=Integer.parseInt(JOptionPane.showInputDialog("Insira a posicao: "));
			System.out.println(dLigada.tamanho());
			dLigada.adicionaPosicao(a,cliente);
			try {
				fs.saveInfo("src/Files/Cliente.dat",dLigada);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			text_nome.setText("");
			text_Apelido.setText("");
			text_id.setText("");
			text_idade.setText("");
		//	System.exit(0);
			new Tela1().setVisible(true);;
			if(botaoRefresh==accao.getSource()){
			try {
				fs.readInfo("src/Files/Cliente.dat",dLigada);
			
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			}
			
			
		}
		if(botaoRegistarInicio==accao.getSource()){
			cliente.setNome(text_nome.getText());
			array[0]=cliente.getNome();
			cliente.setApelido(text_Apelido.getText());
			array[1]=cliente.getApelido();
			
			cliente.setId(text_id.getText());
			array[2]=cliente.getId()+"";
			int passa =Integer.parseInt(text_idade.getText());
			cliente.setIdade(passa);
			array[3]=cliente.getIdade()+"";
			
			try {
				dLigada= fs.readInfo("src/Files/Cliente.dat",dLigada);
			} catch (ClassNotFoundException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			
			modelo.addRow(array);
			
			System.out.println(dLigada.tamanho());
			dLigada.adicionaInicio(cliente);
			
			
			text_nome.setText("");
			text_Apelido.setText("");
			text_id.setText("");
			text_idade.setText("");
		//	System.exit(0);
			try {
				fs.saveInfo("src/Files/Cliente.dat",dLigada);
				new Tela1().setVisible(true);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			
		}
		if(botaoRegistarFim==accao.getSource()){
			
			
			cliente.setNome(text_nome.getText());
			array[0]=cliente.getNome();
			cliente.setApelido(text_Apelido.getText());
			array[1]=cliente.getApelido();
			
			cliente.setId(text_id.getText());
			array[2]=cliente.getId()+"";
			int passa =Integer.parseInt(text_idade.getText());
			cliente.setIdade(passa);
			array[3]=cliente.getIdade()+"";
			
			try {
				dLigada= fs.readInfo("src/Files/Cliente.dat",dLigada);
			} catch (ClassNotFoundException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			
			modelo.addRow(array);
			
			
			dLigada.adicionaFim(cliente);
		//	hotalController.dLigada.adicionaFim((cliente);
			try {
				fs.saveInfo("src/Files/Cliente.dat",dLigada);
				new Tela().setVisible(true);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			text_nome.setText("");
			text_Apelido.setText("");
			text_id.setText("");
			text_idade.setText("");
			//System.exit(0);
			try {
				fs.saveInfo("src/Files/Cliente.dat",dLigada);
				new Tela1().setVisible(true);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			
			
		}
	}

}
