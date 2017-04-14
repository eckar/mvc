<%-- 
    Document   : mostrarcarros
    Created on : 16/08/2016, 01:37:48 PM
    Author     : Gangster
--%>
<%@page import="modelos.carros"%>//se importa la clase carros del paquete modelos.
<%
    carros c1 = (carros)request.getSession().getAttribute("carro");//entramos a la session y rescatamos el objeto carro almacenado en el controlador
%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Listado de carros</title>
    </head>
    <body>
        <h1>Listado de carros</h1>
        <table>
            <tr>
                <td>CODIGO</td>
                <td>DESCRIPCION VEHICULO</td>
                <td>VALOR VEHICULO</td>
            </tr>
            <tr>
                <td> <%= c1.getCodigo() %></td>
                <td><%= c1.getDescripcion() %></td>
                <td>$ <%= c1.getValor() %></td>
            </tr>
        </table>
            <a href="index.jsp">Volver al Formulario inicial.</a>
    </body>
</html>
