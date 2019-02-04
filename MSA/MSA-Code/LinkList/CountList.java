/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package LinkList;

import java.sql.*;
import java.util.LinkedList;
import java.util.List;
import jcf.Count;
import jcf.medicines;

public class CountList {
    public int getCountNO(String username)
    { 
        String JDBC_DRIVER = "com.mysql.jdbc.Driver";  
        String DB_URL = "jdbc:mysql://localhost/MSA";
        String USER="root";
 	String PASS = "dbms";
        Connection conn2 = null;
        String mno;
        int flag=0;
        int no=-1;
        try
        {   
            Class.forName(JDBC_DRIVER);
            conn2 = DriverManager.getConnection(DB_URL,USER,PASS);
            Statement stmt1 = conn2.createStatement();
            String sql="SELECT * FROM  CCOUNT;";
            ResultSet rs=stmt1.executeQuery(sql);
            while(rs.next())
            {
                if(rs.getString(2).equals(username))
                {
                    no=rs.getInt(1);
                    flag=1;
                    break;
                }
            }
            if(flag==1)
            {
                return no;
            }
            else
            {
                String sql1="INSERT INTO CCOUNT VALUES('0','"+username+"');";
                int i=stmt1.executeUpdate(sql1);
                if(i!=-1)
                {
                    return 0;
                }
                else
                {
                    return -1;
                }
            }
        }catch(SQLException se)
        {
          return -11;
        }
        catch(Exception e)
        {
          return -4;
	}
    }
    public List<Count> getCountData()
    {
        LinkedList<Count> list =new LinkedList<>();
        String JDBC_DRIVER = "com.mysql.jdbc.Driver";  
        String DB_URL = "jdbc:mysql://localhost/MSA";
        String USER="root";
 	String PASS = "dbms";
        Connection conn2 = null;
        Statement stmt2 = null;
        try
        {   medicines md;
            Class.forName(JDBC_DRIVER);
            conn2 = DriverManager.getConnection(DB_URL,USER,PASS);
            stmt2 = conn2.createStatement();
            String sql="SELECT * FROM  CCOUNT;";
            ResultSet rs=stmt2.executeQuery(sql);
            while(rs.next())
            {
                String no=rs.getString("NO");
                String username=rs.getString("USERNAME");
                Count od=new Count();
                od.setNo(Integer.parseInt(no));
                od.setUsername(username);
                list.add(od);
            }
            rs.close();
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

    public int updateNo(int no,String username) {
        String JDBC_DRIVER = "com.mysql.jdbc.Driver";  
        String DB_URL = "jdbc:mysql://localhost/MSA";
        String USER="root";
 	String PASS = "dbms";
        Connection conn2 = null;
        Statement stmt2 = null;
        int i=-2;
        try
        {   Class.forName(JDBC_DRIVER);
            conn2 = DriverManager.getConnection(DB_URL,USER,PASS);
            stmt2=conn2.createStatement();
            String sql="UPDATE CCOUNT SET NO='"+no+"' WHERE USERNAME='"+username+"';";
            i=stmt2.executeUpdate(sql);
        }
        catch(SQLException se)
        {
          return 8;
        }
        catch(Exception e)
        {
            return 9;
        }
        return i;
    }

    public int getMax(String username) {
        String JDBC_DRIVER = "com.mysql.jdbc.Driver";  
        String DB_URL = "jdbc:mysql://localhost/MSA";
        String USER="root";
 	String PASS = "dbms";
        Connection conn2 = null;
        Statement stmt2 = null;
        int i=-2;
        try
        {   Class.forName(JDBC_DRIVER);
            conn2 = DriverManager.getConnection(DB_URL,USER,PASS);
            stmt2=conn2.createStatement();
            String sql="SELECT MAX(NO) FROM CCOUNT WHERE USERNAME='"+username+"';";
            ResultSet rs=stmt2.executeQuery(sql);
            rs.next();
            i=rs.getInt(1);
        }
        catch(SQLException se)
        {
          return 8;
        }
        catch(Exception e)
        {
            return 9;
        }
        return i;
    }
}
