<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<html>
<body>
<h2>Spring MVC and List Example</h2>

<form:form method="GET" action="/auctionForm">
    <table>
        <tr>
            <td>
                <input style="background-color: red;" type="submit" value="Add auction"/>
            </td>
        </tr>
    </table>
</form:form>
<c:if test="${not empty auctions}">
    <ul>
            <table>
                <tr>
                    <th>id</th>
                    <th>title</th>
                    <th>description</th>
                    <th>user first name</th>
                    <th>user last name</th>
                    <th>price</th>
                    <th>start date</th>
                    <th>end date</th>
                </tr>
                <c:forEach var="auction" items="${auctions}">
                <tr>
                    <td>${auction.id}</td>
                    <td>${auction.title}</td>
                    <td>${auction.description}</td>
                    <td>${auction.user.firstName}</td>
                    <td>${auction.user.lastName}</td>
                    <td>${auction.price}</td>
                    <td>${auction.startDate}</td>
                    <td>${auction.endDate}</td>
                    <td>

                        <spring:url value="/auctions/${auction.id}/delete" var="deleteUrl" />
                        <%--<spring:url value="/users/${user.id}/update" var="updateUrl" />--%>

                        <%--<button class="btn btn-danger"
                                onclick="post('${deleteUrl}')">Delete</button>--%>
                        <button class="btn btn-danger"
                                onclick="post('${deleteUrl}')">Delete</button>
                    </td>
                    </td>
                </tr>

                </c:forEach>

            </table>

    </ul>
</c:if>

<script type="text/javascript">
    function alertName(){
        alert("Form has been submitted");
    }
</script>
</body>
</html>