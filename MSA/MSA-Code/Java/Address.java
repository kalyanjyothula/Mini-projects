/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import LinkList.*;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class Address extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        PrintWriter out = response.getWriter();
        response.setContentType("text/html;charset=UTF-8");
        String name=request.getParameter("aname");
        String district=request.getParameter("adistrict");
        String state=request.getParameter("state");
        String pincode=request.getParameter("pincode");
        String mobile=request.getParameter("mobile");
        HttpSession session=request.getSession(false); 
        String username=(String)session.getAttribute("USERNAME1");
        int op=(int)session.getAttribute("TOPRICE");
        int sp=(int)session.getAttribute("TSPRICE");
        int no=(int)session.getAttribute("NO");
        String address=name+","+district+","+state+","+pincode+","+mobile;
        //out.println(address);
        MorderList h=new MorderList();
        h.addOrder(username,no,op,sp,address,1);
        int y=h.OrderId(username,no);
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
        out.println("<a href=\"Feedback.jsp\">Feedback</a>");  
        out.println("<a href=\"CNewmedicine.jsp\">MedicineRequest</a>");
        out.println("<a href=\"Cvieworder.jsp\">Orders</a>");  
        out.println("<a href=\"Cmedicine.jsp\">Medicine</a>");
        out.println("<a href=\"Customer.jsp\">Home</a>");
        out.println("</ul>");
        out.println("</div>");
        out.println("<div>");
        out.println("<br><h1 align=\"center\">Successfull<h1><br><br>");
        out.println("<br><div>");
        out.println("<table border=\"1\" width=\"70%\" style=\"text-align:center; margin-left:200px;\">");
        out.println("<tr><td>OrderId</td><td>TotalCost</td><td>Address</td></tr>");
        out.println("<tr><td>"+y+"</td><td>"+sp+"</td><td>"+address+"</td></tr>");
        out.println("</table>");
        out.println("<br><h1 align=\"center\"> Order Processing</h1>");
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
