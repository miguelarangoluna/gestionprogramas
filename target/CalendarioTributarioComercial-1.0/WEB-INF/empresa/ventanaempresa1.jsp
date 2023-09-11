<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Ventana empresa</title>
        <jsp:include page="../boostrap/encabezado.jsp"/>
    </head>
    <body>
            <!-- Button trigger modal -->
    <button type="button" class="btn btn-primary" data-bs-toggle="modal" data-bs-target="#exampleModal">
        Registro empresa
    </button>

    <!-- Modal -->
    <div class="modal fade" id="exampleModal" tabindex="-1" aria-labelledby="exampleModalLabel" aria-hidden="true">
        <div class="modal-dialog">
            <div class="modal-content">
                <div class="modal-header">
                    <h1 class="modal-title fs-5" id="exampleModalLabel">Modal title</h1>
                    <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
                </div>
                <div class="modal-body">
                    <div class="container">
                        <div class="row my-5">
                            <div class="col">
                                <h1>Bienvenido al registro de empresa</h1>
                                <h2>Registro Empresa</h2>
                                <form action="controlempresa" method="post">
                                    <p><label for="empresa">Razon social<input class="form-control" type="text"
                                                name="razonsocial"></label></p>
                                    <p><label for="nit">Nit<input class="form-control" type="number" name="nit"></label>
                                    </p>
                                    <p><label for="dig_verificacion">Digito verificacion<input class="form-control"
                                                type="number" name="digito_verificacion"></label></p>
                                    <p><label for="telefono">Telefono<input class="form-control" type="number"
                                                name="telefono"></label>
                                    </p>
                                    <p><label for="direccion">Direccion<input class="form-control" type="text"
                                                name="direccion"></label>
                                    </p>
                                    <p><label for="fecha">Fecha registro<input class="form-control" type="date"
                                                name="fecha"></label>
                                    </p>
                                    <br />
                                    <input type="submit" value="Registrar" name="accion">
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
    <a href="index.jsp">Volver index</a><br /><br />
    <a href="controlempresa?accion=listar">Listar empresas</a>
    <br /><br/>
    </body>
</html>
