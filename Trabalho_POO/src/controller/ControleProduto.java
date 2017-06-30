
package controller;

import java.util.ArrayList;
import model.dao.ProdutoDAO;
import model.entidades.Produto;

public class ControleProduto {
    Produto produto = new Produto();
    ProdutoDAO prodDao = new ProdutoDAO();
    
    public boolean inserirProduto(ArrayList<String> dados){
        produto.setNomeProduto(dados.get(0));
        produto.setValor(Double.parseDouble(dados.get(1)));
        return prodDao.inserirProduto(produto);
    }
    
    public ArrayList<Produto> listarProduto(){
        return prodDao.listarProduto();
    }
    
    public int retornaTamanhoDaLista(){
        System.out.println("retorna tamanho " + prodDao.listarProduto().size());
        return prodDao.listarProduto().size();
    }
    
    public boolean alterarProduto(Produto produto){
        return prodDao.alterarProduto(produto);
    }
    
    public boolean excluirProduto(int id){
        return prodDao.excluirProduto(id);
    }
}
