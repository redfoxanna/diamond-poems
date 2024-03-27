<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!-- ======= Header ======= -->
<header id="header" class="fixed-top d-flex align-items-center">
    <div class="container d-flex align-items-center justify-content-between">
        <div class="logo">
            <h1 id=nav-logo class="text-light"><a href="${pageContext.request.contextPath}"><span>Diamond Poem Archives</span></a></h1>
            <!-- Uncomment below if you prefer to use an image logo -->
            <!-- <a href="index.html"><img src="assets/img/logo.png" alt="" class="img-fluid"></a>-->
        </div>
        <div class="flex-container" id="nav-container">
        <nav class="navbar">
            <ul>
                <li><a href="${pageContext.request.contextPath}">Home</a></li>
                <li><a href="${pageContext.request.contextPath}/poem-add-display">Upload Poem</a></li>
                <li><a href="${pageContext.request.contextPath}/poem-search-results">Search Archives</a></li>
                <li><a href="${pageContext.request.contextPath}/questions">FAQ</a></li>
                <c:choose>
                    <c:when test="${empty userName}">
                        <li><a class=getStarted href="${pageContext.request.contextPath}/logIn">Login</a></li>
                    </c:when>
                    <c:otherwise>
                        <li><a href="${pageContext.request.contextPath}/logOut">logout ${userName}</a></li>
                    </c:otherwise>
                </c:choose>
            </ul>
            <i class="bi bi-list mobile-nav-toggle"></i>
        </nav><!-- .navbar -->
        </div>
    </div>
</header><!-- End Header -->
