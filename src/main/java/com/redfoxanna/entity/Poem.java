package com.redfoxanna.entity;

import jakarta.persistence.*;
import org.hibernate.annotations.GenericGenerator;

import java.sql.Timestamp;
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
    @Column(name="user_name")
    private String userName;

    @Column(name="poem_image")
    private String poemImage;
    @Column(name="created_at")
    private Timestamp createdAt;
    @ManyToMany(mappedBy = "poems")
    private Set<Genre> genres;


    /**
     * No arg constructor
     */
    public Poem() {
    }

    /**
     * Constructor for a poem with parameters
     */
    public Poem(String content, String poemImage, String userName) {
        this.content = content;
        this.poemImage = poemImage;
        this.userName = userName;

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
     * Gets the user name of poem author
     * @return the user's id
     */
    public String getUserName() {
        return userName;
    }

    /**
     * Sets the user's username
     * @param userName the userName referenced by cognito
     */
    public void setUser(String userName) {
        this.userName = userName;
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
     * Gives all poem variables and values
     * @return all the params
     */
    @Override
    public String toString() {
        return "Poem{" +
                "id=" + id +
                ", content='" + content + '\'' +
                ", poemImage='" + poemImage + '\'' +
                ", userName=" + userName +
                ", createdAt=" + createdAt +
                '}';
    }
}

