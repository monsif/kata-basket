package com.monsif.domain;

import com.monsif.domain.products.Item;
import com.monsif.domain.products.Items;

import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Panier {

    private final Items items;
    private final Discount discount;

    public Panier(Discount discount) {
        this.items = new Items.ItemBuilder().build();
        this.discount = discount;
    }

    public void addItem(Item item) {
        items.add(item);
    }

    public void deleteItem(Item item) {
        items.delete(item);
    }

    public int occurencesOf(Item item) {
        return items.getAll().stream()
                .filter(i -> i.equals(item))
                .collect(Collectors.counting())
                .intValue();
    }

    public float total() {
        return discount.apply(items.getAll().stream()
                .collect(Collectors.groupingBy(item -> item, Collectors.counting()))
                .entrySet().stream()
                .mapToInt(e -> e.getKey().priceBy(e.getValue().intValue()))
                .sum());
    }

    public Stream<Item> items() {
        return items.getAll().stream();
    }
}
