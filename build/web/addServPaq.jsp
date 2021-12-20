<%@page import="logica.Paquete_turistico"%>
<%@page import="logica.Controladora"%>
<%@page import="logica.Servicio_turistico"%>
<%@page import="java.util.List"%>
<%@ page contentType="text/html" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html lang="es">

    <head>
        <!-- Required meta tags-->
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
        <meta name="description" content="Colorlib Templates">
        <meta name="author" content="Colorlib">
        <meta name="keywords" content="Colorlib Templates">

        <!-- Title Page-->
        <title>Agregar Paquete</title>

        <!-- Icons font CSS-->
        <link href="assetsAdd/vendor/mdi-font/css/material-design-iconic-font.min.css" rel="stylesheet" media="all">
        <link href="assetsAdd/vendor/font-awesome-4.7/css/font-awesome.min.css" rel="stylesheet" media="all">
        <!-- Font special for pages-->
        <link href="https://fonts.googleapis.com/css?family=Poppins:100,100i,200,200i,300,300i,400,400i,500,500i,600,600i,700,700i,800,800i,900,900i" rel="stylesheet">

        <!-- Vendor CSS-->
        <link href="assetsAdd/vendor/select2/select2.min.css" rel="stylesheet" media="all">
        <link href="assetsAdd/vendor/datepicker/daterangepicker.css" rel="stylesheet" media="all">

        <!-- Main CSS-->
        <link href="assetsAdd/css/main.css" rel="stylesheet" media="all">
    </head>

    <body>
        <% HttpSession misession = request.getSession();
        String usuar = (String) misession.getAttribute("user");
        if(usuar == null){
            RequestDispatcher dispatcher = request.getRequestDispatcher("index.jsp");
            dispatcher.forward(request, response);
        }else{
        }
        %>
        <div class="flecha">
            <header>
                <a href="index.jsp"><img src="assetsUser/images/icons/back.png" input type="button" value="Back"/></a>
            </header>
        </div>

        <div class="page-wrapper bg-gra-02 p-t-130 p-b-100 font-poppins">
            <div class="wrapper wrapper--w680">
                <div class="card card-4">
                    <div class="card-body">
                        <h2 class="title">Añadir Servicio al Paquete</h2>
                        <form action = "SvAgregarServEnPaq" method="POST">
                            <%String id = request.getAttribute("id").toString(); %>
                            <input type="hidden" name="id" value="<%=id%>">                            
                            <div class="row row-space">
                                <div class="col-2">
                                    <div class="input-group">
                                        <label class="label">Servicios Disponibles</label>
                                        <select class="input--style-4" type="combobox" name="servicio">
                                            <% Controladora control = new Controladora();
                                                 List<Servicio_turistico> lista = control.traerServicios();
                                            for (Servicio_turistico ser : lista) 
                                            { %>
                                                <option value="<%=ser.getCodigo_servicio()%>"><%=ser.getNombre()%></option>
                                            <%}%>                                           
                                        </select>
                                    </div>
                                </div>
                            </div>
                                <div class="p-t-15">
                                    <button class="btn btn--radius-2 btn--blue" type="submit">Agregar</button>
                                </div>
                        </form>
                    </div>
                </div>
            </div>
        </div>

        <!-- Jquery JS-->
        <script src="assetsAdd/vendor/jquery/jquery.min.js"></script>
        <!-- Vendor JS-->
        <script src="assetsAdd/vendor/select2/select2.min.js"></script>
        <script src="assetsAdd/vendor/datepicker/moment.min.js"></script>
        <script src="assetsAdd/vendor/datepicker/daterangepicker.js"></script>

        <!-- Main JS-->
        <script src="assetsAdd/js/global.js"></script>

    </body><!-- This templates was made by Colorlib (https://colorlib.com) -->

</html>
<!-- end document-->