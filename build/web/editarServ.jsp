<%@page import="logica.Servicio_turistico"%>
<%@page import="logica.Cliente"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="logica.Usuario"%>
<%@page import="logica.Controladora"%>
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
        <title>Editar Servicio</title>

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


        <%
            String Id = request.getParameter("id");
            Controladora control = new Controladora();
            Servicio_turistico serv = control.traerServicio(Integer.parseInt(Id));
            int id = serv.getCodigo_servicio();
            String nombre = serv.getNombre();
            String destino = serv.getDestino_servicio();
            String descripcion = serv.getDescripcion_breve();
            double costo = serv.getCosto_servicio();
            SimpleDateFormat parser = new SimpleDateFormat("dd/MM/yyyy");
            String fecha = parser.format(serv.getFecha_servicio());
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
                        <h2 class="title">Editar Servicio</h2>
                        <form action = "SvEditarServ" method="POST">
                            <input type="hidden" name="id" value="<%=id%>">
                            <div class="row row-space">
                                <div class="col-2">
                                    <div class="input-group">
                                        <label class="label">Nombre Servicio</label>
                                        <input class="input--style-4" type="text" name="nombre" value="<%=nombre%>">
                                    </div>
                                </div>
                                <div class="col-2">
                                    <div class="input-group">
                                        <label class="label">Costo</label>
                                        <input class="input--style-4" type="number" name="costo" value="<%=costo%>">
                                    </div>
                                </div>
                            </div>
                            <div class="row row-space">
                                <div class="col-2">
                                    <div class="input-group">
                                        <label class="label">Fecha del Servicio</label>
                                        <div class="input-group-icon">
                                            <input class="input--style-4 js-datepicker" type="text" name="fecha" value="<%=fecha%>">
                                            <i class="zmdi zmdi-calendar-note input-icon js-btn-calendar"></i>
                                        </div>
                                    </div>
                                </div>
                                <div class="col-2">
                                    <div class="input-group">
                                        <label class="label">Destino</label>
                                        <input class="input--style-4" type="text" name="destino" value="<%=destino%>">
                                    </div>
                                </div>
                            </div>
                            <div class="col-2"> 
                                <label class="label">Descripción</label>
                                <textarea class="textarea1" name="descripcion" type=text rows="10" cols="50" value="<%=descripcion%>"
                                          style="width: 550px;height: 200px;
                                          padding: 10px; border:3px ;
                                          border-radius: 5px;
                                          background-color:#3c373e;
                                          resize:none;
                                          color:white;"> <%=descripcion%> </textarea>
                            </div>
                            <div class="p-t-15">
                                <button class="btn btn--radius-2 btn--blue" type="submit">Editar</button>
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