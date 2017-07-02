
package model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.conexao.Conexao;
import model.entidades.Cliente;

public class ClienteDAO {
    private Connection con = null;
    private PreparedStatement pstm = null;
    private ResultSet rs = null;
    private ArrayList<Cliente> clientes = null;
    
    public ClienteDAO(){
        clientes = new ArrayList<>();
    }
    
    public boolean inserirCliente(Cliente cliente){
        String sql ="INSERT INTO Cliente(nome, Rg, Email, Telefone) VALUES(?,?,?,?)";
        con = Conexao.iniciarConexao();
        try {
            pstm =  con.prepareStatement(sql);
            pstm.setString(1, cliente.getNomeDoCliente());
            pstm.setString(2, cliente.getRg());
            pstm.setString(3, cliente.getEmail());
            pstm.setString(4, cliente.getTelefone());
            pstm.executeUpdate();
            return true;
        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
            return false;
        }finally{
            Conexao.fecharConexao(con, pstm);
        }
    }
    
    public boolean excluirCliente(int id){
        String sql ="DELETE FROM Cliente WHERE Id_Cliente = ?";
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
    
    public boolean alterarCliente(Cliente cliente){
        String sql ="UPDATE Cliente SET nome = ?, Rg = ?, Email = ? , Telefone = ? WHERE Id_Cliente = ?";
        con = Conexao.iniciarConexao();
        try {
            pstm = con.prepareStatement(sql);
            pstm.setString(1, cliente.getNomeDoCliente());
            pstm.setString(2, cliente.getRg());
            pstm.setString(3, cliente.getEmail());
            pstm.setString(4, cliente.getTelefone());
            pstm.setInt(5, cliente.getIdCliente());
            pstm.executeUpdate();
            return true;
        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
            return false;
        } finally{
            Conexao.fecharConexao(con, pstm);
        }
        
    }
    
    public ArrayList<Cliente> listarCliente(){
        String sql ="SELECT * FROM Cliente";
        con = Conexao.iniciarConexao();
        clientes =new ArrayList<Cliente>();
        try {
            
            pstm =  con.prepareStatement(sql);
            rs = pstm.executeQuery();
            while(rs.next()){
                Cliente cliente = new Cliente();
                
                cliente.setIdCliente(rs.getInt("Id_Cliente"));
                //System.out.println(rs.getInt("Id_Cliente"));
                
                cliente.setNomeDoCliente(rs.getString("Nome"));
                //System.out.println(rs.getString("Nome"));
                
                cliente.setRg(rs.getString("Rg"));
                //System.out.println(rs.getString("Rg"));
                
                cliente.setEmail(rs.getString("Email"));
                //System.out.println(rs.getString("Email"));
                
                cliente.setTelefone(rs.getString("Telefone"));
                //System.out.println(rs.getString("Telefone"));
                
                clientes.add(cliente);
            }
            Conexao.fecharConexao(con, pstm);
            return clientes;
        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
            Conexao.fecharConexao(con, pstm);
            return null;
        } 
    }
}
