<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<c:set var="title" value="Poem Edit" />
<c:import url="head.jsp" />

<html>
<c:import url="header.jsp" />

<body>
<div class="container-fluid">
    <h2>Poem added to archives:</h2>
    <c:if test="${not empty newPoem}">
        <form action="poem-edit" method="post">
            <!-- Hidden input field to send the poemId -->
            <input type="hidden" name="poemId" value="${newPoem.id}">
            <div class="form-group">
                <label for="poemContent">Edit poem below for errors:</label><br>
                <textarea class="form-control" id="poemContent" name="poemContent" rows="10" cols="50">${newPoem.content}</textarea>
            </div>
            <br>
            <button type="submit" class="btn btn-primary">Update Poem</button>
        </form>
    </c:if>
</div>
</body>

<c:import url="footer.jsp" />
</html>
