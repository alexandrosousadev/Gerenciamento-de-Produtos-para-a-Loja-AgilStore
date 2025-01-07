package org.example.controller;

import org.example.model.Product;
import org.example.repository.ProductRepository;

import java.util.List;
import java.util.Optional;

public class ProductController {
    private ProductRepository productRepository;

    public ProductController(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public void addProduct(String name, String category, int stock, double price) {
        Product product = new Product(0, name, category, stock, price);
        productRepository.addProduct(product);
    }

    public List<Product> listProducts() {
        return productRepository.getAllProducts();
    }

    public Optional<Product> getProductById(int id) {
        return productRepository.getProductById(id);
    }

    public List<Product> searchProducts(String name) {
        return productRepository.searchByName(name);
    }

    public boolean removeProduct(int id) {
        return productRepository.removeProduct(id);
    }
}
