<%-- 
    Document   : index
    Created on : 06-11-2017, 18:06:40
    Author     : Bladi
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Bienvenido a MTT</title>
    </head>
    <body>


        <form action="login.do" method="post">
            <h3>Bienvenido! Por favor Ingrese</h3>

            <input type="text"  name="username" placeholder="Username" required="" />
            <input type="password"  name="password" placeholder="Password" required=""/>     		  

            <button name="Submit" value="Login" >Login</button>
            <a href="registroUsuario.jsp">Crear una nueva cuenta</a>
        </form>

        <div class="bg-warning">
            <c:if test="${not empty listaMensajesLogin}">
                <ul>
                    <c:forEach var="mensaje" items="${listaMensajesLogin}">
                        <li>${mensaje}</li>
                        </c:forEach>
                </ul>
            </c:if>
        </div>        
    </body>
</html>
