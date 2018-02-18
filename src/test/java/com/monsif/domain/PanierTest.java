package com.monsif.domain;

import com.monsif.domain.products.Item;
import org.junit.Before;
import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class PanierTest {


    private Panier panier;

    @Before
    public void initialize() {
        panier = new Panier(Discount.NONE);
    }

    @Test
    public void calculate_total_price_of_basket_when_empty() {
        assertThat(panier.total()).isEqualTo(0);
    }

    @Test
    public void calculate_total_basket_when_one_apple() {
        panier.addItem(Item.POMME);
        assertThat(panier.total()).isEqualTo(15);
    }

    @Test
    public void calculate_total_basket_when_two_apple() {
        panier.addItem(Item.POMME);
        panier.addItem(Item.POMME);
        assertThat(panier.total()).isEqualTo(30);
    }

    @Test
    public void occurrences_of_apple_should_be_3() {
        panier.addItem(Item.POMME);
        panier.addItem(Item.POMME);
        panier.addItem(Item.POMME);
        panier.addItem(Item.KIWI);
        assertThat(panier.occurencesOf(Item.POMME)).isEqualTo(3);
    }

    @Test
    public void calculate_total_when_one_apple_and_one_orange() {
        panier.addItem(Item.POMME);
        panier.addItem(Item.ORANGE);
        assertThat(panier.total()).isEqualTo(25);
    }

    @Test
    public void calculate_total_when_one_kiwi_and_one_apple() {
        panier.addItem(Item.POMME);
        panier.addItem(Item.KIWI);
        assertThat(panier.total()).isEqualTo(20);
    }


    @Test
    public void calculate_total_when_one_banana_and_one_apple() {
        panier.addItem(Item.POMME);
        panier.addItem(Item.BANANE);
        assertThat(panier.total()).isEqualTo(27);
    }

    @Test
    public void calculate_total_of_two_kiwi() {
        panier.addItem(Item.KIWI);
        panier.addItem(Item.KIWI);
        assertThat(panier.total()).isEqualTo(10);
    }

    @Test
    public void basket_total_should_be_equal_to_0_when_cleared() {
        panier.addItem(Item.POMME);
        panier.addItem(Item.ORANGE);
        panier.addItem(Item.ORANGE);
        assertThat(panier.total()).isEqualTo(35);

        panier.deleteItem(Item.POMME);
        panier.deleteItem(Item.ORANGE);
        panier.deleteItem(Item.ORANGE);
        assertThat(panier.total()).isEqualTo(0);
    }


    @Test
    public void basket_total_should_apply_discount_when_eligible_to_5(){
        panier = new Panier(Discount.OVER_TOTAL_OF_20);
        panier.addItem(Item.POMME);
        panier.addItem(Item.ORANGE);
        panier.addItem(Item.ORANGE);
        assertThat(panier.total()).isEqualTo(33.25f);
    }

    @Test
    public void basket_total_should_apply_discount_when_eligible_to_10(){
        panier = new Panier(Discount.OVER_TOTAL_OF_50);
        panier.addItem(Item.POMME);
        panier.addItem(Item.ORANGE);
        panier.addItem(Item.ORANGE);
        panier.addItem(Item.KIWI);
        panier.addItem(Item.POMME);
        assertThat(panier.total()).isEqualTo(49.5f);
    }


}