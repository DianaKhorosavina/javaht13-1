package ru.netology.product;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class ShopRepositoryTest {

    @Test
    public void shouldRemoveProductFromMeddle() {
        ShopRepository repo = new ShopRepository();
        Product product1 = new Product(22, "Книга", 35000);
        Product product2 = new Product(468, "Футболка", 95000);
        Product product3 = new Product(555, "Ручка", 300);

        repo.add(product1);
        repo.add(product2);
        repo.add(product3);
        repo.remove(468);

        Product[] actual = repo.findAll();
        Product[] expected = {product1, product3};

        Assertions.assertArrayEquals(actual, expected);
    }

    @Test
    public void shouldRemoveProductFromBegin() {
        ShopRepository repo = new ShopRepository();
        Product product1 = new Product(22, "Книга", 35000);
        Product product2 = new Product(468, "Футболка", 95000);
        Product product3 = new Product(555, "Ручка", 300);

        repo.add(product1);
        repo.add(product2);
        repo.add(product3);
        repo.remove(22);

        Product[] actual = repo.findAll();
        Product[] expected = {product2, product3};

        Assertions.assertArrayEquals(actual, expected);
    }

    @Test
    public void shouldRemoveProductFromTheEnd() {
        ShopRepository repo = new ShopRepository();
        Product product1 = new Product(22, "Книга", 35000);
        Product product2 = new Product(468, "Футболка", 95000);
        Product product3 = new Product(555, "Ручка", 300);

        repo.add(product1);
        repo.add(product2);
        repo.add(product3);
        repo.remove(555);

        Product[] actual = repo.findAll();
        Product[] expected = {product1, product2};

        Assertions.assertArrayEquals(actual, expected);
    }

    @Test
    public void shouldRemoveWhenProductNotExist() {
        ShopRepository repo = new ShopRepository();
        Product product1 = new Product(22, "Книга", 35000);
        Product product2 = new Product(468, "Футболка", 95000);
        Product product3 = new Product(555, "Ручка", 300);

        repo.add(product1);
        repo.add(product2);
        repo.add(product3);


        Assertions.assertThrows(NotFoundException.class,
                () -> repo.remove(385)
        );

    }
}
