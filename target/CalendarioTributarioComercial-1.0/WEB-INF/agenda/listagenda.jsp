<%@taglib  prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Lista Calendario</title>
    </head>
    <body>
        <h1>Lista de proximos pagos </h1>
        <h2>La empresa seleccionada es: ${razon}</h2>
        <div class="container">
                <div class="row g-6 m-4">
                    <div class="col justify-content-center m-8">
                        <table class="table table-striped table-hover table-sm table-responsive">
                            <caption>Lista de calendario</caption>
                            <thead class="table-dark">
                                <tr>
                                    <th>ITEMS </th>    
                                    <th>FECHA </th>
                                    <th>RAZON SOCIAL </th>
                                    <th>DIA RECORDAR </th>
                                    <th>DESCRIPCION </th>
                                </tr>
                            </thead>
                            <c:forEach var="cal" items="${listar}" varStatus="item">
                                <tbody>
                                    <tr>
                                        <td>${item.count}</td>
                                        <td>${cal.fecha}</td>
                                        <td>${cal.razonsocial}</td>
                                        <td>${cal.diarecordar}</td>
                                        <td>${cal.descripcion}</td>
                                    </tr>  
                                </tbody>
                            </c:forEach>
                        </table>
                    </div>
                </div>
            </div>
        La fecha es: <input type="date" value="${fechasistema}"><br/>
        <a href="index.jsp">Volver</a>
      
    </body>
</html>
