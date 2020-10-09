package Controller;
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.List;
import java.awt.ScrollPane;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;

import java.awt.FlowLayout;

import javax.swing.JButton;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.CardLayout;
import java.awt.Color;

import javax.swing.border.SoftBevelBorder;
import javax.swing.border.BevelBorder;
import javax.swing.table.DefaultTableModel;

import java.awt.Font;

import Controller.*;
import Files.FileSave;
import Modell.Clientes;
import java.awt.Button;
import java.awt.Rectangle;

public class Tela1 extends JFrame  implements ActionListener{
	
	private JPanel contentPane;
	private JButton btnRegistrrar ;
	private JButton btnAdicionar_1 ,btnAlterar,btnEliminar_1,btnLista;
	private JPanel panel_4;
	private Paine_Primero paineRegistar;
	private Paine_Segundo painePesquisar;
	private PaineTerceiro paineAlterar;
	private Paine_Quarto paineEliminar;
	private Painel_Listar paineListar;
	private Paine_Quinto paineSobre;
	private Hotel_Controller hotel_Controller;
	private ListaDLigada dLigada;
	private JTable tabela;
	private JScrollPane scrollPane;
	private FileSave fs=new FileSave();
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					
					Tela1 frame = new Tela1();
					frame.setResizable(false);
					frame.setUndecorated(true);
					frame.setSize(920, 470);
					frame.setDefaultCloseOperation(frame.EXIT_ON_CLOSE);
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Tela1() {
		hotel_Controller = new Hotel_Controller();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 925, 525);
		
		contentPane = new JPanel();
		contentPane.setBounds(new Rectangle(0, 0, 2024, 1024));
		contentPane.setFont(new Font("Bookman Old Style", Font.PLAIN, 11));
		contentPane.setSize(new Dimension(1024, 980));
		contentPane.setBackground(Color.LIGHT_GRAY);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
	
		ListaDLigada list = new ListaDLigada();
		
		JPanel panel = new JPanel();
		panel.setForeground(Color.BLACK);
		panel.setBackground(new Color(0, 102, 153));
		panel.setBounds(0, 31, 153, 455);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JButton btnSobre = new JButton("Sobre");
		btnSobre.setFont(new Font("Algerian", Font.PLAIN, 10));
		btnSobre.setBounds(0, 280, 151, 23);
		panel.add(btnSobre);
		
		JButton btnRegistrrar = new JButton("Registar");
		btnRegistrrar.setFont(new Font("Algerian", Font.PLAIN, 10));
		btnRegistrrar.setBounds(0, 26, 161, 23);
		panel.add(btnRegistrrar);
		
		JButton btnPesquisar = new JButton("Pesquisar");
		btnPesquisar.setFont(new Font("Algerian", Font.PLAIN, 10));
		btnPesquisar.setBounds(0, 76, 151, 23);
		panel.add(btnPesquisar);
		
		JButton btnAlterar = new JButton("Alterar Dados");
		btnAlterar.setFont(new Font("Algerian", Font.PLAIN, 10));
		btnAlterar.setBounds(0, 127, 151, 23);
		panel.add(btnAlterar);
		
		JButton btnLista = new JButton("Listar Clientes");
		btnLista.setFont(new Font("Algerian", Font.PLAIN, 10));
		btnLista.setBounds(0, 176, 151, 23);
		panel.add(btnLista);
		
		JButton btnEliminar_1 = new JButton("Eliminar Clientes");
		btnEliminar_1.setBounds(0, 231, 151, 23);
		btnEliminar_1.setFont(new Font("Algerian", Font.PLAIN, 10));
		panel.add(btnEliminar_1);
		
		JButton btnSair = new JButton("Sair");
		
		btnSair.setFont(new Font("Algerian", Font.PLAIN, 10));
		btnSair.setBackground(Color.LIGHT_GRAY);
		btnSair.setBounds(38, 346, 89, 23);
		panel.add(btnSair);
		btnSair.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			System.exit(0);
			}
		});
		
		JPanel panel_1 = new JPanel();

		panel_1.setBackground(new Color(0, 102, 153));
		panel_1.setBounds(0, 0, 915, 32);
		contentPane.add(panel_1);
		panel_1.setLayout(null);
		
		JLabel label = new JLabel("");
		label.setBounds(207, 5, 0, 0);
		panel_1.add(label);
		
		JLabel lblHotelTransylvania = new JLabel("Hotel Transylvania");
		lblHotelTransylvania.setBackground(new Color(240, 240, 240));
		lblHotelTransylvania.setForeground(new Color(0, 0, 0));
		lblHotelTransylvania.setFont(new Font("Viner Hand ITC", Font.PLAIN, 15));
		lblHotelTransylvania.setBounds(454, 5, 245, 27);
		panel_1.add(lblHotelTransylvania);
		
		Button button = new Button("Welcome");
		
		button.setBackground(new Color(0, 102, 153));
		button.setFont(new Font("Algerian", Font.PLAIN, 10));
		
		//button.setBackground(Color.);
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		button.setBounds(0, 5, 154, 27);
		panel_1.add(button);
		
		JPanel panel_2 = new JPanel();
		panel_2.setForeground(Color.LIGHT_GRAY);
		panel_2.setBorder(null);
		panel_2.setBackground(new Color(0, 102, 153));
		panel_2.setBounds(152, 31, 763, 455);
		contentPane.add(panel_2);
		panel_2.setLayout(null);
		
		panel_4 = new JPanel();
		panel_4.setBounds(10, 11, 764, 469);
		panel_2.add(panel_4);
		panel_4.setLayout(new CardLayout(0, 0));
		Paine_Primero paineRegistar=new Paine_Primero();
		paineRegistar.setBackground(Color.LIGHT_GRAY);
		Paine_Segundo painePesquisar=new Paine_Segundo();
		PaineTerceiro paineAlterar=new PaineTerceiro();
		Paine_Quarto paineEliminar=new Paine_Quarto();
		Painel_Listar paineListar=new Painel_Listar();
		Paine_Quinto paineSobre=new Paine_Quinto();
		
		panel_4.add(paineRegistar,"p1");
		panel_4.add(painePesquisar,"p2");
		panel_4.add(paineAlterar,"p3");
		panel_4.add(paineEliminar,"p4");
		panel_4.add(paineListar,"p5");
		panel_4.add(paineSobre,"p6");
		btnRegistrrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				CardLayout layout =(CardLayout)panel_4.getLayout();
				layout.show(panel_4, "p1");
				
				
				//hotel_Controller.registarCliente(clientes);
			}
		});
		btnPesquisar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				CardLayout layout =(CardLayout)panel_4.getLayout();
				new Tela1().setVisible(true);
				layout.show(panel_4, "p2");
				
			}
		});
		btnEliminar_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				CardLayout layout =(CardLayout)panel_4.getLayout();
				layout.show(panel_4, "p4");
				//Clientes clientes = null;
				//clientes.setNome("");
				//hotel_Controller.buscarCliente(clientes);
			}
		});
		
		btnAlterar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				CardLayout layout =(CardLayout)panel_4.getLayout();
				layout.show(panel_4, "p3");
				//Clientes clientes = null;
				//clientes.setNome("");
				//hotel_Controller.registarCliente(clientes);
			}
		});
		
		
		btnLista.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				CardLayout layout =(CardLayout)panel_4.getLayout();
				layout.show(panel_4, "p5");
				//Clientes clientes = null;
				//clientes.setNome("");
				//hotel_Controller.registarCliente(clientes);
			}
		});
		btnSobre.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				CardLayout layout =(CardLayout)panel_4.getLayout();
				layout.show(panel_4, "p6");
				//Clientes clientes = null;
				//clientes.setNome("");
				//hotel_Controller.registarCliente(clientes);
			}
		});
		btnRegistrrar.addActionListener(this);
		btnPesquisar.addActionListener(this);
		btnEliminar_1.addActionListener(this);
		btnAlterar.addActionListener(this);
		btnLista.addActionListener(this);
		btnSobre.addActionListener(this);
		
	}

	@Override
	public void actionPerformed(ActionEvent accao) {
		// TODO Auto-generated method stub
		CardLayout layout =(CardLayout)panel_4.getLayout();
		
		
	}
}
