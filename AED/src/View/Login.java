package View;



import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

public class Login implements ActionListener {
	private JFrame frame; 
	private JLabel label,label2,label3;
	private JPasswordField pass;
	private JButton botaoSub,botaoClear;
	private JTextField text1;
	private JPanel painel;
	private ImageIcon image = new ImageIcon(getClass().getResource("22.jpg"));
	private JCheckBox boxC;
	
	public Login(){
			
			frame = new JFrame();
			frame.setLocation(500, 100);
			
			frame.setSize(300, 200);
			ImagePanel painel=new ImagePanel();
			painel.setLayout(new FlowLayout(FlowLayout.CENTER));
			//frame.setLaMyout(new BoxLayout(frame,BoxLayout.Y_AXIS));
		//	frame.setLayout(new FlowLayout(FlowLayout.CENTER));
			frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			label =new JLabel("Username:");
			//text =new JTextField(5);
			text1 = new JTextField(15);
			
			
			label2=new JLabel("Password:");
			pass = new JPasswordField(15);
			label3=new JLabel("             ");
			botaoSub=new JButton("Sing in");
			botaoClear=new JButton("Exit");
			
			botaoSub.setMnemonic(KeyEvent.VK_ENTER);
			//frame.setContentPane(new ImagePanel());
			label.setForeground(Color.blue);
			label2.setForeground(Color.blue);
			frame.add(painel);
			painel.add(label);
			painel.add(text1);
			//painel.add(label3);
			painel.add(label2);
			painel.add(pass);
			//painel.add(label3);
			painel.add(botaoSub);
			
			painel.add(botaoClear);
			frame.setResizable(false);
		
			botaoSub.addActionListener(this);
			botaoClear.addActionListener(this);
			frame.setVisible(true);
		} 
		
		public static void main(String[] args) throws NumberFormatException, ClassNotFoundException, InstantiationException, IllegalAccessException, UnsupportedLookAndFeelException {
			try{
				//UIManager.setLookAndFeel("com.jtattoo.plaf.noire.NoireLookAndFeel");
			new Login();
			}catch(RuntimeException e){
				e.printStackTrace();
			}
		}
		
		public class ImagePanel extends JPanel {
			
			protected void paintComponent(Graphics g){
				 	super.paintComponent(g);
					Image img = image.getImage();
					g.drawImage(img,0,0,this);
					
				 }
		}
		@Override
		public void actionPerformed(ActionEvent event) {
			if(event.getSource()==botaoSub){
				
			new Tela();
			frame.setVisible(false);
				
			}else if(event.getSource()==botaoClear){
				System.exit(0);
			}
			
		}
}			
