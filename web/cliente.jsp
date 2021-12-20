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
        <title>Clientes</title>
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
        if(usuar == null){
            RequestDispatcher dispatcher = request.getRequestDispatcher("index.jsp");
            dispatcher.forward(request, response);
        }else{
        }
        %>
        <div>
            <header>
                <a href="index.jsp"><img src="assetsUser/images/icons/back.png" input type="button" value="Back"/></a>
            </header>
        </div>
        <div class="container1">
            <h1 class="text-center">Clientes</h1>

            <a href="SvAgregarClientes" class="btn btn-secondary" id="agregar">Agregar cliente</a>
        </div>

        <div class="limiter">
            <div class="container-table100">
                <div class="wrap-table100">
                    <div class="table100">
                        <table>
                            <thead>
                                <tr class="table100-head">
                                    <th class="column1">ID</th>
                                    <th class="column2">Nombre</th>
                                    <th class="column3">Apellido</th>
                                    <th class="column4">Dirección</th>
                                    <th class="column5">DNI</th>
                                    <th class="column6">F. Nacimiento</th>
                                    <th class="column7">Nacionalidad</th>
                                    <th class="column8">Celular</th>
                                    <th class="column9">Email</th>
                                    <th class="column10"></th>
                                    <th class="column11"></th>
                                </tr>
                            </thead>
                            <tbody>
                               <% Controladora control = new Controladora();
                                    List<Cliente> listaClientes = control.traerClientes();
                               for (Cliente cliente1 : listaClientes) 
                               { %>
                               <tr>
                                    <% int id = cliente1.getId_cliente(); %>
                                    <%String nombre = cliente1.getNombre(); %>
                                    <%String apellido = cliente1.getApellido();%>
                                    <%String direccion  = cliente1.getDireccion(); %>
                                    <% int dni  = cliente1.getDni(); %> 
                                    <%SimpleDateFormat parser = new SimpleDateFormat("dd/MM/yyyy");%>
                                    <% String diaNac  = parser.format(cliente1.getFecha_nac());%>
                                    <%String nacionalidad  = cliente1.getNacionalidad();%>
                                    <%long celu  = cliente1.getCelular();%>
                                    <%String email  = cliente1.getEmail();%>
                                    
                                    <td class="column1"> <%=id %></td>
                                    <td class="column2"> <%=nombre %> </td>
                                    <td class="column3"><%=apellido %></td>
                                    <td class="column4"><%=direccion %></td>
                                    <td class="column5"> <%=dni%></td>
                                    <td class="column6"><%=diaNac %></td>
                                    <td class="column7"><%=nacionalidad %></td>
                                    <td class="column8"><%=celu %></td>
                                    <td class="column9"><%=email %></td>
                                    <td class="column10">
                                        <form name="borrarCliente" action="SvBorrarCliente" method="POST" style="display:inline">
                                            <input type="hidden" name="id" value="<%=id %>">
                                            <button type="submit" class="btn btn-danger btn-xs" data-title="Delete" style="display:inline" >Borrar</button>
                                        </form>                                            
                                    </td>
                                    
                                    <td class="column11">
                                        <form name="editarCliente" action="SvEditarCliente" method="GET" style="display:inline">
                                            <input type="hidden" name="id" value="<%=id %>">
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