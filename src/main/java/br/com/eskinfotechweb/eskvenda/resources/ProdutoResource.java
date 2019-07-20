package br.com.eskinfotechweb.eskvenda.resources;

import java.net.URI;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import br.com.eskinfotechweb.eskvenda.domain.Produto;
import br.com.eskinfotechweb.eskvenda.services.ProdutoService;

@RestController
@RequestMapping("/produtos")
public class ProdutoResource {

	@Autowired
	private ProdutoService produtoService;
	
	@GetMapping
	public ResponseEntity<List<Produto>> findAll() {
		List<Produto> produtos = produtoService.findAll();
		return ResponseEntity.ok(produtos);
	} 
	
	@GetMapping("/{id}")
	public ResponseEntity<Produto> findById(@PathVariable Long id) {
		Produto produto = produtoService.findById(id);
		return ResponseEntity.ok(produto);		
	}
	
	@PostMapping
	public ResponseEntity<Produto> create(@Valid @RequestBody Produto produto) {
		Produto produtoInsert = produtoService.insert(produto);
		
		URI uri = ServletUriComponentsBuilder.fromCurrentRequestUri().path("/{id}")
				.buildAndExpand(produtoInsert.getId()).toUri();
		
		return ResponseEntity.created(uri).body(produtoInsert);
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<Produto> update(@PathVariable Long id, @Valid @RequestBody Produto produto) {
		Produto produtoUpdate = produtoService.update(id, produto);
		return ResponseEntity.ok(produtoUpdate);
	}
	
	@DeleteMapping("/{id}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void delete(@PathVariable Long id) {
		produtoService.delete(id);
	}
}
