CREATE TABLE produtos (
	id BIGINT(20) PRIMARY KEY AUTO_INCREMENT,
	nome VARCHAR(150) NOT NULL,
	preco DOUBLE NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE produtos_categorias (
	produto_id BIGINT(20) NOT NULL,
	categoria_id BIGINT(20) NOT NULL,
	PRIMARY KEY (produto_id, categoria_id),
	FOREIGN KEY (produto_id) REFERENCES produtos(id),
	FOREIGN KEY (categoria_id) REFERENCES categorias(id)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

INSERT INTO produtos (nome, preco) VALUES ('Computador', 2000.00 );
INSERT INTO produtos (nome, preco) VALUES ('Impressora', 800.00 );
INSERT INTO produtos (nome, preco) VALUES ('Mouse', 80.00 );
INSERT INTO produtos (nome, preco) VALUES ('Mesa de escritório', 300.00 );
INSERT INTO produtos (nome, preco) VALUES ('Toalha', 50.00);
INSERT INTO produtos (nome, preco) VALUES ('Colcha', 200.00 );
INSERT INTO produtos (nome, preco) VALUES ('TV true color', 1200.00 );
INSERT INTO produtos (nome, preco) VALUES ('Roçadeira', 800.00 );
INSERT INTO produtos (nome, preco) VALUES ('Abajour', 100.00 );
INSERT INTO produtos (nome, preco) VALUES ('Pendente', 180.00 );
INSERT INTO produtos (nome, preco) VALUES ('Shampoo', 90.00 );

INSERT INTO produtos (nome, preco) VALUES ('Produto 12', 10.00 );
INSERT INTO produtos (nome, preco) VALUES ('Produto 13', 10.00 );
INSERT INTO produtos (nome, preco) VALUES ('Produto 14', 10.00 );
INSERT INTO produtos (nome, preco) VALUES ('Produto 15', 10.00 );
INSERT INTO produtos (nome, preco) VALUES ('Produto 16', 10.00 );
INSERT INTO produtos (nome, preco) VALUES ('Produto 17', 10.00 );
INSERT INTO produtos (nome, preco) VALUES ('Produto 18', 10.00 );
INSERT INTO produtos (nome, preco) VALUES ('Produto 19', 10.00 );

INSERT INTO produtos (nome, preco) VALUES ('Produto 20', 10.00 );
INSERT INTO produtos (nome, preco) VALUES ('Produto 21', 10.00 );
INSERT INTO produtos (nome, preco) VALUES ('Produto 22', 10.00 );
INSERT INTO produtos (nome, preco) VALUES ('Produto 23', 10.00 );
INSERT INTO produtos (nome, preco) VALUES ('Produto 24', 10.00 );
INSERT INTO produtos (nome, preco) VALUES ('Produto 25', 10.00 );
INSERT INTO produtos (nome, preco) VALUES ('Produto 26', 10.00 );
INSERT INTO produtos (nome, preco) VALUES ('Produto 27', 10.00 );
INSERT INTO produtos (nome, preco) VALUES ('Produto 28', 10.00 );
INSERT INTO produtos (nome, preco) VALUES ('Produto 29', 10.00 );

INSERT INTO produtos (nome, preco) VALUES ('Produto 30', 10.00 );
INSERT INTO produtos (nome, preco) VALUES ('Produto 31', 10.00 );
INSERT INTO produtos (nome, preco) VALUES ('Produto 32', 10.00 );
INSERT INTO produtos (nome, preco) VALUES ('Produto 33', 10.00 );
INSERT INTO produtos (nome, preco) VALUES ('Produto 34', 10.00 );
INSERT INTO produtos (nome, preco) VALUES ('Produto 35', 10.00 );
INSERT INTO produtos (nome, preco) VALUES ('Produto 36', 10.00 );
INSERT INTO produtos (nome, preco) VALUES ('Produto 37', 10.00 );
INSERT INTO produtos (nome, preco) VALUES ('Produto 38', 10.00 );
INSERT INTO produtos (nome, preco) VALUES ('Produto 39', 10.00 );

INSERT INTO produtos (nome, preco) VALUES ('Produto 40', 10.00 );
INSERT INTO produtos (nome, preco) VALUES ('Produto 41', 10.00 );
INSERT INTO produtos (nome, preco) VALUES ('Produto 42', 10.00 );
INSERT INTO produtos (nome, preco) VALUES ('Produto 43', 10.00 );
INSERT INTO produtos (nome, preco) VALUES ('Produto 44', 10.00 );
INSERT INTO produtos (nome, preco) VALUES ('Produto 45', 10.00 );
INSERT INTO produtos (nome, preco) VALUES ('Produto 46', 10.00 );
INSERT INTO produtos (nome, preco) VALUES ('Produto 47', 10.00 );
INSERT INTO produtos (nome, preco) VALUES ('Produto 48', 10.00 );
INSERT INTO produtos (nome, preco) VALUES ('Produto 49', 10.00 );

INSERT INTO produtos (nome, preco) VALUES ('Produto 50', 10.00 );
		
INSERT INTO produtos_categorias (produto_id, categoria_id) VALUES (1, 1);
INSERT INTO produtos_categorias (produto_id, categoria_id) VALUES (2, 1);
INSERT INTO produtos_categorias (produto_id, categoria_id) VALUES (3, 1);
INSERT INTO produtos_categorias (produto_id, categoria_id) VALUES (2 ,2);
INSERT INTO produtos_categorias (produto_id, categoria_id) VALUES (4, 2);
INSERT INTO produtos_categorias (produto_id, categoria_id) VALUES (5, 3);
INSERT INTO produtos_categorias (produto_id, categoria_id) VALUES (6, 3);
INSERT INTO produtos_categorias (produto_id, categoria_id) VALUES (1, 4);
INSERT INTO produtos_categorias (produto_id, categoria_id) VALUES (2, 4);
INSERT INTO produtos_categorias (produto_id, categoria_id) VALUES (3, 4);
INSERT INTO produtos_categorias (produto_id, categoria_id) VALUES (7, 4);
INSERT INTO produtos_categorias (produto_id, categoria_id) VALUES (8, 5);
INSERT INTO produtos_categorias (produto_id, categoria_id) VALUES (9, 6);
INSERT INTO produtos_categorias (produto_id, categoria_id) VALUES (10, 6);
INSERT INTO produtos_categorias (produto_id, categoria_id) VALUES (11, 7);

INSERT INTO produtos_categorias (produto_id, categoria_id) VALUES (12, 1);
INSERT INTO produtos_categorias (produto_id, categoria_id) VALUES (13, 1);
INSERT INTO produtos_categorias (produto_id, categoria_id) VALUES (14, 1);
INSERT INTO produtos_categorias (produto_id, categoria_id) VALUES (15, 1);
INSERT INTO produtos_categorias (produto_id, categoria_id) VALUES (16, 1);
INSERT INTO produtos_categorias (produto_id, categoria_id) VALUES (17, 1);
INSERT INTO produtos_categorias (produto_id, categoria_id) VALUES (18, 1);
INSERT INTO produtos_categorias (produto_id, categoria_id) VALUES (19, 1);

INSERT INTO produtos_categorias (produto_id, categoria_id) VALUES (20, 1);
INSERT INTO produtos_categorias (produto_id, categoria_id) VALUES (21, 1);
INSERT INTO produtos_categorias (produto_id, categoria_id) VALUES (22, 1);
INSERT INTO produtos_categorias (produto_id, categoria_id) VALUES (23, 1);
INSERT INTO produtos_categorias (produto_id, categoria_id) VALUES (24, 1);
INSERT INTO produtos_categorias (produto_id, categoria_id) VALUES (25, 1);
INSERT INTO produtos_categorias (produto_id, categoria_id) VALUES (26, 1);
INSERT INTO produtos_categorias (produto_id, categoria_id) VALUES (27, 1);
INSERT INTO produtos_categorias (produto_id, categoria_id) VALUES (28, 1);
INSERT INTO produtos_categorias (produto_id, categoria_id) VALUES (29, 1);

INSERT INTO produtos_categorias (produto_id, categoria_id) VALUES (30, 1);
INSERT INTO produtos_categorias (produto_id, categoria_id) VALUES (31, 1);
INSERT INTO produtos_categorias (produto_id, categoria_id) VALUES (32, 1);
INSERT INTO produtos_categorias (produto_id, categoria_id) VALUES (33, 1);
INSERT INTO produtos_categorias (produto_id, categoria_id) VALUES (34, 1);
INSERT INTO produtos_categorias (produto_id, categoria_id) VALUES (35, 1);
INSERT INTO produtos_categorias (produto_id, categoria_id) VALUES (36, 1);
INSERT INTO produtos_categorias (produto_id, categoria_id) VALUES (37, 1);
INSERT INTO produtos_categorias (produto_id, categoria_id) VALUES (38, 1);
INSERT INTO produtos_categorias (produto_id, categoria_id) VALUES (39, 1);

INSERT INTO produtos_categorias (produto_id, categoria_id) VALUES (40, 1);
INSERT INTO produtos_categorias (produto_id, categoria_id) VALUES (41, 1);
INSERT INTO produtos_categorias (produto_id, categoria_id) VALUES (42, 1);
INSERT INTO produtos_categorias (produto_id, categoria_id) VALUES (43, 1);
INSERT INTO produtos_categorias (produto_id, categoria_id) VALUES (44, 1);
INSERT INTO produtos_categorias (produto_id, categoria_id) VALUES (45, 1);
INSERT INTO produtos_categorias (produto_id, categoria_id) VALUES (46, 1);
INSERT INTO produtos_categorias (produto_id, categoria_id) VALUES (47, 1);
INSERT INTO produtos_categorias (produto_id, categoria_id) VALUES (48, 1);
INSERT INTO produtos_categorias (produto_id, categoria_id) VALUES (49, 1);

INSERT INTO produtos_categorias (produto_id, categoria_id) VALUES (50, 1);
