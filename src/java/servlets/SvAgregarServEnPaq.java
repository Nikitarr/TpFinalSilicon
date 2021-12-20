
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
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import logica.Controladora;
import logica.Paquete_turistico;
import logica.Servicio_turistico;

@WebServlet(name = "SvAgregarServEnPaq", urlPatterns = {"/SvAgregarServEnPaq"})
public class SvAgregarServEnPaq extends HttpServlet {
    
    Controladora control = new Controladora();
    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
           throws ServletException, IOException {
    }

//En el GET pide que se abra el jsp de editarUser
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        RequestDispatcher dispatcher = request.getRequestDispatcher("addServPaq.jsp");
        dispatcher.forward(request, response);
    }
    
//Se piden los mismos datos que en agregar clientes pero esta vez la controladora llama a modificaraClientes y te redirije a la lista de usuarios actualizada
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
  
        int id = Integer.parseInt(request.getParameter("id"));
        String servicio = request.getParameter("servicio");
        
        if(servicio != null ){
            int idServ = Integer.parseInt(servicio );
            Paquete_turistico paq = control.traerPaquete(id);
            Servicio_turistico ser = control.traerServicio(idServ);

            paq.getServicio().add(ser );

            control.modificarPaquete(paq);
            response.sendRedirect("paquetes.jsp");
        } else {
            request.setAttribute("id" , id );
            
            RequestDispatcher dispatcher = request.getRequestDispatcher("addServPaq.jsp");
            dispatcher.forward(request, response);
        }

    }
    
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
