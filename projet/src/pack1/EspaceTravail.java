package pack1;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextArea;
import javax.swing.JButton;
import javax.swing.JTextField;

public class EspaceTravail extends JFrame {

	JPanel contentPane;
	JButton btnValider;
	JTextField textField;
	String mail;
	MaConnexion mc;
	
	public EspaceTravail(String mail) {
		this.mail=mail;
		setIconImage(Toolkit.getDefaultToolkit().getImage("D:\\tp java\\projet\\letter-s (4).png"));
		setTitle("Slack");
		
		setBounds(100, 100, 419, 291);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(240, 248, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Cr\u00E9er votre propre espace ");
		lblNewLabel.setFont(new Font("Sitka Small", Font.BOLD, 20));
		lblNewLabel.setForeground(new Color(0, 0, 128));
		lblNewLabel.setBounds(12, 26, 360, 36);
		contentPane.add(lblNewLabel);
		
		JLabel lblNomDeDiscussion = new JLabel("Nom de discussion");
		lblNomDeDiscussion.setFont(new Font("Sitka Small", Font.PLAIN, 16));
		lblNomDeDiscussion.setForeground(new Color(0, 0, 128));
		lblNomDeDiscussion.setBounds(25, 108, 156, 16);
		contentPane.add(lblNomDeDiscussion);
		
		btnValider = new JButton("Valider");
		btnValider.setForeground(Color.WHITE);
		btnValider.setBackground(new Color(0, 191, 255));
		btnValider.setFont(new Font("Sitka Small", Font.PLAIN, 13));
		btnValider.setBounds(138, 181, 97, 25);
		contentPane.add(btnValider);
		
		textField = new JTextField();
		textField.setFont(new Font("Sitka Small", Font.PLAIN, 14));
		textField.setForeground(Color.GRAY);
		textField.setBounds(209, 105, 180, 22);
		contentPane.add(textField);
		textField.setColumns(10);
		btnValider.addActionListener(new Action());
		mc=new MaConnexion();
	}
	class Action implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			if(e.getSource()==btnValider)
			{
				int req=mc.ajoutDiscussion(textField.getText(), "", mail,"discusiion");
				
			}
		}
		
	}
}
