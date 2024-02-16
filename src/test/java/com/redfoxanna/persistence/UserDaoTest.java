package com.redfoxanna.persistence;

import com.redfoxanna.entity.Poem;
import com.redfoxanna.entity.User;
import com.redfoxanna.util.Database;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class UserDaoTest {
    UserDao userDao;
    @BeforeEach
    void setUp() {
        Database database = Database.getInstance();
        database.runSQL("cleanDB.sql");
        userDao = new UserDao();
    }

    @Test
    void getByIdSuccess() {
        User retrievedUser = userDao.getById(1);
        assertNotNull(retrievedUser);
        assertEquals("Anna", retrievedUser.getFirstName());
    }
    @Test // TODO decide what to do about persisting a poem if user deleted
    void testUpdateSuccess() {
        User userToUpdate = userDao.getById(1);
        userToUpdate.setLastName("Banana");
        userDao.update(userToUpdate);

        // Get the actual user and check values match after update
        User actualUser = userDao.getById(1);
        assertEquals("Banana", actualUser.getLastName());

    }

    @Test
    void testInsertSuccess() {
        User userToInsert = new User("Fox", "Mulder", "truth", "user", "want2Blieve@xfiles.com", "1969-10-13");
        int insertedUserId = userDao.insert(userToInsert);
        assertNotEquals(0, insertedUserId);
        User insertedUser = userDao.getById(insertedUserId);
        assertEquals("Fox", insertedUser.getFirstName());
    }

    @Test
    void testDeleteSuccess() {
        userDao.delete(userDao.getById(1));
        assertNull(userDao.getById(1));
    }

    @Test
    void testDeleteWithPoemSuccess() {

        // get the user you want to delete with two poems associated
        User userToBeDeleted = userDao.getById(1);
        List<Poem> poems = userToBeDeleted.getPoems();

        // get the associated poem numbers
        int poemNumber1 = poems.get(0).getId();
        int poemNumber2 = poems.get(1).getId();

        // delete the user
        userDao.delete(userDao.getById(1));
        assertNull(userDao.getById(1));

        // verify the user was deleted
        assertNull(userDao.getById(1));

        // verify the poems were also deleted
        PoemDao poemDao = new PoemDao();
        assertNull(poemDao.getById(poemNumber1));
        assertNull(poemDao.getById(poemNumber2));
    }

    @Test
    void testGetAllSuccess() {
        List<User> users = userDao.getAll();
        assertEquals(1, users.size());
    }

    @Test
    void testGetByPropertyEqualSuccess() {
        List<User> users = userDao.getByPropertyLike("lastName", "Kessler");
        assertEquals(1, users.size());
        assertEquals(1, users.get(0).getId());
    }

    @Test
    void testGetByPropertyLike() {
        List<User> users = userDao.getByPropertyLike("lastName", "K");
        assertEquals(1, users.size());
    }
}
