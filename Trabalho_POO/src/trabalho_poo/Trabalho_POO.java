/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package trabalho_poo;
import controller.ControleItemPedido;
import java.text.ParseException;
import java.sql.Date;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.dao.PedidoDAO;
import model.dao.ProdutoDAO;
import model.entidades.Cliente;
import model.entidades.Pedido;
import model.entidades.Produto;
import model.dao.ClienteDAO;
import model.dao.ConsultaDAO;
import model.entidades.ItemPedido;
        


public class Trabalho_POO {

    public static void main(String[] args) {
        Pedido pedido = new Pedido();
        PedidoDAO pedDao = new PedidoDAO();
        
        /*SimpleDateFormat formatBrasil = new SimpleDateFormat("dd/MM/yyyy");
        Date dataAtual = new Date();
        System.out.println(formatBrasil.format(dataAtual));
        
        String niver = "20/12/1970";
        try {
            Date meuNiver = (Date) formatBrasil.parse(niver);
            System.out.println(formatBrasil.format(meuNiver));
        } catch (ParseException ex) {
            Logger.getLogger(Trabalho_POO.class.getName()).log(Level.SEVERE, null, ex);
        }*/
        
        //String ds = "20121970";
        //String data = ds.substring(0, 2) + "/" + ds.substring(2,4) + "/"+ ds.substring(4, 8);
        //String d1 = ds.substring(0, 2);
       // String d2 = ds.substring(2,4);
        //String d3 = ds.substring(4, 8);
        //System.out.println( data);
        
       /* String nome = "José Silveira"; 
        System.out.println("String : " + nome);

        String substring = nome.substring(5);
        System.out.println("String depois da 3º index: " + "["+substring+"]");
 
        substring = nome.substring(1, 6);
        System.out.println("Substring (1,6): " + "["+substring+"]");*/


        
        //String st1 = "Ricardo"; 
	//String st2 = st1.substring(0, 3);
        
        /*String dataString = "16/06/2017";
        DateFormat fmt = new SimpleDateFormat("dd/MM/yyyy");
        try {
            java.sql.Date data = new java.sql.Date(fmt.parse(dataString).getTime());
            pedido.setData(data);
            //System.out.println("Imprimindo data inserida na tabela " + fmt.format(data));
        } catch (ParseException ex) {
            Logger.getLogger(Trabalho_POO.class.getName()).log(Level.SEVERE, null, ex);
        }
        pedido.setCodCliente(2);
        //pedido.setQuantidade(8);
        ControleItemPedido cItem = new ControleItemPedido();*/
        //cItem.confirmarPedido(pedido);
        //pedDao.inserirPedido(pedido);
        
        /*Produto p = new Produto("furadeira", 50.00);
        ProdutoDAO dao = new ProdutoDAO();
        dao.inserirProduto(p);
        
        System.out.println(dao.listarProduto());*/
        
        /*Cliente c = new Cliente();
        ClienteDAO cliDao = new ClienteDAO();
        
        System.out.println(cliDao.listarCliente());*/
        
       /* ItemPedido item = new ItemPedido();
        item.setQuantidade(5);*/
       
      ConsultaDAO conDao = new ConsultaDAO();
       /*for( Object e1: conDao.retornMaisVendidos()){
           System.out.println(e1.toString());
           ArrayList aux = new ArrayList();
           ArrayList aux2 = new ArrayList();
           aux.add(e1);
           for ( Object e2 : aux){
               System.out.println(e2.toString());
               for(Object e3 : aux2 )
                System.out.println(e3.toString());    
                    aux.add(e1);
           }
           aux = null;
       }*/

        
       /*Iterator it1 = conDao.retornMaisVendidos().iterator();
       while(it1.hasNext()){
           System.out.println("it1 = " + it1.next());
           Iterator it2 = it1.next().iterator();
       }*/
   

       }
       
        
    
    
}
