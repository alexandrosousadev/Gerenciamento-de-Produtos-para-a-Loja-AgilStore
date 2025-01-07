# Desafio de Código - Gerenciamento de Produtos

## Sobre o Desafio

Este projeto é uma solução para o desafio proposto, que consiste em criar um sistema de gerenciamento de produtos para uma loja. A aplicação permite realizar operações de **CRUD** (Criar, Ler, Atualizar e Deletar) em uma lista de produtos, armazenando os dados em um arquivo JSON para persistência.

## Funcionalidades

- Adicionar novos produtos.
- Listar produtos cadastrados.
- Atualizar informações de um produto existente.
- Remover um produto do cadastro.
- Armazenar e carregar os dados em um arquivo JSON (`products.json`).

## Decisões de Design e Implementação

### Estrutura do Projeto

O projeto está organizado nas seguintes camadas:

- **Model**: Contém a classe `Product`, que representa os produtos.
- **Repository**: Responsável por manipular os dados dos produtos (armazenamento em JSON e operações CRUD).
- **View**: Interface para interação com o usuário via terminal.
- **Controller**: Controla o fluxo de dados entre o repositório e a interface.

### Persistência de Dados

A persistência dos dados é feita em um arquivo JSON (`products.json`), garantindo que os dados dos produtos sejam mantidos entre execuções do programa. 

A biblioteca `Gson` foi utilizada para serializar e desserializar os dados no formato JSON.

### Mensagens e Interface

Optei por uma interface de linha de comando simples e intuitiva, com mensagens claras para orientar o usuário sobre as operações disponíveis.

## Instruções para Execução

### Pré-requisitos

- Java 8 ou superior instalado.
- Maven configurado (se necessário para gerenciar dependências).

### Passos

1. Clone o repositório:
   ```bash
   git clone <[url-do-repositorio](https://github.com/alexandrosousadev/Gerenciamento-de-Produtos-para-a-Loja-AgilStore.git)>
  
