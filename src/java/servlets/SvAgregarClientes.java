
package servlets;

import java.io.IOException;
import java.io.PrintWriter;
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

@WebServlet(name = "SvAgregarClientes", urlPatterns = {"/SvAgregarClientes"})
public class SvAgregarClientes extends HttpServlet {
    Controladora control = new Controladora();
    protected void processRequest(HttpServletRequest request, HttpServletResponse response){
         
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
      
        RequestDispatcher dispatcher = request.getRequestDispatcher("agregarCliente.jsp");
        dispatcher.forward(request, response);
      }    
  
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
               throws ServletException, IOException {
        try {
            SimpleDateFormat parser = new SimpleDateFormat("dd/MM/yyyy");
            
            Date fecha_nac;
            fecha_nac = parser.parse(request.getParameter("fechaDeNac"));
            String nombre = request.getParameter("nombre");
            String apellido = request.getParameter("apellido");
            String direccion = request.getParameter("direccion");
            String nacionalidad = request.getParameter("nacionalidad");
            int dni = Integer.parseInt(request.getParameter("dni"));
            String email = request.getParameter("email");
            long celular = Long.parseLong(request.getParameter("celular"));

            Cliente cliente1 = new Cliente(nombre, apellido, direccion, dni, fecha_nac, nacionalidad, celular, email);

            control.salvarCliente(cliente1);
            
        } catch (ParseException ex) {
            Logger.getLogger(SvAgregarClientes.class.getName()).log(Level.SEVERE, null, ex);
        }
        response.sendRedirect("cliente.jsp");

    }    
    
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
