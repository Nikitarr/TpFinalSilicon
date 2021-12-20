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
        <title>Servicios</title>
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
            <h1 class="text-center">Servicios</h1>

            <a href="SvAgregarServ" class="btn btn-secondary" id="agregar">Agregar Servicios</a>
        </div>

        <div class="limiter">
            <div class="container-table100">
                <div class="wrap-table100">
                    <div class="table100">
                        <table>
                            <thead>
                                <tr class="table100-head">
                                    <th class="column1">ID</th>
                                    <th class="column2">Servicio</th>
                                    <th class="column3">Destino</th>
                                    <th class="column4">Fechas</th>
                                    <th class="column5">Costo</th>
                                    <th class="column6">Descripcion</th>
                                    <th class="column7"></th>
                                    <th class="column8"></th>
                                </tr>
                            </thead>
                            <tbody>
                                <% Controladora control = new Controladora();
                                    List<Servicio_turistico> listaServs = control.traerServicios();
                                    for (Servicio_turistico serv : listaServs) {

                                %>

                                <tr>

                                    <% int id = serv.getCodigo_servicio(); %>
                                    <%String nombre = serv.getNombre(); %> 
                                    <%String descripcion = serv.getDescripcion_breve(); %>
                                    <%SimpleDateFormat parser = new SimpleDateFormat("dd/MM/yyyy");%>
                                    <% String fecha = parser.format(serv.getFecha_servicio());%>
                                    <%String destino = serv.getDestino_servicio();%>
                                    <% double costo = serv.getCosto_servicio();%>



                                    <td class="column1"> <%=id%></td>
                                    <td class="column2"> <%=nombre%></td>
                                    <td class="column3"> <%=destino%></td>
                                    <td class="column4"> <%=fecha%></td>
                                    <td class="column5"> <%=costo%></td>
                                    <td class="column6"><%=descripcion%> </td>
                                    <td class="column7">
                                        <form name="borrarServ" action="SvBorrarServicio" method="POST" style="display:inline">
                                            <input type="hidden" name="id" value="<%=id%>">
                                            <button type="submit" class="btn btn-danger btn-xs" data-title="Delete" style="display:inline" >Borrar</button>
                                        </form>                                            
                                    </td>

                                    <td class="column8">
                                        <form name="editarServ" action="SvEditarServ" method="GET" style="display:inline">
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