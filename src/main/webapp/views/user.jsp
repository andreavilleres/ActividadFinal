<%-- 
    Document   : usuario

--%>

<%@page import="model.Usuario"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.8.1/css/all.css" integrity= "sha384-50oBUHEmvpQ+1lW4y57PTFmhCaXp0ML5d60M1M7uH2+nqUivzIebhndOJK28anvf" crossorigin="anonymous">
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.1/dist/css/bootstrap.min.css">
    <link rel="stylesheet"  href="/css/main.css">
    <title>Ejercicio Integrador Front End</title>
</head>
<body>


<!-- Navbar inicio-->
<nav class="navbar navbar-dark navbar-expand-lg bg-dark" id="nav">
  <div class="container-fluid text-start">
   <a class="navbar-brand text-light" href="/index.html"> Ejercicio integrador Codo a Codo 4.0</a> 
   
  <div class="container-fluid-right">
   <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#collapsibleNavbar">
     <span class="navbar-toggler-icon"></span>
   </button>
  
 </div>
</div>
 </nav>
<br>



</div>

<%
    Usuario usuario = (Usuario) session.getAttribute("usuarioSession");
%>
<!--formulario-->
  <div class="container-xl mt-2 text-center" style="width:53%" >

    <h4 class="text smal text-center">Datos del usuario</h4>
  </div>
  
  <div class="container-fluid" style="width:53%">
    <form action="/ActividadFinal/UpdateUsuarioController" method="POST">
         <input type="hidden"  name="id" id="id" value="<%=usuario.getId()%>">
         <div class="row">
          <div class="col" >
            <input type="text" class="form-control" placeholder="Usuario" name="username" id="username" value="<%=usuario.getUsername()%>">
          </div>
          <div class="col">
            <input type="password" class="form-control" placeholder="Password" name="password" id="password" value="<%=usuario.getPassword()%>">
          </div>
        </div>
<br>
        <div class="row">
            <div class="col" >
              <input type="text" class="form-control" placeholder="Nombre" name="nombre" id="nombre" value="<%=usuario.getNombre()%>">
            </div>
            <div class="col">
              <input type="text" class="form-control" placeholder="Apellido" name="apellido"  id="apellido" value="<%=usuario.getApellido()%>">
            </div>
          </div>

        <br>
        
        <div class="mb-3 mt-3">
                   <input type="email" class="form-control" id="mail" name="mail" placeholder="Correo" value="<%=usuario.getMail()%>">
        </div>

       
          <br>

         
          <div class="row">
            <div class="col order-1">
                <button type="reset" class="btn btn-md-6 text-light"
                style="background-color: rgba(116, 202, 35, 0.877); font-size: medium; width:100%">Limpiar</button>
            </div>
            <div class="col order-2">
                <button type="submit" class="btn btn-md text-light" style="width:100%; background-color: rgba(116, 202, 35, 0.877); font-size: medium;">Actualizar</button>
            </div>
          </div>
      
          </form>
      
    </div>
  </div>
</div>
