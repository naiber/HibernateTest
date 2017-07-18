package service;

import database_table.DepartmentsEntity;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import java.util.List;

/**
 * Created by Michele on 14/07/2017.
 */
public class DepartmentsCRUD {

    protected EntityManager em;

    public DepartmentsCRUD (EntityManager em){
        this.em = em;
    }

    public List<DepartmentsEntity> getDeps(){
        Query query = em.createQuery("select d from DepartmentsEntity d");
        return (List<DepartmentsEntity>) query.getResultList();
    }

    public DepartmentsEntity getDepById(int id){
        /*TypedQuery<DepartmentsEntity> query = em.createQuery(
                "Select d from DepartmentsEntity d where d.id = :id", DepartmentsEntity.class);
        return query.setParameter("id",id).getSingleResult();*/
        return em.find(DepartmentsEntity.class,id);
    }
}
