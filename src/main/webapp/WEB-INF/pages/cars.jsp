<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<t:pageTemplate pageTitle="Cars">
    <h1>Cars</h1>
    <div class="container text-center">

        <button class="btn btn-primary btn-lg" type="submit">
         <a href="${pageContext.request.contextPath}/AddCar">NEW CAR</a>
        </button>

    <c:forEach var="car" items="${cars}">
        <div class="row">
            <div class="col">
                ${car.licensePlate}
            </div>
            <div class="col">
                ${car.parkingSpot}
            </div>
            <div class="col">
                ${car.ownerName}
            </div>
            <div class="col">
                    ${car.data}
            </div>
        </div>
    </c:forEach>


</t:pageTemplate>