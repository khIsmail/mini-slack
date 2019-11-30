package pack1;

import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.table.AbstractTableModel;

public class MonModel extends AbstractTableModel {
int nbcol,nbl;
ResultSetMetaData rsmd;
//ArrayList<Etudiant> data;
ArrayList<Object[]> data;
String []titre;
public MonModel(ResultSet rs) {
	// TODO Auto-generated constructor stub
	try {
		rsmd=rs.getMetaData();
		nbcol=rsmd.getColumnCount();
		//titre=new String[nbcol];
		//data=new ArrayList<Etudiant>();
		data=new ArrayList<Object[]>();
		/*for(int i=0;i<nbcol;i++)
		{
			titre[i]=rsmd.getColumnName(i+1);
		}*/
		while(rs.next())
		{
			nbl++;
			//data.add(new Etudiant(rs.getInt(1),rs.getString(2),rs.getString(3),rs.getString(4)));
			Object []t=new Object[nbcol];
			for(int i=0;i<nbcol;i++)
				t[i]=rs.getObject(i+1);
			data.add(t);
		}
		
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	
}
@Override
public int getColumnCount() {
	// TODO Auto-generated method stub
	return nbcol;
}

@Override
public int getRowCount() {
	// TODO Auto-generated method stub
	return nbl;
}

@Override
public Object getValueAt(int l, int c) {
	// TODO Auto-generated method stub
	/*String ch="";
	Etudiant e=data.get(l);
	if(c==0)
		ch=e.getNum()+"";
	if(c==1)
		ch=e.getNom();
	if(c==2)
		ch=e.getPrenom();
	if(c==3)
		ch=e.getAdr();
	return ch;
	*/
	Object[] t=data.get(l);
	return t[c];
}
public void insert(Object []obj)
{	data.add(obj);
	nbl++;
	}
@Override
	public boolean isCellEditable(int lig, int col) {
		// TODO Auto-generated method stub
		//return super.isCellEditable(arg0, arg1);
	if(col==0)
		return false;
	else return true;
		
	}
@Override
	public String getColumnName(int col) {
		// TODO Auto-generated method stub
		String t="";
		try {
			t=rsmd.getColumnName(col+1);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return t;
		//return titre[col];
		
		
	}}

