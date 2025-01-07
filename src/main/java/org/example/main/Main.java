package org.example.main;

import org.example.model.Product;
import org.example.repository.ProductRepository;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ProductRepository repository = new ProductRepository();

        int option;

        do {
            System.out.println("\n=== Gerenciamento de Produtos ===");
            System.out.println("1. Adicionar Produto");
            System.out.println("2. Listar Produtos");
            System.out.println("3. Atualizar Produto");
            System.out.println("4. Excluir Produto");
            System.out.println("5. Buscar Produto");
            System.out.println("0. Sair");
            System.out.print("Escolha uma opção: ");
            option = scanner.nextInt();
            scanner.nextLine();

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
                    scanner.nextLine();

                    Product product = new Product(name, category, stock, price);
                    repository.addProduct(product);
                    System.out.println("Produto adicionado com sucesso!");
                }
                case 2 -> {
                    System.out.println("\nProdutos cadastrados:");
                    repository.getAllProducts().forEach(System.out::println);
                }
                case 3 -> {
                    System.out.print("ID do Produto a atualizar: ");
                    int id = scanner.nextInt();
                    scanner.nextLine();

                    System.out.print("Novo Nome: ");
                    String name = scanner.nextLine();
                    System.out.print("Nova Categoria: ");
                    String category = scanner.nextLine();
                    System.out.print("Novo Estoque: ");
                    int stock = scanner.nextInt();
                    System.out.print("Novo Preço: ");
                    double price = scanner.nextDouble();
                    scanner.nextLine();

                    Product updatedProduct = new Product(name, category, stock, price);
                    boolean updated = repository.updateProduct(id, updatedProduct);
                    if (updated) {
                        System.out.println("Produto atualizado com sucesso!");
                    } else {
                        System.out.println("Produto não encontrado.");
                    }
                }
                case 4 -> {
                    System.out.print("ID do Produto a excluir: ");
                    int id = scanner.nextInt();
                    boolean removed = repository.removeProduct(id);
                    if (removed) {
                        System.out.println("Produto excluído com sucesso!");
                    } else {
                        System.out.println("Produto não encontrado.");
                    }
                }
                case 5 -> {
                    System.out.print("Buscar por Nome: ");
                    String name = scanner.nextLine();
                    repository.searchByName(name).forEach(System.out::println);
                }
                case 0 -> System.out.println("Saindo...");
                default -> System.out.println("Opção inválida. Tente novamente.");
            }
        } while (option != 0);

        scanner.close();
    }
}
