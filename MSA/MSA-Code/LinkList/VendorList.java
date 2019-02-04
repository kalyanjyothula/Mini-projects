/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package LinkList;

import java.sql.*;
import java.util.LinkedList;
import java.util.List;
import jcf.vendor;

public class VendorList {

    public int AddOldReq(int mcode, String mname, int mqu, String vname,int status) {
        int s=0;
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
            String sql ="UPDATE VENDOR SET MCODE='"+mcode+"',MNAME='"+mname+"',MQU='"+mqu+"',STATUS='"+status+"' WHERE USERNAME='"+vname+"'";
            int q = stmt2.executeUpdate(sql);
            if(q!=-1) s=1;
            stmt2.close();
            conn2.close();
        }catch(SQLException se)
        {
          return 3;
        }
        catch(Exception e)
        {
          return 4;
	}
        return s;
    }

    public int NewReq(String vname, int vphone, String mname, String exdate) {
        int s=0;
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
            String sql ="INSERT INTO VENDOR(USERNAME,VPHONE,MNAME,MQU,STATUS) VALUES('"+vname+"','"+vphone+"','"+mname+"','"+exdate+"','0');";
            int q = stmt2.executeUpdate(sql);
            if(q!=-1) s=1;
            stmt2.close();
            conn2.close();
        }catch(SQLException se)
        {
          return 3;
        }
        catch(Exception e)
        {
          return 4;
	}
        return s;
    }

    public int addExdate(int mcode, int mqu, String mname, String vname, int vphone, int i) {
        int z=0;
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
            String sql ="UPDATE VENDOR SET MCODE='"+mcode+"',MNAME='"+mname+"',MQU='"+mqu+"',STATUS='"+i+"' WHERE USERNAME='"+vname+"'";
            int q = stmt2.executeUpdate(sql);
            if(q!=-1) z=1;
            stmt2.close();
            conn2.close();
        }catch(SQLException se)
        {
          return 3;
        }
        catch(Exception e)
        {
          return 4;
	}
        return z;
    }

    public List<vendor> retriveReq(String username) {
        
        LinkedList<vendor> list =new LinkedList<>();
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
            String sql="SELECT * FROM  VENDOR WHERE USERNAME='"+username+"' && STATUS='0';";
            ResultSet rs=stmt2.executeQuery(sql);
            while(rs.next())
            {   
                vendor vd =new vendor();
                int mcode =rs.getInt(3);
                int mqu = rs.getInt(5);
                String mname=rs.getString("MNAME");
                int status=rs.getInt(6);
                vd.setMcode(mcode);
                vd.setMname(mname);
                vd.setMqu(mqu);
                vd.setStatus(status);
                list.add(vd);
            }
            rs.close();
            stmt2.close();
            conn2.close();
        }catch(SQLException se)  
        {
            //return 11;
        }
        catch(Exception e){
                //return 22;
	}
        return list;
        
    }   

    public void updateapprove(int mcode) {
        
        LinkedList<vendor> list =new LinkedList<>();
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
            String sql="UPDATE VENDOR SET STATUS='1' WHERE MCODE='"+mcode+"';";
            int i=stmt2.executeUpdate(sql);
        }catch(SQLException se)  
        {
            //return 11;
        }
        catch(Exception e){
                //return 22;
	}
    }

    public List<vendor> GetApproves(String username) {
        
        LinkedList<vendor> list =new LinkedList<>();
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
            String sql="SELECT * FROM  VENDOR WHERE USERNAME='"+username+"' && STATUS='1';";
            ResultSet rs=stmt2.executeQuery(sql);
            while(rs.next())
            {   
                vendor vd =new vendor();
                int mcode =rs.getInt(3);
                int mqu = rs.getInt(5);
                String mname=rs.getString("MNAME");
                vd.setMcode(mcode);
                vd.setMname(mname);
                vd.setMqu(mqu);
                list.add(vd);
            }
            rs.close();
            stmt2.close();
            conn2.close();
        }catch(SQLException se)  
        {
            //return 11;
        }
        catch(Exception e){
                //return 22;
	}
        return list;
    }
}
