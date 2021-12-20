
package servlets;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import logica.Controladora;

@WebServlet(name = "SvLogin", urlPatterns = {"/SvLogin"})
public class SvLogin extends HttpServlet {
    Controladora control  = new Controladora();
    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        RequestDispatcher dispatcher = request.getRequestDispatcher("login.jsp");
        dispatcher.forward(request, response);   
    }
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

            String user = request.getParameter("username");
            String contra = request.getParameter("contrasenia");
        
            boolean autorizado = control.verificarUsuario(user,contra);
            
            if (autorizado == true){
                HttpSession misession = request.getSession(true);
                misession.setAttribute("user", user);
                misession.setAttribute("contra", contra);
                
                response.sendRedirect("index.jsp");
                   
            }else{
                response.sendRedirect("login.jsp");
            }
            
    }
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
