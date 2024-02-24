<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<c:set var="title" value="Search Results" />
<%@include file="head.jsp"%>

<script type="text/javascript" class="init">
    $(document).ready( function () {
        $('#userTable').DataTable();
    } );
</script>
<html>
<%@include file="header.jsp"%>
<body>

<div class="container-fluid">
    <h2>Search Results: </h2>
    <table id="userTable" class="display">
        <thead>
        <th>Name</th>
        <th>User Name</th>
        <th>Poems</th>
        </thead>
        <tbody>
        <c:forEach var="user" items="${users}">
            <tr>
                <td>${user.firstName} ${user.lastName}</td>
                <td>${user.userName}</td>
                <td>Poems should go here</td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
</div>

</body>
</html>