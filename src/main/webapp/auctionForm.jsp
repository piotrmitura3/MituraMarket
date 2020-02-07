<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<body>
<h2>Adding auction</h2>
<hr/>
<form:form method="post" modelAttribute="auctionDetails">
    <table>
        <%--<tr>
            <td><form:label path="id">Id</form:label></td>
            <td><form:input path="id" /></td>
        </tr>--%>
        <tr>
            <td><form:label path="title">Title</form:label></td>
            <td><form:input path="title"/></td>
        </tr>
        <tr>
            <td><form:label path="description">Description</form:label></td>
            <td><form:input path="description"/></td>
        </tr>
        <%--<tr>
            <td><form:label path="user">User</form:label> </td>
            <td><form:select path="user">
            <form:option value="${user.get(0)}"/>
            <form:option value="${user.get(1)}"/>
            </form:select>
        </tr>--%>
        <tr>
            <td><form:label path="price">Price</form:label></td>
            <td><form:input path="price"/></td>
        </tr>
        <tr>
            <td><form:label path="startDate">Start date</form:label></td>
            <td><form:input path="startDate"/></td>
        </tr>
        <tr>
            <td><form:label path="endDate">End date</form:label></td>
            <td><form:input path="endDate"/></td>
        </tr>
        <tr>
            <td colspan="2"><input type="submit" value="Add auction"/></td>
        </tr>
    </table>
</form:form>
</body>
</html>