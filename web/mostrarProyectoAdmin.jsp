        <%-- 
    Document   : mostrarProyecto
    Created on : 06-11-2017, 18:07:36
    Author     : Bladi
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title></title>
    </head>
    <body>
        <table border="1">
            <thead>
                <tr>
                    <th>id</th>
                    <th>Nombre Proyecto</th>
                    <th>descripcion</th>
                    <th>fecha_inicio</th>
                    <th>estado/th>
                    <th>Presupuesto inicial</th>
                    <th>Presupuesto gastado</th>
                    <th>Comuna</th>
                </tr>
            </thead>
            <tbody>
            <c:forEach var="pr" items="${listaProyecto}">
                <tr>
                    <td>${pr.id}</td>
                    <td>${pr.nombre}</td>
                    <td>${pr.descripcion}</td>
                    <td>${pr.fecha_inicio}</td>
                    <td>${pr.estado}</td>
                    <td>${pr.presupuesto_inicial}</td>
                    <td>${pr.presupuesto_gastado}</td>
                    <td>${pr.comuna_id}</td>
                </tr>
            </c:forEach>
        </tbody>
    </table>
</body>
</html>
