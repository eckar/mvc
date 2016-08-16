<%-- 
    Document   : index
    Created on : 16/08/2016, 01:03:23 PM
    Author     : Edgar Rodriguez Arias
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Formulario Basico con MVC</title>
    </head>
    <body>
        <h1>Formulario de Autos</h1>
        <h2>A continuacion un formulario básico basado en MVC WEB Java</h2>
        <form action="procesar.do" method="post"> 
            <table>
                <tr>
                    <td>Codigo: </td> 
                    <td><input type="text" name="txtCod"/></td>
                </tr>
                <tr>
                    <td>Descripcion Vehiculo: </td>
                    <td><input type="text" name="txtDesc"/></td>
                </tr>
                <tr>
                    <td>Valor Vahiculo: </td>
                    <td><input type="text" name="txtValor"/></td>
                </tr>
            </table>
            <input type="submit" value="Enviar info"/>
        </form>
    </body>
</html>
