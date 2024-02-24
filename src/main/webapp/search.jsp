<%@include file="head.jsp"%>
<html>
<%@include file="header.jsp"%>
<body>
<section id="search-archives" class="d-flex align-items-center">
    <form action="searchUser" class="form-inline">
        <h2>Search Archives</h2>
        <div class="form-group">
            <label for="searchTerm">Search Archives</label>
            <input type="text" class="form-control" id="searchTerm" name="searchTerm" aria-describedby="searchTermHelp" placeholder="Enter search term">
        </div>
        <button type="submit" name="submit" value="search">Search</button>
        <button type="submit" name="submit" value="viewAll">View all</button>
    </form>
</section>

</body>
</html>
