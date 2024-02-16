package com.redfoxanna.entity;

import jakarta.persistence.*;
import org.hibernate.annotations.GenericGenerator;

import java.sql.Timestamp;
import java.util.List;

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
    private String poemImage; // TODO: How handle images?
    @ManyToOne
    private User user = new User();
    @Column(name="created_at")
    private Timestamp createdAt;
    @Column(name="poem_tags")
    private String genreTags;

    /**
     * No arg constructor
     */
    public Poem() {
    }

    /**
     * Constructor for a poem with parameters
     */
    public Poem(String content, String poemImage, Timestamp createdAt, String genreTags) {
        this.content = content;
        this.poemImage = poemImage;
        this.createdAt = createdAt;
        this.genreTags = genreTags;
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
     * Gets the user id of poem author
     * @return the user's id
     */
    public User getUser() {
        return user;
    }

    /**
     * Sets the user's id
     * @param user the user object
     */
    public void setUser(User user) {
        this.user = user;
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
     * Sets created at.
     *
     * @param createdAt the created at
     */
    public void setCreatedAt(Timestamp createdAt) {
        this.createdAt = createdAt;
    }

    /**
     * Gets the poem's genre tags
     *
     * @return the genre tags for the poem
     */
    public String getGenreTags() {
        return genreTags;
    }

    /**
     * Set the genre tags
     *
     * @param genreTags the genre tags
     */
    public void setGenreTags(String genreTags) {
        this.genreTags = genreTags;
    }

    /**
     * Gives all poem variables and values
     * @return all the params
     */
    @Override
    public String toString() {
        return "Poem{" +
                "id=" + id +
                ", content='" + content + '\'' +
                ", poemImage='" + poemImage + '\'' +
                ", userId=" + user +
                ", createdAt=" + createdAt +
                ", genreTags='" + genreTags + '\'' +
                '}';
    }
}

