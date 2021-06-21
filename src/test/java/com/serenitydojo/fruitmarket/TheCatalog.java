package com.serenitydojo.fruitmarket;

import org.junit.Test;

import java.util.Map;

import static com.serenitydojo.fruitmarket.Fruit.*;
import static org.assertj.core.api.Assertions.assertThat;

public class TheCatalog {

    @Test
    public void shouldBeAbleToUpdateTheCurrentPriceOfAFruit() {
        Catalog catalog = new Catalog();

        catalog.setPriceOf(Apple).to(4.00)
                .setPriceOf(Orange).to(5.50)
                .setPriceOf(Banana).to(4.50)
                .setPriceOf(Pear).to(4.50);
        assertThat(catalog.getPriceOf(Apple)).isEqualTo(4.00);
        assertThat(catalog.getPriceOf(Orange)).isEqualTo(5.50);
        assertThat(catalog.getPriceOf(Banana)).isEqualTo(4.50);
        assertThat(catalog.getPriceOf(Pear)).isNotEqualTo(4.60);

    }
//too hard-copy
    @Test
    public void ShouldCatalogBeInOrder() {
        Catalog catalog = new Catalog();

        catalog.setPriceOf(Apple).to(4.00)
                .setPriceOf(Orange).to(5.50)
                .setPriceOf(Banana).to(4.50)
                .setPriceOf(Pear).to(4.50);
        assertThat(catalog.getAvailableFruit()).containsExactly("Apple", "Banana", "Orange", "Pear");

    }

    @Test
    public void reportThePriceOfGivenFruit() {
        Catalog catalog = new Catalog();

        catalog.setPriceOf(Apple).to(4.00)
                .setPriceOf(Orange).to(5.50)
                .setPriceOf(Banana).to(4.50)
                .setPriceOf(Pear).to(4.50);

        assertThat(catalog.getPriceOf(Apple)).isEqualTo(4.00);
        assertThat(catalog.getPriceOf(Orange)).isEqualTo(5.50);
    }

    @Test(expected = FruitUnavailableException.class)
    public void reportAnException() {
        Catalog catalog = new Catalog();

        catalog.setPriceOf(Apple).to(4.00)
                .setPriceOf(Orange).to(5.50)
                .setPriceOf(Banana).to(4.50)
                .setPriceOf(Pear).to(4.50);
        catalog.getPriceOf(Strawberries);
    }

}
