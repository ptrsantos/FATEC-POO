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
    
    
    
    public ArrayList<Produto> selecionarElementos(String nome){
        System.out.println("Nome no DAO "+ nome);
        String sql ="SELECT * FROM Cliente_Pedido_Produto where Nome_do_Cliente like '%" + nome + "%'";
        con = Conexao.iniciarConexao();
        lista = new ArrayList();
        try {            
            pstm =  con.prepareStatement(sql);
            rs = pstm.executeQuery();
            while(rs.next()){
                ArrayList elementos = new ArrayList();
                
                elementos.add(rs.getString("Nome_do_Cliente"));
                //System.out.println(produto.getIdProduto());
                
                elementos.add(rs.getInt("Id_Pedido"));
                //System.out.println(produto.getNomeProduto());
                
                elementos.add(rs.getDouble("Data"));
                //System.out.println(produto.getValor());
                
                elementos.add(rs.getInt("Id_Produto"));
                //System.out.println(produto.getIdProduto());
                
                elementos.add(rs.getString("Nome_de_Produto"));
                //System.out.println(produto.getNomeProduto());
                
                elementos.add(rs.getInt("Quantidade"));
                //System.out.println(produto.getValor());
                
                elementos.add(rs.getInt("Valor"));
                
                lista.add(elementos);
            }
        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
        } finally{
            Conexao.fecharConexao(con, pstm, rs);
            return lista;
        }
        
    }
}
