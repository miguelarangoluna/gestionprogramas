<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<div class="container">
    <div class="row g-6 m-4">
        <div class="col justify-content-center m-8">
            <table class="table table-striped table-hover table-sm table-responsive">
                <caption>Lista de servicios</caption>
                <thead class="table-dark">
                    <tr>
                        <th>Código </th>
                        <th>Fecha </th>
                        <th>Descripción </th>
                        <th>Ciudad </th>
                        <th>Acciones</th>
                    </tr>
                </thead>
                <c:forEach var="servicio" items="${listarservicio}" varStatus="item">
                    <tbody>
                        <tr>
                            <td>${item.count}</td>
                            <td>${servicio.fecha}</td>
                            <td>${servicio.descripcion}</td>
                            <td>${servicio.ciudad}</td>
                            <td><a href="${pageContext.request.contextPath}/controlservicio?accion=editar&nit=${servicio.codigo}&razonsocial=${servicio.codigo}&direccion=${servicio.codigo}" class="btn btn-primary">Editar</a>
                            <a href="${pageContext.request.contextPath}/controlservicio?accion=eliminar&codigo=${servicio.codigo}" class="btn btn-secondary">Eliminar</a>
                            <a href="${pageContext.request.contextPath}/controlcalendario?accion=asociar&codigo=${servicio.codigo}&descripcion=${servicio.descripcion}&fecha=${servicio.fecha}" class="btn btn-secondary">Asignar</a></td>
                        </tr>
                    </tbody>
                </c:forEach>
            </table>
        </div>
    </div>
</div><br/>
