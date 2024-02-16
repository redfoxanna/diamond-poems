package com.redfoxanna.persistence;

import com.redfoxanna.entity.Poem;
import com.redfoxanna.entity.User;
import com.redfoxanna.util.Database;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.sql.Timestamp;
import java.time.LocalDateTime;
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
    }

    @Test
    void insert() {
        // get a User
        UserDao userDao = new UserDao();
        User user = userDao.getById(1);

        // create a poem with the user on it
        Poem poem = new Poem("This is a test poem", "poem2.jpg", Timestamp.valueOf(LocalDateTime.now()), "example, tag");
        // insert the poem
        int insertedPoemId = poemDao.insert(poem);
        // retrieve the poem
        Poem retrievedPoem = poemDao.getById(insertedPoemId);
        // verify
        assertNotNull(retrievedPoem);
    }

    @Test
    void delete() {
        poemDao.delete(poemDao.getById(1));
        assertNull(poemDao.getById(1));
    }

    @Test
    void getAll() {
        List<Poem> poems = poemDao.getAll();
        assertEquals(1, poems.size());
    }

    @Test
    void getByPropertyEqual() {
    }

    @Test
    void getByPropertyLike() {
    }
}