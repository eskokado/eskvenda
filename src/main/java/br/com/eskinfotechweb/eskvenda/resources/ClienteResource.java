package br.com.eskinfotechweb.eskvenda.resources;

import java.net.URI;
import java.util.List;
import java.util.stream.Collectors;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import br.com.eskinfotechweb.eskvenda.domain.Cliente;
import br.com.eskinfotechweb.eskvenda.dto.ClienteDTO;
import br.com.eskinfotechweb.eskvenda.services.ClienteService;

@RestController
@RequestMapping("/clientes")
public class ClienteResource {

	@Autowired
	private ClienteService clienteService;

	@GetMapping
	public ResponseEntity<List<ClienteDTO>> findAll() {
		List<Cliente> clientes = clienteService.findAll();
		List<ClienteDTO> clientesDto = clientes.stream().map(c -> new ClienteDTO(c)).collect(Collectors.toList());
		return ResponseEntity.ok(clientesDto);
	}

	@GetMapping("/{id}")
	public ResponseEntity<Cliente> findById(@PathVariable Long id) {
		Cliente cliente = clienteService.findById(id);
		return ResponseEntity.ok(cliente);
	}

	@GetMapping("/page")
	public ResponseEntity<Page<ClienteDTO>> findPage(
				@RequestParam(value = "page", defaultValue = "0") Integer page,
				@RequestParam(value = "linesPerPage", defaultValue = "24") Integer linesPerPage,
				@RequestParam(value = "orderBy", defaultValue = "nome") String orderBy,
				@RequestParam(value = "direction", defaultValue = "ASC") String direction) {
		Page<Cliente> clientes = clienteService.findPage(page, linesPerPage, orderBy, direction);
		Page<ClienteDTO> clientesDto = clientes.map(c -> new ClienteDTO(c));
		return ResponseEntity.ok(clientesDto);
	}
	
	@PostMapping
	public ResponseEntity<Cliente> create(@Valid @RequestBody ClienteDTO clienteDto) {
		Cliente clienteInsert = clienteService.fromDTO(clienteDto) ;
		clienteInsert = clienteService.insert(clienteInsert);

		URI uri = ServletUriComponentsBuilder.fromCurrentRequestUri().path("/{id}")
				.buildAndExpand(clienteInsert.getId()).toUri();

		return ResponseEntity.created(uri).body(clienteInsert);
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<Cliente> update(@PathVariable Long id, @Valid @RequestBody ClienteDTO clienteDto) {
		Cliente clienteUpdate = clienteService.fromDTO(clienteDto); 
		clienteUpdate = clienteService.update(id, clienteUpdate);
		return ResponseEntity.ok(clienteUpdate);
	}
	
	@DeleteMapping("/{id}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void delete(@PathVariable Long id) {
		clienteService.delete(id);
	}
}
