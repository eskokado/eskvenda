package br.com.eskinfotechweb.eskvenda.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import br.com.eskinfotechweb.eskvenda.domain.Produto;
import br.com.eskinfotechweb.eskvenda.repositories.ProdutoRepository;
import br.com.eskinfotechweb.eskvenda.services.exceptions.DataIntegrityException;
import br.com.eskinfotechweb.eskvenda.services.exceptions.ObjectNotFoundException;

@Service
public class ProdutoService {

	@Autowired
	private ProdutoRepository produtoRepository;
	
	public List<Produto> findAll() {
		return produtoRepository.findAll();
	}
	
	public Produto findById(Long id) {
		Optional<Produto> obj = produtoRepository.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException(
				"Objeto não encontrado! Id: " + id + ", Tipo: " + Produto.class.getName()));
	}
	
	public Produto insert(Produto produto) {
		produto.setId(null);
		Produto produtoInsert = produtoRepository.save(produto);
		return produtoInsert;
	}
	
	public Produto update(Long id, Produto produto) {
		Produto produtoUpdate = findById(id);
		BeanUtils.copyProperties(produto, produtoUpdate, "id");
		
		return produtoRepository.save(produtoUpdate);
	}
	
	public void delete(Long id) {
		Produto produto = findById(id);
		try {
			produtoRepository.delete(produto);
		}
		catch (DataIntegrityViolationException e) {
			throw new DataIntegrityException("Não é possível excluir um produto que possui categoria! Id: " + id
					+ ", Tipo: " + Produto.class.getName());
		}
	}
}
