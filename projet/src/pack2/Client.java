package pack2;



import java.rmi.NotBoundException;
import java.rmi.Remote;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

import javax.swing.JOptionPane;



public class Client {

	String IP = "127.0.0.1";
	int port = 2001;
	
	String mail,nom,prenom,chaine;
	byte[] img;
	MyService service;
	public Client(String mail,String nom,String prenom,byte[] img,String chaine) throws RemoteException, NotBoundException {
		
		this.mail=mail;
		this.nom=nom;
		this.prenom=prenom;
		this.img=img;
		this.chaine=chaine;
		System.out.println("lancement client");
		

		
		Registry reg = LocateRegistry.getRegistry(IP,port);
		
		Remote r =reg.lookup("chat");
		
		if(r instanceof MyService) {
			
			service = (MyService)r;
		
		}
		
	}
	

	
	public void sendMessage(String value) throws RemoteException {
		
		service.setMsg(value,chaine,prenom+" "+nom);
	}
	
	public String getDiscuttion() throws RemoteException {
		return service.getDiscussion(chaine);
	}
	
}
