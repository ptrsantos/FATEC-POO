/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.util.ArrayList;
import model.dao.ClienteDAO;
import model.dao.ConsultaDAO;
import model.dao.ItemPedidoDAO;
import model.dao.PedidoDAO;
import model.dao.ProdutoDAO;
import model.entidades.Cliente;
import model.entidades.ItemPedido;
import model.entidades.Pedido;
import model.entidades.Produto;

/**
 *
 * @author Paulo
 */
public class ControleConsulta {
    
    Cliente cliente = new Cliente();
    ClienteDAO cliDao = new ClienteDAO();
    Pedido pedido = new Pedido();
    PedidoDAO pedDao = new PedidoDAO();
    ConsultaDAO conDao = new ConsultaDAO();
    ItemPedidoDAO itPedDao = new ItemPedidoDAO();
    ProdutoDAO prodDao = new ProdutoDAO();
    
    public ArrayList<Cliente> listarCliente(){
        return cliDao.listarCliente();
    }
    
    public Pedido retornaPedido(int CodCli){
        return pedDao.retornaPedido(CodCli);
    }
    
    public ItemPedido retornaItemPedido(Pedido ped){
        ItemPedido ip = itPedDao.retornaItemPedido(ped);
       // System.out.println("Quantidade ItemPedido no Controle Consulta = " + ip.getQuantidade().toString());
        return conDao.retornaProduto(ip);
    }
    
    public ArrayList maisVendidos(){
        return conDao.retornaMaisVendidos();
    }
    public ArrayList clieneQuantidade(){
        return conDao.retornaClienteQuantidade();
    }
    
    public ArrayList clientePreco(){
        return conDao.retornaClientePreco();
    }
}
