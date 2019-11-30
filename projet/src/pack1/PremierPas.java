package pack1;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.Border;
import javax.swing.border.EmptyBorder;



import java.awt.Color;
import java.awt.SystemColor;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.awt.event.ActionEvent;
import javax.swing.JComboBox;
import javax.swing.BorderFactory;
import javax.swing.DefaultComboBoxModel;
import javax.swing.DefaultListModel;
import pack1.ErrorConnexion;
import java.awt.Toolkit;
import javax.swing.ImageIcon;
import javax.swing.UIManager;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;
import java.awt.Component;
import javax.swing.Box;
import javax.swing.ButtonGroup;
import javax.swing.JRadioButton;
public class PremierPas extends JFrame {

	private JPanel contentPane,panel_1,panelInscription ;
	MaConnexion mc;
	String tab,date;
	Border border,borderInit;
	ResultSet rs;
	ErrorConnexion ErrorPanel;
	private JPanel panel;
	private JTextField mailField;
	private JPasswordField passwordField;
	private JTextField txtNom;
	private JTextField txtPrenom;
	private JPasswordField passwordFieldInscrit;
	private JTextField txtMail;
	private JComboBox<Integer> comboJour,comboMois,comboAnnee;
	ButtonGroup group;
	JLabel lbPic,lblNouveauCompte,lblNom,lblPrenom,lblDateDeNaissance,lblAdresseEmail,lblMotDePasse_1,lblSexe,lbError2,lbError3;
	JButton btnConnexion,btnInscription;
	private JLabel lbError;
	private JLabel lbError1;
	JRadioButton rdbtnHomme,rdbtnFemme;
	String sexe;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					PremierPas frame = new PremierPas ();
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
	public PremierPas () {
		
		setTitle("Slack");
		setIconImage(Toolkit.getDefaultToolkit().getImage("D:\\tp java\\projet\\letter-s (4).png"));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1253, 685);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(240, 248, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		panel = new JPanel();
		panel.setBackground(new Color(0, 191, 255));
		
		panel_1 = new JPanel();
		panel_1.setBackground(new Color(240, 248, 255));
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addContainerGap()
					.addComponent(panel_1, GroupLayout.DEFAULT_SIZE, 1213, Short.MAX_VALUE)
					.addContainerGap())
				.addComponent(panel, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 1237, Short.MAX_VALUE)
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addComponent(panel, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(panel_1, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
					.addContainerGap())
		);
		
		lbPic = new JLabel("");
		lbPic.setIcon(new ImageIcon("D:\\tp java\\projet\\background.png"));
		
		panelInscription = new JPanel();
		panelInscription.setBackground(new Color(240, 248, 255));
		GroupLayout gl_panel_1 = new GroupLayout(panel_1);
		gl_panel_1.setHorizontalGroup(
			gl_panel_1.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_1.createSequentialGroup()
					.addComponent(lbPic, GroupLayout.PREFERRED_SIZE, 593, GroupLayout.PREFERRED_SIZE)
					.addGap(11)
					.addComponent(panelInscription, GroupLayout.PREFERRED_SIZE, 597, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(14, Short.MAX_VALUE))
		);
		gl_panel_1.setVerticalGroup(
			gl_panel_1.createParallelGroup(Alignment.TRAILING)
				.addComponent(lbPic, GroupLayout.PREFERRED_SIZE, 498, Short.MAX_VALUE)
				.addGroup(gl_panel_1.createSequentialGroup()
					.addGap(15)
					.addComponent(panelInscription, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
					.addGap(11))
		);
		
		lblNouveauCompte = new JLabel("Nouveau compte");
		lblNouveauCompte.setFont(new Font("Sitka Small", Font.BOLD, 16));
		
		lblNom = new JLabel("Nom");
		lblNom.setFont(new Font("Sitka Small", Font.PLAIN, 14));
		
		lblPrenom = new JLabel("Prenom");
		lblPrenom.setFont(new Font("Sitka Small", Font.PLAIN, 14));
		
		lblDateDeNaissance = new JLabel("<html>Date<br> de naissance</html>");
		lblDateDeNaissance.setFont(new Font("Sitka Small", Font.PLAIN, 14));
		
		lblAdresseEmail = new JLabel("Adresse e-mail");
		lblAdresseEmail.setFont(new Font("Sitka Small", Font.PLAIN, 14));
		
		lblMotDePasse_1 = new JLabel("Mot de passe ");
		lblMotDePasse_1.setFont(new Font("Sitka Small", Font.PLAIN, 14));
		
		lblSexe = new JLabel("Sexe");
		
		rdbtnHomme = new JRadioButton("Homme");
		rdbtnHomme.setFont(new Font("Sitka Small", Font.PLAIN, 13));
		
		rdbtnFemme = new JRadioButton("Femme");
		rdbtnFemme.setFont(new Font("Sitka Small", Font.PLAIN, 13));
		group=new ButtonGroup();
		group.add(rdbtnFemme);
		group.add(rdbtnHomme);
		txtNom = new JTextField();
		txtNom.setColumns(10);
		
		txtPrenom = new JTextField();
		txtPrenom.setColumns(10);
		comboJour = new JComboBox<Integer>();
		comboMois = new JComboBox<Integer>();
		comboAnnee = new JComboBox<Integer>();
		
		
		passwordFieldInscrit = new JPasswordField();
		
		txtMail = new JTextField();
		txtMail.setColumns(10);
		
		
		
	for(int i=1;i<32;i++)
		 
		{ 
		comboJour.addItem(i);}
		for(int i=1;i<13;i++)
        {   
        	comboMois.addItem(i);
        }
		
		 for(int i=1900;i<2051;i++)
	        {   
	        	comboAnnee.addItem(i);
	        }
		 comboJour.setSelectedIndex(0);
			
			
			comboMois.setSelectedIndex(0);

			comboAnnee.setSelectedIndex(0);
			
		btnInscription = new JButton("Inscription");
		btnInscription.setFont(new Font("Sitka Small", Font.PLAIN, 14));
		
		lbError2 = new JLabel("");
		lbError2.setForeground(new Color(255, 0, 0));
		lbError2.setFont(new Font("Sitka Small", Font.PLAIN, 13));
		
		lbError3 = new JLabel("");
		lbError3.setFont(new Font("Sitka Small", Font.PLAIN, 13));
		lbError3.setForeground(new Color(255, 0, 0));
		
		lbError = new JLabel("");
		lbError.setFont(new Font("Sitka Small", Font.PLAIN, 13));
		lbError.setForeground(new Color(255, 0, 0));
		
		lbError1 = new JLabel("");
		lbError1.setFont(new Font("Sitka Small", Font.PLAIN, 13));
		lbError1.setForeground(new Color(255, 0, 0));
		GroupLayout gl_panelInscription = new GroupLayout(panelInscription);
		gl_panelInscription.setHorizontalGroup(
			gl_panelInscription.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panelInscription.createSequentialGroup()
					.addGroup(gl_panelInscription.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panelInscription.createSequentialGroup()
							.addContainerGap()
							.addComponent(lblNouveauCompte, GroupLayout.PREFERRED_SIZE, 187, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_panelInscription.createSequentialGroup()
							.addGap(48)
							.addGroup(gl_panelInscription.createParallelGroup(Alignment.LEADING)
								.addGroup(gl_panelInscription.createSequentialGroup()
									.addComponent(lblSexe)
									.addGap(85)
									.addComponent(rdbtnHomme)
									.addGap(56)
									.addComponent(rdbtnFemme))
								.addGroup(gl_panelInscription.createSequentialGroup()
									.addGroup(gl_panelInscription.createParallelGroup(Alignment.LEADING)
										.addComponent(lblAdresseEmail)
										.addComponent(lblMotDePasse_1))
									.addGap(18)
									.addGroup(gl_panelInscription.createParallelGroup(Alignment.LEADING)
										.addComponent(txtMail, GroupLayout.PREFERRED_SIZE, 170, GroupLayout.PREFERRED_SIZE)
										.addComponent(passwordFieldInscrit, GroupLayout.PREFERRED_SIZE, 170, GroupLayout.PREFERRED_SIZE))
									.addPreferredGap(ComponentPlacement.RELATED)
									.addGroup(gl_panelInscription.createParallelGroup(Alignment.LEADING)
										.addComponent(lbError3, GroupLayout.PREFERRED_SIZE, 248, GroupLayout.PREFERRED_SIZE)
										.addComponent(lbError2, GroupLayout.DEFAULT_SIZE, 239, Short.MAX_VALUE)))
								.addGroup(gl_panelInscription.createSequentialGroup()
									.addGroup(gl_panelInscription.createParallelGroup(Alignment.LEADING)
										.addComponent(lblDateDeNaissance, GroupLayout.PREFERRED_SIZE, 113, GroupLayout.PREFERRED_SIZE)
										.addComponent(lblNom)
										.addComponent(lblPrenom))
									.addGroup(gl_panelInscription.createParallelGroup(Alignment.LEADING)
										.addGroup(gl_panelInscription.createSequentialGroup()
											.addGap(4)
											.addComponent(comboJour, GroupLayout.PREFERRED_SIZE, 42, GroupLayout.PREFERRED_SIZE)
											.addGap(11)
											.addComponent(comboMois, GroupLayout.PREFERRED_SIZE, 45, GroupLayout.PREFERRED_SIZE)
											.addGap(10)
											.addComponent(comboAnnee, GroupLayout.PREFERRED_SIZE, 63, GroupLayout.PREFERRED_SIZE))
										.addGroup(gl_panelInscription.createSequentialGroup()
											.addGap(5)
											.addComponent(txtNom, GroupLayout.PREFERRED_SIZE, 167, GroupLayout.PREFERRED_SIZE)
											.addGap(16)
											.addComponent(lbError, GroupLayout.PREFERRED_SIZE, 231, GroupLayout.PREFERRED_SIZE))
										.addGroup(gl_panelInscription.createSequentialGroup()
											.addGap(4)
											.addComponent(txtPrenom, GroupLayout.PREFERRED_SIZE, 169, GroupLayout.PREFERRED_SIZE)
											.addGap(11)
											.addComponent(lbError1, GroupLayout.PREFERRED_SIZE, 227, GroupLayout.PREFERRED_SIZE)))
									.addGap(15)))
							.addPreferredGap(ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
						.addGroup(gl_panelInscription.createSequentialGroup()
							.addGap(126)
							.addComponent(btnInscription)))
					.addContainerGap())
		);
		gl_panelInscription.setVerticalGroup(
			gl_panelInscription.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panelInscription.createSequentialGroup()
					.addGroup(gl_panelInscription.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panelInscription.createSequentialGroup()
							.addGroup(gl_panelInscription.createParallelGroup(Alignment.LEADING)
								.addGroup(gl_panelInscription.createSequentialGroup()
									.addContainerGap()
									.addComponent(lblNouveauCompte, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE)
									.addGap(26)
									.addComponent(lblNom))
								.addGroup(gl_panelInscription.createSequentialGroup()
									.addGap(60)
									.addComponent(txtNom, GroupLayout.PREFERRED_SIZE, 34, GroupLayout.PREFERRED_SIZE)))
							.addGap(0, 0, Short.MAX_VALUE)
							.addGroup(gl_panelInscription.createParallelGroup(Alignment.LEADING)
								.addGroup(gl_panelInscription.createSequentialGroup()
									.addGap(29)
									.addComponent(lblPrenom))
								.addGroup(gl_panelInscription.createSequentialGroup()
									.addGap(16)
									.addComponent(txtPrenom, GroupLayout.PREFERRED_SIZE, 33, GroupLayout.PREFERRED_SIZE)))
							.addGroup(gl_panelInscription.createParallelGroup(Alignment.LEADING)
								.addGroup(gl_panelInscription.createSequentialGroup()
									.addGap(37)
									.addComponent(lblDateDeNaissance))
								.addGroup(gl_panelInscription.createSequentialGroup()
									.addGap(33)
									.addComponent(comboJour, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
								.addGroup(gl_panelInscription.createSequentialGroup()
									.addGap(33)
									.addComponent(comboMois, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
								.addGroup(gl_panelInscription.createSequentialGroup()
									.addGap(32)
									.addComponent(comboAnnee, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))
							.addGap(32))
						.addGroup(gl_panelInscription.createSequentialGroup()
							.addGap(60)
							.addComponent(lbError, GroupLayout.PREFERRED_SIZE, 29, GroupLayout.PREFERRED_SIZE)
							.addGap(27)
							.addComponent(lbError1, GroupLayout.PREFERRED_SIZE, 28, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED)))
					.addGroup(gl_panelInscription.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblAdresseEmail)
						.addComponent(txtMail, GroupLayout.PREFERRED_SIZE, 32, GroupLayout.PREFERRED_SIZE)
						.addComponent(lbError2, GroupLayout.PREFERRED_SIZE, 35, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addGroup(gl_panelInscription.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblMotDePasse_1)
						.addComponent(passwordFieldInscrit, GroupLayout.PREFERRED_SIZE, 33, GroupLayout.PREFERRED_SIZE)
						.addComponent(lbError3, GroupLayout.PREFERRED_SIZE, 34, GroupLayout.PREFERRED_SIZE))
					.addGap(26)
					.addGroup(gl_panelInscription.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblSexe)
						.addComponent(rdbtnHomme)
						.addComponent(rdbtnFemme))
					.addGap(40)
					.addComponent(btnInscription)
					.addContainerGap())
		);
		panelInscription.setLayout(gl_panelInscription);
		panel_1.setLayout(gl_panel_1);
		
		JLabel lblSlack = new JLabel("Slack");
		lblSlack.setForeground(new Color(255, 255, 255));
		lblSlack.setFont(new Font("Sitka Small", Font.BOLD, 48));
		
		JLabel lblAdreeseEmail = new JLabel("Adreese e-mail");
		lblAdreeseEmail.setForeground(new Color(255, 255, 255));
		lblAdreeseEmail.setFont(new Font("Sitka Small", Font.PLAIN, 14));
		
		mailField = new JTextField();
		mailField.setColumns(10);
		
		JLabel lblMotDePasse = new JLabel("Mot de passe");
		lblMotDePasse.setForeground(new Color(255, 255, 255));
		lblMotDePasse.setFont(new Font("Sitka Small", Font.PLAIN, 14));
		
		passwordField = new JPasswordField();
		
		btnConnexion = new JButton("Connexion");
		
		btnConnexion.setFont(new Font("Sitka Small", Font.PLAIN, 14));
		btnConnexion.setForeground(new Color(0, 0, 0));
		GroupLayout gl_panel = new GroupLayout(panel);
		gl_panel.setHorizontalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addGap(42)
					.addComponent(lblSlack, GroupLayout.PREFERRED_SIZE, 157, GroupLayout.PREFERRED_SIZE)
					.addGap(389)
					.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
						.addComponent(lblAdreeseEmail, GroupLayout.PREFERRED_SIZE, 111, GroupLayout.PREFERRED_SIZE)
						.addComponent(mailField, GroupLayout.PREFERRED_SIZE, 149, GroupLayout.PREFERRED_SIZE))
					.addGap(36)
					.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
						.addComponent(lblMotDePasse)
						.addComponent(passwordField, GroupLayout.PREFERRED_SIZE, 146, GroupLayout.PREFERRED_SIZE))
					.addGap(47)
					.addComponent(btnConnexion)
					.addContainerGap(154, Short.MAX_VALUE))
		);
		gl_panel.setVerticalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panel.createSequentialGroup()
							.addGap(27)
							.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
								.addGroup(gl_panel.createSequentialGroup()
									.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
										.addComponent(lblAdreeseEmail)
										.addComponent(lblMotDePasse))
									.addPreferredGap(ComponentPlacement.RELATED)
									.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
										.addComponent(mailField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
										.addComponent(passwordField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))
								.addComponent(lblSlack, GroupLayout.PREFERRED_SIZE, 60, GroupLayout.PREFERRED_SIZE)))
						.addGroup(gl_panel.createSequentialGroup()
							.addGap(41)
							.addComponent(btnConnexion)))
					.addContainerGap(23, Short.MAX_VALUE))
		);
		panel.setLayout(gl_panel);
		contentPane.setLayout(gl_contentPane);
	
		btnInscription.addActionListener(new Action());
		txtNom.addFocusListener(new Focus());
		txtPrenom.addFocusListener(new Focus());
		txtMail.addFocusListener(new Focus());
		passwordFieldInscrit.addFocusListener(new Focus());
		mc=new MaConnexion();
		btnConnexion.addActionListener(new Action());
		ErrorPanel=new ErrorConnexion();
	}
	class Focus implements FocusListener{

		@Override
		public void focusGained(FocusEvent e) {
			// TODO Auto-generated method stub
			if(e.getSource()==txtNom ) {
				if(txtNom.getText().equals("Tapper votre nom"))
					txtNom.setText("");
			}
			if(e.getSource()==txtPrenom) {
				if(txtPrenom.getText().equals("Tapper votre prenom"))
					txtPrenom.setText("");
			}
			if(e.getSource()==txtMail) {
				if(txtMail.getText().equals("Tapper votre e-mail"))
					txtMail.setText("");
			}
			
		}

		@Override
		public void focusLost(FocusEvent e) {
			// TODO Auto-generated method stub
			if(e.getSource()==txtNom) {
				if(txtNom.getText().equals("")) { txtNom.setText("Tapper votre nom");}
				}
			if(e.getSource()==txtPrenom) {
				if(txtPrenom.getText().equals("")) { txtPrenom.setText("Tapper votre prenom");}
				}
			if(e.getSource()==txtMail) {
				if(txtMail.getText().equals("")) { txtMail.setText("Tapper votre e-mail");}
				}
		}
		
	}

	class Action implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			if(e.getSource()==btnInscription)
			{	 lbError.setText("");
				 lbError1.setText("");
				 lbError2.setText("");
				 lbError3.setText("");
				 borderInit = BorderFactory.createLineBorder(Color.gray, 1);
				 txtNom.setBorder(borderInit);
				 txtPrenom.setBorder(borderInit);
				 txtMail.setBorder(borderInit);
				 passwordFieldInscrit.setBorder(borderInit);
				 border = BorderFactory.createLineBorder(Color.red, 1);
				 
				if((txtNom.getText().isEmpty()) || (txtNom.getText().equals("Tapper votre nom") ) ){
 
 
						txtNom.setBorder(border);
						lbError.setText("Il faut saisir votre nom");
						lbError.setForeground(Color.red);
					}
				else if(txtPrenom.getText().isEmpty()|| txtPrenom.getText().equals("Tapper votre prenom")) {

 
						txtPrenom.setBorder(border);
						lbError1.setText("Il faut saisir votre prenom");
						lbError1.setForeground(Color.red);
					}
				else if(txtMail.getText().isEmpty() || txtMail.getText().equals("Tapper votre e-mail") ) {

 
					txtMail.setBorder(border);
					lbError2.setText("Il faut saisir votre e-mail");
					lbError2.setForeground(Color.red);
				}
				 
			
				
				
					else if(passwordFieldInscrit.getText().isEmpty()) {
						 
					    passwordFieldInscrit.setBorder(border);
					    lbError3.setText("Il faut saisir votre mot de passe");
					    lbError3.setForeground(Color.red);}
						
						else if( passwordFieldInscrit.getText().length()>8 )
							 {
								 
						        passwordFieldInscrit.setBorder(border);
						        lbError3.setText("longueur ne dépasse pas 8 caractères");
						        lbError3.setForeground(Color.red);
							}
								
						
						
						
					
					else {
						tab="utilisateur";
						Date datNaiss=null;
						SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd/MM/yyyy");
						String requete= "SELECT * FROM "+tab+" WHERE email ='"+txtMail.getText()+"' ;";
						rs=mc.select(requete);
						date=comboJour.getSelectedItem()+"/"+comboMois.getSelectedItem()+"/"+comboAnnee.getSelectedItem();
						try {
							if(rs.next()) {
								txtMail.setBorder(border);
								lbError2.setText("Cette adresse est déjà utilisé");
								lbError2.setForeground(Color.red);
							}
							else {
							try {
								datNaiss = simpleDateFormat.parse(date);
							
							} catch (ParseException e1) {
								// TODO Auto-generated catch block
								e1.printStackTrace();
							}
							if(rdbtnFemme.isSelected())
								sexe="Femme";
							else if(rdbtnHomme.isSelected())
								sexe="Homme";
							else sexe="";
							int req=mc.ajout(tab, txtMail.getText(), txtNom.getText(),txtPrenom.getText() ,new Timestamp(datNaiss.getTime()) ,passwordFieldInscrit.getText(),sexe);
							txtNom.setText("Tapper votre nom");
							txtPrenom.setText("Tapper votre prenom");
							txtMail.setText("Tapper votre e-mail");
							passwordFieldInscrit.setText("");
							group.clearSelection();
}
						} catch (SQLException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}}}
				
			if(e.getSource()==btnConnexion)
			{	 
				tab="utilisateur";
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
									dispose();
									new ErrorConnexion().setVisible(true);
								}
						else 
						 {	dispose();
						  	
							new Accueil(rs.getString(1), rs.getString(2), rs.getString(3), rs.getDate(4),rs.getString(6),rs.getBytes(7),rs.getString(8)).setVisible(true);}
						}
					
					 
					 else
						{	
							dispose();
							new ErrorConnexion().setVisible(true);
						}
					
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
					
	
		
	}
	}
		}
	}

