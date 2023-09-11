<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Ventana agenda</title>
        <link rel="stylesheet" href="css/estiloventanagenda.css"/>
        <jsp:include page="../boostrap/encabezado.jsp"/>
    </head>
    <body>

        <section class="encabezado">
            <div class="container">
                <div class="row">
                    <div class="col-2 d-flex">
                        <img class="logoempresa" src="imagen/indutronica.png" alt="logoempresa" width="200px" height="150px">
                    </div>
                    <div class="col-8">
                        <h1>Ventana agenda</h1>
                        <p class="parrafo">Lorem ipsum dolor sit amet consectetur adipisicing elit. Placeat, cum.</p>
                    </div>
                    <div class="row">
                        <div class="col-12 py-2 mt-2">
                            <a class="btn btn-secondary" href="index.jsp">
                                <svg xmlns="http://www.w3.org/2000/svg" width="20" height="20" fill="currentColor" class="bi bi-x-square-fill" viewBox="0 0 16 16">
                                <path d="M2 0a2 2 0 0 0-2 2v12a2 2 0 0 0 2 2h12a2 2 0 0 0 2-2V2a2 2 0 0 0-2-2H2zm3.354 4.646L8 7.293l2.646-2.647a.5.5 0 0 1 .708.708L8.707 8l2.647 2.646a.5.5 0 0 1-.708.708L8 8.707l-2.646 2.647a.5.5 0 0 1-.708-.708L7.293 8 4.646 5.354a.5.5 0 1 1 .708-.708z"/>
                                </svg> Salir</a>
                            <a class="btn btn-secondary" href="${pageContext.request.contextPath}/controlagenda?accion=limpiar">Limpiar</a>
                        </div>

                    </div>
                </div>
            </div>
        </section>
        <h1>Agregue la empresa, servicio y el día a recordar</h1>
        <div class="container">
            <div class="row mt-3">
                <div class="col">
                    <form action="controlagenda" method="post">
                        <div class="row">
                            <div class="col-6">
                                <select name="listempresa" class="form-select form-select-sm">
                                    <option selected="">
                                        Seleccione empresa
                                    </option>
                                    <c:forEach var="emp" items="${listaempresas}">
                                        <option>${emp.razonsocial}
                                        </c:forEach>
                                    </option>
                                    <br />
                                </select>
                            </div>
                            <div class="col-6">
                                <select name="listservicio" class="form-select form-select-sm">
                                    <option>
                                        Seleccione servicio
                                    </option>
                                    <c:forEach var="servi" items="${listaservicios}">
                                        <option>${servi.descripcion}
                                        </c:forEach>
                                    </option>
                                    <br />
                                </select>
                            </div>
                        </div><br>
                        <div class="row-2">
                            <label class="form-label" for="diarecordar">Dia a recordar <input type="number" name="diarecordar"
                                                                                              class="form-control"></label>
                        </div>
                        <br />
                        <input class="btn btn-success" type="submit" value="Registrar" name="accion">
                        <input class="btn btn-secondary" type="submit" value="Agregar" name="accion">
                    </form>
                </div>
            </div>
        </div>
        <br/><br/>
        <h1>Servicios programados</h1>
        <div class="container">
            <div class="row g-6 m-4">
                <div class="col justify-content-center m-8">
                    <table class="table table-striped table-hover table-sm table-responsive">
                        <caption>Lista de agenda</caption>
                        <thead class="table-dark">
                            <tr>
                                <th>Item </th>
                                <th>Servicio</th>
                                <th>Empresa </th>
                                <th>Recordarme </th>
                                <th>Acciones</th>
                            </tr>
                        </thead>
                        <c:forEach var="servicio" items="${listagenda}" varStatus="item">
                            <tbody>
                                <tr>
                                    <td>${item.count}</td>
                                    <td>${servicio.servicio}</td>
                                    <td>${servicio.razonsocial}</td>
                                    <td>${servicio.diarecordar}</td>
                                    <td><a href="${pageContext.request.contextPath}/controlservicio?accion=editar&nit=${servicio.codigo}&razonsocial=${servicio.codigo}&direccion=${servicio.codigo}" class="btn btn-primary">Editar</a>
                                        <a href="${pageContext.request.contextPath}/controlservicio?accion=eliminar&codigo=${servicio.codigo}" class="btn btn-secondary">Eliminar</a>
                                        <a href="${pageContext.request.contextPath}/controlcalendario?accion=asociar&codigo=${servicio.codigo}&descripcion=${servicio.codigo}&fecha=${servicio.codigo}" class="btn btn-secondary">Asignar</a>
                                    </td>
                                </tr>
                            </tbody>
                        </c:forEach>
                    </table>
                </div>
            </div>
        </div><br/>

        <jsp:include page="../boostrap/piedepagina.jsp" />

    </body>
</html>