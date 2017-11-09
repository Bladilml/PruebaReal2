<%-- 
    Document   : registroUsuario
    Created on : 06-11-2017, 18:07:08
    Author     : Bladi
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Registhor</title>
    </head>
    <body>
        <form action="registrar.do" method="POST">

            <h2>Crear usuario nuevo</h2>

            <table>
                <tbody>
                    <tr>
                        <th>Username:</th>
                        <td> <input type="text" name="user" placeholder="Ingrese usuario" required/> </td>
                    </tr>
                    <tr>
                        <th>Password:</th>
                        <td> <input type="password" name="password"  placeholder="ingrese contraseña" required/> </td>
                    </tr>
                    <tr>
                        <td colspan="2"> <input type="submit" value="Crear" /> </td>
                    </tr>
                </tbody>
            </table>


            <c:if test="${not empty listaMensajes}">                      
                <div class="bg-warning">
                    <ul>
                        <c:forEach var="mensaje" items="${listaMensajes}">
                            <li>${mensaje}</li>
                            </c:forEach>
                    </ul>
                </div>
            </c:if>

        </form>
    </body>
</html>
