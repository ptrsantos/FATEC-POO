
package model.conexao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Conexao {
    
    private static final String DRIVER = "org.apache.derby.jdbc.ClientDriver";
    //private static final String BD ="jdbc:derby://localhost:1527/SistemDePedidos";
    private static final String BD ="jdbc:derby://localhost:1527/SistemaDePedidos";
    private static final String USUARIO = "paulo";
    private static final String SENHA = "1234";

    public Conexao() {
        try {
            Class.forName(DRIVER);
        } catch (ClassNotFoundException ex) {
            System.err.println(ex.getMessage());
        }
    }
    
    public static Connection iniciarConexao() {
        try {
            return DriverManager.getConnection(BD, USUARIO, SENHA);
        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
            return null;
        }
    }
    
    public static void fecharConexao(Connection con){
        try {
            con.close();
            //return con;
        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
        }
    }
    public static void fecharConexao(Connection con, PreparedStatement pstm){
        try {
            pstm.close();
        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
        }
        fecharConexao(con);
    }
    public  static void fecharConexao(Connection con, PreparedStatement pstm, ResultSet rs){
        try {
            rs.close();
        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
        }
        fecharConexao(con, pstm);
    }
    
}
