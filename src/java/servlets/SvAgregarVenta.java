
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
import logica.Cliente;
import logica.Controladora;
import logica.Paquete_turistico;
import logica.Servicio_turistico;
import logica.Usuario;
import logica.Venta;

@WebServlet(name = "SvAgregarVenta", urlPatterns = {"/SvAgregarVenta"})
public class SvAgregarVenta extends HttpServlet {
    
    Controladora control = new Controladora();
    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
           throws ServletException, IOException {
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
            RequestDispatcher dispatcher = request.getRequestDispatcher("agregarVenta.jsp");
        dispatcher.forward(request, response);
      }    
  
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
               throws ServletException, IOException {

      try{
        String modoPago = request.getParameter("modoPago");
        SimpleDateFormat parser = new SimpleDateFormat("dd/MM/yyyy");  
        Date fechaVenta;
        fechaVenta = parser.parse(request.getParameter("fechaVenta"));
        List<Paquete_turistico> paq = new ArrayList<Paquete_turistico>();   
        List<Servicio_turistico> serv = new ArrayList<Servicio_turistico>();
        
        int idCliente = Integer.parseInt(request.getParameter("cliente") );
        Cliente cliente =  control.traerCliente(idCliente);

        int idEmpleado = Integer.parseInt(request.getParameter("empleado") );
        Usuario empleado =  control.traerUsuario(idEmpleado);
        
       
        Venta venta = new Venta(modoPago, fechaVenta, paq, serv, cliente, empleado);

        control.salvarVenta(venta);
        
    } catch (ParseException ex) {
            Logger.getLogger(SvAgregarClientes.class.getName()).log(Level.SEVERE, null, ex);
        }
        response.sendRedirect("ventas.jsp");

    }    
    
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
