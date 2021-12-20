
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
import logica.Cliente;
import logica.Controladora;
import logica.Usuario;
import logica.Venta;

@WebServlet(name = "SvEditarVenta", urlPatterns = {"/SvEditarVenta"})
public class SvEditarVenta extends HttpServlet {
        Controladora control = new Controladora();

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
    }
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        RequestDispatcher dispatcher = request.getRequestDispatcher("editarVenta.jsp");
        dispatcher.forward(request, response);             

    }
    

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
   
        try{
            int id = Integer.parseInt(request.getParameter("id"));
            String modoPago = request.getParameter("modoPago");
            SimpleDateFormat parser = new SimpleDateFormat("dd/MM/yyyy");
            Date fechaVenta;
            fechaVenta = parser.parse(request.getParameter("fechaVenta"));
          

            int idCliente = Integer.parseInt(request.getParameter("cliente") );
            Cliente cliente =  control.traerCliente(idCliente);

            int idEmpleado = Integer.parseInt(request.getParameter("empleado") );
            Usuario empleado =  control.traerUsuario(idEmpleado);
       
            
            Venta venta = control.traerVenta(id);
            venta.setCliente(cliente);
            venta.setUsu1(empleado);            
            venta.setModo_pago(modoPago);
            venta.setFecha_venta(fechaVenta);
            
            control.modificarVenta(venta);
       } catch (ParseException ex) {
            Logger.getLogger(SvAgregarUser.class.getName()).log(Level.SEVERE, null, ex);
        }
             
        response.sendRedirect("ventas.jsp");

   }
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
