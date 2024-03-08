<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:import url="head.jsp">
<html>
<c:import url="header.jsp">
<body>
<section id="search-archives" class="d-flex align-items-center">
    <form action="searchPoem" class="form-inline">
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
<c:import url="footer.jsp">
</html>