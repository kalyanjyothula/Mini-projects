
package LinkList;

import java.sql.*;
import java.util.LinkedList;
import java.util.List;
import jcf.Corder;

public class CorderList {

    public void addToData(int no, int mcode, int op, int sp, String username) {
        String JDBC_DRIVER = "com.mysql.jdbc.Driver";  
        String DB_URL = "jdbc:mysql://localhost/MSA";
        String USER="root";
 	String PASS = "dbms";
        Connection conn2 = null;
        Statement stmt2 = null;
        try
        {   
            Class.forName(JDBC_DRIVER);
            conn2 = DriverManager.getConnection(DB_URL,USER,PASS);
            stmt2 = conn2.createStatement();
            String sql="INSERT INTO CORDER(NO,MCODE,OPRICE,CPRICE,USERNAME) VALUES('"+no+"','"+mcode+"','"+op+"','"+sp+"','"+username+"');";
            int i=stmt2.executeUpdate(sql);
            stmt2.close();
            conn2.close();
        }catch(SQLException se)
        {
          
        }
        catch(Exception e)
        {
          
	}
      
    }

    public List<Corder> getOrderList(int no,String username) {
        LinkedList<Corder> list =new LinkedList<>();
        String JDBC_DRIVER = "com.mysql.jdbc.Driver";  
        String DB_URL = "jdbc:mysql://localhost/MSA";
        String USER="root";
 	String PASS = "dbms";
        Connection conn2 = null;
        Statement stmt2 = null;
        try
        {   
            Class.forName(JDBC_DRIVER);
            conn2 = DriverManager.getConnection(DB_URL,USER,PASS);
            stmt2 = conn2.createStatement();
            String sql="SELECT * FROM CORDER WHERE NO='"+no+"' && USERNAME='"+username+"';";
            ResultSet rs=stmt2.executeQuery(sql);
            while(rs.next())
            {
                Corder g=new Corder();
                g.setMcode(rs.getInt(2));
                g.setOprice(rs.getInt(3));
                g.setCprice(rs.getInt(4));
                list.add(g);
            }
            stmt2.close();
            conn2.close();
        }catch(SQLException se)
        {
          
        }
        catch(Exception e)
        {
          
	}
        return list;
    }

    public void UpdateMqc(int rmq, int x,int no) {
        
        String JDBC_DRIVER = "com.mysql.jdbc.Driver";  
        String DB_URL = "jdbc:mysql://localhost/MSA";
        String USER="root";
 	String PASS = "dbms";
        Connection conn2 = null;
        Statement stmt2 = null;
        try
        {   
            Class.forName(JDBC_DRIVER);
            conn2 = DriverManager.getConnection(DB_URL,USER,PASS);
            stmt2 = conn2.createStatement();
            String sql="UPDATE CORDER SET MQU='"+rmq+"' WHERE MCODE='"+x+"' && NO='"+no+"';";
            int i=stmt2.executeUpdate(sql);
            stmt2.close();
            conn2.close();
        }catch(SQLException se)
        {
          
        }
        catch(Exception e)
        {
          
	}
    }
       public int getOrders(int no,String username) {
           int i=-1;
        LinkedList<Corder> list =new LinkedList<>();
        String JDBC_DRIVER = "com.mysql.jdbc.Driver";  
        String DB_URL = "jdbc:mysql://localhost/MSA";
        String USER="root";
 	String PASS = "dbms";
        Connection conn = null;
        Statement stmt = null;
        try
        {
            Class.forName("com.mysql.jdbc.Driver");
            conn = DriverManager.getConnection(DB_URL,USER,PASS);
            stmt = conn.createStatement();
            String sql=String.format("SELECT * FROM CORDER WHERE NO='"+no+"' && USERNAME='"+username+"';");
            ResultSet rs = stmt.executeQuery(sql);
            while(rs.next())
            {
                int mcode=rs.getInt(2);
                int cprice=rs.getInt(4);
                int q=rs.getInt(6);
                Corder ho=new Corder();
                ho.setMcode(mcode);
                ho.setCprice(cprice);
                ho.setMqu(q);
                list.add(ho);  
            } 
            rs.close();
            stmt.close();
            conn.close();
        }catch(SQLException se)
        {
          return -2;
        }
        catch(Exception e)
        {
          return -3;
	}
        return i;
    }

    public int getMquty(int p,int mcode,String username) {
        String JDBC_DRIVER = "com.mysql.jdbc.Driver";  
        String DB_URL = "jdbc:mysql://localhost/MSA";
        String USER="root";
 	String PASS = "dbms";
        Connection conn = null;
        Statement stmt = null;
        int mq=-1;
        try
        {
            Class.forName("com.mysql.jdbc.Driver");
            conn = DriverManager.getConnection(DB_URL,USER,PASS);
            stmt = conn.createStatement();
            String sql=String.format("SELECT * FROM CORDER WHERE NO='"+p+"' && USERNAME='"+username+"' && MCODE='"+mcode+"';");
            ResultSet rs = stmt.executeQuery(sql);
            rs.next();
            mq=rs.getInt(6);
            rs.close();
            stmt.close();
            conn.close();
        }catch(SQLException se)
        {
          return -2;
        }
        catch(Exception e)
        {
          return -3;
	}
        return mq;
    }
}

