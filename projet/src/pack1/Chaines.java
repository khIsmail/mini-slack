package pack1;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.DefaultListModel;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JList;
import java.awt.Color;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Vector;

public class Chaines extends JFrame implements MouseListener {

	private JPanel contentPane;

	JList list;
	DefaultListModel model;
	MaConnexion mc;
	ResultSet rs;
	String chaine="";
	Vector<String> vect;
	String elt;
	public Chaines() {
		setTitle("Chaines existantes");
		setIconImage(Toolkit.getDefaultToolkit().getImage("D:\\tp java\\projet\\letter-s (4).png"));
	
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(240, 248, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		model=new DefaultListModel();
		list = new JList(model);
		list.setFont(new Font("Sitka Small", Font.BOLD, 14));
		list.setBackground(new Color(240, 248, 255));
		list.setBounds(12, 13, 408, 227);
		contentPane.add(list);
		vect=new Vector<String>();
		mc=new MaConnexion();
		rs=mc.select("SELECT * FROM discusiion;");
		try {
			while(rs.next())
			{
				vect.addElement(rs.getString(1));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		for(String elt:vect)
			model.addElement(elt);
		list.addMouseListener(this);
	}
			
				
	public String  getChaine() {
		return chaine;
	}


	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
			if (e.getButton()==MouseEvent.BUTTON1 & e.getClickCount()==2)
		{
			chaine=(String) list.getSelectedValue();
			Accueil.Chaines.addElement(chaine);
			Accueil.list.validate();
		}
	}







	@Override
	public void mouseEntered(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}







	@Override
	public void mouseExited(MouseEvent arg0) {
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
