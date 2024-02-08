package com.redfoxanna.persistence;

import com.redfoxanna.entity.User;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;


/**
 * UserDao Test class
 *
 * @author akessler
 */
public class UserDaoTest {

    UserDao userDao;

    @Test
    public void testGetById() {
        userDao = new UserDao();
        User retrievedUser = userDao.getById(1);
        assertNotNull(retrievedUser);
        assertEquals("Anna", retrievedUser.getFirstName());
    }

    @Test
    public void testUpdate() {
        userDao = new UserDao();
        User userToUpdate = userDao.getById(1);

    }

    @Test
    public void testInsert() {
    }

    @Test
    public void testDelete() {
    }

    @Test
    public void testGetAll() {
    }

    @Test
    public void testGetByPropertyEqual() {
    }

    @Test
    public void testGetByPropertyLike() {
    }
}