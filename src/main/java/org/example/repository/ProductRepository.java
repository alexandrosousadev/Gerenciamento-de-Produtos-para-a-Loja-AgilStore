package org.example.repository;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.example.model.Product;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class ProductRepository {
    private List<Product> products = new ArrayList<>();
    private static final String FILE_NAME = "products.json";

    public ProductRepository() {
        loadDataFromFile(); // Carrega os dados do JSON ao iniciar
    }

    public void addProduct(Product product) {
        product.setId(getNextId());
        products.add(product);
        saveDataToFile(); // Salva no arquivo após adicionar
    }

    public List<Product> getAllProducts() {
        return products;
    }

    public Optional<Product> getProductById(int id) {
        return products.stream().filter(p -> p.getId() == id).findFirst();
    }

    public List<Product> searchByName(String name) {
        return products.stream()
                .filter(p -> p.getName().toLowerCase().contains(name.toLowerCase()))
                .collect(Collectors.toList());
    }

    public boolean removeProduct(int id) {
        boolean removed = products.removeIf(p -> p.getId() == id);
        if (removed) {
            saveDataToFile(); // Salva no arquivo após remoção
        }
        return removed;
    }

    public boolean updateProduct(int id, Product updatedProduct) {
        Optional<Product> existingProduct = getProductById(id);
        if (existingProduct.isPresent()) {
            Product product = existingProduct.get();
            product.setName(updatedProduct.getName());
            product.setCategory(updatedProduct.getCategory());
            product.setStock(updatedProduct.getStock());
            product.setPrice(updatedProduct.getPrice());

            saveDataToFile(); // Salva no arquivo após atualizar
            return true;
        }
        return false;
    }

    private int getNextId() {
        return products.isEmpty() ? 1 : products.stream().mapToInt(Product::getId).max().orElse(0) + 1;
    }

    private void saveDataToFile() {
        ObjectMapper mapper = new ObjectMapper();
        try {
            mapper.writerWithDefaultPrettyPrinter().writeValue(new File(FILE_NAME), products);
        } catch (IOException e) {
            System.err.println("Erro ao salvar os dados: " + e.getMessage());
        }
    }

    private void loadDataFromFile() {
        ObjectMapper mapper = new ObjectMapper();
        try {
            File file = new File(FILE_NAME);
            if (file.exists()) {
                products = mapper.readValue(file, new TypeReference<List<Product>>() {});
            }
        } catch (IOException e) {
            System.err.println("Erro ao carregar os dados: " + e.getMessage());
        }
    }
}
