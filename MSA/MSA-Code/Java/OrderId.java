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

public class OrderId extends HttpServlet {
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        PrintWriter out = response.getWriter();
        response.setContentType("text/html;charset=UTF-8");
        HttpSession session=request.getSession(false); 
        String username=(String)session.getAttribute("USERNAME1");
        int size=(int)session.getAttribute("Size");
        CountList fg=new CountList();
        int no=fg.getMax(username);
        CorderList cd=new CorderList();
        List<Corder> list= cd.getOrderList(no,username);
        Iterator<Corder> run;
        run=list.iterator();
        int mqy[] =new int[size];
        int op[]=new int[size];
        int sp[]=new int[size];
        int opsum=0,spsum=0;
        int i=0;
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
        out.println("<h1 style=\"color:red\"> Note: Cash On Delivary Only Available</h1>");
        out.println("<form action=\"Address\" method=\"POST\">");
        
        out.println("<input style=\"margin-left:1200px; margin-bottom:40px; margin-right:4px; padding: 10px 20px 10px 20px;\" type=\"Submit\" value=\"BUY\">");
        out.println("<div style=\"float:right; border:1; margin-right:20px; margin-bottom:10px; background-color:red; padding:20px 40px 20px 40px;\">");
        out.println("ADDRESS<br><br><input type=\"text\" name=\"aname\" placeholder=\"Name\" required/><br>");
        out.println("<input type=\"text\" name=\"adistrict\" placeholder=\"district\" required/><br>");
        out.println("<input type=\"text\" name=\"state\" placeholder=\"State\" required ><br>");
        out.println("<input type=\"number\" name=\"pincode\" placeholder=\"Pincode\" required/><br>");
        out.println("<input type=\"number\" name=\"mobile\" placeholder=\"Mobile No\" required/><br>");
        out.println("</div>");
        out.println("<table border=\"1\" width=\"70%\" style=\"text-align:center;\">");
        out.println("<tr><td>Medicine Name</td><td>MedicineQuantity</td><td>MedicinePrice</td></tr>");
        while(run.hasNext())
        {
            Corder m=run.next();
            int x=m.getMcode();
            int y=m.getCprice();
            int z=m.getOprice();
            String qu=request.getParameter(Integer.toString(x));
            int rmq=Integer.parseInt(qu);
            cd.UpdateMqc(rmq,x,no);
            mqy[i]=x;
            op[i]=rmq*z;
            sp[i]=rmq*y;
            opsum+=op[i];
            spsum+=sp[i];
            MedicineList we=new MedicineList();
            out.println("<tr><td>"+we.getName(x)+"</td><td>"+rmq+"</td><td>"+sp[i]+"</td></tr>");
            i++;    
        }
        out.println("</table>");
        out.println("<table border=\"0\" width=\"70%\" style=\"text-align:center; color:red; margin-right:4px;\">");
        out.println("<tr><td></td><td>TotalMedicinePrice</td><td>"+spsum+"</td></tr>");
        out.println("</table>");
        out.println("</div>");
        out.println("</form>");
        session.setAttribute("TOPRICE",opsum);
        session.setAttribute("TSPRICE",spsum);
        
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
