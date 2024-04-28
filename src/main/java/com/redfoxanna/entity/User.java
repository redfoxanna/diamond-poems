    package com.redfoxanna.entity;

    import jakarta.persistence.*;
    import org.hibernate.annotations.GenericGenerator;

    import java.util.*;

    /**
     * Represents a user/author of the poem
     */
    @Entity(name = "User")
    @Table(name = "user")
    public class User {
        @Id
        @GeneratedValue(strategy = GenerationType.AUTO, generator = "native")
        @GenericGenerator(name = "native", strategy = "native")
        private int id;
        @Column(name = "user_name")
        private String userName;

        // TODO if I delete a user I probably don't want to delete the poems...
        @OneToMany(mappedBy = "user", cascade = CascadeType.ALL, orphanRemoval = false, fetch = FetchType.EAGER)
        private Set<Poem> userPoems = new HashSet<>();

        /**
         * Empty constructor to instantiate a new User
         */
        public User() {
        }

        /**
         * Instantiates a new User with username param
         *
         * @param userName the username
         */
        public User(String userName) {
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
         * Gets poem
         *
         * @return the poems associated with the user
         */
        public Set<Poem> getUserPoems() {
            return userPoems;
        }

        /**
         * Sets poem
         *
         * @param userPoems poems for the user
         */
        public void setUserPoems(Set<Poem> userPoems) {
            this.userPoems = userPoems;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            User user = (User) o;
            return id == user.id && Objects.equals(userName, user.userName) && Objects.equals(userPoems, user.userPoems);
        }

        @Override
        public int hashCode() {
            return Objects.hash(id, userName, userPoems);
        }
    }