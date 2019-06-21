package com.algorithm.demo.designPatterns.builderPattern;

import java.util.ArrayList;
import java.util.List;

/**
 * @author mahongbin
 * @date 2019/6/21 17:38
 * @Description
 */
public class Meal {
    private List<Item> items = new ArrayList<Item>();

    public void addItem(Item item){
        items.add(item);
    }

    public float getCost(){
        float cost = 0.0f;
        for (Item item : items) {
            cost += item.price();
        }
        return cost;
    }

    public void showItems(){
        for (Item item : items) {
            System.out.print("Item : "+item.name());
            System.out.print(", Packing : "+item.packing().packing());
            System.out.println(", Price : "+item.price());
        }
    }
}
