

import LinkList.MedicineList;
import java.io.IOException;
import java.io.PrintWriter;
import static java.lang.System.out;
import java.util.Iterator;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import jcf.medicines;

public class MedicinePrint extends HttpServlet {
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        PrintWriter out = response.getWriter();
        MedicineList gh=new MedicineList();
        List<medicines> list=gh.getMedicines();
        Iterator<medicines> run;
        run=list.iterator();
        response.setContentType("text/html;charset=UTF-8");
        out.println("<div align=\"center\">");
        out.println("<br><br><table border=\"1\" width=\"90%\" style=\"text-align:center;\">");
        out.println("<tr><td> Medicine Code </td><td>Medicine Name</td><td>Medicine Quantity</td><td>Th Value</td></tr>");
        while(run.hasNext())
        {
            medicines m=run.next();
            int  mcode=m.getMCODE();
            String mname=m.getMNAME();
            int mquantity=m.getMQUANTITY();
            int th=m.getTHVALUE();
            
            out.println("<tr><td>"+mcode+"</td><td>"+mname+"</td><td>"+mquantity+"</td><td>"+th+"</td></tr>");   
        }
        out.println("</table>");
        out.println("</div>");
    }
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
