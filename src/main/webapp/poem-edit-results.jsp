<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<c:set var="title" value="Edit Results" />
<c:import url="head.jsp" />

<script type="text/javascript" class="init">
    $(document).ready( function () {
        $('#poemTable').DataTable();
    } );
</script>

<html>
<c:import url="header.jsp" />
<body>

<div class="container-fluid">
    <h2>Edit Results:</h2>
    <table id="poemTable" class="display">
        <thead>
        <th>Created at</th>
        <th>Poem</th>
        <th>Upload by</th>
        </thead>
        <tbody>
        <tr>
            <td>${newPoemEdit.createdAt}</td>
            <td>${newPoemEdit.content}</td>
            <td>${newPoemEdit.user.userName}</td>
        </tr>
        </tbody>
    </table>
</div>

</body>
<c:import url="footer.jsp" />
</html>