package com.monsif.domain.products;

public enum Item {

    POMME("Pomme", 15),
    ORANGE("Orange", 10),
    BANANE("Banane", 12),
    KIWI("Kiwi", 5);

    private final String name;
    private final int price;

    Item(String name, int price) {
        this.name = name;
        this.price = price;
    }

    public String Name() {
        return this.name;
    }

    public int getPrice() {
        return this.price;
    }

    public int priceBy(int volume) {
        return getPrice() * volume;
    }
}
