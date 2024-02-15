package com.redfoxanna.entity;

import jakarta.persistence.*;
import org.hibernate.annotations.GenericGenerator;

import java.time.LocalDate;


/**
 * The type User.
 *
 * @author akessler
 */
@Entity
@Table(name = "user") // case sensitive!
public class User {
    @Column(name = "first_name")
    private String firstName;

    @Column(name = "last_name")
    private String lastName;

    @Column(name = "user_name")
    private String userName;

    @Column(name="user_status")
    private String userStatus;

    @Column(name = "user_email")
    private String userEmail;

    @Column(name = "birthdate")
    private String dateOfBirth;

    // Every Entity must have a unique identifier which is annotated @Id
    // Notice there is no @Column here as the column and instance variable name are the same
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO, generator="native")
    @GenericGenerator(name = "native",strategy = "native")
    private int id;

    /**
     * Zero-arg constructor that instantiates a new User.
     */
    public User() {
    }

    /**
     * Instantiates a new User with parameters
     *
     * @param firstName the first name
     * @param lastName  the last name
     * @param userName  the username
     * @param userStatus the user's status
     * @param userEmail the user's email address
     * @param dateOfBirth the user's birthdate
     */
    public User(String firstName, String lastName, String userName, String userStatus, String userEmail, String dateOfBirth) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.userName = userName;
        this.userStatus = userStatus;
        this.userEmail = userEmail;
        this.dateOfBirth = dateOfBirth;
    }


    /**
     * Gets first name.
     *
     * @return the first name
     */
    public String getFirstName() {
        return firstName;
    }

    /**
     * Sets first name.
     *
     * @param firstName the first name
     */
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    /**
     * Gets last name.
     *
     * @return the last name
     */
    public String getLastName() {
        return lastName;
    }

    /**
     * Sets last name.
     *
     * @param lastName the last name
     */
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    /**
     * Gets username.
     *
     * @return the username
     */
    public String getUserName() {
        return userName;
    }

    /**
     * Sets username.
     *
     * @param userName the username
     */
    public void setUserName(String userName) {
        this.userName = userName;
    }

    /**
     * Gets user id
     *
     * @return the user id
     */
    public int getId() {
        return id;
    }

    /**
     * Sets user id
     * @param id the user id
     */
    public void seId(int id) {this.id = id;}

    /**
     * Gets user's status.
     *
     * @return the user's status
     */
    public String getUserStatus() {
        return userStatus;
    }

    /**
     * Sets user's status
     *
     * @param userStatus the user's status
     */
    public void setUserStatus(String userStatus) {
        this.userStatus = userStatus;
    }

    /**
     * Gets user's email
     * @return the user's email
     */
    public String getUserEmail() {
        return userEmail;
    }

    /**
     * Sets user's email
     * @param userEmail the user's email
     */
    public void setUserEmail(String userEmail) {
        this.userEmail = userEmail;
    }


    /**
     * Gets date of birth.
     *
     * @return the date of birth
     */
    public String getDateOfBirth() {
        return dateOfBirth;
    }

    /**
     * Sets date of birth.
     *
     * @param dateOfBirth the date of birth
     */
    public void setDateOfBirth(String dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    /**
     * Returns all values formatted
     * @return the User instance variables with values
     */
    @Override
    public String toString() {
        return "User{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", userName='" + userName + '\'' +
                ", userStatus='" + userStatus + '\'' +
                ", userEmail='" + userEmail + '\'' +
                ", birthdate='" + dateOfBirth + '\'' +
                ", userId='" + id +
                '}';
    }
}




