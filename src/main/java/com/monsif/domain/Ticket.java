package com.monsif.domain;

import java.util.stream.Collectors;

public class Ticket {
    private final StringBuilder ticket;

    public Ticket(StringBuilder ticket) {
        this.ticket = ticket;
    }

    public String show(Panier panier) {
        panier.items().collect(Collectors.groupingBy(item -> item, Collectors.counting()))
                .entrySet()
                .forEach(entry -> ticket.append(String.format("%s\t%dX%d/unit\t%d",
                        entry.getKey().Name(), entry.getValue(), entry.getKey().getPrice(),
                        entry.getKey().priceBy(entry.getValue().intValue()))));
        return ticket.toString();
    }
}
