package com.redfoxanna.persistence;

import com.redfoxanna.entity.Genre;
import com.redfoxanna.entity.Poem;
import com.redfoxanna.entity.PoemGenre;
import com.redfoxanna.entity.User;
import com.redfoxanna.util.Database;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Ignore;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;


import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class PoemDaoTest {

    GenericDao<Poem> poemDao;
    GenericDao<User> userDao;
    private final Logger logger = LogManager.getLogger(this.getClass());

    @BeforeEach
    void setUp() {
        poemDao = new GenericDao<>(Poem.class);
        Database database = Database.getInstance();
        database.runSQL("cleanDB.sql");
    }

    @Test
    void getAll() {
        List<Poem> poems = poemDao.getAll();
        assertNotNull(poems);
        assertEquals(5, poems.size());
    }

    @Test
    void getById() {
        Poem retrievedPoem = poemDao.getById(1);
        assertNotNull(retrievedPoem);
        assertEquals("Pineapple, on pizza, I love pizza, but not the heartburn, it burns like, hot fire, spicy", retrievedPoem.getContent());
    }

    @Ignore
    void insert() {
        User newUser = new User("annabanana");
        int newUserId = userDao.insertEntity(newUser);
        Poem poemToInsert = new Poem("This is just a test","testimg.png", newUser);
        int insertedPoemId = poemDao.insertEntity(poemToInsert);
        assertNotEquals(0, insertedPoemId);
    }

    @Test
    void update() {
        Poem poemToUpdate = poemDao.getById(1);
        poemToUpdate.setContent("New Poem Content");
        poemDao.update(poemToUpdate);
        Poem updatedPoem = poemDao.getById(1);
        assertEquals("New Poem Content", updatedPoem.getContent());
    }

    @Test
    void delete() {
        Poem poemToDelete = poemDao.getById(1);
        poemDao.delete(poemToDelete);
        assertNull(poemDao.getById(1));
    }

}
