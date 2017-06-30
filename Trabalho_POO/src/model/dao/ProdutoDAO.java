
package model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import model.conexao.Conexao;
import model.entidades.Produto;


public class ProdutoDAO {
    
    private Connection con = null;
    private PreparedStatement pstm = null;
    private ResultSet rs = null;
    private ArrayList<Produto> produtos = null;
    
   
    public boolean inserirProduto(Produto produto){
        String sql ="INSERT INTO Produto(nome, valor) VALUES(?,?)";
        con = Conexao.iniciarConexao();
        try {
            pstm =  con.prepareStatement(sql);
            pstm.setString(1, produto.getNomeProduto());
            pstm.setDouble(2, produto.getValor());
            pstm.executeUpdate();
            return true;
        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
            return false;
        }finally{
            Conexao.fecharConexao(con, pstm);
        }
    }
    
    public boolean excluirProduto(int id){
        String sql ="DELETE FROM Produto WHERE Id_Produto = ?";
        con = Conexao.iniciarConexao();
        try {
            pstm = con.prepareStatement(sql);
            pstm.setInt(1, id);
            pstm.executeUpdate();
            return true;
        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
            return false;
        } finally{
            Conexao.fecharConexao(con, pstm);
        }
    }
    
    public boolean alterarProduto(Produto produto){
        System.out.println("dao AlteraProduto produto.getName = " + produto.getNomeProduto());
        String sql ="UPDATE Produto SET nome = ?, Valor = ? WHERE Id_Produto = ?";
        con = Conexao.iniciarConexao();
        try {
            pstm = con.prepareStatement(sql);
            pstm.setString(1, produto.getNomeProduto());
            pstm.setDouble(2, produto.getValor());
            pstm.setInt(3, produto.getIdProduto());
            pstm.executeUpdate();
            return true;
        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
            return false;
        } finally{
            Conexao.fecharConexao(con, pstm);
        }
        
    }
    
    public ArrayList<Produto> listarProduto(){
        String sql ="SELECT * FROM Produto";
        con = Conexao.iniciarConexao();
        produtos = new ArrayList<Produto>();
        try {            
            pstm =  con.prepareStatement(sql);
            rs = pstm.executeQuery();
            while(rs.next()){
                Produto produto = new Produto();
                
                produto.setIdProduto(rs.getInt("Id_Produto"));
                System.out.println(produto.getIdProduto());
                
                produto.setNomeProduto(rs.getString("Nome"));
                System.out.println(produto.getNomeProduto());
                
                produto.setValor(rs.getDouble("Valor"));
                System.out.println(produto.getValor());
                
                produtos.add(produto);
            }
        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
        } finally{
            Conexao.fecharConexao(con, pstm, rs);
            return produtos;
        }
    }
    
    public ArrayList<Produto> selecionarProduto(String nome){
        System.out.println("Nome no DAO "+ nome);
        String sql ="SELECT * FROM Produto where Nome like '%" + nome + "%'";
        con = Conexao.iniciarConexao();
        produtos = new ArrayList<Produto>();
        try {            
            pstm =  con.prepareStatement(sql);
            rs = pstm.executeQuery();
            while(rs.next()){
                Produto produto = new Produto();
                
                produto.setIdProduto(rs.getInt("Id_Produto"));
                System.out.println(produto.getIdProduto());
                
                produto.setNomeProduto(rs.getString("Nome"));
                System.out.println(produto.getNomeProduto());
                
                produto.setValor(rs.getDouble("Valor"));
                System.out.println(produto.getValor());
                
                produtos.add(produto);
            }
        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
        } finally{
            Conexao.fecharConexao(con, pstm, rs);
            return produtos;
        }
        
    }
    
    public Produto retornaProduto(int id){
        String sql ="SELECT Id_Produto, Nome, Valor FROM Produto  WHERE Id_Produto = " + id;
        Produto produto = new Produto();
        con = Conexao.iniciarConexao();
        try {            
            pstm =  con.prepareStatement(sql);
            rs = pstm.executeQuery();
            while(rs.next()){
                
                produto.setIdProduto(rs.getInt("Id_Produto"));
                System.out.println(produto.getIdProduto());
                
                produto.setNomeProduto(rs.getString("Nome"));
                System.out.println(produto.getNomeProduto());
                
                produto.setValor(rs.getDouble("Valor"));
                System.out.println(produto.getValor());
            }
        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
        } finally{
            Conexao.fecharConexao(con, pstm, rs);
            return produto;
        }
    
    }
}
