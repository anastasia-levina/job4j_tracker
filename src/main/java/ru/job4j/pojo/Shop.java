package ru.job4j.pojo;

public class Shop {

    public static Product[] delete(Product[] products, int index) {

        products[index] = null;

        for (int i = index; i < products.length - 1; i++) {
            products[i] = products[i + 1];
            products[i + 1] = null;
        }
        return products;
    }

    public static void main(String[] args) {
        Product[] prods = new Product[5];
        prods[0] = new Product("Milk", 10);
        prods[1] = new Product("Bread", 4);
        prods[2] = new Product("Egg", 19);
        prods[3] = new Product("Oil", 5);
        delete(prods, 1);
        for (int i = 0; i < prods.length; i++) {
            Product product = prods[i];
            if (product != null) {
                System.out.println(product.getName());
            } else {
                System.out.println("null");
            }
        }
    }
}