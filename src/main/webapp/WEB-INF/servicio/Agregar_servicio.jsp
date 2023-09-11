<form action="controlservicio" method="post" class="was-validated">
    <input type="hidden" name="codigoservicio">
    <p><label for="empresa">Descripción: <input class="form-control" type="text" name="descripcion" required="" ></label></p>
    <p><label for="fecha">Fecha: <input class="form-control" type="date" name="fecha" required=""></label></p>
    <p><label for="telefono">Ciudad: <input class="form-control" type="text" name="ciudad" required=""></label></p>
    <br/>
    <input class="btn btn-primary" type="submit" value="Registrar" name="accion">
</form>