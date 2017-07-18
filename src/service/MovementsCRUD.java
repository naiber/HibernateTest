package service;

import database_table.MovementsEntity;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import java.util.List;

/**
 * Created by Michele on 14/07/2017.
 */
public class MovementsCRUD {
    protected EntityManager em;
    public MovementsCRUD(EntityManager em){
        this.em = em;
    }

    public List<MovementsEntity> getMovements(){
        Query query = em.createQuery("select m from MovementsEntity m");
        return (List<MovementsEntity>) query.getResultList();
    }
}
