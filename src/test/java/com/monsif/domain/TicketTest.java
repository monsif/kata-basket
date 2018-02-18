package com.monsif.domain;

import com.monsif.domain.products.Item;
import org.junit.Before;
import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class TicketTest {


    private Ticket ticket;

    @Before
    public void initialize() {
        ticket = new Ticket(new StringBuilder());
    }

    @Test
    public void ticket_should_show_price_number_per_item() {
        Panier panier = new Panier(Discount.OVER_TOTAL_OF_50);
        panier.addItem(Item.ORANGE);
        panier.addItem(Item.ORANGE);
        panier.addItem(Item.ORANGE);
        String result = ticket.show(panier);

        assertThat(result).isEqualTo("Orange\t3X10/unit\t30");
    }

}