
package controle;

import model.dao.ItemPedidoDAO;
import model.dao.PedidoDAO;
import model.entidades.ItemPedido;
import model.entidades.Pedido;

public class ControleItemPedido {
    private Pedido pedido;
    private ItemPedido item;
    private ItemPedidoDAO itemDao;
    private PedidoDAO pedDao;
    
    public ControleItemPedido(){
        pedido = new Pedido();
        item = new ItemPedido();
        itemDao = new ItemPedidoDAO();
        pedDao = new PedidoDAO();        
    }
    
    public void confirmarPedido(ItemPedido item){
        pedDao.inserirPedido(item.getPedido());
        itemDao.inserirItemPedido(item);
    }
    
}
