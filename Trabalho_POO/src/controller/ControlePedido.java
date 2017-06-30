
package controller;

import java.sql.Date;
import java.util.ArrayList;
import model.dao.ClienteDAO;
import model.dao.PedidoDAO;
import model.dao.ProdutoDAO;
import model.entidades.Cliente;
import model.entidades.ItemPedido;
import model.entidades.Pedido;
import model.entidades.Produto;

public class ControlePedido {
    
    private Produto produto = null;
    private PedidoDAO pedDao = null;
    private Cliente cliente = null;
    private Pedido pedido = null;
    private ClienteDAO cliDao = null;
    private ProdutoDAO prodDao = null;
    
    public ControlePedido(){
    this.produto = new Produto();
    this.pedDao = new PedidoDAO();
    this.cliente = new Cliente();
    this.pedido = new Pedido();
    this.cliDao = new ClienteDAO();
    this.prodDao= new ProdutoDAO();
    }
    
    public ArrayList<Pedido> listarPedido(){
        return pedDao.listarPedido();
    }
    
    public ArrayList<Cliente> listarCliente(){
        return cliDao.listarCliente();
    }
    
    public ArrayList<Produto> listarProduto(){
        return prodDao.listarProduto();
    }
    
    public int retornaTamanhoDaLista(){
        //System.out.println("retorna tamanho " + pedDao.listarPedido().size());
        return pedDao.listarPedido().size();
    }

    
    public ArrayList<Produto> selecionarProduto(String nome){
        return prodDao.selecionarProduto(nome);
    }
    
    public Produto retornaProduto( int id){
       return prodDao.retornaProduto(id);
    }
    
    public void inserirPedido(Pedido pedido){
        pedDao.inserirPedido(pedido);
    }
    
        public void confirmarPedido(ItemPedido item){
        pedDao.inserirPedido(item.getPedido());
        
    }
    

}