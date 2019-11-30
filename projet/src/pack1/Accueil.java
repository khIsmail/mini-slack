package pack1;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.Border;
import javax.swing.border.EmptyBorder;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.net.MalformedURLException;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;
import java.util.Vector;

import javax.swing.BorderFactory;
import javax.swing.DefaultListModel;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;

import javax.swing.border.LineBorder;
import javax.swing.table.AbstractTableModel;

import pack2.Discussion;

import javax.swing.JLabel;
import javax.swing.JList;

import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Insets;

import javax.swing.JToggleButton;
import javax.swing.JTextField;
import javax.swing.JTextPane;
import javax.swing.JEditorPane;
import javax.swing.ImageIcon;
import java.awt.SystemColor;
import javax.swing.JButton;
import javax.swing.JCheckBoxMenuItem;
import javax.swing.JMenuItem;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JTable;
import javax.swing.JScrollBar;
import javax.swing.JScrollPane;
import javax.swing.SwingConstants;
import jeux.*;
public class Accueil extends JFrame {

	JPanel contentPane,panel,panelChaines,panelOption,panel_1,panelProfil;
	JTextField recherche;
	MaConnexion mc;
	ResultSet rs;
	DefaultListModel<String> modelList;
	JList listRecherche;
	static JList list;
	JLabel  photoProfil ,lblNomUser,nomUser,lblChaines ;
	JButton btnModifierProfil,btnDfinirStatut,btnInviterDesPersonnes,btnAjoutChaine;
	String mail,nom,prenom,sexe,stat,statut;
	Date datNaiss;
	byte [] img;
	ImageIcon image,finalImg;
    Image photo,newImg;
    JMenuBar menuBar;
    JMenu nomMenu; 
    JMenuItem statItem,espaceItem,deconxItem;
    JTable table;
    MonModel model;
    private JTable table_1;
   static DefaultListModel Chaines;
    JScrollPane scroll;
    private JButton btnLoisirs;
	/**
	 * Launch the application.
	 */
/*	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Date datNaiss = null;
					String prenom ="";
					String nom = "";
					String mail = "";
					Accueil frame = new Accueil(mail,nom,prenom,datNaiss);
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
	public Accueil(String mail,String nom,String prenom,Date datNaiss,String sexe,byte[] img,String stat) {
		this.mail=mail;
		this.nom=nom;
		this.prenom=prenom;
		this.datNaiss=datNaiss;
		this.sexe=sexe;
		this.img=img;
		this.stat=stat;
		setTitle("Slack");
		setIconImage(Toolkit.getDefaultToolkit().getImage("D:\\tp java\\projet\\letter-s (4).png"));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(1900, 1000);
		contentPane = new JPanel();
		contentPane.setForeground(Color.GRAY);
		contentPane.setBackground(new Color(240, 248, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		panel = new JPanel();
		panel.setForeground(new Color(0, 191, 255));
		panel.setBorder(new LineBorder(new Color(169, 169, 169)));
		panel.setBackground(new Color(240, 248, 255));
		panel.setBounds(0, 0, 1911, 98);
		contentPane.add(panel);
		panel.setLayout(null);
		
		recherche = new JTextField();
		recherche.setForeground(new Color(128, 128, 128));
		recherche.setText("Recherche");
		recherche.setFont(new Font("Sitka Small", Font.PLAIN, 14));
		recherche.setBounds(1288, 38, 445, 31);
		panel.add(recherche);
		recherche.setColumns(10);
		
		JLabel label = new JLabel("");
		label.setIcon(new ImageIcon("D:\\tp java\\projet\\img\\recherche.png"));
		label.setBounds(1740, 38, 25, 31);
		panel.add(label);
		
		JLabel lblTitre = new JLabel("Slack\r\n");
		lblTitre.setForeground(new Color(0, 191, 255));
		lblTitre.setFont(new Font("Sitka Small", Font.BOLD, 37));
		lblTitre.setBounds(109, 27, 272, 40);
		panel.add(lblTitre);
		
	
		panelOption = new JPanel();
		panelOption.setBackground(new Color(0, 191, 255));
		panelOption.setForeground(Color.WHITE);
		panelOption.setBounds(0, 98, 382, 855);
		contentPane.add(panelOption);
		panelOption.setLayout(null);
		menuBar = new JMenuBar();
		menuBar.setFont(new Font("Sitka Small", Font.BOLD, 15));
		menuBar.setBackground(new Color(240, 248, 255));
		menuBar.setForeground(Color.WHITE);
		menuBar.setBounds(12, 13, 200, 26);
		panelOption.add(menuBar);
		 nomMenu = new JMenu(this.prenom+" "+this.nom);
		nomMenu.setBackground(new Color(240, 248, 255));
		nomMenu.setForeground(new Color(112, 128, 144));
		nomMenu.setFont(new Font("Sitka Small", Font.PLAIN, 16));
		menuBar.add(nomMenu);
		/*if(stat.isEmpty())
			statut="statut non précisé";
		else
			statut="Je suis en "+stat;*/
		statItem = new JMenuItem(statut);
		statItem.setBackground(new Color(240, 248, 255));
		statItem.setForeground(new Color(112, 128, 144));
		statItem.setFont(new Font("Sitka Small", Font.PLAIN, 15));
		nomMenu.add(statItem);
		
		espaceItem = new JMenuItem("espace de travail");
		espaceItem.setForeground(new Color(112, 128, 144));
		espaceItem.setBackground(new Color(240, 248, 255));
		nomMenu.add(espaceItem);
		
		deconxItem = new JMenuItem("D\u00E9connexion");
		deconxItem.setBackground(new Color(240, 248, 255));
		deconxItem.setForeground(new Color(112, 128, 144));
		nomMenu.add(deconxItem);
		
		btnAjoutChaine = new JButton("Ajout chaine");
		btnAjoutChaine.setHorizontalAlignment(SwingConstants.LEFT);
		btnAjoutChaine.setBackground(new Color(0, 191, 255));
		btnAjoutChaine.setFont(new Font("Sitka Small", Font.BOLD, 20));
		btnAjoutChaine.setForeground(Color.WHITE);
		btnAjoutChaine.setBounds(0, 165, 382, 38);
		panelOption.add(btnAjoutChaine);
		
		btnInviterDesPersonnes = new JButton("Inviter des personnes");
		btnInviterDesPersonnes.setFont(new Font("Sitka Small", Font.BOLD, 20));
		btnInviterDesPersonnes.setBackground(new Color(0, 191, 255));
		btnInviterDesPersonnes.setForeground(Color.WHITE);
		btnInviterDesPersonnes.setBounds(0, 399, 382, 38);
		panelOption.add(btnInviterDesPersonnes);
		
		panelOption.add(btnInviterDesPersonnes);
		
		panel_1 = new JPanel();
		panel_1.setBackground(new Color(0, 191, 255));
		panel_1.setBounds(0, 124, 382, 38);
		panelOption.add(panel_1);
		panel_1.setLayout(null);
		
		lblChaines = new JLabel("Chaines:");
		lblChaines.setForeground(Color.WHITE);
		lblChaines.setFont(new Font("Sitka Small", Font.BOLD, 20));
		lblChaines.setBounds(12, 13, 118, 16);
		panel_1.add(lblChaines);
		
		
		
		
		
		panelProfil = new JPanel();
		panelProfil.setBackground(new Color(240, 248, 255));
		panelProfil.setBounds(942, 136, 636, 571);
		contentPane.add(panelProfil);
		panelProfil.setLayout(null);
		
		photoProfil = new JLabel();
		photoProfil.setBounds(84, 13, 300, 318);
		panelProfil.add(photoProfil);
		if(img==null)
		{photoProfil.setIcon(new ImageIcon("D:\\tp java\\projet\\img\\add-user.png"));}
		else {
		image=new ImageIcon(img);
		photo =image.getImage();
		newImg=photo.getScaledInstance(photoProfil.getWidth(), photoProfil.getHeight(), Image.SCALE_SMOOTH);
		finalImg=new ImageIcon(newImg);
		
	
	    photoProfil.setIcon(finalImg);}
		lblNomUser = new JLabel(this.prenom+" "+this.nom);
		lblNomUser.setFont(new Font("Sitka Small", Font.BOLD, 13));
		lblNomUser.setBounds(84, 347, 144, 16);
		panelProfil.add(lblNomUser);
		
		btnDfinirStatut = new JButton("D\u00E9finir statut");
		btnDfinirStatut.setForeground(Color.DARK_GRAY);
		btnDfinirStatut.setBackground(new Color(240, 248, 255));
		btnDfinirStatut.setFont(new Font("Sitka Small", Font.PLAIN, 14));
		btnDfinirStatut.setBounds(141, 430, 144, 25);
		panelProfil.add(btnDfinirStatut);
		
		btnModifierProfil = new JButton("Modifier profil");
		btnModifierProfil.setBackground(new Color(240, 248, 255));
		btnModifierProfil.setFont(new Font("Sitka Small", Font.PLAIN, 14));
		btnModifierProfil.setForeground(Color.DARK_GRAY);
		btnModifierProfil.setBounds(141, 469, 144, 25);
		panelProfil.add(btnModifierProfil);
		
		JLabel lblDateDeNaissance = new JLabel("Date de Naissance:"+this.datNaiss);
		lblDateDeNaissance.setFont(new Font("Sitka Small",Font.PLAIN, 14));
		lblDateDeNaissance.setBounds(84, 376, 250, 16);
		panelProfil.add(lblDateDeNaissance);
		
		JLabel lblStatut = new JLabel("Statut:"+this.stat);
		lblStatut.setFont(new Font("Sit5a Small", Font.PLAIN, 15));
		panelProfil.add(lblStatut);
		lblStatut.setBounds(84, 405, 250, 16);
		panelChaines = new JPanel();
		panelChaines.setBackground(new Color(240, 248, 255));
		
		panelChaines.setBounds(380, 720, 1502, 233);
		
		contentPane.add(panelChaines);
		recherche.addFocusListener(new Focus());
		setFocusable(true);
		recherche.addKeyListener(new Key());
		mc=new MaConnexion();
		modelList=new DefaultListModel<String>();
		listRecherche=new JList(modelList);
		btnInviterDesPersonnes.setBorderPainted(false);
		btnAjoutChaine.setBorderPainted(false);
		Chaines=new DefaultListModel();
		list = new JList(Chaines);
		list.setForeground(Color.WHITE);
		list.setFont(new Font("Sitka Small", Font.BOLD, 20));
		list.setBackground(new Color(0, 191, 255));
		list.setBounds(0, 204, 382, 197);
		panelOption.add(list);
		scroll=new JScrollPane();
		panelOption.add(scroll);
		
		btnLoisirs = new JButton("Loisirs");
		btnLoisirs.setForeground(Color.WHITE);
		btnLoisirs.setBackground(new Color(0, 191, 255));
		btnLoisirs.setFont(new Font("Sitka Small", Font.BOLD, 20));
		btnLoisirs.setBounds(0, 438, 382, 38);
		panelOption.add(btnLoisirs);
		btnModifierProfil.addActionListener(new Action());
		btnDfinirStatut.addActionListener(new Action());
		btnInviterDesPersonnes.addMouseListener(new Mouse());
		btnAjoutChaine.addMouseListener(new Mouse());
		panel_1.addMouseListener(new Mouse());
		deconxItem.addActionListener(new Action());
		espaceItem.addActionListener(new Action());
		btnAjoutChaine.addActionListener(new Action());
		list.addMouseListener(new Mouse());
		btnLoisirs.addMouseListener(new Mouse());
		btnLoisirs.addActionListener(new Action());
	}
	class Focus implements FocusListener {

		@Override
		public void focusGained(FocusEvent e) {
			// TODO Auto-generated method stub
			if(e.getSource()==recherche) {
			recherche.setText("");
			Border border = BorderFactory.createLineBorder(new Color(0, 191, 255), 1);
			recherche.setBorder(border);
				
			}
		}

		@Override
		public void focusLost(FocusEvent e) {
			// TODO Auto-generated method stub
			if(e.getSource()==recherche) {
				recherche.setText("Recherche");
				Border border = BorderFactory.createLineBorder(Color.gray, 1);
				recherche.setBorder(border);
				
				}
		}
		}
	class Key implements KeyListener {

		@Override
		public void keyPressed(KeyEvent e) {
			// TODO Auto-generated method stub
			
			if ((e.getKeyCode() == KeyEvent.VK_ENTER)) {
				String modele=recherche.getText();
				String tab="utilisateur";
				String req="SELECT * FROM "+tab+" WHERE (nom like '%"+modele+"%' or prenom like '%"+modele+"%');";
				rs=mc.select(req);
				try { int i=0;
					while(rs.next()) {
						model=new MonModel(rs);
						table=new JTable();
						table.setBounds(1511, 125, -72, -40);
						Object[] t=new Object[] {rs.getString(2),rs.getString(3)};
						table.setModel(model);
						model.insert(t);
						
						
						panel.add(new JScrollPane(table));
						System.out.println(rs.getString(2)+" "+rs.getString(3));
					}
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
				
			}
		}

		@Override
		public void keyReleased(KeyEvent arg0) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void keyTyped(KeyEvent arg0) {
			// TODO Auto-generated method stub
			
		}
		
	}
	class Action implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			if(e.getSource()==btnModifierProfil)
			{	
				new ModificationProfil(mail).setVisible(true);
				panelProfil.validate();
			}
			if(e.getSource()==btnDfinirStatut)
			{
				new Statut(mail).setVisible(true);
			}
			
			if(e.getSource()==deconxItem)
			{	dispose();
				new PremierPas().setVisible(true);
			}
			
			if(e.getSource()==espaceItem)
			{
				new EspaceTravail(mail).setVisible(true);
			}
			if(e.getSource()==btnAjoutChaine)
			{
				
				new Chaines().setVisible(true);
				
			}
			if(e.getSource()==btnLoisirs)
			{
				new Opning().setVisible(true);}
			}
		
	}

class Mouse implements MouseListener{
@Override
public void mouseEntered(MouseEvent e) {
	// TODO Auto-generated method stub
	if(e.getSource()==panel_1)
	{
		lblChaines.setBackground(new Color(240, 248, 255));
		panel_1.setBackground(new Color(240, 248, 255));
		lblChaines.setForeground(Color.darkGray);
		
	}
	
	if(e.getSource()==btnAjoutChaine)
	{
		btnAjoutChaine.setBackground(new Color(240, 248, 255));
		btnAjoutChaine.setForeground(Color.darkGray);
		
	}
	if(e.getSource()==btnInviterDesPersonnes)
	{
		btnInviterDesPersonnes.setBackground(new Color(240, 248, 255));
		btnInviterDesPersonnes.setForeground(Color.darkGray);
		
	}
	if(e.getSource()==btnLoisirs)
	{
		btnLoisirs.setBackground(new Color(240, 248, 255));
		btnLoisirs.setForeground(Color.darkGray);
		
	}
}
@Override
public void mouseExited(MouseEvent e) {
	// TODO Auto-generated method stub
	if(e.getSource()==panel_1)
	{
		lblChaines.setBackground(new Color(0, 191, 255));
		panel_1.setBackground(new Color(0, 191, 255));
		lblChaines.setForeground(Color.white);
		
	}
	
	if(e.getSource()==btnAjoutChaine)
	{
		btnAjoutChaine.setBackground(new Color(0, 191, 255));
		btnAjoutChaine.setForeground(Color.white);
		
	}
	if(e.getSource()==btnInviterDesPersonnes)
	{
		btnInviterDesPersonnes.setBackground(new Color(0, 191, 255));
		btnInviterDesPersonnes.setForeground(Color.white);
	}
	if(e.getSource()==btnLoisirs)
	{
		btnLoisirs.setBackground(new Color(0, 191, 255));
		btnLoisirs.setForeground(Color.white);
	}
	}
@Override
public void mouseClicked(MouseEvent e) {
	// TODO Auto-generated method stub
	if (e.getButton()==MouseEvent.BUTTON1 & e.getClickCount()==2) {
		try {
			String chaine=(String) list.getSelectedValue();
		panelChaines.add(new Discussion(mail,nom,prenom,img,chaine));
		panelOption.validate();
	} catch (RemoteException | MalformedURLException | NotBoundException e1) {
		// TODO Auto-generated catch block
		e1.printStackTrace();
	}
	}
}
@Override
public void mousePressed(MouseEvent arg0) {
	// TODO Auto-generated method stub
	
}
@Override
public void mouseReleased(MouseEvent arg0) {
	// TODO Auto-generated method stub
	
}
}
}
