package br.com.eskinfotechweb.eskvenda.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;

import br.com.eskinfotechweb.eskvenda.domain.Categoria;
import br.com.eskinfotechweb.eskvenda.domain.Produto;
import br.com.eskinfotechweb.eskvenda.dto.ProdutoDTO;
import br.com.eskinfotechweb.eskvenda.repositories.CategoriaRepository;
import br.com.eskinfotechweb.eskvenda.repositories.ProdutoRepository;
import br.com.eskinfotechweb.eskvenda.services.exceptions.DataIntegrityException;
import br.com.eskinfotechweb.eskvenda.services.exceptions.ObjectNotFoundException;

@Service
public class ProdutoService {

	@Autowired
	private ProdutoRepository produtoRepository;
	
	@Autowired
	private CategoriaRepository categoriaRepository;

	public List<Produto> findAll() {
		return produtoRepository.findAll();
	}

	public Produto findById(Long id) {
		Optional<Produto> obj = produtoRepository.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException(
				"Objeto não encontrado! Id: " + id + ", Tipo: " + Produto.class.getName()));
	}

	public Page<Produto> search(String nome, List<Long> ids, Integer page, Integer linesPerPage, String orderBy,
			String direction) {
		PageRequest pageRequest = PageRequest.of(page, linesPerPage, Direction.valueOf(direction), orderBy);
		List<Categoria> categorias = categoriaRepository.findAllById(ids);
		return produtoRepository.search(nome, categorias, pageRequest);
		//return produtoRepository.findDistinctByNomeContainingAndCategoriasIn(nome, categorias, pageRequest);
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
		} catch (DataIntegrityViolationException e) {
			throw new DataIntegrityException("Não é possível excluir um produto que possui categoria! Id: " + id
					+ ", Tipo: " + Produto.class.getName());
		}
	}
	
	public Produto fromDTO(ProdutoDTO produtoDto) {
		return new Produto(produtoDto.getId(), produtoDto.getNome(), produtoDto.getPreco());
	}
}
