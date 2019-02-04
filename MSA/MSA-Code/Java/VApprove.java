/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import LinkList.VendorList;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Iterator;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import jcf.vendor;

public class VApprove extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        HttpSession session=request.getSession(false); 
        String username=(String)session.getAttribute("USERNAME1");
        String vlist[]=request.getParameterValues("vapprove");
        VendorList h=new VendorList();
        for(int i=0;i<vlist.length;i++)
        {
             h.updateapprove(Integer.parseInt(vlist[i]));
        }
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
        out.println("<a href=\"VApprove1\">Approve</a> ");  
        out.println("<a href=\"VmedicineReq.jsp\">MedicinesRequest</a>  ");
        out.println("<a href=\"Vendor.jsp\">Home</a>");  
        out.println("</ul>");
        out.println("</div>");
        List<vendor> list=h.GetApproves(username);
        Iterator<vendor> run;
        run=list.iterator();
        out.println("<div align=\"center\">");
        out.println("<form action=\"VApprove\" method=\"POST\">");
        //out.println("<input style=\"margin-left:900px; padding: 10px 90px 10px 20px;\" type=\"Submit\" value=\"APPROVE\"/>");
        out.println("<table border=\"1\" width=\"90%\" style=\"text-align:center; margin-top:90px;\">");
        out.println("<tr><td> Medicine Code </td><td>Medicine Name</td><td>Medicine Quntity</td><td>APPROVE STATUS</td></tr>");
        while(run.hasNext())
        {
            vendor vd=run.next();
            int mcode=vd.getMcode();
            int mqu=vd.getMqu();
            String mname=vd.getMname();
            out.println("<tr><td>"+vd.getMcode()+"</td><td>"+vd.getMname()+"</td><td>"+vd.getMqu()+"</td><td style=\"color:green\" >APPROVED</td></tr>");
            //out.println("<tr><td>"+mcode+"</td><td>"+mname+"</td><td>"+mqu+"</td><td><input type=\"checkbox\" name=\"vapprove\" value=\""+mcode+"\"/></td></tr>");

        }
        out.println("</table>");
        out.println("</form>");
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
