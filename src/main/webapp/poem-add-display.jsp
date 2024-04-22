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
                    <div class="row">
                        <div class="col-md-6">
                            <!-- First column of checkboxes -->
                            <div class="form-check">
                                <input class="form-check-input" type="checkbox" value="" id="genre1">
                                <label class="form-check-label" for="genre1">
                                    Love and Relationships
                                </label>
                            </div>
                            <div class="form-check">
                                <input class="form-check-input" type="checkbox" value="" id="genre2">
                                <label class="form-check-label" for="genre2">
                                    Nature and the Environment
                                </label>
                            </div>
                    <!-- Repeat this block to create more checkboxes -->
                    <div class="form-check">
                        <input class="form-check-input" type="checkbox" value="" id="genre3">
                        <label class="form-check-label" for="genre3">
                            Identity and Self-Discovery
                        </label>
                    </div>
                    <div class="form-check">
                        <input class="form-check-input" type="checkbox" value="" id="genre4">
                        <label class="form-check-label" for="genre4">
                            Loss and Grief
                        </label>
                    </div>
                    <div class="form-check">
                        <input class="form-check-input" type="checkbox" value="" id="genre5">
                        <label class="form-check-label" for="genre5">
                            Hope and Resilience
                        </label>
                    </div>
                    <div class="form-check">
                        <input class="form-check-input" type="checkbox" value="" id="genre6">
                        <label class="form-check-label" for="genre6">
                            Social Justice and Equality
                        </label>
                    </div>
                    <div class="form-check">
                        <input class="form-check-input" type="checkbox" value="" id="genre7">
                        <label class="form-check-label" for="genre7">
                            Dreams and Aspirations
                        </label>
                    </div>
                    <div class="form-check">
                        <input class="form-check-input" type="checkbox" value="" id="genre8">
                        <label class="form-check-label" for="genre8">
                            Time and Memories
                        </label>
                    </div>
                    <div class="form-check">
                        <input class="form-check-input" type="checkbox" value="" id="genre9">
                        <label class="form-check-label" for="genre9">
                            Spirituality and Transcendence
                        </label>
                    </div>
                    <div class="form-check">
                        <input class="form-check-input" type="checkbox" value="" id="genre10">
                        <label class="form-check-label" for="genre10">
                            Transformation and Growth
                        </label>
                    </div>
                    <div class="form-check">
                        <input class="form-check-input" type="checkbox" value="" id="genre11">
                        <label class="form-check-label" for="genre11">
                            Adult Content
                        </label>
                    </div>
                    <div class="form-check">
                        <input class="form-check-input" type="checkbox" value="" id="genre12">
                        <label class="form-check-label" for="genre12">
                            Thought-Provoking
                        </label>
                    </div>
                    <div class="form-check">
                        <input class="form-check-input" type="checkbox" value="" id="genre13">
                        <label class="form-check-label" for="genre13">
                            Profane
                        </label>
                    </div>
                        </div>
                        <div class="col-md-6">
                            <!-- Second column of checkboxes -->
                            <div class="form-check">
                                <input class="form-check-input" type="checkbox" value="" id="genre14">
                                <label class="form-check-label" for="genre14">
                                    Joyful
                                </label>
                            </div>
                    <div class="form-check">
                        <input class="form-check-input" type="checkbox" value="" id="genre15">
                        <label class="form-check-label" for="genre15">
                            Melancholic
                        </label>
                    </div>
                    <div class="form-check">
                        <input class="form-check-input" type="checkbox" value="" id="genre16">
                        <label class="form-check-label" for="genre16">
                            Reflective
                        </label>
                    </div>
                    <div class="form-check">
                        <input class="form-check-input" type="checkbox" value="" id="genre17">
                        <label class="form-check-label" for="genre17">
                            Serene
                        </label>
                    </div>
                    <div class="form-check">
                        <input class="form-check-input" type="checkbox" value="" id="genre18">
                        <label class="form-check-label" for="genre18">
                            Mysterious
                        </label>
                    </div>
                    <div class="form-check">
                        <input class="form-check-input" type="checkbox" value="" id="genre19">
                        <label class="form-check-label" for="genre19">
                            Playful
                        </label>
                    </div>
                    <div class="form-check">
                        <input class="form-check-input" type="checkbox" value="" id="genre20">
                        <label class="form-check-label" for="genre20">
                            Nostalgic
                        </label>
                    </div>
                    <div class="form-check">
                        <input class="form-check-input" type="checkbox" value="" id="genre21">
                        <label class="form-check-label" for="genre21">
                            Sweet
                        </label>
                    </div>
                    <div class="form-check">
                        <input class="form-check-input" type="checkbox" value="" id="genre22">
                        <label class="form-check-label" for="genre22">
                            Empathetic
                        </label>
                    </div>
                    <div class="form-check">
                        <input class="form-check-input" type="checkbox" value="" id="genre23">
                        <label class="form-check-label" for="genre23">
                            Eerie
                        </label>
                    </div>
                    <div class="form-check">
                        <input class="form-check-input" type="checkbox" value="" id="genre24">
                        <label class="form-check-label" for="genre24">
                            Dark
                        </label>
                    </div>
                    <div class="form-check">
                        <input class="form-check-input" type="checkbox" value="" id="genre25">
                        <label class="form-check-label" for="genre25">
                            Inappropriate
                        </label>
                    </div>
                    <div class="form-check">
                        <input class="form-check-input" type="checkbox" value="" id="genre26">
                        <label class="form-check-label" for="genre26">
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
