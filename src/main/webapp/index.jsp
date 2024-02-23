<%@include file="head.jsp"%>
<html>
<%@include file="header.jsp"%>
<body>
<!-- ======= Hero Section ======= -->
<section id="hero" class="d-flex align-items-center">

    <div class="container">
        <div class="row gy-4">
            <div class="col-lg-6 order-2 order-lg-1 d-flex flex-column justify-content-center">
                <h1>Diamond Poem Archives</h1>
                <h2>Memorializing Diamond Poems</h2>
                <div>
                    <a href="#about" class="btn-get-started scrollto">Get Started</a>
                </div>
            </div>
            <div class="col-lg-6">
                <img  class="img-responsive" src="images/letters.png" alt="colorful letters">
            </div>
        </div>
    </div>

</section><!-- End Hero -->
<br/>
<h2>Search Archives</h2>
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