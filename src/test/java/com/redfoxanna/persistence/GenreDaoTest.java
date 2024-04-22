package com.redfoxanna.persistence;

import com.redfoxanna.entity.Genre;
import com.redfoxanna.entity.Genre;
import com.redfoxanna.entity.PoemGenre;
import com.redfoxanna.util.Database;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;


import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class GenreDaoTest {

    GenericDao<Genre> genreDao;
    private final Logger logger = LogManager.getLogger(this.getClass());

    @BeforeEach
    void setUp() {
        genreDao = new GenericDao<>(Genre.class);
        Database database = Database.getInstance();
        database.runSQL("cleanDB.sql");
    }

    @Test
    void getAll() {
        List<Genre> genres = genreDao.getAll();
        assertNotNull(genres);
        assertEquals(26, genres.size());
    }

    @Test
    void getById() {
        Genre retrievedPoem = genreDao.getById(21);
        assertNotNull(retrievedPoem);
        assertEquals("Sweet", retrievedPoem.getGenreName());
    }

    @Test
    void insert() {
        Genre genreToInsert = new Genre("This is a new genre name");
        int insertedGenreId = genreDao.insertEntity(genreToInsert);
        assertNotEquals(0, insertedGenreId);
    }

    @Test
    void update() {
        Genre genreToUpdate = genreDao.getById(1);
        genreToUpdate.setGenreName("New Genre Content");
        genreDao.update(genreToUpdate);
        Genre updatedGenre = genreDao.getById(1);
        assertEquals("New Genre Content", updatedGenre.getGenreName());
    }

    @Test
    void delete() {
        Genre genreToDelete = genreDao.getById(1);
        genreDao.delete(genreToDelete);
        assertNull(genreDao.getById(1));
    }

}
