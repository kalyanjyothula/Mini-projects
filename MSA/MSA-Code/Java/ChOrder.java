/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import LinkList.*;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Iterator;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import jcf.Morder;

public class ChOrder extends HttpServlet {
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        MorderList h=new MorderList();
        List<Morder> list=h.chorder(1);
        Iterator<Morder> run;
        run=list.iterator();
        out.println("<head>");
        out.println("<link rel=\"stylesheet\" type=\"text/css\" href=\"css/main.css\">");
        out.println("<title>MSA</title>");
        out.println(" </head>");
        out.println("<body>");
        out.println("<div>");
        out.println("<div class=\"rgukt\">");
        out.println("<img align=\"left\" style=\"width:100px; height:100px; margin-top:10px;\" src=\"images/icon1.png\" alt=\"IMG\" >");
        out.println("<h1>MEDICAL SHOP AUTOMATION</h1>");
        out.println("</div>");
        out.println("</div>");
        out.println("<div class=\"login-2\">");
        out.println("<ul>");       
        out.println("<a href=\"SignOut\">Signout</a>");  
        out.println("<a href=\"m_notification.jsp\">Notification</a>");  
        out.println("<a href=\"m_profits.jsp\">Profits</a> ");
        out.println("<a href=\"m_v_request.jsp\">MedicineRequest</a>");  
        out.println("<a href=\"Supply.jsp\">Supply</a> ");
        out.println("<a href=\"m_s_approve.jsp\">OrderApprove</a> ");
        out.println("<a href=\"ShopkeeperPrint\">Shopkeeper</a> ");  
        out.println("<a href=\"ChOrder\">Orders</a>  ");
        out.println("<a href=\"List.jsp\">Medicines</a>");
        out.println("<a href=\"Manager.jsp\">Home</a>");
        out.println("</ul>");
        out.println("</div>");
        out.println("<div align=\"center\">");
        out.println("<br><br><table border=\"1\" width=\"90%\" style=\"text-align:center;\">");
        out.println("<tr><td>OrderId</td><td>Username</td><td>Address</td><td>Status</td></tr>");
        while(run.hasNext())
        {
            Morder m=run.next();
            String hp="";
            if((m.getStatus())==1) hp="Not Assign";
            else hp="Assigned";
            out.println("<tr><td>"+m.getOrderid()+"</td><td>"+m.getUsername()+"</td><td>"+m.getAddress()+"</td><td>"+hp+"</td></tr>");   
        }
        out.println("</table>");
        out.println("</div>");
        
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
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
