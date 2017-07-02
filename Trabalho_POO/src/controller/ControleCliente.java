
package controller;

import java.util.ArrayList;
import model.dao.ClienteDAO;
import model.entidades.Cliente;

public class ControleCliente {
    Cliente cliente = new Cliente();
    ClienteDAO cliDao = new ClienteDAO();
    
    public boolean inserirCliente(ArrayList<String> dados){
        cliente.setNomeDoCliente(dados.get(0));
        cliente.setRg(dados.get(1));
        cliente.setEmail(dados.get(2));
        cliente.setTelefone(dados.get(3));
        return cliDao.inserirCliente(cliente);
    }
    
    public ArrayList<Cliente> listarCliente(){
        return cliDao.listarCliente();
    }
    
    public int retornaTamanhoDaLista(){
        //System.out.println("retorna tamanho " + cliDao.listarCliente().size());
        return cliDao.listarCliente().size();
    }
    
    public boolean alterarCliente(ArrayList<String> dados){
        cliente.setIdCliente(Integer.parseInt(dados.get(0)));
        cliente.setNomeDoCliente(dados.get(1));
        cliente.setRg(dados.get(2));
        cliente.setEmail(dados.get(3));
        cliente.setTelefone(dados.get(4));
        
        return cliDao.alterarCliente(cliente);
    }
    
    public boolean excluirCliente(int id){
        return cliDao.excluirCliente(id);
    }
}
