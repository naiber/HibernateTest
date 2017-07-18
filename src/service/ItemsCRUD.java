package service;

import database_table.ItemsEntity;
import database_table.DepartmentsEntity;
import database_table.MovementsEntity;
//import org.hibernate.test.cache.infinispan.functional.entities.Item;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.TypedQuery;
/**
 * Created by Michele on 14/07/2017.
 */
public class ItemsCRUD {

    protected EntityManager em;
    public ItemsCRUD(EntityManager em){
        this.em = em;
    }

    public List<ItemsEntity> getItems(){
        /*Query query = em.createQuery("select i from ItemsEntity i");
        return (List<ItemsEntity>) query.getResultList();*/
        return em.createQuery("FROM " + ItemsEntity.class.getName()).getResultList();
    }

    /*public ItemsEntity getItemByID(int id){
        Query query = em.createQuery("select i from ItemsEntity i where i.id="+id);
        return (ItemsEntity) query.getSingleResult();
    }*/

    public ItemsEntity getItemByID(int id) {
        /*TypedQuery<ItemsEntity> query = em.createQuery(
                "SELECT i FROM ItemsEntity i WHERE i.id = :id", ItemsEntity.class);
        return query.setParameter("id", id).getSingleResult();*/
        return em.find(ItemsEntity.class, id);
    }

    public List<ItemsEntity> getItemsByDep(String dep){
        /*ArrayList<ItemsEntity> returnItems = new ArrayList<ItemsEntity>();
        List<ItemsEntity> items = this.getItems();
        for(ItemsEntity item:items){
            System.out.println("sono dentro il for di getItemsByDep");
            if(item.getDepartments().toString()==dep){
                System.out.println(item.toString());
                returnItems.add(item);
            }
        }
        System.out.println("sono fuori dal for");
        return returnItems;*/
        TypedQuery<ItemsEntity> query = em.createQuery(
                "Select i from ItemsEntity i where i.departments.name = :dep", ItemsEntity.class);
        return query.setParameter("dep",dep).getResultList();
    }

    /*public List<MovementsEntity> getMovByItemId(int id){
        List<MovementsEntity> moves = this.getItemByID(1).getMovements();
        return moves;
    }*/

    public void insertItem(String name,int price,int size,String description){
        ItemsEntity item = new ItemsEntity();
        DepartmentsCRUD dep = new DepartmentsCRUD(em);
        item.setName(name);
        item.setPrice(price);
        item.setSize(size);
        item.setDescription(description);
        item.setDepartments(dep.getDepById(1));
        if(!this.getItems().contains(item)){
            em.getTransaction().begin();
            em.persist(item);
            em.getTransaction().commit();
            em.close();
        }
        else{
            System.out.println("the object is already in list");
        }
    }

    /*  public void updateItemById(int id,ItemsEntity item){
        this.getItemByID(id).replaceItem(item);
    }*/

    public void merge(ItemsEntity item) {
        try {
            em.getTransaction().begin();
            em.merge(item);
            em.getTransaction().commit();
        } catch (Exception ex) {
            ex.printStackTrace();
            em.getTransaction().rollback();
        }
    }
}