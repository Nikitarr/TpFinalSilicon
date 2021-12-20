/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlets;

import java.io.IOException;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import logica.Controladora;
import logica.Servicio_turistico;

@WebServlet(name = "SvServicios", urlPatterns = {"/SvServicios"})
public class SvServicios extends HttpServlet {
    Controladora control = new Controladora();
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
    }
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
    
        listarServicios(request, response);

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

    
    private void listarServicios(HttpServletRequest request, HttpServletResponse response)
            throws IOException, ServletException {
        List<Servicio_turistico> servicios = control.traerServicios();
        request.setAttribute("servicios", servicios);
        RequestDispatcher dispatcher = request.getRequestDispatcher("servicios.jsp");
        dispatcher.forward(request, response);
    }

}
