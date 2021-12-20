
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

@WebServlet(name = "SvEditarCliente", urlPatterns = {"/SvEditarCliente"})
public class SvEditarCliente extends HttpServlet {
        Controladora control = new Controladora();

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
    }
//En el GET pide que se abra el jsp de editarUser
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        RequestDispatcher dispatcher = request.getRequestDispatcher("editarCliente.jsp");
        dispatcher.forward(request, response);

    }
    
//Se piden los mismos datos que en agregar clientes pero esta vez la controladora llama a modificaraClientes y te redirije a la lista de usuarios actualizada
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
   try {
            int id = Integer.parseInt(request.getParameter("id"));
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

            Cliente cliente1 = new Cliente(id, nombre, apellido, direccion, dni, fecha_nac, nacionalidad, celular, email);

            control.modificarCliente(cliente1);
            
        } catch (ParseException ex) {
            Logger.getLogger(SvAgregarUser.class.getName()).log(Level.SEVERE, null, ex);
        }
        response.sendRedirect("cliente.jsp");

   }
    @Override
    
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
