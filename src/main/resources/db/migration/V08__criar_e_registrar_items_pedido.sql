CREATE TABLE items_pedido (
  pedido_id BIGINT(20) NOT NULL,
  produto_id BIGINT(20) NOT NULL,
  desconto double DEFAULT NULL,
  preco double DEFAULT NULL,
  quantidade int(11) DEFAULT NULL,
  PRIMARY KEY (pedido_id, produto_id),
  FOREIGN KEY (pedido_id) REFERENCES pedidos(id),
  FOREIGN KEY (produto_id) REFERENCES produtos(id)
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

INSERT INTO items_pedido (pedido_id, produto_id, desconto, quantidade, preco)
VALUES
(1, 1, 0.00, 1, 2000.00),
(1, 3, 0.00, 2, 80.00),
(2, 2, 100.00, 1, 800.00);


