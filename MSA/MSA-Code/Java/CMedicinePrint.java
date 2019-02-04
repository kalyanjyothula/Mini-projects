
import LinkList.*;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Iterator;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import jcf.medicines;

public class CMedicinePrint extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        PrintWriter out= response.getWriter();
        MedicineList gh=new MedicineList();
        List<medicines> list=gh.getMedicines();
        Iterator<medicines> run;
        run=list.iterator();
        response.setContentType("text/html;charset=UTF-8");
        out.println("<div align=\"center\">");
        out.println("<form action=\"COrder\" method=\"POST\">");
        out.println("<input style=\"margin-left:900px; padding: 10px 50px 10px 20px;\" type=\"Submit\" value=\"ORDER\"/>");
        out.println("<table border=\"1\" width=\"90%\" style=\"text-align:center; margin-top:20px;\">");
        out.println("<tr><td> Medicine Code </td><td>Medicine Name</td><td>Medicine Price</td><td>Select Medicine</td></tr>");
        while(run.hasNext())
        {
            medicines m=run.next();
            int  mcode=m.getMCODE();
            String mname=m.getMNAME();
            int mp=m.getSPRICE();
            
            out.println("<tr><td>"+mcode+"</td><td>"+mname+"</td><td>"+mp+"</td><td><input type=\"checkbox\" name=\"order\" value=\""+mcode+"\"/></td></tr>");   
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
