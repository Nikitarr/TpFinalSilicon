<%@page import="logica.Paquete_turistico"%>
<%@page import="logica.Servicio_turistico"%>
<%@page import="logica.Venta"%>
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
        <title>Ventas</title>
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
            String usuar = (String) misession.getAttribute("user");
            if (usuar == null) {
                RequestDispatcher dispatcher = request.getRequestDispatcher("index.jsp");
                dispatcher.forward(request, response);
            } else {
            }
        %>
        <div>
            <header>
                <a href="index.jsp"><img src="assetsUser/images/icons/back.png" input type="button" value="Back"/></a>
            </header>
        </div>
        <div class="container1">
            <h1 class="text-center">Ventas</h1>

            <a href="SvAgregarVenta" class="btn btn-secondary" id="agregar">Agregar Venta</a>
        </div>

        <div class="limiter">
            <div class="container-table100">
                <div class="wrap-table100">
                    <div class="table100">
                        <table>
                            <thead>
                                <tr class="table100-head">
                                    <th class="column1">ID</th>
                                    <th class="column2">Método de Pago</th>
                                    <th class="column3">Fecha de la Venta</th>
                                    <th class="column4">Servicio</th>
                                    <th class="column5">Paquete</th>
                                    <th class="column8">Cliente</th>
                                    <th class="column9">Empleado</th>
                                    <th class="column10"></th>
                                    <th class="column11"></th>
                                </tr>
                            </thead>
                            <tbody>
                                <% Controladora control = new Controladora();
                                    List<Venta> listaVentas = control.traerVentas();
                                    for (Venta venta : listaVentas) { %>
                                <tr>
                                    <% int id = venta.getNum_venta(); %>
                                    <%String pago = venta.getModo_pago(); %>
                                    <%SimpleDateFormat parser = new SimpleDateFormat("dd/MM/yyyy");%>
                                    <% String fechaVenta = parser.format(venta.getFecha_venta());%>
                                    <% List<Servicio_turistico> servicios = venta.getServicio(); %> 
                                    <% List<Paquete_turistico> paquetes = venta.getPaquete(); %> 
                                    <% Cliente cliente = venta.getCliente(); %> 
                                    <% Usuario empleado = venta.getUsu1();%> 


                                    <td class="column1"> <%=id%></td>
                                    <td class="column2"> <%=pago%> </td>
                                    <td class="column3"><%=fechaVenta%></td>
                                    <td class="column4">
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
                                        <form name="addServ" action="SvAddServEnVenta" method="POST" style="display:inline">
                                            <input type="hidden" name="id" value="<%=id%>">
                                            <button type="submit" class="btn btn-dark" data-title="Add" style="display:inline" >+</button>
                                        </form>
                                    </td>
                                    <td class="column5">
                                        <table style="padding-left: 500px;">
                                            <tbody>

                                                    <% 
                                                        for (Paquete_turistico paq : paquetes) {
                                                    %>
                                                    <tr>
                                                        <td > <%=paq.getNombre()%></td>
                                                    </tr>
                                                    <%}%>            
                                            </tbody>
                                        </table>
                                        <form name="addPaq" action="SvAddPaqEnVenta" method="POST" style="display:inline">
                                            <input type="hidden" name="id" value="<%=id%>">
                                            <button type="submit" class="btn btn-dark" data-title="Add" style="display:inline" >+</button>
                                        </form>    
                                    </td>
                                    
                                    <td class="column8"><%=cliente.getNombre() %></td>
                                    <td class="column9"><%=empleado.getNombre()%></td>
                                    
                                    <td class="column10">
                                        <form name="borrarVenta" action="SvBorrarVenta" method="POST" style="display:inline">
                                            <input type="hidden" name="id" value="<%=id%>">
                                            <button type="submit" class="btn btn-danger btn-xs" data-title="Delete" style="display:inline" >Borrar</button>
                                        </form>                                            
                                    </td>

                                    <td class="column11">
                                        <form name="editarVenta" action="SvEditarVenta" method="GET" style="display:inline">
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