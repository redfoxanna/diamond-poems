<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:import url="head.jsp" />
<html>
<c:import url="header.jsp" />
<body>
<div class="container">
    <div class="row justify-content-center">
        <div class="col-md-6">
            <form>
                <h1>Upload a Poem:</h1>
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
                            Love and relationships
                        </label>
                    </div>
                    <!-- Add more checkboxes as needed -->
                    <!-- Example: -->
                    <div class="form-check">
                        <input class="form-check-input" type="checkbox" value="" id="genre2">
                        <label class="form-check-label" for="genre2">
                            Nature and the environment
                        </label>
                    </div>
                    <!-- Repeat this block to create more checkboxes -->
                    <div class="form-check">
                        <input class="form-check-input" type="checkbox" value="" id="genre3">
                        <label class="form-check-label" for="genre3">
                            Identity and self-discovery
                        </label>
                    </div>
                    <div class="form-check">
                        <input class="form-check-input" type="checkbox" value="" id="genre4">
                        <label class="form-check-label" for="genre4">
                            Loss and grief
                        </label>
                    </div>
                    <div class="form-check">
                        <input class="form-check-input" type="checkbox" value="" id="genre5">
                        <label class="form-check-label" for="genre5">
                            Hope and resilience
                        </label>
                    </div>
                    <div class="form-check">
                        <input class="form-check-input" type="checkbox" value="" id="genre6">
                        <label class="form-check-label" for="genre6">
                            Social justice and equality
                        </label>
                    </div>
                    <div class="form-check">
                        <input class="form-check-input" type="checkbox" value="" id="genre7">
                        <label class="form-check-label" for="genre7">
                            Dreams and aspirations
                        </label>
                    </div>
                    <div class="form-check">
                        <input class="form-check-input" type="checkbox" value="" id="genre8">
                        <label class="form-check-label" for="genre8">
                            Time and memories
                        </label>
                    </div>
                    <div class="form-check">
                        <input class="form-check-input" type="checkbox" value="" id="genre9">
                        <label class="form-check-label" for="genre9">
                            Spirituality and transcendence
                        </label>
                    </div>
                    <div class="form-check">
                        <input class="form-check-input" type="checkbox" value="" id="genre10">
                        <label class="form-check-label" for="genre10">
                            Transformation and growth
                        </label>
                    </div>
                </div>
                <div class="form-group">
                    <label>Moods</label>
                    <div class="form-check">
                        <input class="form-check-input" type="checkbox" value="" id="mood1">
                        <label class="form-check-label" for="mood1">
                            Joyful
                        </label>
                    </div>
                    <div class="form-check">
                        <input class="form-check-input" type="checkbox" value="" id="mood2">
                        <label class="form-check-label" for="mood2">
                            Melancholic
                        </label>
                    </div>
                    <div class="form-check">
                        <input class="form-check-input" type="checkbox" value="" id="mood3">
                        <label class="form-check-label" for="mood3">
                            Reflective
                        </label>
                    </div>
                    <div class="form-check">
                        <input class="form-check-input" type="checkbox" value="" id="mood4">
                        <label class="form-check-label" for="mood4">
                            Serene
                        </label>
                    </div>
                    <div class="form-check">
                        <input class="form-check-input" type="checkbox" value="" id="mood5">
                        <label class="form-check-label" for="mood5">
                            Mysterious
                        </label>
                    </div>
                    <div class="form-check">
                        <input class="form-check-input" type="checkbox" value="" id="mood6">
                        <label class="form-check-label" for="mood6">
                            Playful
                        </label>
                    </div>
                    <div class="form-check">
                        <input class="form-check-input" type="checkbox" value="" id="mood7">
                        <label class="form-check-label" for="mood7">
                            Nostalgic
                        </label>
                    </div>
                    <div class="form-check">
                        <input class="form-check-input" type="checkbox" value="" id="mood8">
                        <label class="form-check-label" for="mood8">
                            Empathetic
                        </label>
                    </div>
                    <div class="form-check">
                        <input class="form-check-input" type="checkbox" value="" id="mood9">
                        <label class="form-check-label" for="mood9">
                            Eerie
                        </label>
                    </div>
                    <div class="form-check">
                        <input class="form-check-input" type="checkbox" value="" id="mood10">
                        <label class="form-check-label" for="mood10">
                            Inspirational
                        </label>
                    </div>
                </div>
                <button type="submit" class="btn btn-primary">Submit</button>
            </form>
        </div>
    </div>
</div>
</body>
<c:import url="footer.jsp" />
</html>
