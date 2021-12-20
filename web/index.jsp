<%@page import="java.io.IOException"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head lang="es">
        <meta charset="utf-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
        <title> Agencia de Viajes </title>
        
        <meta name="description" content="">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <link rel="apple-touch-icon" href="apple-touch-icon.png">

        <link rel="stylesheet" href="assetsHome/css/bootstrap.min.css">
        <link rel="stylesheet" href="assetsHome/css/bootstrap-theme.min.css">
        <link rel="stylesheet" href="assetsHome/css/fontAwesome.css">
        <link rel="stylesheet" href="assetsHome/css/light-box.css">
        <link rel="stylesheet" href="assetsHome/css/templatemo-main.css">

        <link href="https://fonts.googleapis.com/css?family=Open+Sans:300,400,600,700,800" rel="stylesheet">

        <script src="assetsHome/js/vendor/modernizr-2.8.3-respond-1.4.2.min.js"></script>
        
    </head>

<body>
    
    <% HttpSession misession = request.getSession();
        String usu = (String) misession.getAttribute("user");
    %>
        
        <nav>
          <div class="logo">
              <% if(usu == null){ %>
              <h1 style="color: white"> Agencia de Viajes </h1>
              <%} else{ %>
              <h1 style="color: white"> Agencia de Viajes <em> <%=usu%> </em></h1>
              <%}%>
              
          </div>
          <div class="mini-logo">
              <img src="assetsHome/img/mini_logo.png" alt="">
          </div>
          <ul>
            <li><a href="index.jsp"><i class="fa fa-home"></i> <em>Inicio</em></a></li>
            <li><a href="SvServicios"><i class="fa fa-image"></i> <em>Servicios</em></a></li>
            <li><a href="SvPaquetes"><i class="fa fa-image"></i> <em>Paquetes</em></a></li>
            <li><a href="SvClientes"><i class="fa fa-user"></i> <em>Clientes</em></a></li>
            <li><a href="SvUsuario"><i class="fa fa-user"></i> <em>Usuarios/Empleados</em></a></li>
            <li><a href="SvVentas"><i class="fa fa-pencil"></i> <em>Ventas</em></a></li>          
          </ul>
        </nav>
        
        <div class="slides">
          <div class="slide" id="1">
            <div class="content first-content">
              <div class="container-fluid">
                  <div class="col-md-3">
                      <div class="author-image"><img src="assetsHome/img/author_image.png" alt="Author Image"></div>
                  </div>
                  <div class="col-md-9">
                      <h2>Nuestra Agencia</h2>
                      <p> Si sos empleado por favor <strong> Inicia Sesión </strong> en el siguiente botón</p>
                      
                      <%if(usu == null) {%>
                      <div class="main-btn"><a href="SvLogin">LOG IN</a></div>
                      <%} else{ %>
                      <div class="main-btn"><a href="SvLogout">LOG OUT</a></div>
                      <%}%>
                      
                  </div>
              </div>
            </div>
          </div>
        </div>             
        </body>