
package com.redfoxanna.persistence;

import com.redfoxanna.entity.Poem;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Expression;
import jakarta.persistence.criteria.Root;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.criteria.HibernateCriteriaBuilder;

import java.util.List;

/**
 *
 * @author akessler
 */
public class PoemDao {

    private final Logger logger = LogManager.getLogger(this.getClass());
    SessionFactory sessionFactory = SessionFactoryProvider.getSessionFactory();

    /**
     * Get poem by id
     */
    public Poem getById(int id) {
        Session session = sessionFactory.openSession();
        Poem poem = session.get( Poem.class, id );
        session.close();
        return poem;
    }

    /**
     * update poem
     * @param poem  Poem to be updated
     */
    public void update(Poem poem) {
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        session.merge(poem);
        transaction.commit();
        session.close();
    }

    /**
     * insert a new poem
     * @param poem  Poem to be inserted
     */
    public int insert(Poem poem) {
        int id = 0;
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        session.persist(poem);
        transaction.commit();
        id = poem.getId();
        session.close();
        return id;
    }

    /**
     * Delete a poem
     * @param poem Poem to be deleted
     */
    public void delete(Poem poem) {
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        session.delete(poem);
        transaction.commit();
        session.close();
    }


    /** Return a list of all poems
     *
     * @return All poems
     */
    public List<Poem> getAll() {

        Session session = sessionFactory.openSession();

        HibernateCriteriaBuilder builder = session.getCriteriaBuilder();
        CriteriaQuery<Poem> query = builder.createQuery(Poem.class);
        Root<Poem> root = query.from(Poem.class);
        List<Poem> poems = session.createSelectionQuery( query ).getResultList();

        logger.debug("The list of poems " + poems);
        session.close();

        return poems;
    }

    /**
     * Get poem by property (exact match)
     * sample usage: getByPropertyEqual("lastname", "Curry")
     */
    public List<Poem> getByPropertyEqual(String propertyName, String value) {
        Session session = sessionFactory.openSession();

        logger.debug("Searching for poem with " + propertyName + " = " + value);

        HibernateCriteriaBuilder builder = session.getCriteriaBuilder();
        CriteriaQuery<Poem> query = builder.createQuery(Poem.class);
        Root<Poem> root = query.from(Poem.class);
        query.select(root).where(builder.equal(root.get(propertyName), value));
        List<Poem> poems = session.createSelectionQuery( query ).getResultList();

        session.close();
        return poems;
    }

    /**
     * Get poem by property (like)
     * sample usage: getByPropertyLike("lastname", "C")
     */
    public List<Poem> getByPropertyLike(String propertyName, String value) {
        Session session = sessionFactory.openSession();

        logger.debug("Searching for poem with {} = {}",  propertyName, value);

        HibernateCriteriaBuilder builder = session.getCriteriaBuilder();
        CriteriaQuery<Poem> query = builder.createQuery(Poem.class);
        Root<Poem> root = query.from( Poem.class );
        Expression<String> propertyPath = root.get(propertyName);

        query.where(builder.like(propertyPath, "%" + value + "%"));

        List<Poem> poems = session.createQuery( query ).getResultList();
        session.close();
        return poems;
    }

}

