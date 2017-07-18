package service;

/**
 * Created by Michele on 14/07/2017.
 */

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import database_table.WarehousemenEntity;

import java.util.List;

public class TestWarehousemenCRUD {

    public static void main(String args[]){
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("jpa-example");
        EntityManager em = emf.createEntityManager();

        WarehousemanCRUD waremenCRUD = new WarehousemanCRUD(em);

        List<WarehousemenEntity> listOfWaremen = waremenCRUD.getWarehousemen();
        for(WarehousemenEntity waremen:listOfWaremen){
            System.out.println(waremen.toString());
        }

        em.close();
        emf.close();
    }
}
