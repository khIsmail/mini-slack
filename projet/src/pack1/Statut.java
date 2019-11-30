package pack1;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;
import java.awt.Color;
import java.awt.Font;
import javax.swing.JButton;
import javax.swing.ImageIcon;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.ActionEvent;

public class Statut extends JFrame {

	private JPanel contentPane,panel,panel_1,panel_2,panel_3,panel_4;
	JButton btnEnRunion,btnDansLesTransports,btnEnCongMaladie,btnEnVacances,btnTltravail,btnEnregistrez;
	JLabel lblDfinirVotreStatut,lbl1,lbl2,lbl3,lbl4,lbl5;
	String mail;
	String statut="";
	MaConnexion mc;
	/**
	 * Launch the application.
	 */
	/*public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Statut frame = new Statut();
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
	public Statut(String mail) {
		this.mail=mail;
		setBounds(100, 100, 526, 430);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(240, 248, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		lblDfinirVotreStatut = new JLabel("D\u00E9finir un statut ");
		lblDfinirVotreStatut.setFont(new Font("Sitka Small", Font.BOLD, 24));
		lblDfinirVotreStatut.setForeground(Color.DARK_GRAY);
		lblDfinirVotreStatut.setBounds(12, 23, 273, 42);
		contentPane.add(lblDfinirVotreStatut);
		
		panel = new JPanel();
		panel.setBackground(new Color(240, 248, 255));
		panel.setBounds(0, 76, 508, 49);
		contentPane.add(panel);
		panel.setLayout(null);
		
		lbl1 = new JLabel("");
		lbl1.setBounds(12, 0, 40, 42);
		lbl1.setFont(new Font("Sitka Small", Font.PLAIN, 18));
		lbl1.setIcon(new ImageIcon("D:\\tp java\\projet\\img\\reunion.gif"));
		panel.add(lbl1);
		
		
		btnEnRunion = new JButton("En r\u00E9union");
		
		
		btnEnRunion.setBounds(55, 0, 441, 41);
		btnEnRunion.setForeground(new Color(0, 0, 0));
		btnEnRunion.setBackground(new Color(240, 248, 255));
		btnEnRunion.setBorderPainted(false);
		
		btnEnRunion.setFont(new Font("Sitka Small", Font.PLAIN, 20));
		panel.add(btnEnRunion);
		
		 panel_1 = new JPanel();
		panel_1.setBackground(new Color(240, 248, 255));
		panel_1.setBounds(0, 128, 508, 49);
		contentPane.add(panel_1);
		panel_1.setLayout(null);
		
		btnDansLesTransports = new JButton("Dans les transports");
		btnDansLesTransports.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		
		
		
		btnDansLesTransports.setBackground(new Color(240, 248, 255));
		btnDansLesTransports.setFont(new Font("Sitka Small", Font.PLAIN, 20));
		btnDansLesTransports.setBounds(57, 2, 439, 42);
		btnDansLesTransports.setBorderPainted(false);
		panel_1.add(btnDansLesTransports);
		
		lbl2 = new JLabel("");
		lbl2.setIcon(new ImageIcon("D:\\tp java\\projet\\img\\transport.gif"));
		lbl2.setBounds(12, 0, 43, 42);
		panel_1.add(lbl2);
		
		panel_2 = new JPanel();
		panel_2.setBackground(new Color(240, 248, 255));
		panel_2.setBounds(0, 181, 508, 49);
		contentPane.add(panel_2);
		panel_2.setLayout(null);
		
		lbl3 = new JLabel("");
		lbl3.setIcon(new ImageIcon("D:\\tp java\\projet\\img\\png-malade-malade-256.png"));
		lbl3.setBounds(12, 4, 42, 31);
		panel_2.add(lbl3);
		
		btnEnCongMaladie = new JButton("En cong\u00E9 maladie");
	
		btnEnCongMaladie.setBackground(new Color(240, 248, 255));
		btnEnCongMaladie.setFont(new Font("Sitka Small", Font.PLAIN, 20));
		btnEnCongMaladie.setBounds(58, 2, 441, 42);
		btnEnCongMaladie.setBorderPainted(false);
		panel_2.add(btnEnCongMaladie);
		
		panel_3 = new JPanel();
		panel_3.setBackground(new Color(240, 248, 255));
		panel_3.setBounds(0, 232, 508, 49);
		contentPane.add(panel_3);
		panel_3.setLayout(null);
		
		lbl4 = new JLabel("");
		lbl4.setIcon(new ImageIcon("D:\\tp java\\projet\\img\\bb42-tiny-en-vacances-5244.png"));
		lbl4.setBounds(12, 4, 45, 40);
		panel_3.add(lbl4);
		
		btnEnVacances = new JButton("En vacances");
		btnEnVacances.setBounds(56, 2, 440, 42);
		panel_3.add(btnEnVacances);
		
		btnEnVacances.setBackground(new Color(240, 248, 255));
		btnEnVacances.setFont(new Font("Sitka Small", Font.PLAIN, 20));
		btnEnVacances.setBorderPainted(false);
		
		panel_4 = new JPanel();
		panel_4.setBackground(new Color(240, 248, 255));
		panel_4.setBounds(0, 282, 508, 45);
		contentPane.add(panel_4);
		panel_4.setLayout(null);
		
		btnTltravail = new JButton("T\u00E9l\u00E9travail");
		
		
		btnTltravail.setBackground(new Color(240, 248, 255));
		btnTltravail.setFont(new Font("Sitka Small", Font.PLAIN, 20));
		btnTltravail.setBounds(60, 1, 439, 40);
		btnTltravail.setBorderPainted(false);
		panel_4.add(btnTltravail);
		
		lbl5 = new JLabel("");
		lbl5.setIcon(new ImageIcon("D:\\tp java\\projet\\img\\web-desk-3345988_1280-256x256.jpg"));
		lbl5.setBounds(12, 0, 42, 42);
		panel_4.add(lbl5);
		
		btnEnregistrez = new JButton("Enregistrez");
		btnEnregistrez.setForeground(Color.WHITE);
		btnEnregistrez.setBackground(new Color(0, 191, 255));
		btnEnregistrez.setFont(new Font("Sitka Small", Font.BOLD, 13));
		btnEnregistrez.setBorderPainted(false);
		
		btnEnregistrez.setBounds(343, 340, 128, 25);
		contentPane.add(btnEnregistrez);
		panel.addMouseListener(new Mouse());
		btnEnRunion.addMouseListener(new Mouse());
		panel_1.addMouseListener(new Mouse());
		btnDansLesTransports.addMouseListener(new Mouse());
		panel_2.addMouseListener(new Mouse());
		btnEnCongMaladie.addMouseListener(new Mouse());
		panel_3.addMouseListener(new Mouse());
		btnEnVacances.addMouseListener(new Mouse());
		panel_4.addMouseListener(new Mouse());
		btnTltravail.addMouseListener(new Mouse());
		btnEnRunion.addActionListener(new Action());
		btnDansLesTransports.addActionListener(new Action());
		btnEnCongMaladie.addActionListener(new Action());
		btnEnVacances.addActionListener(new Action());
		btnTltravail.addActionListener(new Action());
		btnEnregistrez.addActionListener(new Action());
		mc=new MaConnexion();
		}
	class Mouse implements MouseListener{
		@Override
		public void mouseEntered(MouseEvent e) {
			// TODO Auto-generated method stub
			if(e.getSource()==panel)
			{
				panel.setBackground(new Color(135, 206, 235));
				btnEnRunion.setBackground(new Color(135, 206, 235));
				
			}
			if(e.getSource()==btnEnRunion)
			{
				panel.setBackground(new Color(135, 206, 235));
				btnEnRunion.setBackground(new Color(135, 206, 235));
				
			}
			if(e.getSource()==panel_1)
			{
				panel_1.setBackground(new Color(135, 206, 235));
				btnDansLesTransports.setBackground(new Color(135, 206, 235));
				
			}
			if(e.getSource()==btnDansLesTransports)
			{
				panel_1.setBackground(new Color(135, 206, 235));
				btnDansLesTransports.setBackground(new Color(135, 206, 235));
				
			}
			if(e.getSource()==panel_2)
			{
				panel_2.setBackground(new Color(135, 206, 235));
				btnEnCongMaladie.setBackground(new Color(135, 206, 235));
				
			}
			if(e.getSource()==btnEnCongMaladie)
			{
				panel_2.setBackground(new Color(135, 206, 235));
				btnEnCongMaladie.setBackground(new Color(135, 206, 235));
				
			}
			if(e.getSource()==panel_3)
			{
				panel_3.setBackground(new Color(135, 206, 235));
				btnEnVacances.setBackground(new Color(135, 206, 235));
				
			}
			if(e.getSource()==btnEnVacances)
			{
				panel_3.setBackground(new Color(135, 206, 235));
				btnEnVacances.setBackground(new Color(135, 206, 235));
				
			}
			if(e.getSource()==panel_4)
			{
				panel_4.setBackground(new Color(135, 206, 235));
				btnTltravail.setBackground(new Color(135, 206, 235));
				
			}
			if(e.getSource()==btnTltravail)
			{
				panel_4.setBackground(new Color(135, 206, 235));
				btnTltravail.setBackground(new Color(135, 206, 235));
				
			}
			
		}
		@Override
		public void mouseExited(MouseEvent e) {
			// TODO Auto-generated method stub
			if(e.getSource()==panel)
			{
				panel.setBackground(new Color(240, 248, 255));
				btnEnRunion.setBackground(new Color(240, 248, 255));
			}
			if(e.getSource()==btnEnRunion)
			{
				panel.setBackground(new Color(240, 248, 255));
				btnEnRunion.setBackground(new Color(240, 248, 255));
			}
			if(e.getSource()==panel_1)
			{
				panel_1.setBackground(new Color(240, 248, 255));
				btnDansLesTransports.setBackground(new Color(240, 248, 255));
			}
			if(e.getSource()==btnDansLesTransports)
			{
				panel_1.setBackground(new Color(240, 248, 255));
				btnDansLesTransports.setBackground(new Color(240, 248, 255));
			}
			if(e.getSource()==panel_2)
			{
				panel_2.setBackground(new Color(240, 248, 255));
				btnEnCongMaladie.setBackground(new Color(240, 248, 255));
			}
			if(e.getSource()==btnEnCongMaladie)
			{
				panel_2.setBackground(new Color(240, 248, 255));
				btnEnCongMaladie.setBackground(new Color(240, 248, 255));
			}
			if(e.getSource()==panel_3)
			{
				panel_3.setBackground(new Color(240, 248, 255));
				btnEnVacances.setBackground(new Color(240, 248, 255));
			}
			if(e.getSource()==btnEnVacances)
			{
				panel_3.setBackground(new Color(240, 248, 255));
				btnEnVacances.setBackground(new Color(240, 248, 255));
			}
			if(e.getSource()==panel_4)
			{
				panel_4.setBackground(new Color(240, 248, 255));
				btnTltravail.setBackground(new Color(240, 248, 255));
			}
			if(e.getSource()==btnTltravail)
			{
				panel_4.setBackground(new Color(240, 248, 255));
				btnTltravail.setBackground(new Color(240, 248, 255));
			}
		}
		@Override
		public void mouseClicked(MouseEvent arg0) {
			// TODO Auto-generated method stub
			
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

class Action implements ActionListener{

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource()==btnEnRunion) {
			statut="En réunion";
		}
		if(e.getSource()==btnDansLesTransports) {
			statut="Dans les transports";
		}
		if(e.getSource()==btnEnCongMaladie) {
			statut="En congé maladie";
		}
		if(e.getSource()==btnEnVacances) {
			statut="En vacances";
		}
		if(e.getSource()==btnTltravail) {
			statut="Télétravail";
		}
		if(e.getSource()==btnEnregistrez)
		{
			int res=mc.modifier("UPDATE utilisateur SET statut='"+statut+"' WHERE email='"+mail+"';");
		}
		
		
		
	}
	
}
}