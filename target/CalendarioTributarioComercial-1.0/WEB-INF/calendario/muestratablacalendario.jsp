<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<div class="container">
    <div class="row g-6 m-4">
        <div class="col justify-content-center m-8">
            <table class="table table-striped table-hover table-sm table-responsive">
                <caption>Lista de calendario</caption>
                <thead class="table-dark">
                    <tr>
                        <th>ITEMS </th>    
                        <th>FECHA </th>
                        <th>DIGITO VERIFICACIÓN</th>
                    </tr>
                </thead>
                <c:forEach var="cal" items="${listar}" varStatus="item">
                    <tbody>
                        <tr>
                            <td>${item.count}</td>
                            <td>${cal.fecha}</td>
                            <td>${cal.digito_verificacion}</td>
                        </tr>  
                    </tbody>
                </c:forEach>
            </table>
        </div>
    </div>
</div>
La fecha es: <input type="date" value="${fechasistema}"><br/>
<a href="index.jsp">Volver</a>


