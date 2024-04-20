package com.redfoxanna.persistence;

import com.redfoxanna.entity.Poem;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import com.redfoxanna.util.Database;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class PoemDaoTest {

    GenericDao<Poem> poemDao;
    //GenericDao<Genre> genreDao;

    private final Logger logger = LogManager.getLogger(this.getClass());

    @BeforeEach
    void setUp() {
        Database database = Database.getInstance();
        database.runSQL("cleanDB.sql");
        poemDao = new GenericDao<>(Poem.class);
        //genreDao = new GenericDao<>(Genre.class);
    }

    @Test
    void getAllSuccess() {
        List<Poem> poemList = poemDao.getAll();
        assertNotNull(poemList);
        assertEquals(2, poemList.size());
    }

    @Test
    void getByIdSuccess() {
        Poem retrievedPoem = poemDao.getById(1);
        logger.debug("The retrieved poem: " + retrievedPoem);
        assertNotNull(retrievedPoem);
        logger.debug("The retrieved poem for the update: " + retrievedPoem);
        assertEquals("Pineapple, on pizza, I love pizza, but not the heartburn, it burns like, hot fire, spicy", retrievedPoem.getContent());
    }

    @Test
    void insertSuccess() {
        Poem poemToInsert = new Poem("This is just a test","testimg.png");
        int insertedPoemId = poemDao.insert(poemToInsert);
        assertNotEquals(0, insertedPoemId);
    }

    @Test
    void updateSuccess() {
        Poem poemToUpdate = poemDao.getById(1);
        poemToUpdate.setContent("New Poem Content");
        poemDao.update(poemToUpdate);
        Poem updatedPoem = poemDao.getById(1);
        assertEquals("New Poem Content", updatedPoem.getContent());
    }

    @Test
    void deleteSuccess() {
        Poem poemToDelete = poemDao.getById(1);
        poemDao.delete(poemToDelete);
        assertNull(poemDao.getById(1));
    }



}
