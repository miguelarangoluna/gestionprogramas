<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Editar empresa</title>
    </head>
    <body>
        <h1>Editar servicio</h1>
        
        <div class="container">
            <div class="row ">
                <div class="col col-10">
                    <p>Formulario para modificar el servicio del codigo ${servicio.codigo}</p>
                    <form action="${pageContext.request.contextPath}/controlservicio?accion=modificar&codigo=${servicio.codigo}" class="col-sm-7 border p-2" method="post">
                        <div class="form-group">
                            <label for="nombre">Descripcion</label>
                            <input type="text" class="form-control mb-2" name="descripcion" required value="${servicio.descripcion}">
                        </div>
                        <div class="form-group">
                            <label for="nombre">Precio</label>
                            <input type="number" class="form-control mb-2" name="precio" required value="${servicio.precio}">
                        </div>
                        <div class=" modal-footer">
                            <a href="seleccionaccion.jsp" class="btn btn-secondary m-2">Volver</a>
                            <button type="submit" class="btn btn-success m-5">
                                Guardar cambios</button>
                        </div>
                    </form>
                </div>
            </div>
        </div>
</body>
</html>
