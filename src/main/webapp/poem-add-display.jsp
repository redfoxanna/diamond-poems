<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:import url="head.jsp" />
<html>
<c:import url="header.jsp" />
<body>
<h1>Add to the archives:</h1>
    <div class="container">
    <div class="row justify-content-center">
    <div class="col-md-6">
    <form>
    <div class="form-group">
    <label for="poemImage">Upload Poem Image</label>
    <input type="file" class="form-control-file" id="poemImage">
    </div>
    <div class="form-group">
    <label for="poemText">Enter Poem Text</label>
    <textarea class="form-control" id="poemText" rows="4"></textarea>
    </div>
    <div class="form-group">
    <label>Genres</label>
    <div class="form-check">
    <input class="form-check-input" type="checkbox" value="" id="genre1">
    <label class="form-check-label" for="genre1">
    Genre 1
    </label>
    </div>
    <!-- Add more checkboxes as needed -->
    <!-- Example: -->
    <div class="form-check">
    <input class="form-check-input" type="checkbox" value="" id="genre2">
    <label class="form-check-label" for="genre2">
    Genre 2
    </label>
    </div>
    <!-- Repeat this block to create more checkboxes -->
    </div>
    <button type="submit" class="btn btn-primary">Submit</button>
    </form>
    </div>
    </div>
    </div>
</body>
<c:import url="footer.jsp" />
</html>