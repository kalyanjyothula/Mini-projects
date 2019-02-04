
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
import jcf.medicines;

public class COrder extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        PrintWriter out = response.getWriter();
        response.setContentType("text/html;charset=UTF-8");
        String mlist[]=request.getParameterValues("order");
        HttpSession session=request.getSession(false); 
        String username=(String)session.getAttribute("USERNAME1");
        session.setAttribute("Size",mlist.length);
        int mcode,op,sp,no;
        MedicineList gh=new MedicineList();
        List<medicines> list=gh.getMedicines();
        Iterator<medicines> run;
        run=list.iterator();
        CountList hp=new CountList();
        no=hp.getCountNO(username);
        no++;
        int x=hp.updateNo(no,username);
        session.setAttribute("NO",no);
       
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
        out.println("<div align=\"center\">");
        out.println("<form action=\"OrderId\" method=\"POST\">");
        out.println("<input style=\"margin-left:900px; margin-bottom:40px; padding: 10px 20px 10px 20px;\" type=\"Submit\" value=\"ORDER\">");
        out.println("<table border=\"1\" width=\"90%\" style=\"text-align:center;\">");
        out.println("<tr><td> Medicine Code </td><td>Medicine Name</td><td>MedicinePrice</td><td>MedicineQuantity</td></tr>");
        
        while(run.hasNext())
        {
            medicines m=run.next();
            mcode=m.getMCODE();
            String mc=Integer.toString(mcode);
            for(int i=0;i<mlist.length;i++)
            {
                if(mc.equalsIgnoreCase(mlist[i]))
                {
                    op=m.getPPRICE();
                    sp=m.getSPRICE();
                    m.getMNAME();
                    out.println("<tr><td>"+mcode+"</td><td>"+m.getMNAME()+"</td><td>"+sp+"</td><td><input style=\"align:center; bgcolor:black; margin-left:10px; margin-right:100px;\"  type=\"text\" name=\""+mcode+"\" required/></td></tr>");
                    CorderList t=new CorderList();
                    t.addToData(no,mcode,op,sp,username);
                    break;
                }
            }
        }
        out.println("</table>");
        out.println("</form>");
        
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
