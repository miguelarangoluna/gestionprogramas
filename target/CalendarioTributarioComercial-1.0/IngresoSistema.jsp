<!DOCTYPE html>
<html lang="en">
    <head>
        <meta charset="UTF-8" />
        <meta name="viewport" content="width=device-width, initial-scale=1.0" />
        <title>Desarrollo 4</title>
        <jsp:include page="WEB-INF/boostrap/encabezado.jsp"/>
        <link rel="stylesheet" href="css/estilosIngresoSistema.css" />
    </head>
    <body>
        <div class="encabezado container">
            <div class="row">
                <div class="col">
                    <form class="formulario form-control justify-content-center" action="controlevento" method="post">
                        <div class="col">
                            <img class="imagenformulario" src="imagen/logoproyecto.png" alt="logoempresa"/>
                            <div class="col">
                                <div class="row">
                                    <div class="campos col">
                                        <div class="col">
                                            <label class="form-label" for="">Usuario<input class="form-control" type="text" name="usuario"/></label>
                                        </div>
                                        <div class="col"> 
                                            <label class="form-label" for="">Contraseña<input class="form-control" type="password" name="contrasena"/></label>
                                        </div>
                                    </div>
                                </div>
                                <div class="row">
                                    <input class="btn btn-success py-2 my-2" type="submit" value="Ingresar" name="accion"/>
                                </div>
                            </div>
                        </div>
                    </form>
                </div>
            </div>
        </div>
        <footer class="bg-dark text-white fixed-bottom">
            <div class="container py-3">
                <p>
                    &copy; miguelarango3777@hotmail.com <br/>2023 Todos los derechos reservados
                </p>
            </div>
        </footer>
        <jsp:include page="WEB-INF/boostrap/pie.jsp"/>
    </body>
</html>
