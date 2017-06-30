drop table item_pedido;
drop table pedido;
drop table cliente;
drop table produto;

CREATE TABLE cliente (
Id_Cliente INTEGER NOT NULL GENERATED ALWAYS AS IDENTITY CONSTRAINT Id_Cliente PRIMARY KEY,
Nome VARCHAR(60) NOT NULL,
Rg VARCHAR (20),
Email VARCHAR (40),
Telefone VARCHAR (10)
);

CREATE TABLE Produto(
Id_Produto INTEGER NOT NULL GENERATED ALWAYS AS IDENTITY CONSTRAINT Id_Produto PRIMARY KEY,
Nome VARCHAR(60) NOT NULL,
Valor DECIMAL (15,2)
);

CREATE TABLE Pedido (
Id_Pedido INTEGER NOT NULL GENERATED ALWAYS AS IDENTITY CONSTRAINT Id_Pedido PRIMARY KEY,
Cod_Cliente INTEGER NOT NULL,
Data Date not null,
Foreign Key(Cod_Cliente) references Cliente(Id_Cliente)
);

CREATE TABLE Item_Pedido (
Cod_Pedido INTEGER NOT NULL,
Cod_Produto INTEGER NOT NULL,
Quantidade INTEGER NOT NULL,
Foreign Key(Cod_Pedido) references Pedido(Id_Pedido),
Foreign key(Cod_Produto) references Produto(Id_Produto)
);

CREATE TABLE Pedido (
Id_Pedido INTEGER UNSIGNED  NOT NULL auto_increment,
Cod_Cliente INTEGER NOT NULL,
Data Date not null,
PRIMARY KEY(ID_PEDIDO),
Foreign Key(Cod_Cliente) references Cliente(Id_Cliente)
);

