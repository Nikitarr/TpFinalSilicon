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
        <title>Au Register Forms by Colorlib</title>

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


        <%
            String Id = request.getParameter("id");
            Controladora control = new Controladora();
            Usuario usu = control.traerUsuario(Integer.parseInt(Id));
            int id = usu.getId_user();
            String nombre = usu.getNombre();
            String apellido = usu.getApellido();
            String direccion = usu.getDireccion();
            int dni = usu.getDni();
            SimpleDateFormat parser = new SimpleDateFormat("dd/MM/yyyy");
            String diaNac = parser.format(usu.getFecha_nac());
            String nacionalidad = usu.getNacionalidad();
            long celu = usu.getCelular();
            String email = usu.getEmail();
            String cargo = usu.getCargo();
            double sueldo = usu.getSueldo();
        %>
        <div class="flecha">
            <header>
                <a href="SvServicio"><img src="assetsUser/images/icons/back.png" input type="button" value="Back"/></a>
            </header>
        </div>

        <div class="page-wrapper bg-gra-02 p-t-130 p-b-100 font-poppins">
            <div class="wrapper wrapper--w680">
                <div class="card card-4">
                    <div class="card-body">
                        <h2 class="title">Editar Empleado/Usuario</h2>
                        <form action = "SvEditarUser" method="POST">
                            <input type="hidden" name="id" value="<%=id%>">
                            <div class="row row-space">
                                <div class="col-2">
                                    <div class="input-group">
                                        <label class="label">Nombre</label>
                                        <input class="input--style-4" type="text" name="nombre" value="<%=nombre%>">
                                    </div>
                                </div>
                                <div class="col-2">
                                    <div class="input-group">
                                        <label class="label">Apellido</label>
                                        <input class="input--style-4" type="text" name="apellido" value="<%=apellido%>">
                                    </div>
                                </div>
                            </div>
                            <div class="row row-space">
                                <div class="col-2">
                                    <div class="input-group">
                                        <label class="label">Direccion</label>
                                        <input class="input--style-4" type="text" name="direccion" value="<%=direccion%>">
                                    </div>
                                </div>
                                <div class="col-2">
                                    <div class="input-group">
                                        <label class="label">Nacionalidad</label>
                                        <input class="input--style-4" type="text" name="nacionalidad" value="<%=nacionalidad%>">
                                    </div>
                                </div>
                            </div>
                            <div class="row row-space">
                                <div class="col-2">
                                    <div class="input-group">
                                        <label class="label">Dia de Nacimiento</label>
                                        <div class="input-group-icon">
                                            <input class="input--style-4 js-datepicker" type="text" name="fechaDeNac" value="<%=diaNac%>">
                                            <i class="zmdi zmdi-calendar-note input-icon js-btn-calendar"></i>
                                        </div>
                                    </div>
                                </div>
                                <div class="col-2">
                                    <div class="input-group">
                                        <label class="label">DNI</label>
                                        <input class="input--style-4" type="number" name="dni" value="<%=dni%>">
                                    </div>
                                </div>
                            </div>
                            <div class="row row-space">
                                <div class="col-2">
                                    <div class="input-group">
                                        <label class="label">Email</label>
                                        <input class="input--style-4" type="email" name="email" value="<%=email%>">
                                    </div>
                                </div>
                                <div class="col-2">
                                    <div class="input-group">
                                        <label class="label">Celular</label>
                                        <input class="input--style-4" type="tel" name="celular" value="<%=celu%>">
                                        <div class="col-2">
                                        </div>
                                    </div>
                                </div>
                                <div class="row row-space">
                                    <div class="col-2">
                                        <div class="input-group">
                                            <label class="label">Cargo</label>
                                            <input class="input--style-4" type="text" name="cargo" value="<%=cargo%>">
                                        </div>
                                    </div>
                                    <div class="col-2">
                                        <div class="input-group">
                                            <label class="label">Sueldo</label>
                                            <input class="input--style-4" type="number" name="sueldo" value="<%=sueldo%>">
                                        </div>
                                    </div>
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