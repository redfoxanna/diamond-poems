package com.redfoxanna.persistence;

import com.redfoxanna.entity.Poem;
import com.redfoxanna.util.Database;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class PoemTest {
    PoemDao poemDao;

    @BeforeEach
    void setUp() {
        Database database = Database.getInstance();
        database.runSQL("cleanDB.sql");
        poemDao = new PoemDao();
    }

    @Test
    void getById() {
        Poem retrievedPoem = poemDao.getById(1);
        assertNotNull(retrievedPoem);
        assertEquals("userName", retrievedPoem.getUserName());
    }

    @Test
    void update() {
        Poem poem = poemDao.getById(1);
        poem.setPoemImage("poem3.jpg");
        poemDao.update(poem);

        Poem retrievedPoem = poemDao.getById(1);
        assertEquals("poem3.jpg", retrievedPoem.getPoemImage());

    }

    @Test
    void insert() {

        // Create a poem with the user and genre
        Poem poem = new Poem("This is a test poem", "poem2.jpg", "testUser");

        // Insert the poem
        int insertedPoemId = poemDao.insert(poem);

        // Retrieve the poem
        Poem retrievedPoem = poemDao.getById(insertedPoemId);

        // Verify
        assertNotNull(retrievedPoem);
        assertEquals(poem.getPoemImage(), retrievedPoem.getPoemImage());
        assertEquals(poem.getUserName(), retrievedPoem.getUserName());
    }



    @Test
    void delete() {
        poemDao.delete(poemDao.getById(1));
        assertNull(poemDao.getById(1));
    }

    @Test
    void getAll() {
        List<Poem> poems = poemDao.getAll();
        assertEquals(2, poems.size());
    }

    @Test
    void getByPropertyEqual() {
        List<Poem> poems = poemDao.getByPropertyEqual("genreTags","cute, funny");
        assertEquals(1, poems.size());
    }

    @Test
    void getByPropertyLike() {
        List<Poem> poems = poemDao.getByPropertyLike("genreTags", "happy");
        assertEquals(1, poems.size());
    }
}