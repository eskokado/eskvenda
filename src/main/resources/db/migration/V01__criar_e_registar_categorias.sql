CREATE TABLE categorias (
	id BIGINT(20) PRIMARY KEY AUTO_INCREMENT,
	nome VARCHAR(100) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

INSERT INTO categorias (nome) values ('Informática');
INSERT INTO categorias (nome) values ('Escritório');
INSERT INTO categorias (nome) values ('Cama mesa e banho');
INSERT INTO categorias (nome) values ('Eletrônicos');
INSERT INTO categorias (nome) values ('Jardinagem');
INSERT INTO categorias (nome) values ('Decoração');
INSERT INTO categorias (nome) values ('Perfumaria');
 