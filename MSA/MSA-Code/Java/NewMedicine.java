import LinkList.MedicineList;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
public class NewMedicine extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        PrintWriter out = response.getWriter();
        response.setContentType("text/html;charset=UTF-8");
        try
        {
            String c=request.getParameter("mcode");
            String mq=request.getParameter("mquantity");
            String mname=request.getParameter("mname");
            String tradename=request.getParameter("tdname");
            String generic_name=request.getParameter("grname");
            String vendor_name=request.getParameter("vname");
            String vp=request.getParameter("vph");
            String th=request.getParameter("thvalue"); 
            String pp=request.getParameter("purchase");
            String sp=request.getParameter("selling");
            String exdate=request.getParameter("exdate");
            int mcode=Integer.parseInt(c);
            int vphone=Integer.parseInt(vp);
            int pprice=Integer.parseInt(pp);
            int sprice=Integer.parseInt(sp);
            int thv=Integer.parseInt(th);
            int mqu=Integer.parseInt(mq);
            MedicineList md=new MedicineList();
            //out.println(mcode+"\n"+mquantity+"\n"+mname+"\n"+tradename+"\n"+generic_name+"\n"+vendor_name+"\n"+vendor_phno+"\n"+th_value+"\n"+purchase_price+"\n"+selling_price);
            int value=md.addNewMedicine(mcode,vphone,pprice,sprice,mqu,thv,tradename,generic_name,vendor_name,mname,exdate);
            out.println(value);
            if(value==1)
            {
                out.println("ADDED");
            }
            else
            {
                out.println("NOT ADDED");
            }
        }catch(Exception e)
        {
           out.println("YES");
          //e.printStackTrace();
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
