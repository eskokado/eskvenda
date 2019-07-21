CREATE TABLE clientes (
  id BIGINT(20) PRIMARY KEY AUTO_INCREMENT,
  nome varchar(255) DEFAULT NULL,
  email varchar(255) DEFAULT NULL,
  cpf_ou_cnpj varchar(255) DEFAULT NULL,
  tipo int(11) DEFAULT NULL,
  senha varchar(255) DEFAULT NULL
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

INSERT INTO clientes (id, nome, email, cpf_ou_cnpj, tipo, senha)
values
(1, 'Maria Silva', 'eskokadofoxxb@gmail.com', '61850389004', 1, '$2a$10$Aef0glhRa6PMGrqMnQAZUuJr.WeFQWatOXZnU6NxE81EvAkB65qFm'),
(2, 'Ana Costa', 'eskokadoeef@gmail.com', '14145573021', 1, '$2a$10$Aef0glhRa6PMGrqMnQAZUuJr.WeFQWatOXZnU6NxE81EvAkB65qFm');

CREATE TABLE telefones (
  cliente_id BIGINT(20) NOT NULL,
  telefones varchar(255) DEFAULT NULL,
  FOREIGN KEY (cliente_id) REFERENCES clientes(id)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

INSERT INTO telefones (cliente_id, telefones)
VALUES
(1, '1212121212'),
(1, '343434343434'),
(2, '3445677777'),
(2, '656577875346');

CREATE TABLE enderecos (
  id BIGINT(20) PRIMARY KEY AUTO_INCREMENT,
  logradouro varchar(255) DEFAULT NULL,
  numero varchar(255) DEFAULT NULL,
  complemento varchar(255) DEFAULT NULL,
  bairro varchar(255) DEFAULT NULL,
  cep varchar(255) DEFAULT NULL,
  cliente_id BIGINT(20) DEFAULT NULL,
  cidade_id BIGINT(20) DEFAULT NULL,
  FOREIGN KEY (cliente_id) REFERENCES clientes(id),
  FOREIGN KEY (cidade_id) REFERENCES cidades(id)
) ENGINE=MyISAM AUTO_INCREMENT=4 DEFAULT CHARSET=latin1;

INSERT INTO enderecos (id, logradouro, numero, complemento, bairro, cep, cliente_id, cidade_id)
VALUES
(1, 'Ruas Flores', '300', 'Apto 203', 'Jardim', '1212121212', 1, 2389),
(2, 'Avenida Matos', '105', 'Sala 800', 'Centro', '34343434343', 1, 5270),
(3, 'Avenida Floriano', '455', '', 'Norte', '89898989898', 2, 4814);
