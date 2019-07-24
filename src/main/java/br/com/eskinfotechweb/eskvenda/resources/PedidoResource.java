package br.com.eskinfotechweb.eskvenda.resources;

import java.net.URI;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import br.com.eskinfotechweb.eskvenda.domain.Pedido;
import br.com.eskinfotechweb.eskvenda.services.PedidoService;

@RestController
@RequestMapping("/pedidos")
public class PedidoResource {

	@Autowired
	private PedidoService pedidoService;

	@GetMapping("/{id}")
	public ResponseEntity<Pedido> findById(@PathVariable Long id) {
		Pedido pedido = pedidoService.findById(id);
		return ResponseEntity.ok(pedido);
	}

	@PostMapping
	public ResponseEntity<Pedido> create(@RequestBody Pedido pedido) {
		Pedido pedidoInsert = pedidoService.insert(pedido);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequestUri().path("/{id}").buildAndExpand(pedidoInsert.getId())
				.toUri();
		return ResponseEntity.created(uri).body(pedidoInsert);
	}
}
