
package LinkList;

import java.sql.*;
import java.util.LinkedList;
import java.util.List;
import jcf.shopkeeper;

public class ShopkeeperList {
    public List<shopkeeper> getShopkeeper()
    {
        LinkedList<shopkeeper> list =new LinkedList<>();
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
            stmt = conn.createStatement();
            String sql=String.format("SELECT * FROM  REG WHERE TYPE='3';");
            ResultSet rs=stmt.executeQuery(sql);
            while(rs.next())
            {
                String username=rs.getString("USERNAME");
                String email=rs.getString("EMAIL");
                String mb=rs.getString("MOBILE");
                int mobile=Integer.parseInt(mb);
                shopkeeper sd=new shopkeeper();
                sd.setEmail(email);
                sd.setUsername(username);
                sd.setMobile(mobile);
                list.add(sd);
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
}
