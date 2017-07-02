
package model.tableModel;

import java.util.ArrayList;
import javax.swing.table.AbstractTableModel;
import model.entidades.Cliente;

public class TableModelCliente extends AbstractTableModel{
    
    private ArrayList<Cliente> listaDeClientes = new ArrayList<>();
    private String[] campos = {"Id_Cliente", "Nome", "Rg", "Email", "Telefone"};
    
    @Override
    public int getRowCount() {
        return listaDeClientes.size();
    }

    @Override
    public int getColumnCount() {
        return campos.length;
    }

    @Override
    public String getColumnName(int coluna) {
        return campos[coluna];
    }
    
    

    @Override
    public Object getValueAt(int linha, int coluna) {
       switch (coluna){
            case 0: 
                return listaDeClientes.get(0).getIdCliente();
            case 1:
                return listaDeClientes.get(1).getNomeDoCliente();
            case 2:
                return listaDeClientes.get(2).getRg();
            case 3:
                return listaDeClientes.get(3).getEmail();
            case 4:
                return listaDeClientes.get(4).getTelefone();
            default:
                return null;
            
       }
    }
    
}
