package com.monsif.domain.products;

import java.util.ArrayList;
import java.util.List;

public class Items {
    private final List<Item> items;

    private Items(ItemBuilder builder) {
        this.items = builder.items;
    }

    public int count() {
        return items.size();
    }

    public void add(Item item) {
        items.add(item);
    }

    public List<Item> getAll() {
        return items;
    }

    public void delete(Item item) {
        items.remove(item);
    }

    public static class ItemBuilder {
        private final List<Item> items = new ArrayList<Item>();

        public ItemBuilder addItem(Item item) {
            items.add(item);
            return this;
        }

        public ItemBuilder addItems(List<Item> items) {
            items.addAll(items);
            return this;
        }

        public Items build() {
            return new Items(this);
        }
    }
}
