package com.ydj.collection.list;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class ListSortTest {

    public static void main(String[] args) {
        Entity entity1 = new Entity();
        Entity entity2 = new Entity();
        Entity entity3 = new Entity();
        Entity entity4 = new Entity();
        Entity entity5 = new Entity();
        Entity entity6 = new Entity();
        Entity entity7 = new Entity();
        entity1.setName("御园-1栋-1单元-09层-0901");
        entity2.setName("御园-1栋-3单元-18层-1808");
        entity3.setName("御园-2栋-2单元-16层-1606");
        entity4.setName("御园-2栋-2单元-09层-0911");
        entity5.setName("御园-3栋-1单元-16层-1606");
        entity6.setName("御园-1栋-1单元-09层-0901");
        entity7.setName("御园-4栋-2单元-17层-1607");
        List<Entity> entityList = new ArrayList<>();
        entityList.add(entity1);
        entityList.add(entity2);
        entityList.add(entity3);
        entityList.add(entity4);
        entityList.add(entity5);
        entityList.add(entity6);
        entityList.add(entity7);
        List<Entity> entityList1 = sortList(entityList);
        entityList1.stream().forEach(item ->
            System.out.println(item.getName())
        );
    }

    private static List<Entity> sortList(List<Entity> list) {
        list.sort(new Comparator<Entity>() {
            @Override
            public int compare(Entity o1, Entity o2) {
                return o1.getName().compareTo(o2.getName());
            }
        });
        return list;
    }

}


class Entity{

    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "POJOs{" +
                "name='" + name + '\'' +
                '}';
    }
}