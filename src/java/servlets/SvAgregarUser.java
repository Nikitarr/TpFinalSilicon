
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
import logica.Usuario;

@WebServlet(name = "SvAgregarUser", urlPatterns = {"/SvAgregarUser"})
public class SvAgregarUser extends HttpServlet {
    
    Controladora control = new Controladora();

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
    }

//En el GET se pone la funcion para que te lleve al jsp de agregarUser
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        RequestDispatcher dispatcher = request.getRequestDispatcher("agregarUser.jsp");
        dispatcher.forward(request, response);

    }

  //Se pasan los parametros y la controladora llama a salvarUsuario y te redirije a la lista actualizada
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
            String cargo = request.getParameter("cargo");
            double sueldo = Double.parseDouble(request.getParameter("sueldo"));
            String user = request.getParameter("dni");
            String contrasenia = request.getParameter("dni");



            Usuario usu = new Usuario(nombre, apellido, direccion, dni,  fecha_nac, nacionalidad, celular, email, cargo, sueldo, user, contrasenia);

            control.salvarUsuario(usu);
            
        } catch (ParseException ex) {
            Logger.getLogger(SvAgregarUser.class.getName()).log(Level.SEVERE, null, ex);
        }
        response.sendRedirect("usuario.jsp");

    }
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
