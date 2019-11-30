package pack2;

import java.io.Serializable;

public class Note implements Serializable {

	String body;
	String pseudo;
	
	public Note(String pseudo, String content) {
		
		this.pseudo = pseudo;
		body = content;
		
	}
	
	public String getIndex() {
		return pseudo;
	}
	
	public String getContent() {
		
		return body;
		
	}

	@Override
	public String toString() {
		
		return( pseudo + " : " + body+"\n" );
		
	}
	
}