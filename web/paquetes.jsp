<%@page import="logica.Paquete_turistico"%>
<%@page import="logica.Servicio_turistico"%>
<%@page import="logica.Servicio_turistico"%>
<%@page import="logica.Cliente"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.util.Date"%>
<%@page import="logica.Usuario"%>
<%@page import="java.util.List"%>
<%@page import="logica.Controladora"%>
<%@ page contentType="text/html" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html lang="es">

    <head>
        <title>Paquetes</title>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <link rel="preconnect" href="https://fonts.googleapis.com">
        <link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
        <link href="https://fonts.googleapis.com/css2?family=Roboto:wght@300&display=swap" rel="stylesheet">
        <!--===============================================================================================-->	
        <link rel="icon" type="image/png" href="assetsUser/images/icons/favicon.ico"/>
        <!--===============================================================================================-->
        <link rel="stylesheet" type="text/css" href="assetsUser/vendor/bootstrap/css/bootstrap.min.css">
        <!--===============================================================================================-->
        <link rel="stylesheet" type="text/css" href="assetsUser/fonts/font-awesome-4.7.0/css/font-awesome.min.css">
        <!--===============================================================================================-->
        <link rel="stylesheet" type="text/css" href="assetsUser/vendor/animate/animate.css">
        <!--===============================================================================================-->
        <link rel="stylesheet" type="text/css" href="assetsUser/vendor/select2/select2.min.css">
        <!--===============================================================================================-->
        <link rel="stylesheet" type="text/css" href="assetsUser/vendor/perfect-scrollbar/perfect-scrollbar.css">
        <!--===============================================================================================-->
        <link rel="stylesheet" type="text/css" href="assetsUser/css/util.css">
        <link rel="stylesheet" type="text/css" href="assetsUser/css/main.css">
        <!--===============================================================================================-->
    </head>
    <body>
        <% HttpSession misession = request.getSession();
        String usu = (String) misession.getAttribute("user");
        if(usu == null){
            response.sendRedirect("index.jsp"); 
        }else{
        }
        %>
        <div>
            <header>
                <a href="index.jsp"><img src="assetsUser/images/icons/back.png" input type="button" value="Back"/></a>
            </header>
        </div>
        <div class="container1">
            <h1 class="text-center">Paquetes</h1>

            <a href="SvAgregarPaq" class="btn btn-secondary" id="agregar">Agregar Paquetes</a>
        </div>

        <div class="limiter">
            <div class="container-table100">
                <div class="wrap-table100">
                    <div class="table100">
                        <table>
                            <thead>
                                <tr class="table100-head" >
                                    <th class="column1">ID</th>
                                    <th class="column1">Nombre Paquete</th>
                                    <th class="column5">Costo</th>
                                    <th class="column3">Servicios incluidos</th>
                                    <th class="column7"></th>
                                    <th class="column8"></th>
                                </tr>
                            </thead>
                            <tbody>
                                
                                <% Controladora control = new Controladora();
                                    List<Paquete_turistico> listaPaq = control.traerPaquetes();
                                    for (Paquete_turistico paq : listaPaq) {
                                %>

                                <tr>
                                    <% int id = paq.getCodigo_paquete(); %>
                                    <% List<Servicio_turistico> servicios = paq.getServicio() ; %> 
                                    <% double costo = paq.getCosto_paquete() ;%>
                                    <% String nombre = paq.getNombre();%>


                                    <td class="column1"> <%=id%></td>
                                    <td class="column2"> <%=nombre%></td>
                                    <td class="column5"> <%=costo%></td>
                                    
                                    <td class="column8">
                                        <table style="padding-left: 500px;">
                                            <tbody>

                                                    <% 
                                                        for (Servicio_turistico ser : servicios) {
                                                    %>
                                                    <tr>
                                                        <td > <%=ser.getNombre()%></td>
                                                    </tr>
                                                    <%}%>            
                                            </tbody>
                                        </table>
                                    </td>

                                    <td class="column7">
                                        <form name="SvAgregarServEnPaq" action="SvAgregarServEnPaq" method="POST" style="display:inline">
                                            <input type="hidden" name="id" value="<%=id%>">
                                            <button type="submit" class="btn btn-dark" data-title="Add" style="display:inline" >+</button>
                                        </form>                                            
                                    </td>
                                    <td class="column7">
                                        <form name="borrarPaq" action="SvBorrarPaquete" method="POST" style="display:inline">
                                            <input type="hidden" name="id" value="<%=id%>">
                                            <button type="submit" class="btn btn-danger btn-xs" data-title="Delete" style="display:inline" >Borrar</button>
                                        </form>                                            
                                    </td>

                                    <td class="column8">
                                        <form name="editarPaq" action="SvEditarPaquete" method="GET" style="display:inline">
                                            <input type="hidden" name="id" value="<%=id%>">
                                            <button type="submit" class="btn btn-danger btn-xs" data-title="Edit" style="display:inline">Editar</button>
                                        </form>                                            
                                    </td>
                                </tr>

                                <%}%>            

                            </tbody>

                        </table>
                    </div>
                </div>
            </div>
        </div>




        <!--===============================================================================================-->	
        <script src="vendor/jquery/jquery-3.2.1.min.js"></script>
        <!--===============================================================================================-->
        <script src="vendor/bootstrap/js/popper.js"></script>
        <script src="vendor/bootstrap/js/bootstrap.min.js"></script>
        <!--===============================================================================================-->
        <script src="vendor/select2/select2.min.js"></script>
        <!--===============================================================================================-->
        <script src="js/main.js"></script>

    </body>
</html>