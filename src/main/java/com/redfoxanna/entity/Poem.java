package com.redfoxanna.entity;

import jakarta.persistence.*;
import org.hibernate.annotations.GenericGenerator;

import java.sql.Timestamp;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

/**
 * The Poem class
 *
 * @author redfoxanna
 */
@Entity(name="Poem")
@Table(name = "poem")
public class Poem {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "native")
    @GenericGenerator(name = "native")
    private int id;
    @Column(name="poem_content")
    private String content;
    @Column(name="poem_image")
    private String poemImage;
    @Column(name="created_at")
    private Timestamp createdAt;
    @OneToMany(mappedBy = "poem", fetch = FetchType.EAGER)
    private Set<PoemGenre> genres = new HashSet<>();

    /**
     * No arg constructor
     */
    public Poem() {
    }

    /**
     * Constructor for a poem with parameters
     */
    public Poem(String content, String poemImage) {
        this.content = content;
        this.poemImage = poemImage;
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
     * Gets content.
     *
     * @return the content
     */
    public String getContent() {
        return content;
    }

    /**
     * Sets content.
     *
     * @param content the content
     */
    public void setContent(String content) {
        this.content = content;
    }

    /**
     * Gets poem image.
     *
     * @return the poem image
     */
    public String getPoemImage() {
        return poemImage;
    }

    /**
     * Sets poem image.
     *
     * @param poemImage the poem image
     */
    public void setPoemImage(String poemImage) {
        this.poemImage = poemImage;
    }

    /**
     * Gets created at.
     *
     * @return the created at
     */
    public Timestamp getCreatedAt() {
        return createdAt;
    }

    /**
     * Gets genres.
     *
     * @return the genres
     */
    public Set<PoemGenre> getGenres() {
        return genres;
    }

    /**
     * Sets genres.
     *
     * @param genres the genres
     */
    public void setGenres(Set<PoemGenre> genres) {
        this.genres = genres;
    }

    @Override
    public String toString() {
        return "Poem{" +
                "id=" + id +
                ", content='" + content + '\'' +
                ", poemImage='" + poemImage + '\'' +
                ", createdAt=" + createdAt +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Poem poem = (Poem) o;
        return id == poem.id && Objects.equals(content, poem.content) && Objects.equals(poemImage, poem.poemImage) && Objects.equals(createdAt, poem.createdAt);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, content, poemImage, createdAt);
    }
}

