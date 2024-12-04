package br.edu.unisep.cadastro.view;

import br.edu.unisep.cadastro.controller.PedidoController;
import br.edu.unisep.cadastro.model.Cliente;
import br.edu.unisep.cadastro.model.Pedido;
import br.edu.unisep.cadastro.model.Produto;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class PedidoView {
    private PedidoController controller;
    private Scanner scanner;

    public PedidoView() {
        controller = new PedidoController();
        scanner = new Scanner(System.in);
    }

    public void exibirMenu() {
        int opcao;
        do {
            System.out.println("\nMenu de Pedidos:");
            System.out.println("1. Cadastrar Pedido");
            System.out.println("2. Listar Pedidos");
            System.out.println("3. Editar Pedido");
            System.out.println("4. Sair");
            System.out.print("Escolha uma opção: ");
            opcao = scanner.nextInt();
            scanner.nextLine(); // Limpar buffer

            switch (opcao) {
                case 1:
                    cadastrarPedido();
                    break;
                case 2:
                    listarPedidos();
                    break;
                case 3:
                    editarPedido();
                    break;
                case 4:
                    System.out.println("Saindo...");
                    break;
                default:
                    System.out.println("Opção inválida!");
            }
        } while (opcao != 4);
    }

    private void cadastrarPedido() {
        System.out.print("Número do Pedido: ");
        int numeroPedido = scanner.nextInt();
        scanner.nextLine();

        System.out.print("Nome do Cliente: ");
        String nomeCliente = scanner.nextLine();
        System.out.print("E-mail do Cliente: ");
        String emailCliente = scanner.nextLine();
        Cliente cliente = new Cliente(nomeCliente, emailCliente);

        System.out.print("Nome do Produto: ");
        String nomeProduto = scanner.nextLine();
        System.out.print("Preço do Produto: ");
        double precoProduto = scanner.nextDouble();
        Produto produto = new Produto(nomeProduto, precoProduto);

        System.out.print("Quantidade: ");
        int quantidade = scanner.nextInt();
        scanner.nextLine();

        System.out.print("Status (Pago/Pendente/Enviado): ");
        String status = scanner.nextLine();

        List<Produto> produtos = new ArrayList<>();
        produtos.add(produto);

        Pedido pedido = new Pedido(numeroPedido, cliente, produtos, quantidade, status);
        controller.cadastrarPedido(pedido);
        System.out.println("Pedido cadastrado com sucesso!");
    }

    private void listarPedidos() {
        System.out.println("\nLista de Pedidos:");
        for (Pedido pedido : controller.listarPedidos()) {
            System.out.println(pedido);
        }
    }

    private void editarPedido() {
        System.out.print("Número do Pedido a ser editado: ");
        int numeroPedido = scanner.nextInt();
        scanner.nextLine();

        Pedido pedidoExistente = controller.buscarPedidoPorNumero(numeroPedido);
        if (pedidoExistente != null) {
            cadastrarPedido();
            controller.editarPedido(pedidoExistente, pedidoExistente);
            System.out.println("Pedido editado com sucesso!");
        } else {
            System.out.println("Pedido não encontrado!");
        }
    }
}
