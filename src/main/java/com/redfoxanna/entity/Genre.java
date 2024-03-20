package com.redfoxanna.entity;

/**
 * The type Poem genre.
 *
 * @author redfoxanna
 */
public class PoemGenre {
    private String genreName;

    /**
     * Instantiates a new Poem genre.
     *
     * @param genreName the genre name
     */
    public PoemGenre(String genreName) {
        this.genreName = genreName;
    }

    /**
     * Gets genre name.
     *
     * @return the genre name
     */
    public String getGenreName() {
        return genreName;
    }

    /**
     * Sets genre name.
     *
     * @param genreName the genre name
     */
    public void setGenreName(String genreName) {
        this.genreName = genreName;
    }
}
