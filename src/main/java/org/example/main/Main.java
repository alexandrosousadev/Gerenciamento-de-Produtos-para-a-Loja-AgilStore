package org.example.main;

import org.example.controller.ProductController;
import org.example.repository.ProductRepository;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        ProductRepository productRepository = new ProductRepository();
        ProductController productController = new ProductController(productRepository);
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("\n=== Gerenciamento de Produtos ===");
            System.out.println("1. Adicionar Produto");
            System.out.println("2. Listar Produtos");
            System.out.println("3. Atualizar Produto");
            System.out.println("4. Excluir Produto");
            System.out.println("5. Buscar Produto");
            System.out.println("0. Sair");
            System.out.print("Escolha uma opção: ");

            int option = scanner.nextInt();
            scanner.nextLine(); // Consumir o '\n'

            switch (option) {
                case 1 -> {
                    System.out.print("Nome: ");
                    String name = scanner.nextLine();
                    System.out.print("Categoria: ");
                    String category = scanner.nextLine();
                    System.out.print("Estoque: ");
                    int stock = scanner.nextInt();
                    System.out.print("Preço: ");
                    double price = scanner.nextDouble();

                    productController.addProduct(name, category, stock, price);
                    System.out.println("Produto adicionado com sucesso!");
                }
                case 2 -> {
                    System.out.println("\nProdutos cadastrados:");
                    productController.listProducts().forEach(System.out::println);
                }
                case 3 -> {
                    System.out.print("ID do Produto a atualizar: ");
                    int id = scanner.nextInt();
                    scanner.nextLine(); // Consumir o '\n'

                    var productOptional = productController.getProductById(id);
                    if (productOptional.isPresent()) {
                        System.out.print("Novo Nome: ");
                        String newName = scanner.nextLine();
                        System.out.print("Nova Categoria: ");
                        String newCategory = scanner.nextLine();
                        System.out.print("Novo Estoque: ");
                        int newStock = scanner.nextInt();
                        System.out.print("Novo Preço: ");
                        double newPrice = scanner.nextDouble();

                        var product = productOptional.get();
                        product.setName(newName);
                        product.setCategory(newCategory);
                        product.setStock(newStock);
                        product.setPrice(newPrice);

                        System.out.println("Produto atualizado com sucesso!");
                    } else {
                        System.out.println("Produto não encontrado.");
                    }
                }
                case 4 -> {
                    System.out.print("ID do Produto: ");
                    int id = scanner.nextInt();

                    if (productController.removeProduct(id)) {
                        System.out.println("Produto excluído com sucesso!");
                    } else {
                        System.out.println("Produto não encontrado.");
                    }
                }
                case 5 -> {
                    System.out.print("Buscar por Nome: ");
                    String searchName = scanner.nextLine();

                    var results = productController.searchProducts(searchName);
                    if (results.isEmpty()) {
                        System.out.println("Nenhum produto encontrado.");
                    } else {
                        results.forEach(System.out::println);
                    }
                }
                case 0 -> {
                    System.out.println("Saindo...");
                    return;
                }
                default -> System.out.println("Opção inválida.");
            }
        }
    }
}
