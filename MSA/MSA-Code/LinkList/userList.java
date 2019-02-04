package LinkList;

import java.sql.*;
import java.util.LinkedList;
import java.util.List;
import jcf.user;

public class userList {
    public List<user> getUsers()
    {
        LinkedList<user> list =new LinkedList<>();
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
            String sql=String.format("SELECT * FROM  REG WHERE TYPE='2';");
            ResultSet rs = stmt.executeQuery(sql);
            while(rs.next())
            {
                String usernmae=rs.getString("username");
                String email=rs.getString("email");
                String phone=rs.getString("phone");  
                user ud=new user();
                ud.setEmail(email);
                ud.setPhone(phone);
                ud.setUsername(usernmae);
                list.add(ud);
                
            } 
            rs.close();
            stmt.close();
            conn.close();
        }catch(SQLException se)
        {
          se.printStackTrace();
        }
        catch(Exception e)
        {
          e.printStackTrace();
	}
        return list;
    }
    public int UserReg(String username,String email,String pass1,String phone, String type)
    {
        int flag =0;
        String JDBC_DRIVER = "com.mysql.jdbc.Driver";  
        String DB_URL = "jdbc:mysql://localhost/MSA";
        String USER="root";
 	String PASS = "dbms";
        Connection conn = null;
        Statement stmt = null;
        try
        {
            
            Class.forName(JDBC_DRIVER);
            conn = DriverManager.getConnection(DB_URL,USER,PASS);
            stmt =conn.createStatement();
            String sql = "insert into REG(EMAIL,PASSWORD,PHONE,TYPE,USERNAME) values('"+email+"','"+pass1+"','"+phone+"','"+type+"','"+username+"');";
            int q = stmt.executeUpdate(sql);
            if(q!=-1)
            {
                flag=1;
            }
            stmt.close();
            conn.close();
        }catch(SQLException se)
        {
          se.printStackTrace();
        }
        catch(Exception e)
        {
          
          e.printStackTrace();
	}
        return flag;
    }

    public int login(String username, String password) {
        String JDBC_DRIVER = "com.mysql.jdbc.Driver";  
        String DB_URL = "jdbc:mysql://localhost/MSA";
        String USER="root";
 	String PASS = "dbms";
        Connection conn = null;
        Statement stmt = null;
        int i=0;
        try
        {
          
            Class.forName(JDBC_DRIVER);
            conn = DriverManager.getConnection(DB_URL,USER,PASS);
            stmt =conn.createStatement();
            String sql = "select * from REG WHERE USERNAME='"+username+"' && PASSWORD='"+password+"';";
            ResultSet rs=stmt.executeQuery(sql);
            while(rs.next())
            {
                String type=rs.getString("TYPE");
                i=Integer.parseInt(type);
            }
            rs.close();
            stmt.close();
            conn.close();
        }catch(SQLException se)
        {
          se.printStackTrace();
          return -1;
        }
        catch(Exception e)
        {
          
          e.printStackTrace();
          return -2;
	}
        return i;
    }

    public int addFeedback(String feed,String username) {
        
        String JDBC_DRIVER = "com.mysql.jdbc.Driver";  
        String DB_URL = "jdbc:mysql://localhost/MSA";
        String USER="root";
 	String PASS = "dbms";
        Connection conn = null;
        Statement stmt = null;
        int i=0;
        try
        {
            Class.forName(JDBC_DRIVER);
            conn = DriverManager.getConnection(DB_URL,USER,PASS);
            stmt =conn.createStatement();
            String sql = "INSERT INTO FEEDBACK VALUES('"+username+"','"+feed+"');";
            i=stmt.executeUpdate(sql);
            stmt.close();
            conn.close();
        }catch(SQLException se)
        {
          se.printStackTrace();
          return -1;
        }
        catch(Exception e)
        {
          
          e.printStackTrace();
          return -2;
	}
        return i;
    }

    public int addNewMedicine(String username, String newmedicine) 
    {
        int i=0;
        String JDBC_DRIVER = "com.mysql.jdbc.Driver";  
        String DB_URL = "jdbc:mysql://localhost/MSA";
        String USER="root";
 	String PASS = "dbms";
        Connection conn = null;
        Statement stmt = null;
        try
        {
            Class.forName(JDBC_DRIVER);
            conn = DriverManager.getConnection(DB_URL,USER,PASS);
            stmt =conn.createStatement();
            String sql = "INSERT INTO CNEWMEDICINE VALUES('"+username+"','"+newmedicine+"');";
            i=stmt.executeUpdate(sql);
            stmt.close();
            conn.close();
            
        }catch(SQLException se)
        {
          se.printStackTrace();
          return -1;
        }
        catch(Exception e)
        {
          
          e.printStackTrace();
          return -2;
	}
        return i;
    }
}


