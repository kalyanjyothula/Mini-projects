
import LinkList.MedicineList;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class OldMedicine extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        PrintWriter out=response.getWriter();
        response.setContentType("text/html;charset=UTF-8");
        String c=request.getParameter("mcode");
        String mq=request.getParameter("mquantity");
        String mname=request.getParameter("mname");
        String th=request.getParameter("thvalue"); 
        String pp=request.getParameter("purchase");
        String sp=request.getParameter("selling");
        String exdate=request.getParameter("exdate");
        int mcode=Integer.parseInt(c);
        int mqu=Integer.parseInt(mq);
        int thv=Integer.parseInt(th);
        int pprice=Integer.parseInt(pp);
        int sprice=Integer.parseInt(sp);
        MedicineList md=new MedicineList();
        int y=md.AddOldMedicine(mcode,mqu,thv,pprice,sprice,mname,exdate);
        out.println(y);
        if(y==1)
        {
            out.println("YES");
        }
        else
        {
            out.println("NO");
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
