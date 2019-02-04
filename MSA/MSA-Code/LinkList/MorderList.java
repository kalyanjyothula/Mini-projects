
package LinkList;

import java.sql.*;
import java.util.LinkedList;
import java.util.List;
import jcf.Morder;

public class MorderList {

    public void addOrder(String username, int no, int op, int sp, String address,int status) {
        
        String JDBC_DRIVER = "com.mysql.jdbc.Driver";  
        String DB_URL = "jdbc:mysql://localhost/MSA";
        String USER="root";
 	String PASS = "dbms";
        Connection conn2 = null;
        Statement stmt2 = null;

        try
        {   Class.forName(JDBC_DRIVER);
            conn2 = DriverManager.getConnection(DB_URL,USER,PASS);
            stmt2=conn2.createStatement();
            String sql="INSERT INTO MORDER(USERNAME,NO,OPTOTAL,SPTOTAL,ADDRESS,status) VALUES('"+username+"','"+no+"','"+op+"','"+sp+"','"+address+"','"+status+"');";
            int i=stmt2.executeUpdate(sql);
            
        }
        catch(SQLException se)
        {
          
        }
        catch(Exception e)
        {
            
        }
    }

    public int OrderId(String username, int no) {
        int oid=-1;
        String JDBC_DRIVER = "com.mysql.jdbc.Driver";  
        String DB_URL = "jdbc:mysql://localhost/MSA";
        String USER="root";
 	String PASS = "dbms";
        Connection conn2 = null;
        Statement stmt2 = null;

        try
        {   Class.forName(JDBC_DRIVER);
            conn2 = DriverManager.getConnection(DB_URL,USER,PASS);
            stmt2=conn2.createStatement();
            String sql="SELECT ORDERID FROM MORDER WHERE USERNAME='"+username+"' && NO='"+no+"';";
            ResultSet rs=stmt2.executeQuery(sql);
            rs.next();
            oid=rs.getInt(1);
            
        }
        catch(SQLException se)
        {
          
        }
        catch(Exception e)
        {
            
        }
        return oid;
    }

    public int OrderStatus(String username, int p) {
        int oid=-1;
        String JDBC_DRIVER = "com.mysql.jdbc.Driver";  
        String DB_URL = "jdbc:mysql://localhost/MSA";
        String USER="root";
 	String PASS = "dbms";
        Connection conn2 = null;
        Statement stmt2 = null;

        try
        {   Class.forName(JDBC_DRIVER);
            conn2 = DriverManager.getConnection(DB_URL,USER,PASS);
            stmt2=conn2.createStatement();
            String sql="SELECT * FROM MORDER WHERE USERNAME='"+username+"' && NO='"+p+"';";
            ResultSet rs=stmt2.executeQuery(sql);
            rs.next();
            oid=rs.getInt(7);
            
        }
        catch(SQLException se)
        {
          
        }
        catch(Exception e)
        {
            
        }
        return oid;
    }

    public List<Morder> chorder(int i) {
        LinkedList<Morder> list =new LinkedList<>();
        String JDBC_DRIVER = "com.mysql.jdbc.Driver";  
        String DB_URL = "jdbc:mysql://localhost/MSA";
        String USER="root";
 	String PASS = "dbms";
        Connection conn2 = null;
        Statement stmt2 = null;

        try
        {   Class.forName(JDBC_DRIVER);
            conn2 = DriverManager.getConnection(DB_URL,USER,PASS);
            stmt2=conn2.createStatement();
            String sql="SELECT * FROM MORDER WHERE status='"+i+"';";
            ResultSet rs=stmt2.executeQuery(sql);
            while(rs.next())
            {
                Morder mm=new Morder();
                int oid=rs.getInt(1);
                String us=rs.getString(2);
                String ad=rs.getString(6);
                int st=rs.getInt(7);
                mm.setUsername(us);
                mm.setOrderid(oid);
                mm.setAddress(ad);
                mm.setStatus(st);
                list.add(mm);
            }
            
        }
        catch(SQLException se)
        {
          
        }
        catch(Exception e)
        {
            
        }
        return list;
    }
    
}
