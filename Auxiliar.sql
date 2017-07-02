create view Produtos_mais_vendidos as 
select id_produto, nome_do_produto, sum(Quantidade) as total_de_produtos_vendidos  from cliente_pedido_produto 
group by  nome_do_produto, id_produto 

--select * from produtos_mais_vendidos order by total_de_produtos_vendidos desc

create view cliente_quantidade as 
select id_cliente, nome_do_cliente, sum(Quantidade) as total_de_produtos_comprados  from cliente_pedido_produto 
group by id_cliente, nome_do_cliente

--select * from cliente_quantidade order by quantidade_de_produtos_comprados desc

create view cliente_preco_fixo as
select id_cliente, nome_do_cliente, nome_do_produto, valor as preco_fixo, sum(Quantidade) as total_de_produtos_comprados  from cliente_pedido_produto 
group by id_cliente, nome_do_cliente, nome_do_produto, valor

--select * from cliente_preco_fixo order by total_de_produtos_comprados desc

