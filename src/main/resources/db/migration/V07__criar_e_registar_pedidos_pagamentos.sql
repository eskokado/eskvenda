CREATE TABLE pedidos (
  id BIGINT(20) NOT NULL AUTO_INCREMENT,
  instante DATETIME,
  cliente_id BIGINT(20),
  endereco_de_entrega_id BIGINT(20),
  PRIMARY KEY (id),
  FOREIGN KEY (cliente_id) REFERENCES clientes(id),
  FOREIGN KEY (endereco_de_entrega_id) REFERENCES enderecos(id)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

INSERT INTO pedidos (instante, cliente_id, endereco_de_entrega_id) 
VALUES
('2019/07/15 00:00', 1, 1),
('2019/07/16 00:00', 1, 2);

CREATE TABLE pagamentos (
  pedido_id BIGINT(20) NOT NULL,
  estado INT(11) DEFAULT NULL,
  PRIMARY KEY (pedido_id)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

INSERT INTO pagamentos (pedido_id, estado) 
VALUES 
(1, 2),
(2, 1);

CREATE TABLE pagamentos_com_cartao (
  numero_de_parcelas int(11) DEFAULT NULL,
  pedido_id BIGINT(20) NOT NULL,
  PRIMARY KEY (pedido_id)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

INSERT INTO pagamentos_com_cartao (numero_de_parcelas, pedido_id)
VALUES (1, 6);

CREATE TABLE pagamentos_com_boleto (
  data_pagamento datetime DEFAULT NULL,
  data_vencimento datetime DEFAULT NULL,
  pedido_id BIGINT(20) NOT NULL,
  PRIMARY KEY (pedido_id)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

INSERT INTO pagamentos_com_boleto (data_pagamento, data_vencimento, pedido_id)
VALUES (NULL, '2019/07/30', 2); 

