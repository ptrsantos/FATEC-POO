
package model.entidades;

import java.sql.Date;
import java.util.ArrayList;
import java.util.Calendar;
import model.entidades.Produto;

public class Pedido {
    
    private int idPedido;
    private int codCliente;
    private Date data;

    public Pedido() {
    }

    public Pedido(int codCliente, int quantidade, Date data, Produto produto) {
        this.codCliente = codCliente;
        this.data = data;
    }

 
    public int getIdPedido() {
        return idPedido;
    }

    public void setIdPedido(int idPedido) {
        this.idPedido = idPedido;
    }

    public int getCodCliente() {
        return codCliente;
    }

    public void setCodCliente(int codCliente) {
        this.codCliente = codCliente;
    }

    public Date getData() {
        return data;
    }

    public void setData(Date data) {
        this.data = data;
    }

}
