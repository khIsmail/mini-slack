package pack1;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.filechooser.FileNameExtensionFilter;

import com.mysql.jdbc.Blob;

import java.awt.Toolkit;
import javax.swing.JLabel;
import java.awt.Color;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.Image;

import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.JFileChooser;
import javax.swing.JPasswordField;
import javax.swing.ImageIcon;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.awt.event.ActionEvent;

public class ModificationProfil extends JFrame {

	private JPanel contentPane;
	private JTextField txtNom;
	private JTextField txtPrenom;
	private JTextField txtMail;
	private JPasswordField passwordField;
	JButton addPhoto,btnEnregistrezModification ,btnAnnuler;
	JLabel lblNom,lblPrenom,lblDateDeNaissance,lblEmail,lblMotDePasse,lblModifierVotreProfil,lblPhotoDeProfil;
	MaConnexion mc;
	JComboBox comboJour,comboMois,comboAnnee;
	int rq;
	String email,path="";
	/**
	 * Launch the application.
	 */
/*	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
			try {
					//ModificationProfil frame = new ModificationProfil();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}*/

	/**
	 * Create the frame.
	 */
	public ModificationProfil(String email) {
		this.email=email;
		setIconImage(Toolkit.getDefaultToolkit().getImage("D:\\tp java\\projet\\letter-s (4).png"));
		setTitle("Slack");
		
		setBounds(100, 100, 659, 505);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(240, 248, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		lblNom = new JLabel("Nom");
		lblNom.setFont(new Font("Sitka Small", Font.BOLD, 14));
		lblNom.setBounds(62, 101, 56, 16);
		contentPane.add(lblNom);
		
		lblPrenom = new JLabel("Prenom");
		lblPrenom.setFont(new Font("Sitka Small", Font.BOLD, 15));
		lblPrenom.setBounds(61, 146, 70, 16);
		contentPane.add(lblPrenom);
		
		lblDateDeNaissance = new JLabel("<html>Date<br> de naissance</html>");
		lblDateDeNaissance.setFont(new Font("Sitka Small", Font.BOLD, 15));
		lblDateDeNaissance.setBounds(60, 175, 119, 61);
		contentPane.add(lblDateDeNaissance);
		
		lblEmail = new JLabel("e-mail");
		lblEmail.setFont(new Font("Sitka Small", Font.BOLD, 15));
		lblEmail.setBounds(62, 258, 67, 16);
		contentPane.add(lblEmail);
		
		lblMotDePasse = new JLabel("Mot de passe");
		lblMotDePasse.setFont(new Font("Sitka Small", Font.BOLD, 15));
		lblMotDePasse.setBounds(60, 299, 119, 16);
		contentPane.add(lblMotDePasse);
		
		lblModifierVotreProfil = new JLabel("Modifier Votre profil");
		lblModifierVotreProfil.setFont(new Font("Sitka Small", Font.BOLD, 24));
		lblModifierVotreProfil.setForeground(Color.DARK_GRAY);
		lblModifierVotreProfil.setBounds(127, 28, 268, 39);
		contentPane.add(lblModifierVotreProfil);
		
		txtNom = new JTextField();
		txtNom.setBounds(202, 97, 173, 22);
		contentPane.add(txtNom);
		txtNom.setColumns(10);
		
		txtPrenom = new JTextField();
		txtPrenom.setBounds(202, 142, 173, 22);
		contentPane.add(txtPrenom);
		txtPrenom.setColumns(10);
		
		comboJour = new JComboBox();
		comboJour.setBounds(211, 194, 38, 22);
		contentPane.add(comboJour);
		
		comboMois = new JComboBox();
		comboMois.setBounds(264, 194, 38, 22);
		contentPane.add(comboMois);
		
		comboAnnee = new JComboBox();
		comboAnnee.setBounds(314, 194, 61, 22);
		contentPane.add(comboAnnee);
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
		 
		txtMail = new JTextField();
		txtMail.setBounds(202, 252, 173, 22);
		contentPane.add(txtMail);
		txtMail.setColumns(10);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(202, 295, 173, 22);
		contentPane.add(passwordField);
		
		addPhoto = new JButton("");
		addPhoto.addActionListener(new Action() );
			
		
		addPhoto.setIcon(new ImageIcon("D:\\tp java\\projet\\img\\add_photo.png"));
		addPhoto.setBounds(469, 146, 127, 128);
		contentPane.add(addPhoto);
		
		lblPhotoDeProfil = new JLabel("Photo de profil");
		lblPhotoDeProfil.setFont(new Font("Sitka Small", Font.BOLD, 12));
		lblPhotoDeProfil.setBounds(469, 117, 99, 16);
		contentPane.add(lblPhotoDeProfil);
		
		btnEnregistrezModification = new JButton("Enregistrez modification");
		btnEnregistrezModification.setFont(new Font("Sitka Small", Font.PLAIN, 13));
		btnEnregistrezModification.setBounds(108, 376, 208, 25);
		contentPane.add(btnEnregistrezModification);
		
		btnAnnuler = new JButton("Annuler");
		btnAnnuler.setFont(new Font("Sitka Small", Font.PLAIN, 13));
		btnAnnuler.setBounds(364, 376, 97, 25);
		contentPane.add(btnAnnuler);
		mc=new MaConnexion();
		btnEnregistrezModification.addActionListener(new Action());
		btnAnnuler.addActionListener(new Action());
	}
 class Action implements ActionListener{

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource()==addPhoto) {
			JFileChooser chooser = new JFileChooser();
		    FileNameExtensionFilter filter = new FileNameExtensionFilter(
		        "JPG & GIF Images", "jpg", "gif");
		    chooser.setFileFilter(filter);
		    int returnVal = chooser.showOpenDialog(null);
		    if(returnVal == JFileChooser.APPROVE_OPTION) {
		       File selectedFile=chooser.getSelectedFile();
		       path=selectedFile.getAbsolutePath();
		       ImageIcon image=new ImageIcon(path);
		       Image img =image.getImage();
		       Image newImg=img.getScaledInstance(addPhoto.getWidth(), addPhoto.getHeight(), Image.SCALE_SMOOTH);
		       ImageIcon finalImg=new ImageIcon(newImg);
		       addPhoto.setIcon(finalImg);
		      
		    }}
		    if(e.getSource()==btnEnregistrezModification)
		    { 	String req;
		    	int res;
		    	if(!(path.isEmpty())) {
		    		mc.ajoutImage(path, "utilisateur", email);
		    		}
		    	
		    	if(!(txtNom.getText().isEmpty())){
		    		req="UPDATE utilisateur SET nom='"+txtNom.getText()+"' WHERE email='"+email+"';";
		    		res=mc.modifier(req);
		    	}
		    	if(!(txtPrenom.getText().isEmpty())){
		    		req="UPDATE utilisateur SET prenom='"+txtPrenom.getText()+"' WHERE email='"+email+"';";
		    		res=mc.modifier(req);
		    	}
		    	if(!(txtMail.getText().isEmpty())){
		    		req="UPDATE utilisateur SET email='"+txtNom.getText()+"' WHERE email='"+email+"';";
		    		res=mc.modifier(req);
		    	}
		    	if(!(passwordField.getText().isEmpty())){
		    		req="UPDATE utilisateur SET motpasse='"+txtNom.getText()+"' WHERE email='"+email+"';";
		    		res=mc.modifier(req);
		    	}
		    	Date datNaiss=null;
				SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd/MM/yyyy");
				String date=comboJour.getSelectedItem()+"/"+comboMois.getSelectedItem()+"/"+comboAnnee.getSelectedItem();
				try {
					datNaiss = simpleDateFormat.parse(date);
				} catch (ParseException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				req="UPDATE utilisateur SET datnaiss='"+new Timestamp(datNaiss.getTime())+"' WHERE email='"+email+"';";
	    		res=mc.modifier(req);
	    		
				
		    }
		    
		       
		if(e.getSource()==btnAnnuler)
		{
			dispose();
		}
		    
		}
	}
	 
 }

