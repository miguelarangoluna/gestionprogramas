<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Editar empresa</title>
        <jsp:include page="../boostrap/encabezado.jsp" />
    </head>
    <body>
        <h1>Editar empresa</h1>

        <div class="container">
            <div class="row ">
                <div class="col col-10">
                    <p>Formulario para modificar el servicio del codigo: ${nit}</p>
                    <form action="${pageContext.request.contextPath}/controlempresa" class="col-sm-7 border p-2" method="post">
                        <div class="form-group">
                            <input type="hidden" class="form-control mb-2" name="nit" value="${nit}">
                        </div>
                        <div class="form-group">
                            <label for="razonsocial">Razon Social</label>
                            <input type="text" class="form-control mb-2" name="razonsocial" required value="${razonsocial}">
                        </div>
                        <div class="form-group">
                            <label for="direccion">Dirección</label>
                            <input type="text" class="form-control mb-2" name="direccion" required value="${direccion}">
                        </div>
                        <div class=" modal-footer">
                            <a href="index.jsp" class="btn btn-secondary m-2">Volver</a>
                            <button type="submit" class="btn btn-success m-5" value="modificar" name="accion">
                                Guardar cambios</button>
                        </div>
                    </form>
                </div>
            </div>
        </div>
        <jsp:include page="../boostrap/pie.jsp" />
    </body>
</html>
