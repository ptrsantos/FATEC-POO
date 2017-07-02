
package model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import model.conexao.Conexao;
import model.entidades.Pedido;
import model.entidades.Produto;

public class PedidoDAO {
    
    private Connection con = null;
    private PreparedStatement pstm = null;
    private ResultSet rs = null;
    private ArrayList<Pedido> pedidos = null;
    
   
    public void inserirPedido(Pedido pedido){
        System.out.println("DATA RECEBIDA NO DAO = " + pedido.getData());
        String sql ="INSERT INTO Pedido( Data, Cod_Cliente) VALUES(?,?)";
        con = Conexao.iniciarConexao();
        int id;
        try {
            pstm =  con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            pstm.setDate(1, pedido.getData());
            pstm.setInt(2, pedido.getCodCliente());
            pstm.executeUpdate();
            rs = pstm.getGeneratedKeys();
            if(rs.next()){
                pedido.setIdPedido(rs.getInt(1));
                System.out.println("Chave pega = " + pedido.getIdPedido());
            }

        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
        }finally{
           Conexao.fecharConexao(con, pstm);
           //return pedido;
        }
    }
    
    public boolean excluirPedido(int id){
        String sql ="DELETE FROM Pedido WHERE id = ?";
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
    
    public boolean alterarPedido(Produto produto){
        String sql ="UPDATE Pedido SET Quantiade = ?, Data = ?, CodCliente = ? WHERE Id_Produto = ?";
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
    
    public ArrayList<Pedido> listarPedido(){
        String sql ="SELECT * FROM Pedido";
        con = Conexao.iniciarConexao();
        try {
            
            pstm =  con.prepareStatement(sql);
            rs = pstm.executeQuery();
            while(rs.next()){
                Pedido pedido = new Pedido();
                
                pedido.setIdPedido(rs.getInt("Id_Pedido"));
                //System.out.println(rs.getInt("Id_Cliente"));
                
                pedido.setCodCliente(rs.getInt("Cod_Cliente"));
                //System.out.println(rs.getString("Nome"));
                
                pedido.setData(rs.getDate("Data"));
                //System.out.println(rs.getString("Rg"));
 
                pedidos.add(pedido);
            }
            Conexao.fecharConexao(con, pstm);
            return pedidos;
        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
            Conexao.fecharConexao(con, pstm);
            return null;
        } 
    }
    
    public Pedido retornaPedido(int codCliente){
       String sql ="SELECT * FROM Pedido where Cod_Cliente = " + codCliente;
       Pedido pedido = null;
        con = Conexao.iniciarConexao();
        try {
            
            pstm =  con.prepareStatement(sql);
            rs = pstm.executeQuery();
            while(rs.next()){
                pedido = new Pedido();
                
                pedido.setIdPedido(rs.getInt("Id_Pedido"));
                //System.out.println(rs.getInt("Id_Cliente"));
                
                pedido.setCodCliente(rs.getInt("Cod_Cliente"));
                //System.out.println(rs.getString("Nome"));
                
                pedido.setData(rs.getDate("Data"));
                //System.out.println(rs.getString("Rg"));
 
            }
            Conexao.fecharConexao(con, pstm);
            return pedido;
        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
            Conexao.fecharConexao(con, pstm);
            return null;
        }

    }
}
