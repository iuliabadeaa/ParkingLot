<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<t:pageTemplate pageTitle="AddCar">


    <form class="needs-validation" novalidate method="POST" action="${pageContext.request.contextPath}/AddCar">
        <div class="row">
            <div class="col-md-6 mb-3">
                <label for="license_plate"></label>
                <input type="text" class="form-control" id="license_plate" name="license_plate" value="" required/>
                <div class="invalid_feedback">
                    License plate is required!!!
                </div>
            </div>

            <div class="col-md-6 mb-3">
                <label for="parking_spot"></label>
                <input type="text" class="form-control" id="parking_spot" name="parking_spot" value="" required/>
                <div class="invalid_feedback">
                    Parking spot is required!!!
                </div>
            </div>

            <div class="col-md-6 mb-3">
                <label for="owner">Owner</label>
                    <select id="owner" name="owner">
                        <option value="">Choose</option>
                        <c:forEach var="user" items="${users}" varStatus="status">
                            <option value="${user.userId}">${user.userName}</option>
                        </c:forEach>
                    </select>
                    <input type="submit" class="btn btn-primary btn-lg" value="Save"/>
                <div class="invalid_feedback">
                   Owner is required!!!
                </div>
            </div>
        </div>
        <button class="btn btn-primary btn-lg" type="submit">
            <a href="${pageContext.request.contextPath}/AddCar">SAVE</a>
        </button>
    </form>
</t:pageTemplate>