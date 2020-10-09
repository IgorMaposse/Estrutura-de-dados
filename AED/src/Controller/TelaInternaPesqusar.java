package Controller;

import java.awt.Dimension;
import java.awt.EventQueue;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JInternalFrame;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import Files.FileSave;

import javax.swing.JPanel;

public class TelaInternaPesqusar extends JInternalFrame {

	/**
	 * Launch the application.
	 */
	private JTable tabela;
	private JRadioButton radioFemenino;
	private ButtonGroup grupo;
	private DefaultTableModel modelo;
	private JScrollPane scrollPane;
	private FileSave fs=new FileSave();
	private ListaDLigada dLigada=new ListaDLigada();
	private JButton botaoVisualisar,botaoVoltar;
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaInternaPesqusar frame = new TelaInternaPesqusar();
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
	public TelaInternaPesqusar() {
		
		
		setBounds(100, 100, 674, 300);
		getContentPane().setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(10, 11, 638, 164);
		getContentPane().add(panel);
		panel.setLayout(null);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBounds(10, 186, 638, 73);
		getContentPane().add(panel_1);
		modelo=new DefaultTableModel();
		modelo.addColumn("Nome:");
		modelo.addColumn("Apelido");
		modelo.addColumn("Id");
		modelo.addColumn("Idade");
		tabela=new  JTable(modelo);
		try {
			dLigada=fs.readInfo("src/Files/Cliente.dat",dLigada);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		tabela.setPreferredScrollableViewportSize(new Dimension(438, 64));
		String[]array=new String[4];
		for (int i = 0; i < array.length; i++) {
			
		}
		
		botaoVisualisar=new JButton("Voltar");
		botaoVoltar=new JButton("Visualizar");
		
		scrollPane=new JScrollPane(tabela);
		
		scrollPane.setBounds(10, 11, 620, 142);
		
		panel.add(scrollPane);
		panel_1.add(botaoVisualisar);
		
		panel_1.add(botaoVoltar);

	}
}
