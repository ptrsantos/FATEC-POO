SELECT Cliente.nome, Id_Pedido, Data, Quantidade, Produto.nome FROM 
Cliente
INNER JOIN( 
	Pedido 
	INNER JOIN(
		Item_Pedido
		INNER JOIN
			Produto
		ON Item_Pedido.Cod_Produto = Produto.Id_Produto
		)
	ON Pedido.Id_Pedido = Item_Pedido.Cod_Pedido
	) 
ON 
Cliente.Id_Cliente = Pedido.Cod_Cliente 
	

SELECT  
   Id_Cliente, Nome, Rg FROM Cliente 
   WHERE Id_Cliente
	IN(SELECT Id_Pedido FROM Pedido
		WHERE Id_Cliente = Pedido.Cod_Cliente AND Id_Pedido
		IN( Select Cod_Produto FROM Item_Pedido
		WHERE Id_Pedido = Cod_Pedido AND Cod_Produto
			IN( SELECT Id_Produto FROM Produto
			WHERE Cod_Produto = Id_Produto
			)
		)
	)
	
CREATE VIEW Cliente_Pedido_Produto as
SELECT Id_Cliente, Cliente.nome as Nome_do_Cliente, Id_Pedido, Data, Quantidade, Id_Produto, Produto.nome as Nome_do_Produto, valor FROM 
Cliente
INNER JOIN( 
	Pedido 
	INNER JOIN(
		Item_Pedido
		INNER JOIN
			Produto
		ON Item_Pedido.Cod_Produto = Produto.Id_Produto
		)
	ON Pedido.Id_Pedido = Item_Pedido.Cod_Pedido
	) 
ON 
Cliente.Id_Cliente = Pedido.Cod_Cliente

select id_produto,nome_do_produto, valor, sum(Quantidade) as total_de_produtos_vendidos  from cliente_pedido_produto 
group by id_produto, nome_do_produto, valor 

select id_cliente, nome_do_cliente, sum(Quantidade) as total_de_produtos_comprados  from cliente_pedido_produto 
group by id_cliente, nome_do_cliente

select nome_do_cliente, valor as Preço_Fixo, sum(Quantidade) as total_de_produtos_comprados  from cliente_pedido_produto 
group by nome_do_cliente,  valor

select id_produto, nome_do_produto, sum(Quantidade) as total_de_produtos_comprados  from cliente_pedido_produto 
group by nome_do_produto


select id_produto, count(id_produto)  as soma_dos_id_produtos from cliente_pedido_produto 
group by id_produto

select id_pedido, sum(quantidade)  as soma_dos_id_produtos from cliente_pedido_produto 
group by id_pedido

select id_pedido, count(valor)  as soma_dos_id_produtos from cliente_pedido_produto 
group by id_pedido

select nome_do_cliente, Id_pedido, Data, Quantidade, Nome_do_Produto from cliente_pedido_produto 
group by id_pedido


select id_produto, nome_do_produto, valor, count(id_produto)  from cliente_pedido_produto 
group by id_produto

select id_produto,nome_do_produto, valor, count(Quantidade)  from cliente_pedido_produto 
group by id_produto, nome_do_produto, valor

select id_Pedido, data, quantidade, nome_do_produto from cliente_pedido_produto where nome_do_cliente = "Maria Joaquina"