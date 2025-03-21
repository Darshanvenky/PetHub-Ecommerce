
package controller;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import model.Registration1;


@WebServlet(name = "adminlog", urlPatterns = {"/adminlog"})
public class adminlog extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
              PrintWriter out = response.getWriter();
         HttpSession session = request.getSession();
          Registration1 reg=new Registration1(session);
        try  {
            if(request.getParameter("adminlog") != null){
            String email = request.getParameter("email");
            String password = request.getParameter("pw");

          
            String status = reg.adminlogin(email, password,session);

            if (status.equals("success")) {
                
                RequestDispatcher rd1 = request.getRequestDispatcher("adminuserindex.jsp");

                //The getRequestDispatcher() method of ServletRequest interface returns the object of RequestDispatcher
                rd1.forward(request, response);

                //   Forwards a request from a servlet to another resource (servlet, JSP file, or HTML file) on the server.
            } else if (status.equals("failure")) {

                RequestDispatcher rd1 = request.getRequestDispatcher("lfailure.html");

                rd1.forward(request, response);

        } }}
            catch (Exception e) {
            e.printStackTrace();
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
    }

}
