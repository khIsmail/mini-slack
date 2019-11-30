package pack2;

import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;
import java.sql.ResultSet;
import java.sql.SQLException;



public class RmiServer extends UnicastRemoteObject implements MyService{


		String msg;
		
		MaConnexion mc=new MaConnexion();
		int rq;
		ResultSet rs;
		
		String chaine,noteText;
	public RmiServer()  throws RemoteException {
		
		super();
		
		if(System.getSecurityManager()==null) {
			Registry reg = LocateRegistry.createRegistry(2001);
			reg.rebind("chat", this);
			System.out.println("lancement du serveur");
			
			
		}
		
	}

	public static void main(String[] args) throws RemoteException {
		new RmiServer();
		
	}
	
	@Override
	public void setMsg(String msg,String chaine,String sender) throws RemoteException{
	
		rq=mc.ajoutMsg(msg, chaine, "message", sender);
		this.msg = msg;
		this.chaine=chaine;
		
	}

	@Override
	public String getMsg() throws RemoteException {
		
		return msg;

	}

	public String getDiscussion(String chaine) throws RemoteException {
		
		StringBuilder sb = new StringBuilder();
		rs=mc.select("SELECT * FROM message WHERE discussion ='"+chaine+"';");
		try {
			while(rs.next()) {
				String line=rs.getString(4)+":"+rs.getString(3);
				sb.append(line+"\n");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		return sb.toString();
	}

	

	


	

	
	
}

