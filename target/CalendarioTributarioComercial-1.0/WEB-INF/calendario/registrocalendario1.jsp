<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Calendario</title>
        <jsp:include page="../boostrap/encabezado.jsp" />
    </head>
    <body>
        <h1>Asignar calendario</h1>
        <div class="container">
            <div class="row ">
                <div class="col col-10">
                    <p>Registrar calendario para el servicio: ${descripcion}</p>
                    <form action="${pageContext.request.contextPath}/controlcalendario" class="col-sm-7 border p-2" method="post">
                        <div class="form-group">
                            <input type="hidden" class="form-control mb-2" name="descripcion" value="${descripcion}">
                        </div>
                        <div class="form-group">
                            <label for="fecha">Fecha: </label>
                            <input type="date" class="form-control mb-2" name="fecha">
                        </div>
                        <div class="form-group">
                            <label for="digito">Digito verificación: </label>
                            <input type="number" class="form-control mb-2" name="digito_verificacion" >
                        </div>
                        <input type="submit" value="agregar" name="accion">
                        <input type="submit" value="limpiar" name="accion">
                        <input type="submit" value="Guardar" name="accion">
                    </form>
                    <br/>
                    <a href="${pageContext.request.contextPath}/controlcalendario?accion=listar&descripcion=${descripcion}">listar</a>
                    <br/>
                    <jsp:include page="/WEB-INF/calendario/muestratablacalendario.jsp"/>
                    <a href="index.jsp">Volver</a>
                </div>
            </div>
        </div>
    </body>
</html>
