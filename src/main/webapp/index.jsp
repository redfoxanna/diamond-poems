<%@include file="head.jsp"%>
<html>
<%@include file="header.jsp"%>
<body>
<h2>Diamond Poem Archives</h2>
<form action="searchUser" class="form-inline">
    <div class="form-group">
        <label for="searchTerm">Search Archives</label>
        <input type="text" class="form-control" id="searchTerm" name="searchTerm" aria-describedby="searchTermHelp" placeholder="Enter search term">
    </div>
    <button type="submit" name="submit" value="search" class="btn btn-primary">Search</button>
    <button type="submit" name="submit" value="viewAll" class="btn btn-primary">View all</button>
</form>
</body>
</html>