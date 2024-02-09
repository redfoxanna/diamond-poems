package com.redfoxanna.persistence;

import com.redfoxanna.entity.User;
import com.redfoxanna.util.Database;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class UserDaoTest {
    UserDao userDao;
    @BeforeEach
    void setUp() {
        Database database = Database.getInstance();
        database.runSQL("cleanDB.sql");
    }

    @Test
    void getByIdSuccess() {
        userDao = new UserDao();
        User retrievedUser = userDao.getById(1);
        assertNotNull(retrievedUser);
        assertEquals("Anna", retrievedUser.getFirstName());
    }
    @Test
    void testUpdateSuccess() {
        userDao = new UserDao();
        User userToUpdate = userDao.getById(1);
        userToUpdate.setLastName("Banana");
        userDao.update(userToUpdate);

        // Get the actual user and check values match after update
        User actualUser = userDao.getById(1);
        assertEquals("Banana", actualUser.getLastName());

    }

    @Test
    void testInsertSuccess() {
        userDao = new UserDao();
        User userToInsert = new User("Fox", "Mulder", "truth", "user");
        int insertedUserId = userDao.insert(userToInsert);
        assertNotEquals(0, insertedUserId);
        User insertedUser = userDao.getById(insertedUserId);
        assertEquals("Fox", insertedUser.getFirstName());
    }

    @Test
    void testDeleteSuccess() {
        userDao = new UserDao();
        userDao.delete(userDao.getById(1));
        assertNull(userDao.getById(1));
    }

    @Test
    void testGetAllSuccess() {
        userDao = new UserDao();
        List<User> users = userDao.getAll();
        assertEquals(1, users.size());
    }

    @Test
    void testGetByPropertyEqualSuccess() {
        userDao = new UserDao();
        List<User> users = userDao.getByPropertyLike("lastName", "Kessler");
        assertEquals(1, users.size());
        assertEquals(1, users.get(0).getId());
    }

    @Test
    void testGetByPropertyLike() {
        userDao = new UserDao();
        List<User> users = userDao.getByPropertyLike("lastName", "K");
        assertEquals(1, users.size());
    }
}
