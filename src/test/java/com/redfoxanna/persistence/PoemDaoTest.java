package com.redfoxanna.persistence;

import com.redfoxanna.entity.Poem;
import com.redfoxanna.util.Database;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PoemDaoTest {

    @BeforeEach
    void setUp() {
        Database database = Database.getInstance();
        database.runSQL("cleanDB.sql");
    }

    @Test
    void getById() {
        PoemDao poemDao = new PoemDao();
        Poem retrievedPoem = poemDao.getById(1);
        assertNotNull(retrievedPoem);
        assertEquals(1, retrievedPoem.getUser().getId());
    }

    @Test
    void update() {
    }

    @Test
    void insert() {
    }

    @Test
    void delete() {
    }

    @Test
    void getAll() {
    }

    @Test
    void getByPropertyEqual() {
    }

    @Test
    void getByPropertyLike() {
    }
}