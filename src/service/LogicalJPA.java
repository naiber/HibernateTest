package service;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;


/**
 * Created by Michele on 18/07/2017.
 */
public class LogicalJPA {

    private EntityManagerFactory emf;
    private EntityManager em;

    public LogicalJPA(String persistenceUnitName) {
        emf = Persistence.createEntityManagerFactory(persistenceUnitName);
        em = emf.createEntityManager();
    }

    public EntityManager getEmSession(){
        return this.em;
    }

    public void jpaCreate(Object obj) {
        em.getTransaction().begin();
        em.persist(obj);
        em.getTransaction().commit();
        em.detach(obj);
    }

    public Query jpaRead(String query) {
        Query q = em.createQuery(query);
        return q;
    }

    public void jpaUpdate(Object obj) {
        em.getTransaction().begin();
        em.merge(obj);
        em.getTransaction().commit();
        em.detach(obj);
    }

    public void jpaDelete(Object obj) {
        em.getTransaction().begin();
        Object managed = em.merge(obj);
        em.remove(managed);
        em.getTransaction().commit();
    }

    public void closeLogicaJPA() {
        em.close();
        emf.close();
    }
}
