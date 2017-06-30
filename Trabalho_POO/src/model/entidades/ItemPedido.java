
package model.entidades;

import java.util.ArrayList;

public class ItemPedido {
    private ArrayList<Produto> produtos;
    private Pedido pedido;
    private ArrayList<Integer> quantidade;

    public ItemPedido() {
        this.produtos = new ArrayList<Produto>();
        this.quantidade = new ArrayList();
    }

    public ItemPedido(Produto produto, Pedido pedido, Integer quantidade) {
        this.produtos.add(produto);
        this.pedido = pedido;
        this.quantidade.add(quantidade);
    }

    public void adicionaProdutos(Produto produto){
        this.produtos.add(produto);
    }
    public ArrayList<Produto> retornaProdutos(){
        return this.produtos;
    }
    public ArrayList<Produto> getProdutos() {
        return produtos;
    }

    public void setProdutos(Produto produto) {
        this.produtos.add(produto);
    }

    public Pedido getPedido() {
        return pedido;
    }

    public void setPedido(Pedido pedido) {
        this.pedido = pedido;
    }

    public ArrayList<Integer> getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(Integer quantidade) {

        this.quantidade.add(quantidade);
    }

   
    
}
