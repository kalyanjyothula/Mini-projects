

import LinkList.*;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;
import java.util.Iterator;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import jcf.shopkeeper;

public class ShopkeeperPrint extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException{
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out=response.getWriter();
        ShopkeeperList gh=new ShopkeeperList();
        List<shopkeeper> list=gh.getShopkeeper();
        Iterator<shopkeeper> run;
        run=list.iterator();
        out.println("<div align=\"center\">");
        out.println("<hr>");
        out.println("<table border=\"1\" width=\"90%\" style=\"text-align:center;\">");
        out.println("<form action=\"UpShopkeep\" method=\"Post\">");
        out.println("<tr><td> Shopkeeper Name</td><td>ShopkeeperMobile</td><td>Assign OrderId</td><td></td></tr>");
        while(run.hasNext())
        {
            shopkeeper g=run.next();
            String username=g.getUsername();
            int mobile=g.getMobile();
           
            out.println("<tr><td>"+username+"</td><br><td>"+mobile+"</td><td><input type=\"text\"placeholder=\"Order Id\" name=\""+username+"\"/></td><td><input type=\"Submit\" value=\"Assign\" /></td></tr>");
            
        }
        out.println("</table>");
        out.println("</div>");
    }
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
