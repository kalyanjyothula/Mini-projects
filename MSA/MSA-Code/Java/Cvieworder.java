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
import javax.servlet.http.HttpSession;
import jcf.Corder;
public class Cvieworder extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        PrintWriter out = response.getWriter();
        response.setContentType("text/html;charset=UTF-8");
        HttpSession session=request.getSession(false); 
        String username=(String)session.getAttribute("USERNAME1");
        CountList xp=new CountList();
        int p=xp.getCountNO(username);
        out.println("<div>");
        if(p<=0)out.println("<br><br><h4 style=\" color:red;margin-top:100px; margin-left:620px;\"> NOT YET ORDERED</h4>");
        while(p>0)
        {   
            MorderList statu=new MorderList();
            int status=statu.OrderStatus(username,p);
            out.println("<h4 align=\"center\">ORDER NO: "+p+"</h4>");
            if(status==1) out.println("<h4 style=\" color:green; float:right; margin-right:60px;\"> PROCESSING</h4>");
            else if(status==0) out.println("<h4 style=\" color:red; float:right; margin-right:60px;\"> DELIVERED</h4>");
            else out.println("<h4 style=\" color:red; float:right; margin-right:60px;\"> NOT AT ORDERED</h4>");
            out.println("<table border=\"1\" width=\"70%\" style=\"text-align:center; margin-left:200px;\">"); 
            out.println("<tr><td>Medicine Code</td><td>Medicine Name</td><td> Medicine Quantity</td><td>Medicine price</td></tr>");
            CorderList fd=new CorderList();
            List<Corder> list=fd.getOrderList(p, username);
            Iterator<Corder> run;
            run=list.iterator();
            int sum=0;
            while(run.hasNext())
            {
                Corder m=run.next();
                int mc=m.getMcode();
                int mp=m.getCprice();
                CorderList d=new CorderList();
                int mq=d.getMquty(p,mc,username);
                int ss=mq*mp;
                sum+=ss;
                MedicineList we=new MedicineList();
                out.println("<tr><td>"+mc+"</td><td>"+we.getName(mc)+"</td><td>"+mq+"</td><td>"+mp+"</td></tr>");
                
            }p--;
            out.println("<tr><td></td></tr>");
            out.println("<tr style=\"color:red;\"><td>TOTAL</td><td>MEDICINE</td><td>Price </td><td>"+sum+"</td></tr>");
            out.println("</table><br><br>");
        }
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
