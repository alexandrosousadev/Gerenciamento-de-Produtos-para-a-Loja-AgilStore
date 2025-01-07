package org.example.view;

import java.util.Scanner;

public class ConsoleView {
    private final Scanner scanner = new Scanner(System.in);

    public int showMenu() {
        System.out.println("\n=== Gerenciamento de Produtos ===");
        System.out.println("1. Adicionar Produto");
        System.out.println("2. Listar Produtos");
        System.out.println("3. Atualizar Produto");
        System.out.println("4. Excluir Produto");
        System.out.println("5. Buscar Produto");
        System.out.println("0. Sair");
        System.out.print("Escolha uma opção: ");
        return scanner.nextInt();
    }

    public String prompt(String message) {
        System.out.print(message);
        return scanner.nextLine();
    }

    public int promptInt(String message) {
        System.out.print(message);
        return scanner.nextInt();
    }

    public double promptDouble(String message) {
        System.out.print(message);
        return scanner.nextDouble();
    }
}
