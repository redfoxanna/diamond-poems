package com.redfoxanna.entity;

import jakarta.persistence.*;
import org.hibernate.annotations.GenericGenerator;

import java.io.Serializable;

/**
 * The type Poem genre.
 */
@Entity(name = "PoemGenre")
@Table(name = "poem_genre")
public class PoemGenre implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "native")
    @GenericGenerator(name = "native")
    private int id;

    @Id
    @ManyToOne
    @JoinColumn(name = "poem", referencedColumnName = "id")
    private Poem poem;

    @Id
    @ManyToOne
    @JoinColumn(name = "genre", referencedColumnName = "id")
    private Genre genre;

    /**
     * Instantiates a new Poem genre.
     */
    public PoemGenre() {

    }

    /**
     * Instantiates a new PoemGenre with params
     *
     * @param poem  the poem
     * @param genre the genre
     */
    public PoemGenre(Poem poem, Genre genre) {
        this.poem = poem;
        this.genre = genre;
    }

    /**
     * Gets id.
     *
     * @return the id
     */
    public int getId() {
        return id;
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
     * Gets poem.
     *
     * @return the poem
     */
    public Poem getPoem() {
        return poem;
    }

    /**
     * Sets poem.
     *
     * @param poem the poem
     */
    public void setPoem(Poem poem) {
        this.poem = poem;
    }

    /**
     * Gets genre.
     *
     * @return the genre
     */
    public Genre getGenre() {
        return genre;
    }

    /**
     * Sets genre.
     *
     * @param genre the genre
     */
    public void setGenre(Genre genre) {
        this.genre = genre;
    }
}
