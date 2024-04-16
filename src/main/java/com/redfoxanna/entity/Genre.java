package com.redfoxanna.entity;

import jakarta.persistence.*;
import org.hibernate.annotations.GenericGenerator;

import java.util.HashSet;
import java.util.Set;

/**
 * The type Poem genre.
 *
 * @author redfoxanna
 */
@Entity(name = "Genre")
@Table(name = "genre")
public class Genre {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "native")
    @GenericGenerator(name = "native")
    private int id;

    @Column(name = "genre_name")
    private String genreName;

    @OneToMany(mappedBy = "genre", fetch = FetchType.EAGER)
    private Set<PoemGenre> genres = new HashSet<PoemGenre>();

    /**
     * Instantiates a new genre with parameter.
     *
     * @param genreName the genre name
     */
    public Genre(String genreName) {
        this.genreName = genreName;
    }

    /**
     * Instantiates a new Genre.
     */
    public Genre() {

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

    /**
     * Sets id.
     *
     * @param id the id
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * Gets id.
     *
     * @return the id
     */
    public int getId() {
        return id;
    }
}
