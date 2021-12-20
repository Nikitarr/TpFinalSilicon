<%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.util.Date"%>
<%@page import="logica.Usuario"%>
<%@page import="java.util.List"%>
<%@page import="logica.Controladora"%>
<%@ page contentType="text/html" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html lang="es">

    <head>
        <title>Usuarios</title>
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
        <div>
            <header>
                <a href="index.jsp"><img src="assetsUser/images/icons/back.png" input type="button" value="Back"/></a>
            </header>
        </div>
        <div class="container1">
            <h1 class="text-center">Usuarios</h1>

            <a href="SvAgregarUser" class="btn btn-secondary" id="agregar">Agregar Empleado</a>
        </div>

        <div class="limiter">
            <div class="container-table100">
                <div class="wrap-table100">
                    <div class="table100">
                        <table clas="table-striped custom-table">
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
                                    <th class="column10">Cargo</th>
                                    <th class="column11">Sueldo</th>
                                    <th class="column12"></th>
                                    <th class="column13"></th>
                                </tr>
                            </thead>
                            <tbody>
                               <% Controladora control = new Controladora();
                                    List<Usuario> listaPersonas = control.traerUsuarios();
                               for (Usuario usu : listaPersonas) 
                               { %>
                               <tr>
                                    <% int id = usu.getId_user(); %>
                                    <%String nombre = usu.getNombre(); %>
                                    <%String apellido = usu.getApellido();%>
                                    <%String direccion  = usu.getDireccion(); %>
                                    <% int dni  = usu.getDni(); %> 
                                    <%SimpleDateFormat parser = new SimpleDateFormat("dd/MM/yyyy");%>
                                    <% String diaNac  = parser.format(usu.getFecha_nac());%>
                                    <%String nacionalidad  = usu.getNacionalidad();%>
                                    <%long celu  = usu.getCelular();%>
                                    <%String email  = usu.getEmail();%>
                                    <%String cargo  = usu.getCargo();%>
                                    <% double sueldo  = usu.getSueldo();%>
                                    
                                    <td class="column1"> <%=id %></td>
                                    <td class="column2"> <%=nombre %> </td>
                                    <td class="column3"><%=apellido %></td>
                                    <td class="column4"><%=direccion %></td>
                                    <td class="column5"> <%=dni%></td>
                                    <td class="column6"><%=diaNac %></td>
                                    <td class="column7"><%=nacionalidad %></td>
                                    <td class="column8"><%=celu %></td>
                                    <td class="column9"><%=email %></td>
                                    <td class="column10"><%=cargo %></td>
                                    <td class="column11"><%=sueldo %></td>
                                    <td class="column12">
                                        <form name="borrarUser" action="SvBorrarUser" method="POST" style="display:inline">
                                            <input type="hidden" name="id" value="<%=id %>">
                                            <button type="submit" class="btn btn-danger btn-xs" data-title="Delete" style="display:inline" >Borrar</button>
                                        </form>                                            
                                    </td>
                                    
                                    <td class="column13">
                                        <form name="editarUser" action="SvEditarUser" method="GET" style="display:inline">
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