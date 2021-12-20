
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

@WebServlet(name = "SvEditarServ", urlPatterns = {"/SvEditarServ"})
public class SvEditarServ extends HttpServlet {
        Controladora control = new Controladora();

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
    }
//En el GET pide que se abra el jsp de editarServ
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        RequestDispatcher dispatcher = request.getRequestDispatcher("editarServ.jsp");
        dispatcher.forward(request, response);

    }
    
//Se piden los mismos datos que en agregar servicios pero esta vez la controladora llama a modificaraServicio y te redirije a la lista de servicios actualizada
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
   try {
            int codigo_servicio = Integer.parseInt(request.getParameter("id"));
            SimpleDateFormat parser = new SimpleDateFormat("dd/MM/yyyy");
           
            Date fecha_servicio;
            fecha_servicio = parser.parse(request.getParameter("fecha"));
            String nombre = request.getParameter("nombre");
            String descripcion_breve = request.getParameter("descripcion");
            String destino_servicio = request.getParameter("destino");
            double costo_servicio = Double.parseDouble(request.getParameter("costo"));

           
            Servicio_turistico serv = new Servicio_turistico(codigo_servicio, nombre, descripcion_breve, destino_servicio, costo_servicio, fecha_servicio);

            control.modificarServicio(serv);
            
        } catch (ParseException ex) {
            Logger.getLogger(SvEditarServ.class.getName()).log(Level.SEVERE, null, ex);
        }
        
   response.sendRedirect("servicios.jsp");

   }
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
