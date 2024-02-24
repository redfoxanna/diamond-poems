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
                    <a href="${pageContext.request.contextPath}/poem-search" class="btn-get-started scrollto">Search Archives</a>
                </div>
            </div>
            <div class="col-lg-6">
                <img  class="img-responsive" src="images/letters.png" alt="colorful letters">
            </div>
        </div>
    </div>

</section><!-- End Hero -->
</body>
</html>