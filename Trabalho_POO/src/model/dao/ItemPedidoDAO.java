
package model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import model.conexao.Conexao;
import model.entidades.ItemPedido;
import model.entidades.Pedido;
import model.entidades.Produto;

public class ItemPedidoDAO {
    private Connection con = null;
    private PreparedStatement pstm = null;
    private ResultSet rs = null;
    private ArrayList<Produto> produtos = null;
    private int quantidade;
    private Pedido pedido;
    
    public void inserirItemPedido(ItemPedido item){
        con = Conexao.iniciarConexao();
        for(int i = 0; i< item.getProdutos().size(); i++){
            try {
                String sql ="INSERT INTO Item_Pedido(Cod_Pedido, Cod_Produto, Quantidade) VALUES(?, ?, ?)";
                pstm =  con.prepareStatement(sql);
                //pstm.setInt(1, item.getPedido().getCodCliente());
                pstm.setInt(1, item.getPedido().getIdPedido());
                pstm.setInt(2, item.retornaProdutos().get(i).getIdProduto());
                pstm.setInt(3, (Integer)item.getQuantidade().get(i));
                pstm.executeUpdate();
            } catch (SQLException ex) {
                System.err.println(ex.getMessage());
            }
        } 
        Conexao.fecharConexao(con, pstm);
    }
    
        public ItemPedido retornaItemPedido(Pedido pedido){
        String sql ="SELECT * FROM Item_Pedido where Cod_Pedido = " + pedido.getIdPedido();
        ItemPedido itemPedido = new ItemPedido();
        //itemPedido.setPedido(pedido);
        con = Conexao.iniciarConexao();
        try {
            pstm =  con.prepareStatement(sql);
            rs = pstm.executeQuery();
            while(rs.next()){
                Produto produto = new Produto();
                int qtde;
                produto.setIdProduto(rs.getInt("Cod_Produto"));
                qtde = rs.getInt("Quantidade");

                itemPedido.setProdutos(produto);
                itemPedido.setQuantidade(qtde);
            }
            Conexao.fecharConexao(con, pstm);
            System.out.println("Quantidade ItemPedio em ConsultDAO = " + itemPedido.getQuantidade());
            return itemPedido;
        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
            Conexao.fecharConexao(con, pstm);
            return null;
        }

    } 

}
