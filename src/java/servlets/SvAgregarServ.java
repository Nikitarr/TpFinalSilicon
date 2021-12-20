
package servlets;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import logica.Controladora;
import logica.Servicio_turistico;

@WebServlet(name = "SvAgregarServ", urlPatterns = {"/SvAgregarServ"})
public class SvAgregarServ extends HttpServlet {
    
    Controladora control = new Controladora();
    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
           throws ServletException, IOException {
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        RequestDispatcher dispatcher = request.getRequestDispatcher("agregarServ.jsp");
        dispatcher.forward(request, response);
      }    
  
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
               throws ServletException, IOException {
        try {
            SimpleDateFormat parser = new SimpleDateFormat("dd/MM/yyyy");
            
            Date fecha_servicio;
            fecha_servicio = parser.parse(request.getParameter("fecha"));
            String nombre = request.getParameter("nombre");
            String descripcion_breve = request.getParameter("descripcion");
            String destino_servicio = request.getParameter("destino");
            double costo_servicio = Double.parseDouble(request.getParameter("costo"));
           
            Servicio_turistico serv = new Servicio_turistico(nombre, descripcion_breve, destino_servicio, costo_servicio, fecha_servicio);

            control.salvarServicio(serv);
            
        } catch (ParseException ex) {
            Logger.getLogger(SvAgregarServ.class.getName()).log(Level.SEVERE, null, ex);
        }
        response.sendRedirect("servicios.jsp");

    }    
    
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
