package org.example.model;

public class Product {
    private int id;
    private String name;
    private String category;
    private int stock;
    private double price;

    // Construtor padrão
    public Product() {
    }

    // Construtor com todos os atributos
    public Product(int id, String name, String category, int stock, double price) {
        this.id = id;
        this.name = name;
        this.category = category;
        this.stock = stock;
        this.price = price;
    }

    // Construtor sem o ID
    public Product(String name, String category, int stock, double price) {
        this.name = name;
        this.category = category;
        this.stock = stock;
        this.price = price;
    }

    // Getters e Setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    // Método toString() para exibição legível dos dados
    @Override
    public String toString() {
        return String.format(
                "ID: %d, Nome: %s, Categoria: %s, Estoque: %d, Preço: R$ %.2f",
                id, name, category, stock, price
        );
    }
}
