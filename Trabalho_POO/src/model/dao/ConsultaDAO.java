/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import model.conexao.Conexao;
import model.entidades.ItemPedido;
import model.entidades.Produto;

/**
 *
 * @author Paulo
 */
public class ConsultaDAO {
    
    private Connection con = null;
    private PreparedStatement pstm = null;
    private ResultSet rs = null;
    private ArrayList lista;
    private ArrayList<String> subLista = null;
    

     
    public ItemPedido retornaProduto(ItemPedido ip){
        ItemPedido itemPedido = new ItemPedido();
            for(int i=0; i<ip.getProdutos().size(); i++ ){
                String sql ="SELECT * FROM Produto where Id_Produto = " + ip.getProdutos().get(i).getIdProduto();
                con = Conexao.iniciarConexao();
                try {
                    pstm =  con.prepareStatement(sql);
                    rs = pstm.executeQuery();
                        while(rs.next()){
                            Produto p= new Produto();
                            p.setIdProduto(rs.getInt("Id_Produto"));
                            p.setNomeProduto(rs.getString("Nome"));
                            p.setValor(rs.getDouble("Valor"));

                            itemPedido.setProdutos(p);
                            itemPedido.setQuantidade(ip.getQuantidade().get(i));
                        }
                    Conexao.fecharConexao(con, pstm);
                    //return itemPedido;
                } catch (SQLException ex) {
                    System.err.println(ex.getMessage());
                    Conexao.fecharConexao(con, pstm);
                    //return null;
                }
            }
            //System.out.println("Testando quantidade no ConsultaDAO = " + itemPedido.getQuantidade().toString());
            return itemPedido;
        }

    public ArrayList retornaMaisVendidos(){
        String sql = "select * from produtos_mais_vendidos order by total_de_produtos_vendidos desc";
        con = Conexao.iniciarConexao();
        lista = new ArrayList<ArrayList>();
        try {            
            pstm =  con.prepareStatement(sql);
            rs = pstm.executeQuery();
            while(rs.next()){
                subLista = new ArrayList();
                
                lista.add(rs.getInt("Id_Produto"));
                lista.add(rs.getString("nome_do_produto"));
                lista.add(rs.getInt("total_de_produtos_vendidos"));
              
            }
        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
        } finally{
            Conexao.fecharConexao(con, pstm, rs);
            return lista;
        }
    }
    
    public ArrayList retornaClienteQuantidade(){
        String sql = "select * from cliente_quantidade order by total_de_produtos_comprados desc";
        con = Conexao.iniciarConexao();
        lista = new ArrayList<ArrayList>();
        try {            
            pstm =  con.prepareStatement(sql);
            rs = pstm.executeQuery();
            while(rs.next()){
                subLista = new ArrayList();
                
                lista.add(rs.getInt("Id_Cliente"));
                lista.add(rs.getString("nome_do_cliente"));
                lista.add(rs.getInt("total_de_produtos_comprados"));
              
            }
        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
        } finally{
            Conexao.fecharConexao(con, pstm, rs);
            return lista;
        }
    }
        
        public ArrayList retornaClientePreco(){
        String sql = "select * from cliente_preco_fixo order by total_de_produtos_comprados desc";
        con = Conexao.iniciarConexao();
        lista = new ArrayList<ArrayList>();
        try {            
            pstm =  con.prepareStatement(sql);
            rs = pstm.executeQuery();
            while(rs.next()){
                subLista = new ArrayList();
                
                lista.add(rs.getInt("Id_Cliente"));
                lista.add(rs.getString("nome_do_cliente"));
                lista.add(rs.getString("nome_do_produto"));
                lista.add(rs.getDouble("preco_fixo"));
                lista.add(rs.getInt("total_de_produtos_comprados"));              
            }
        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
        } finally{
            Conexao.fecharConexao(con, pstm, rs);
            return lista;
        }
    }
}
