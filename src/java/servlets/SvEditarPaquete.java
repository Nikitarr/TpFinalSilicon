
package servlets;

import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import logica.Controladora;
import logica.Paquete_turistico;

@WebServlet(name = "SvEditarPaquete", urlPatterns = {"/SvEditarPaquete"})
public class SvEditarPaquete extends HttpServlet {
        Controladora control = new Controladora();

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
    }
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        RequestDispatcher dispatcher = request.getRequestDispatcher("editarPaquete.jsp");
        dispatcher.forward(request, response);             

    }
    

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
   
            int id = Integer.parseInt(request.getParameter("id"));
            String nombre = request.getParameter("nombre");
           
            Paquete_turistico paq = control.traerPaquete(id);
            paq.setNombre(nombre);

            control.modificarPaquete(paq);
            
        response.sendRedirect("paquetes.jsp");

   }
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
