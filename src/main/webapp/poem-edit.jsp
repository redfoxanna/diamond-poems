<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<c:set var="title" value="Poem Edit" />
<c:import url="head.jsp" />

<html>
<c:import url="header.jsp" />

<body>
<div class="container-fluid">
    <h2>Edit Poem:</h2>
    <c:if test="${not empty poem}">
        <form action="poem-edit" method="post">
            <!-- Hidden input field to send the poemId -->
            <input type="hidden" name="poemId" value="${poem.id}">
            <div class="form-group">
                <label for="poemContent">Edit poem below for errors:</label><br>
                <textarea class="form-control" id="poemContent" name="poemContent" rows="10" cols="50">${poem.content}</textarea>
            </div>
            <!-- TODO you need to add a way here for the user to edit/add genres if they want to  -->
            <br>
            <button type="submit" class="btn btn-primary">Update Poem</button>
        </form>
    </c:if>
</div>
</body>

<c:import url="footer.jsp" />
</html>
