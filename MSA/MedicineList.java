package LinkList;

import java.sql.*;
import java.util.LinkedList;
import java.util.List;
import jcf.medicines;

public class MedicineList {
    public  List<medicines> getMedicines()
    {
        LinkedList<medicines> list =new LinkedList<>();
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
            String sql="SELECT * FROM  MEDICINE;";
            ResultSet rs=stmt2.executeQuery(sql);
            while(rs.next())
            {
                String mco=rs.getString("MCODE");
                String tname=rs.getString("TRADENAME");
                String gname=rs.getString("GENERICNAME");
                String vname=rs.getString("VENDORNAME");
                String vph=rs.getString("VENDORPHONE");
                String pp1=rs.getString("PPRICE");
                String sp1=rs.getString("SPRICE");
                String th1=rs.getString("THVALUE");
                String mqu=rs.getString("MQUANTITY");
                String mname=rs.getString("MNAME");
                int mcode=Integer.parseInt(mco);
                int vphone=Integer.parseInt(vph);
                int pp=Integer.parseInt(pp1);
                int sp=Integer.parseInt(sp1);
                int th=Integer.parseInt(th1);
                int mq=Integer.parseInt(mqu);
                md=new medicines(mcode,vphone,pp,sp,th,mq,tname,gname,mname,vname);
                list.add(md);
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
    public int addNewMedicine(int mcode,int vphone,int pprice,int sprice,int mqu,int thv,String tradename,String generic_name,String vendorname,String mname,String exdate) {
        int flag=0;
        String JDBC_DRIVER = "com.mysql.jdbc.Driver";  
        String DB_URL = "jdbc:mysql://localhost/MSA";
        String USER="root";
 	String PASS = "dbms";
        Connection conn1 = null;
        Statement stmt1 = null;
        try
        {
            Class.forName("com.mysql.jdbc.Driver");
            conn1 = DriverManager.getConnection(DB_URL,USER,PASS);
            stmt1 = conn1.createStatement();
            String sql ="INSERT INTO MEDICINE VALUES('"+mcode+"','"+tradename+"','"+generic_name+"','"+vendorname+"','"+vphone+"','"+pprice+"','"+sprice+"','"+thv+"','"+mqu+"','"+mname+"','"+exdate+"');";
            int q = stmt1.executeUpdate(sql);
            if(q!=-1)
            {
                flag=1;
            }
            stmt1.close();
            conn1.close();
            
        }catch(SQLException se)
        {
          return 3;
        }
        catch(ClassNotFoundException e)
        {
          return 4;
	}     
        return flag;
    }

    public int AddOldMedicine(int mcode,int mqu,int thv,int pprice,int sprice,String mname,String exdate) {
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
            String sql="UPDATE MEDICINE SET MNAME='"+mname+"',MQUANTITY='"+mqu+"',MNAME='"+mname+"',PPRICE='"+pprice+"',SPRICE='"+sprice+"',THVALUE='"+thv+"',EXDATE='"+exdate+"' WHERE MCODE='"+mcode+"';";
            int i=stmt.executeUpdate(sql);
            if(i!=-1)
            {
                flag=1;
            }
        }catch(SQLException se)
        {
          se.printStackTrace();
          return 3;
        }
        catch(Exception e)
        {
          
          e.printStackTrace();
          return 4;
	}
        
        return flag;
    }

    public String getName(int x) {
        String JDBC_DRIVER = "com.mysql.jdbc.Driver";  
        String DB_URL = "jdbc:mysql://localhost/MSA";
        String USER="root";
 	String PASS = "dbms";
         String sd="0";
        Connection conn2 = null;
        Statement stmt2 = null;
        try
        {   
            Class.forName(JDBC_DRIVER);
            conn2 = DriverManager.getConnection(DB_URL,USER,PASS);
            stmt2 = conn2.createStatement();
            String sql="SELECT MNAME FROM MEDICINE WHERE MCODE='"+x+"';";
            ResultSet rs=stmt2.executeQuery(sql);
            rs.next();
            sd=rs.getString(1);
            stmt2.close();
            conn2.close();
        }catch(SQLException se)
        {
          
        }
        catch(Exception e)
        {
          
	}
        return sd;
    }
}
