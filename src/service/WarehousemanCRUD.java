package service;

import database_table.WarehousemenEntity;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import java.util.List;

/**
 * Created by Michele on 14/07/2017.
 */

public class WarehousemanCRUD {

    protected EntityManager em;
    public WarehousemanCRUD(EntityManager em){
        this.em = em;
    }

    public List<WarehousemenEntity> getWarehousemen(){
        Query query = em.createQuery("select wm from WarehousemenEntity wm");
        return (List<WarehousemenEntity>) query.getResultList();
    }
}
