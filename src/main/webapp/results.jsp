<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<%@include file="head.jsp"%>

<script type="text/javascript" class="init">
    $(document).ready( function () {
        $('#userTable').DataTable();
    } );
</script>
<html>
<body>

<div class="container-fluid">
    <h2>Search Results: </h2>
    <table id="userTable" class="display" cellspacing="0" width="100%">
        <thead>
        <th>Name</th>
        <th>User Name</th>
        <th>Age</th>
        <th>Poems</th>
        </thead>
        <tbody>
        <c:forEach var="user" items="${users}">
            <tr>
                <td>${user.firstName} ${user.lastName}</td>
                <td>${user.userName}</td>
                <td>${user.age}</td>
                <td>
                    <ul>
                        <c:forEach var="poem" items="${user.poems}">
                            <li>${poem.content}</li>
                        </c:forEach>
                    </ul>
                </td>
            </tr>

        </c:forEach>
        </tbody>
    </table>
</div>

</body>
</html>