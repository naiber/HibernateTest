package service;

/**
 * Created by Michele on 14/07/2017.
 */
import database_table.ItemsEntity;
import database_table.MovementsEntity;
//import org.hibernate.test.cache.infinispan.functional.entities.Item;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

public class TestItemsCRUD {

    public static void main (String args[]) {

        LogicalJPA logicalJPA = new LogicalJPA("HBPersistence");

        ItemsCRUD itemsCRUD = new ItemsCRUD(logicalJPA.getEmSession());

        //////////////////////Get list of items\\\\\\\\\\\\\\\\\\\\\\\
        /*itemsCRUD.insertItem("Mouse",20,200,"logitech");*/
        /*
        ItemsEntity newItem = new ItemsEntity();

        itemsCRUD.updateItemById();*/
        /*List<ItemsEntity> listOfItems = itemsCRUD.getItems();
        for (ItemsEntity item : listOfItems) {
            System.out.println(item.toString());
        }*/

        List<ItemsEntity> items = logicalJPA.jpaRead("select i from ItemsEntity i").getResultList();

        for(int i=0;i<items.size();i++){
            System.out.println(items.get(i));
        }

        logicalJPA.closeLogicaJPA();
        //////////////////////Get item from id\\\\\\\\\\\\\\\\\\\\\\\
        /*ItemsEntity item = itemsCRUD.getItemByID(1);

       *//* System.out.println("è vuoto? -> "+moves.isEmpty());*//*
        for(MovementsEntity move:item.getMovements()){
            System.out.println(move.getId());
        }*/
        /*for(MovementsEntity move:moves){
            System.out.println("id movimento: "+move.getId()+"\tdata: "+move.getDate());
        }
        System.out.println(item.toString()+"\n----Dep-> ");*/
        /*System.out.println(itemsCRUD.getItemByID(1).toString());*/

        //////////////////////Get items from Departments\\\\\\\\\\\\\\\\\\\\\\\
        /*List<ItemsEntity> items = itemsCRUD.getItemsByDep("E-Items");
        for(ItemsEntity item:items){
            System.out.println(item.toString());
        }*/

    }
}
