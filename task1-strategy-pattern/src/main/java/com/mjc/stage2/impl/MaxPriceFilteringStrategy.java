package com.mjc.stage2.impl;


import com.mjc.stage2.FilteringStrategy;
import com.mjc.stage2.Product;
import lombok.AllArgsConstructor;

@AllArgsConstructor
public class MaxPriceFilteringStrategy implements FilteringStrategy {
    private double maxPrice;

    @Override
    public boolean filter(Product product) {
        if(product.getPrice() >= maxPrice) {
            return true;
        }
        return false;
    }
}
