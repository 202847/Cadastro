package br.edu.unisep.cadastro.controller;

import br.edu.unisep.cadastro.model.Pedido;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class PedidoController {
    private static final String FILE_PATH = "pedidos.txt";
    private List<Pedido> pedidos;

    public PedidoController() {
        pedidos = carregarPedidos();
    }

    public void cadastrarPedido(Pedido pedido) {
        pedidos.add(pedido);
        salvarPedidos();
    }

    public List<Pedido> listarPedidos() {
        return pedidos;
    }

    public Pedido buscarPedidoPorNumero(int numeroPedido) {
        for (Pedido pedido : pedidos) {
            if (pedido.getNumeroPedido() == numeroPedido) {
                return pedido;
            }
        }
        return null;
    }

    public void editarPedido(Pedido pedidoExistente, Pedido novoPedido) {
        pedidoExistente.setCliente(novoPedido.getCliente());
        pedidoExistente.setProdutos(novoPedido.getProdutos());
        pedidoExistente.setQuantidade(novoPedido.getQuantidade());
        pedidoExistente.setStatus(novoPedido.getStatus());
        salvarPedidos();
    }

    private void salvarPedidos() {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(FILE_PATH))) {
            oos.writeObject(pedidos);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @SuppressWarnings("unchecked")
    private List<Pedido> carregarPedidos() {
        File file = new File(FILE_PATH);
        if (!file.exists()) {
            return new ArrayList<>();
        }

        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(file))) {
            return (List<Pedido>) ois.readObject();
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
            return new ArrayList<>();
        }
    }
}
