package com.redfoxanna.persistence;

import com.redfoxanna.entity.Poem;
import com.redfoxanna.entity.User;
import com.redfoxanna.util.Database;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class PoemDaoTest {
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
        assertEquals(1, retrievedPoem.getUser().getId());
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
        // get a User
        UserDao userDao = new UserDao();
        User user = userDao.getById(1);

        // create a poem with the user on it
        Poem poem = new Poem("This is a test poem", "poem2.jpg", user, "example, tag");
        // insert the poem
        int insertedPoemId = poemDao.insert(poem);
        // retrieve the poem
        Poem retrievedPoem = poemDao.getById(insertedPoemId);
        // verify
        assertNotNull(retrievedPoem);
        assertEquals(poem.getPoemImage(),retrievedPoem.getPoemImage());
        assertEquals("Anna", poem.getUser().getFirstName());
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