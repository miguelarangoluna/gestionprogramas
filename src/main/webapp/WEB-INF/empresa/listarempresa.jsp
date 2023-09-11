<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="f" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Lista empresa</title>
        <jsp:include page="../boostrap/encabezado.jsp" />
    </head>
    <body>
        <h1>Lista de empresa</h1>
        <div class="ventana">
            <section>
                <a href="index.jsp" class="btn btn-secondary m-4">Agregar empresa</a>
            </section>
            <h1>Listado de empresas registradas</h1>
            <div class="container">
                <div class="row g-6 m-4">
                    <div class="col justify-content-center m-8">
                        <table class="table table-striped table-hover table-sm table-responsive">
                            <caption>Lista de empresas</caption>
                            <thead class="table-dark">
                                <tr>
                                    <th>Código </th>
                                    <th>Nit </th>
                                    <th>Razon social </th>
                                    <th>Direccion </th>
                                    <th>Acciones</th>
                                </tr>
                            </thead>
                            <c:forEach var="empresa" items="${listar}" varStatus="item">
                                <tbody>
                                    <tr>
                                        <td>${item.count}</td>
                                        <td>${empresa.nit}</td>
                                        <td>${empresa.razonsocial}</td>
                                        <td>${empresa.direccion}</td>
                                        <td><a href="${pageContext.request.contextPath}/controlservicio?accion=editar&nit=${empresa.codigo}&razonsocial=${empresa.codigo}&direccion=${empresa.codigo}" class="btn btn-primary">Editar</a>
                                        <a href="${pageContext.request.contextPath}/controlservicio?accion=eliminar&cedula=${empresa.codigo}" class="btn btn-secondary">Eliminar</a>
                                        <a href="${pageContext.request.contextPath}/controlcalendario?accion=agenda&codigo=${empresa.nit}" class="btn btn-secondary">Consulta fechas</a></td>
                                    </tr>
                                </tbody>
                            </c:forEach>
                        </table>
                    </div>
                </div>
            </div>
        </div>
        <br/>
        <a href="index.jsp">Volver</a>
        <br/> 
     
    </body>
</html>
