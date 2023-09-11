<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Servicio</title>
        <jsp:include page="../boostrap/encabezado.jsp" />
    </head>
   
    <body>
        <h1>Registro servicio</h1>
        <form action="controlservicio" method="post">
            <input type="hidden" name="codigoservicio">
            <p><label for="empresa">Descripción: <input type="text" name="descripcion"></label></p>
            <p><label for="fecha">Fecha: <input type="date" name="fecha"></label></p>
            <p><label for="telefono">Ciudad: <input type="text" name="ciudad"></label></p>
            <br/>
            <input type="submit" value="Registrar" name="accion">
        </form>
        <br/><br/>
        <jsp:include page="../servicio/lista_servicio.jsp"/>
        <br/><br/>
        <a href="index.jsp">Volver</a>
        <br/><br/>
        <a href="controlservicio?accion=listar">Listar</a>
    </body>
</html>
