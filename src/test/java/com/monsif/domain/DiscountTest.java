package com.monsif.domain;

import org.junit.Test;

import static com.monsif.domain.Discount.NONE;
import static com.monsif.domain.Discount.OVER_TOTAL_OF_20;
import static com.monsif.domain.Discount.OVER_TOTAL_OF_50;
import static org.assertj.core.api.Assertions.assertThat;

public class DiscountTest {

    @Test
    public void price_should_apply_discount_of_over_20() {
        assertThat(OVER_TOTAL_OF_20.apply(50)).isEqualTo(47.5f);
    }

    @Test
    public void price_should_apply_discount_of_over_50() {
        assertThat(OVER_TOTAL_OF_50.apply(100)).isEqualTo(90);
    }

    @Test
    public void price_should_not_apply_discount_when_none() {
        assertThat(NONE.apply(50)).isEqualTo(50);
    }

}