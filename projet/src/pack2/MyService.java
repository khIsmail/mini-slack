package pack2;


import java.rmi.Remote;
import java.rmi.RemoteException;



public interface MyService extends Remote {

	void setMsg(String msg,String chaine,String sender) throws RemoteException;
	String getMsg() throws RemoteException;
	String getDiscussion(String chaine) throws RemoteException;
		
		
}
