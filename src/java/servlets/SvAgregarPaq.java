
package servlets;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import logica.Controladora;
import logica.Paquete_turistico;
import logica.Servicio_turistico;

@WebServlet(name = "SvAgregarPaq", urlPatterns = {"/SvAgregarPaq"})
public class SvAgregarPaq extends HttpServlet {
    
    Controladora control = new Controladora();
    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
           throws ServletException, IOException {
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        RequestDispatcher dispatcher = request.getRequestDispatcher("agregarPaquete.jsp");
        dispatcher.forward(request, response);
      }    
  
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
               throws ServletException, IOException {

        String nombre = request.getParameter("nombre");
        List<Servicio_turistico> serv = new ArrayList<Servicio_turistico>();
          
        Paquete_turistico paq = new Paquete_turistico(nombre, serv );

        control.salvarPaquete(paq);
            
        response.sendRedirect("paquetes.jsp");

    }    
    
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
