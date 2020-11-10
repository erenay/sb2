package com.sb;

import org.hibernate.annotations.GenericGenerator;
import org.springframework.boot.jackson.JsonComponent;

import java.util.List;

/**
 * A payment record of a user made for a product.
 */
@JsonComponent
public class Quote {

    List<String> prices;


    public List<String> getPrices() {
        return prices;
    }

    public void setPrices(List<String> prices) {
        this.prices = prices;
    }
}
