package pack1;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.Border;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.UIManager;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.awt.event.ActionEvent;
import java.awt.SystemColor;
import java.awt.Toolkit;

public class ErrorConnexion extends JFrame {

	private JPanel contentPane;
	private JTextField mailField;
	private JPasswordField passwordField;
	MaConnexion mc;
	ResultSet rs;
	JButton  btnConnexion ,btnInscription;
	/**
	 * Launch the application.
	 */
	/*public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ErrorConnexion frame = new ErrorConnexion();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
*/
	/**
	 * Create the frame.
	 */
	public ErrorConnexion() {
		setTitle("Slack");
		setIconImage(Toolkit.getDefaultToolkit().getImage("D:\\tp java\\projet\\letter-s (4).png"));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1347, 679);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(240, 248, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(0, 191, 255));
		panel.setBounds(0, 0, 1344, 88);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblSlack = new JLabel("Slack");
		lblSlack.setForeground(new Color(248, 248, 255));
		lblSlack.setFont(new Font("Sitka Small", Font.BOLD, 39));
		lblSlack.setBounds(71, 24, 139, 51);
		panel.add(lblSlack);
		
		btnInscription = new JButton("Inscription");
		btnInscription.setFont(new Font("Sitka Small", Font.PLAIN, 14));
		btnInscription.setBounds(1047, 43, 126, 25);
		panel.add(btnInscription);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(Color.WHITE);
		panel_1.setBounds(436, 199, 421, 308);
		contentPane.add(panel_1);
		panel_1.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Essayer de se reconnecter");
		lblNewLabel.setFont(new Font("Sitka Small", Font.BOLD, 20));
		lblNewLabel.setForeground(Color.DARK_GRAY);
		lblNewLabel.setBounds(12, 29, 314, 34);
		panel_1.add(lblNewLabel);
		
		JLabel lblAdresseEmail = new JLabel("Adresse e-mail");
		lblAdresseEmail.setFont(new Font("Sitka Small", Font.PLAIN, 13));
		lblAdresseEmail.setBounds(46, 117, 102, 16);
		panel_1.add(lblAdresseEmail);
		
		JLabel lblMotDePasse = new JLabel("Mot de passe");
		lblMotDePasse.setFont(new Font("Sitka Small", Font.PLAIN, 14));
		lblMotDePasse.setBounds(46, 167, 102, 16);
		panel_1.add(lblMotDePasse);
		
		mailField = new JTextField();
		mailField.setBounds(209, 113, 173, 22);
		panel_1.add(mailField);
		mailField.setColumns(10);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(209, 163, 173, 22);
		panel_1.add(passwordField);
		
		btnConnexion = new JButton("Connexion");
	
		btnConnexion.setFont(new Font("Sitka Small", Font.PLAIN, 14));
		btnConnexion.setBounds(147, 224, 116, 25);
		panel_1.add(btnConnexion);
		btnConnexion.addActionListener(new Action());
		btnInscription.addActionListener(new Action());
		mc=new MaConnexion();
	}
	class Action implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			if(e.getSource()==btnConnexion)
			{	Border border1 = BorderFactory.createLineBorder(Color.gray, 1);
				passwordField.setBorder(border1);
				mailField.setBorder(border1);
				String tab="utilisateur";
				String mail=mailField.getText();
				String password=passwordField.getText();
				String requete= "SELECT * FROM "+tab+" WHERE email ='"+mail+"' ;";
				rs=mc.select(requete);
				try {
					 if(rs.next())
					{	
						String motpass="";
						motpass=rs.getString(5);
						
						if(!(password.equals(motpass)))
								{	
									/*dispose();
									new ErrorConnexion().setVisible(true);*/
									 Border border = BorderFactory.createLineBorder(Color.red, 1);
									 passwordField.setBorder(border);
									 passwordField.setToolTipText("Mot de passe erroné");
									 
								}
						else 
						 {	 
							dispose();
						 
						  	
							new Accueil(rs.getString(1), rs.getString(2), rs.getString(3), rs.getDate(4),rs.getString(6),rs.getBytes(7),rs.getString(8)).setVisible(true);}
						}
					
					 
					 else
						{	
							/*dispose();
							new ErrorConnexion().setVisible(true);*/
							 Border border = BorderFactory.createLineBorder(Color.red, 1);
							 mailField.setBorder(border);
							 
						}
					
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
					
	
		
	}
			if(e.getSource()==btnInscription) {
				dispose();
				new PremierPas().setVisible(true);
			}
		}
		
	}
}
