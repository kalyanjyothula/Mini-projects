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

/**
 *
 * @author apiiit-rkv
 */
public class Login extends HttpServlet {
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
         PrintWriter out = response.getWriter();
         response.setContentType("text/html;charset=UTF-8");
         String username=request.getParameter("user");
         String password=request.getParameter("pass");
         HttpSession session=request.getSession();  
         session.setAttribute("USERNAME1",username);  
         userList pop=new userList();
         int v=pop.login(username,password);
         //out.println(v);
         if(v==1)
         {
             response.sendRedirect("Manager.jsp");
         }
         else if(v==2)
         {
             response.sendRedirect("Customer.jsp");
         }
         else if(v==3)
         {
             response.sendRedirect("Shopkeeper.jsp");
         }
         else if(v==4)
         {
             response.sendRedirect("Vendor.jsp");
         }
         else
         {
             out.println("ERROR");
         }
         out.println("Thank u");
         request.getRequestDispatcher("index.jsp").include(request, response);  
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
