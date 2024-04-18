package com.redfoxanna.entity;

import jakarta.persistence.*;
import org.hibernate.annotations.GenericGenerator;

import java.io.Serializable;
import java.util.Objects;

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
    @JoinColumn(name = "poem_id", referencedColumnName = "id")
    private Poem poem;

    @Id
    @ManyToOne
    @JoinColumn(name = "genre_id", referencedColumnName = "id")
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PoemGenre poemGenre = (PoemGenre) o;
        return id == poemGenre.id && Objects.equals(poem, poemGenre.poem) && Objects.equals(genre, poemGenre.genre);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, poem, genre);
    }
}
