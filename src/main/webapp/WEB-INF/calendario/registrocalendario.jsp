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
                    <!--<!-- <form action="${pageContext.request.contextPath}/controlcalendario?accion=agendar&codigo=${codigo}&descripcion=${descripcion}&fecha=${fecha}" class="col-sm-7 border p-2" method="post"> -->
                    <form action="controlcalendario" class="col-sm-7 border p-2" method="post">
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
                    <div class="col justify-content-center m-8">
                        <table class="table table-striped table-hover table-sm table-responsive">
                            <caption>Lista de servicios</caption>
                            <thead class="table-dark">
                                <tr>
                                    <th>Item </th>
                                    <th>Digito verificacion </th>
                                    <th>Servicio </th>
                                    <th>Fecha </th>
                                    <th>Acciones</th>
                                </tr>
                            </thead>
                            <c:forEach var="calendario" items="${listacalendario}" varStatus="item">
                                <tbody>
                                    <tr>
                                        <td>${item.count}</td>
                                        <td>${calendario.digito_verificacion}</td>
                                        <td>${calendario.cod_servicio}</td>
                                        <td>${calendario.fecha}</td>
                                        <td><a href="${pageContext.request.contextPath}/controlservicio?accion=editar&nit=${calendario.descripcion}&razonsocial=${calendario.descripcion}&direccion=${servicio.item}" class="btn btn-primary">Editar</a></td>
                                        <td><a href="${pageContext.request.contextPath}/controlcalendario?accion=limpiar" class="btn btn-secondary">Eliminar</a></td>
                                        <td><a href="${pageContext.request.contextPath}/controlcalendario?accion=asociar&codigo=${calendario.descripcion}&descripcion=${calendario.descripcion}&fecha=${servicio.item}" class="btn btn-secondary">Asignar</a></td>
                                    </tr>
                                </tbody>
                            </c:forEach>
                    </table> 
                    </div>
                    <a href="index.jsp">Volver</a>
                </div>
            </div>
        </div>
    </body>
</html>
