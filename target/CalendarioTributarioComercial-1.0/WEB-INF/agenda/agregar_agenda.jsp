<h1>Registrar agenda</h1>
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
                    <label class="form-label" for="diarecordar">Dia a recordar <input type="number" name="diarecordar" class="form-control"></label>
                </div>
                <br />
                <input class="btn btn-success" type="submit" value="Registrar" name="accion">
                <input class="btn btn-secondary" type="submit" value="Agregar" name="accion">
            </form>
        </div>
    </div>
</div>
