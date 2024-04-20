package com.redfoxanna.entity;

import jakarta.persistence.*;
import org.hibernate.annotations.GenericGenerator;

import java.util.HashSet;
import java.util.Objects;
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
    private Set<PoemGenre> poems = new HashSet<PoemGenre>();

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

    /**
     * Gets poems.
     *
     * @return the poems
     */
    public Set<PoemGenre> getPoems() {
        return poems;
    }

    /**
     * Sets poems.
     *
     * @param poems the poems
     */
    public void setPoems(Set<PoemGenre> poems) {
        this.poems = poems;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Genre genre = (Genre) o;
        return id == genre.id && Objects.equals(genreName, genre.genreName) && Objects.equals(poems, genre.poems);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, genreName, poems);
    }
}