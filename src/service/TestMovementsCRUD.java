package service;

import database_table.MovementsEntity;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.List;

/**
 * Created by Michele on 14/07/2017.
 */
public class TestMovementsCRUD {

    public static void main (String args[]) {

        EntityManagerFactory emf = Persistence.createEntityManagerFactory("jpa-example");
        EntityManager em = emf.createEntityManager();

        MovementsCRUD movementsCRUD = new MovementsCRUD(em);

        //////////////////////Get list of items\\\\\\\\\\\\\\\\\\\\\\\
        List<MovementsEntity> listOfMovements = movementsCRUD.getMovements();
        for (MovementsEntity move : listOfMovements) {
            System.out.println("id : "+move.getId()+ "\tdate"+move.getDate());
        }

        em.close();
        emf.close();
    }
}
