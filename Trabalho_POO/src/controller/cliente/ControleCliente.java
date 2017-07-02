
package controller.cliente;

import java.util.ArrayList;
import model.dao.ClienteDAO;
import model.entidades.Cliente;

public class ControleCliente {
    Cliente cliente = new Cliente();
    ClienteDAO cliDao = new ClienteDAO();
    
    public void inserirCliente(ArrayList<String> dados){
        cliente.setNomeDoCliente(dados.get(0));
        cliente.setRg(dados.get(1));
        cliente.setEmail(dados.get(2));
        cliente.setTelefone(dados.get(3));
        cliDao.inserirCliente(cliente);
    }
    
    public ArrayList<Cliente> listarCliente(){
        return cliDao.listarCliente();
    }
    
    public int retornaTamanhoDaLista(){
        System.out.println("retorna tamanho " + cliDao.listarCliente().size());
        return cliDao.listarCliente().size();
    }
        
}
