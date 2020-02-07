<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<body>
<h2>Modify Auction</h2>
<form:form method="post" modelAttribute="modificate" var="auction" items="${auctions}">
    <table>

        <tr>
            <td><form:label path="title">Title</form:label></td>
            <td><form:input type="text" path="title" value="${auction.title}"/></td>
        </tr>

    </table>


</form:form>
</body>
</html>
