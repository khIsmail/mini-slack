package pack2;

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.Remote;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.Vector;

import javax.swing.DefaultListModel;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.JTextPane;



import javax.swing.JScrollBar;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JList;
import java.awt.Color;
import javax.swing.JSlider;

public class Discussion extends JPanel implements ActionListener {
	JTextField textField;
	JScrollBar bar;
	String mail,nom,prenom,chaine;
	JList list;
	byte[] img;
	JTextArea textArea;
	JScrollBar scrollBar;
	UpdateThread updateThread = new UpdateThread();
	Client client;
	public Discussion(String mail,String nom,String prenom,byte[] img,String chaine) throws RemoteException, MalformedURLException, NotBoundException {
		setBackground(new Color(240, 248, 255));
		this.mail=mail;
		this.nom=nom;
		this.prenom=prenom;
		this.img=img;
		this.chaine=chaine;
		textField = new JTextField();
	    
		setPreferredSize(new Dimension(1502,233));
		setLayout(null);
		bar=new JScrollBar();
		
		textField.setBounds(26, 181, 1317, 39);
		add(textField);
		textField.setColumns(10);
		
		setVisible(true);
		
		
		textField.addActionListener(this);
		textArea = new JTextArea();
		textArea.setBounds(26, 13, 1317, 155);
		
	
		add(textArea);
		
		JScrollBar scrollBar_1 = new JScrollBar();
		scrollBar_1.setBounds(1322, 13, 21, 155);
		textArea.add(scrollBar_1);
		
		scrollBar = new JScrollBar();
		scrollBar.setBounds(1481, 0, 21, 233);
		add(scrollBar);
		
		try {
			client = new Client(mail,nom,prenom,img,chaine);
			setVisible(true);
			
		} catch (RemoteException | NotBoundException e) {

			e.printStackTrace();
		}
		updateThread.start();
		
	}
	
	

	@Override
	public void actionPerformed(ActionEvent arg0) {
	
		if(arg0.getSource() == textField) {
			
			try {
			
				client.sendMessage(textField.getText());
				textField.setText("");
				
				
			} catch (RemoteException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
		
	}
	

	class UpdateThread extends Thread{
	
	public void run() {
		
		while(true) {
			
			
			try {
				textArea.setText(client.getDiscuttion());
			} catch (RemoteException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			
			try {
				Thread.sleep(10);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
		
	}
	
}
}

