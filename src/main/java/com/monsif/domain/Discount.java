package com.monsif.domain;

public enum Discount implements Offer {
    NONE {
        @Override
        public float apply(int total) {
            return total;
        }
    },
    // -5%
    OVER_TOTAL_OF_20 {
        @Override
        public float apply(int total) {
            return total > 20 ? total - (total * 5.f) / 100.f : total;
        }
    },

    // -10%
    OVER_TOTAL_OF_50 {
        @Override
        public float apply(int total) {
            return total > 50 ? total - (total * 10.f) / 100.f : total;
        }
    };
}
