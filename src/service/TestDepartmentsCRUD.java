package service;

/**
 * Created by Michele on 14/07/2017.
 */

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import database_table.DepartmentsEntity;
import database_table.ItemsEntity;

import java.util.List;

public class TestDepartmentsCRUD {

    public static void main (String args[]) {

        LogicalJPA logicalJPA = new LogicalJPA("HBPersistence");

        DepartmentsCRUD departmentsCRUD = new DepartmentsCRUD(logicalJPA.getEmSession());

        //////////////////////Get list of departments\\\\\\\\\\\\\\\\\\\\\\\
        /*List<DepartmentsEntity> listOfDepartments = departmentsCRUD.getDeps();
        for (DepartmentsEntity dep : listOfDepartments) {
            System.out.println("name : "+dep.getName());
        }*/

        //////////////////////Get dep by id\\\\\\\\\\\\\\\\\\\\\\\
        DepartmentsEntity dep = logicalJPA.getEmSession().find(DepartmentsEntity.class,1);
        System.out.println(dep.toString());
        List<ItemsEntity> items = dep.getItems();
        System.out.println("is empty? --> "+items.isEmpty());
        for(ItemsEntity item:items){
            System.out.println(item.toString());
        }

        /*List<ItemsEntity> items = logicalJPA.jpaRead("select i from ItemsEntity i where i.dep="+dep.getId()).getResultList();
        System.out.println(items.isEmpty());*/
        /*List<ItemsEntity> items=logicalJPA.jpaRead("select i from ItemsEntity i,Departments d where d.name=:E-Items").getResultList();
        for(int i=0;i<items.size();i++){
            System.out.println(items.get(i));
        }
        logicalJPA.closeLogicaJPA();*/
    }

}
