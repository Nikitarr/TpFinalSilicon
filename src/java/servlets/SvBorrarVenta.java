
package servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import logica.Controladora;

@WebServlet(name = "SvBorrarVenta", urlPatterns = {"/SvBorrarVenta"})
public class SvBorrarVenta extends HttpServlet {
    Controladora control = new Controladora();


    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
    }
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

//Pide el parametro de ID para poder borrar el usuario quedandose en el mismo jsp    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
    
        int id = Integer.parseInt(request.getParameter("id"));
        
        control.borrarVenta(id);
        
        control.traerVentas();
        response.sendRedirect("ventas.jsp");

        
    }
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
