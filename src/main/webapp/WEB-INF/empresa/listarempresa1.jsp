<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="f" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Lista empresa</title>
        <link rel="stylesheet" href="css/estiloindex.css"/>
        <link rel="stylesheet" href="css/estiloventanaempresas.css"/>
        <jsp:include page="../boostrap/encabezado.jsp" />
    </head>
    <body>

        <section class="encabezado">
            <div class="container">
                <div class="row">
                    <div class="col-2 d-flex">
                        <img class="logoempresa" src="imagen/indutronica.png" alt="logoempresa" width="200px" height="150px">
                    </div>
                    <div class="col-8">
                        <h1>Lista de empresas</h1>
                        <p class="parrafo">Lorem ipsum dolor sit amet consectetur adipisicing elit. Placeat, cum.</p>
                    </div>
                    <div class="row">
                        <div class="col-12 py-2 mt-2">
                            <!-- Button trigger modal -->
                            <button type="button" class="btn btn-primary" data-bs-toggle="modal" data-bs-target="#registroempresa">
                                Agregar empresa <svg xmlns="http://www.w3.org/2000/svg" width="26" height="26" fill="currentColor" class="bi bi-building" viewBox="0 0 16 16">
                                <path d="M4 2.5a.5.5 0 0 1 .5-.5h1a.5.5 0 0 1 .5.5v1a.5.5 0 0 1-.5.5h-1a.5.5 0 0 1-.5-.5v-1Zm3 0a.5.5 0 0 1 .5-.5h1a.5.5 0 0 1 .5.5v1a.5.5 0 0 1-.5.5h-1a.5.5 0 0 1-.5-.5v-1Zm3.5-.5a.5.5 0 0 0-.5.5v1a.5.5 0 0 0 .5.5h1a.5.5 0 0 0 .5-.5v-1a.5.5 0 0 0-.5-.5h-1ZM4 5.5a.5.5 0 0 1 .5-.5h1a.5.5 0 0 1 .5.5v1a.5.5 0 0 1-.5.5h-1a.5.5 0 0 1-.5-.5v-1ZM7.5 5a.5.5 0 0 0-.5.5v1a.5.5 0 0 0 .5.5h1a.5.5 0 0 0 .5-.5v-1a.5.5 0 0 0-.5-.5h-1Zm2.5.5a.5.5 0 0 1 .5-.5h1a.5.5 0 0 1 .5.5v1a.5.5 0 0 1-.5.5h-1a.5.5 0 0 1-.5-.5v-1ZM4.5 8a.5.5 0 0 0-.5.5v1a.5.5 0 0 0 .5.5h1a.5.5 0 0 0 .5-.5v-1a.5.5 0 0 0-.5-.5h-1Zm2.5.5a.5.5 0 0 1 .5-.5h1a.5.5 0 0 1 .5.5v1a.5.5 0 0 1-.5.5h-1a.5.5 0 0 1-.5-.5v-1Zm3.5-.5a.5.5 0 0 0-.5.5v1a.5.5 0 0 0 .5.5h1a.5.5 0 0 0 .5-.5v-1a.5.5 0 0 0-.5-.5h-1Z"/>
                                <path d="M2 1a1 1 0 0 1 1-1h10a1 1 0 0 1 1 1v14a1 1 0 0 1-1 1H3a1 1 0 0 1-1-1V1Zm11 0H3v14h3v-2.5a.5.5 0 0 1 .5-.5h3a.5.5 0 0 1 .5.5V15h3V1Z"/>
                                </svg>
                            </button>
                            <a class="btn btn-secondary" href="index.jsp">
                                <svg xmlns="http://www.w3.org/2000/svg" width="20" height="20" fill="currentColor" class="bi bi-x-square-fill" viewBox="0 0 16 16">
                                <path d="M2 0a2 2 0 0 0-2 2v12a2 2 0 0 0 2 2h12a2 2 0 0 0 2-2V2a2 2 0 0 0-2-2H2zm3.354 4.646L8 7.293l2.646-2.647a.5.5 0 0 1 .708.708L8.707 8l2.647 2.646a.5.5 0 0 1-.708.708L8 8.707l-2.646 2.647a.5.5 0 0 1-.708-.708L7.293 8 4.646 5.354a.5.5 0 1 1 .708-.708z"/>
                                </svg> Salir</a>

                        </div>

                    </div>
                </div>
            </div>
        </section>

        <h1>Ventana empresa</h1>
        <div class="ventana">
            <div class="modal fade" id="registroempresa" tabindex="-1" aria-labelledby="exampleModalLabel" aria-hidden="true">
                <div class="modal-dialog">
                    <div class="modal-content">
                        <div class="modal-header">
                            <h1 class="modal-title fs-5" id="exampleModalLabel">Registro empresa</h1>
                            <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
                        </div>
                        <div class="modal-body">
                            <div class="container">
                                <div class="row my-5">
                                    <div class="col">
                                        <form action="controlempresa" method="post" class="was-validated">
                                            <p><label for="empresa">Razon social<input class="form-control" type="text"
                                                                                       name="razonsocial" required></label></p>
                                            <p><label for="nit">Nit<input class="form-control" type="number" name="nit" required=""></label>
                                            </p>
                                            <p><label for="dig_verificacion">Digito verificacion<input class="form-control"
                                                                                                       type="number" name="digito_verificacion" required=""></label></p>
                                            <p><label for="telefono">Telefono<input class="form-control" type="number"
                                                                                    name="telefono" required=""></label>
                                            </p>
                                            <p><label for="direccion">Direccion<input class="form-control" type="text"
                                                                                      name="direccion" required=""></label>
                                            </p>
                                            <p><label for="fecha">Fecha registro<input class="form-control" type="date"
                                                                                       name="fecha" required=""></label>
                                            </p>
                                            <br />
                                            <input type="submit" value="Registrar" name="accion" required="">
                                        </form>
                                    </div>
                                </div>
                            </div>
                        </div>
                        <div class="modal-footer">
                            <button type="button" class="btn btn-secondary" data-bs-dismiss="modal">Close</button>
                            <button type="button" class="btn btn-primary">Save changes</button>
                        </div>
                    </div>
                </div>
            </div>
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
                                        <td><a href="${pageContext.request.contextPath}/controlempresa?accion=editar&nit=${empresa.nit}&razonsocial=${empresa.razonsocial}&direccion=${empresa.direccion}" class="btn btn-primary"><svg xmlns="http://www.w3.org/2000/svg" width="16" height="16" fill="currentColor" class="bi bi-pen" viewBox="0 0 16 16">
  <path d="m13.498.795.149-.149a1.207 1.207 0 1 1 1.707 1.708l-.149.148a1.5 1.5 0 0 1-.059 2.059L4.854 14.854a.5.5 0 0 1-.233.131l-4 1a.5.5 0 0 1-.606-.606l1-4a.5.5 0 0 1 .131-.232l9.642-9.642a.5.5 0 0 0-.642.056L6.854 4.854a.5.5 0 1 1-.708-.708L9.44.854A1.5 1.5 0 0 1 11.5.796a1.5 1.5 0 0 1 1.998-.001zm-.644.766a.5.5 0 0 0-.707 0L1.95 11.756l-.764 3.057 3.057-.764L14.44 3.854a.5.5 0 0 0 0-.708l-1.585-1.585z"/>
</svg></a>
                                            <a href="${pageContext.request.contextPath}/controlempresa?accion=eliminar&codigo=${empresa.codigo}&nit=${empresa.nit}" class="btn btn-secondary"><svg xmlns="http://www.w3.org/2000/svg" width="16" height="16" fill="currentColor" class="bi bi-trash3" viewBox="0 0 16 16">
  <path d="M6.5 1h3a.5.5 0 0 1 .5.5v1H6v-1a.5.5 0 0 1 .5-.5ZM11 2.5v-1A1.5 1.5 0 0 0 9.5 0h-3A1.5 1.5 0 0 0 5 1.5v1H2.506a.58.58 0 0 0-.01 0H1.5a.5.5 0 0 0 0 1h.538l.853 10.66A2 2 0 0 0 4.885 16h6.23a2 2 0 0 0 1.994-1.84l.853-10.66h.538a.5.5 0 0 0 0-1h-.995a.59.59 0 0 0-.01 0H11Zm1.958 1-.846 10.58a1 1 0 0 1-.997.92h-6.23a1 1 0 0 1-.997-.92L3.042 3.5h9.916Zm-7.487 1a.5.5 0 0 1 .528.47l.5 8.5a.5.5 0 0 1-.998.06L5 5.03a.5.5 0 0 1 .47-.53Zm5.058 0a.5.5 0 0 1 .47.53l-.5 8.5a.5.5 0 1 1-.998-.06l.5-8.5a.5.5 0 0 1 .528-.47ZM8 4.5a.5.5 0 0 1 .5.5v8.5a.5.5 0 0 1-1 0V5a.5.5 0 0 1 .5-.5Z"/>
</svg></a>
                                            <a href="${pageContext.request.contextPath}/controlcalendario?accion=agenda&codigo=${empresa.nit}" class="btn btn-secondary"><svg xmlns="http://www.w3.org/2000/svg" width="16" height="16" fill="currentColor" class="bi bi-calendar" viewBox="0 0 16 16">
  <path d="M3.5 0a.5.5 0 0 1 .5.5V1h8V.5a.5.5 0 0 1 1 0V1h1a2 2 0 0 1 2 2v11a2 2 0 0 1-2 2H2a2 2 0 0 1-2-2V3a2 2 0 0 1 2-2h1V.5a.5.5 0 0 1 .5-.5zM1 4v10a1 1 0 0 0 1 1h12a1 1 0 0 0 1-1V4H1z"/>
</svg></a></td>
                                    </tr>
                                </tbody>
                            </c:forEach>
                        </table>
                    </div>
                </div>
            </div>
        </div>

        <jsp:include page="../boostrap/piedepagina.jsp"/>
    </body>
</html>
