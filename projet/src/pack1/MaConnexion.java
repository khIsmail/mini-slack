package pack1;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Date;


public class MaConnexion {
		Connection con;
		Statement st;
		PreparedStatement ps;
		public MaConnexion()
		{
			try {
				Class.forName("com.mysql.jdbc.Driver");
				try {
					con = DriverManager.getConnection("jdbc:mysql://127.0.0.1/slackbd", "root", "");
					st=con.createStatement();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				 
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
		public void ajoutImage(String path,String tab,String mail) {
			
			try {
				ps= con.prepareStatement("UPDATE "+tab+" SET image=? WHERE email='"+mail+"'");
				InputStream is=new FileInputStream(new File(path));
				ps.setBinaryStream(1, is, (int)(new File(path).length()));
				ps.executeUpdate();
			} catch (SQLException | FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			
		}
		public int modifier(String req)
		{	
			int n=0;
			try {
				n = st.executeUpdate(req);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return n;
		}
		
		public int ajout(String tab,String email,String nom,String prenom,Date date,String motpass,String sexe)
		{
			String req="INSERT INTO "+tab+"(email,nom,prenom,datnaiss,motpasse,sexe) VALUES('"+email+"','"+nom+"','"+prenom+"','"+date+"','"+motpass+"','"+sexe+"');";
		
			int rq=0;
			try {
				rq = st.executeUpdate(req);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return rq;
		}
		public ResultSet select(String req)
		{	ResultSet rs = null;
			try {
				rs=st.executeQuery(req);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return rs;
		}
		int ajoutDiscussion(String nom,String msg,String mail,String tab)
		{
			String req="INSERT INTO "+tab+" VALUES('"+nom+"','"+mail+"');";
			
			int rq=0;
			try {
				rq = st.executeUpdate(req);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return rq;
		
		}
		public int ajoutMsg(String msg,String discussion,String tab,String sender) 
		{
			int rq=0;
			try {			String req="INSERT INTO "+tab+" VALUES('"+discussion+"','"+msg+"','"+sender+"');";

				
				st.executeUpdate(req);

			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return rq;
			
		}
}
