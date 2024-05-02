<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:import url="head.jsp" />
<html>
<c:import url="header.jsp" />
<body>
<div class="container">
    <h1>Upload a Poem:</h1>
    <div class="row">
            <form id="new-poem" action="poem-add" method="post" enctype="multipart/form-data">

                <div class="form-group">
                    <h2>Step 1:</h2>
                    <label for="poemImage">Upload Poem Image</label>
                    <input type="file" class="form-control-file" id="poemImage" name="poemImage">
                </div>

                <div class="form-group">
                    <h2>Step 2:</h2>
                    <label>Select Genres (check all that apply)</label>
                    <div class="row">
                        <div class="col-md-6">
                            <!-- First column of checkboxes -->
                            <div class="form-check">
                                <input class="form-check-input" type="checkbox" value="1" id="genre1" name="selectedGenres">
                                <label class="form-check-label" for="genre1">
                                    Love and Relationships
                                </label>
                            </div>
                            <div class="form-check">
                                <input class="form-check-input" type="checkbox" value="2" id="genre2" name="selectedGenres">
                                <label class="form-check-label" for="genre2">
                                    Nature and the Environment
                                </label>
                            </div>
                    <!-- Repeat this block to create more checkboxes -->
                    <div class="form-check">
                        <input class="form-check-input" type="checkbox" value="3" id="genre3" name="selectedGenres">
                        <label class="form-check-label" for="genre3">
                            Identity and Self-Discovery
                        </label>
                    </div>
                    <div class="form-check">
                        <input class="form-check-input" type="checkbox" value="4" id="genre4" name="selectedGenres">
                        <label class="form-check-label" for="genre4">
                            Loss and Grief
                        </label>
                    </div>
                    <div class="form-check">
                        <input class="form-check-input" type="checkbox" value="5" id="genre5" name="selectedGenres">
                        <label class="form-check-label" for="genre5">
                            Hope and Resilience
                        </label>
                    </div>
                    <div class="form-check">
                        <input class="form-check-input" type="checkbox" value="6" id="genre6" name="selectedGenres">
                        <label class="form-check-label" for="genre6">
                            Social Justice and Equality
                        </label>
                    </div>
                    <div class="form-check">
                        <input class="form-check-input" type="checkbox" value="7" id="genre7" name="selectedGenres">
                        <label class="form-check-label" for="genre7">
                            Dreams and Aspirations
                        </label>
                    </div>
                    <div class="form-check">
                        <input class="form-check-input" type="checkbox" value="8" id="genre8" name="selectedGenres">
                        <label class="form-check-label" for="genre8">
                            Time and Memories
                        </label>
                    </div>
                    <div class="form-check">
                        <input class="form-check-input" type="checkbox" value="9" id="genre9" name="selectedGenres">
                        <label class="form-check-label" for="genre9">
                            Spirituality and Transcendence
                        </label>
                    </div>
                    <div class="form-check">
                        <input class="form-check-input" type="checkbox" value="10" id="genre10" name="selectedGenres">
                        <label class="form-check-label" for="genre10">
                            Transformation and Growth
                        </label>
                    </div>
                    <div class="form-check">
                        <input class="form-check-input" type="checkbox" value="11" id="genre11" name="selectedGenres">
                        <label class="form-check-label" for="genre11">
                            Adult Content
                        </label>
                    </div>
                    <div class="form-check">
                        <input class="form-check-input" type="checkbox" value="12" id="genre12" name="selectedGenres">
                        <label class="form-check-label" for="genre12">
                            Thought-Provoking
                        </label>
                    </div>
                    <div class="form-check">
                        <input class="form-check-input" type="checkbox" value="13" id="genre13" name="selectedGenres">
                        <label class="form-check-label" for="genre13">
                            Profane
                        </label>
                    </div>
                        </div>
                        <div class="col-md-6">
                            <!-- Second column of checkboxes -->
                            <div class="form-check">
                                <input class="form-check-input" type="checkbox" value="14" id="genre14" name="selectedGenres">
                                <label class="form-check-label" for="genre14">
                                    Joyful
                                </label>
                            </div>
                    <div class="form-check">
                        <input class="form-check-input" type="checkbox" value="15" id="genre15" name="selectedGenres">
                        <label class="form-check-label" for="genre15">
                            Melancholic
                        </label>
                    </div>
                    <div class="form-check">
                        <input class="form-check-input" type="checkbox" value="16" id="genre16" name="selectedGenres">
                        <label class="form-check-label" for="genre16">
                            Reflective
                        </label>
                    </div>
                    <div class="form-check">
                        <input class="form-check-input" type="checkbox" value="17" id="genre17" name="selectedGenres">
                        <label class="form-check-label" for="genre17">
                            Serene
                        </label>
                    </div>
                    <div class="form-check">
                        <input class="form-check-input" type="checkbox" value="18" id="genre18" name="selectedGenres">
                        <label class="form-check-label" for="genre18">
                            Mysterious
                        </label>
                    </div>
                    <div class="form-check">
                        <input class="form-check-input" type="checkbox" value="19" id="genre19" name="selectedGenres">
                        <label class="form-check-label" for="genre19">
                            Playful
                        </label>
                    </div>
                    <div class="form-check">
                        <input class="form-check-input" type="checkbox" value="20" id="genre20" name="selectedGenres">
                        <label class="form-check-label" for="genre20">
                            Nostalgic
                        </label>
                    </div>
                    <div class="form-check">
                        <input class="form-check-input" type="checkbox" value="21" id="genre21" name="selectedGenres">
                        <label class="form-check-label" for="genre21">
                            Sweet
                        </label>
                    </div>
                    <div class="form-check">
                        <input class="form-check-input" type="checkbox" value="22" id="genre22" name="selectedGenres">
                        <label class="form-check-label" for="genre22">
                            Empathetic
                        </label>
                    </div>
                    <div class="form-check">
                        <input class="form-check-input" type="checkbox" value="23" id="genre23" name="selectedGenres">
                        <label class="form-check-label" for="genre23">
                            Eerie
                        </label>
                    </div>
                    <div class="form-check">
                        <input class="form-check-input" type="checkbox" value=24"" id="genre24" name="selectedGenres">
                        <label class="form-check-label" for="genre24">
                            Dark
                        </label>
                    </div>
                    <div class="form-check">
                        <input class="form-check-input" type="checkbox" value="25" id="genre25" name="selectedGenres">
                        <label class="form-check-label" for="genre25">
                            Inappropriate
                        </label>
                    </div>
                    <div class="form-check">
                        <input class="form-check-input" type="checkbox" value="26" id="genre26" name="selectedGenres">
                        <label class="form-check-label" for="genre26">
                            Inspirational
                        </label>
                    </div>
                </div>
                <button type="submit" class="btn btn-primary">Submit</button>
                    </div>
                </div>
            </form>
        </div>
    </div>
</body>
<c:import url="footer.jsp" />
</html>
