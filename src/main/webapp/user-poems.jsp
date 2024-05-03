<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<c:set var="title" value="Poem Edit" />
<c:import url="head.jsp" />

<html>
<c:import url="header.jsp" />

<body>
    <div class="container-fluid">
        <h2>User Poems</h2>
        <table id="poemTable" class="display">
            <thead>
            <tr>
                <th>Created</th>
                <th>Content</th>
                <th>Actions</th>
            </tr>
            </thead>
            <tbody>
            <c:forEach var="poem" items="${userPoems}">
                <tr>
                    <td>${poem.createdAt}</td>
                    <td>${poem.content}</td>
                    <td>
                        <a href="edit-poem.jsp?poemId=${poem.id}">Edit</a>
                        <a href="delete-poem?id=${poem.id}">Delete</a>
                    </td>
                </tr>
            </c:forEach>
            </tbody>
        </table>
    </div>
</body>
<c:import url="footer.jsp" />
</html>