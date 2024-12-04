package br.edu.unisep.cadastro.model;

import java.io.Serializable;
import java.util.List;

public class Pedido implements Serializable {
    private int numeroPedido;
    private Cliente cliente;
    private List<Produto> produtos;
    private int quantidade;
    private String status; // Valores: "Pago", "Pendente", "Enviado"

    public Pedido(int numeroPedido, Cliente cliente, List<Produto> produtos, int quantidade, String status) {
        this.numeroPedido = numeroPedido;
        this.cliente = cliente;
        this.produtos = produtos;
        this.quantidade = quantidade;
        this.status = status;
    }

    public int getNumeroPedido() {
        return numeroPedido;
    }

    public void setNumeroPedido(int numeroPedido) {
        this.numeroPedido = numeroPedido;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public List<Produto> getProdutos() {
        return produtos;
    }

    public void setProdutos(List<Produto> produtos) {
        this.produtos = produtos;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "Pedido Nº: " + numeroPedido + ", Cliente: " + cliente.getNome() + ", Produtos: " + produtos +
                ", Quantidade: " + quantidade + ", Status: " + status;
    }
}
