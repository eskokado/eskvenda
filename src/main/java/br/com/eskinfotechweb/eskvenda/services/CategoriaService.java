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
import br.com.eskinfotechweb.eskvenda.dto.CategoriaDTO;
import br.com.eskinfotechweb.eskvenda.repositories.CategoriaRepository;
import br.com.eskinfotechweb.eskvenda.services.exceptions.DataIntegrityException;
import br.com.eskinfotechweb.eskvenda.services.exceptions.ObjectNotFoundException;

@Service
public class CategoriaService {

	@Autowired
	private CategoriaRepository categoriaRepository;

	public List<Categoria> findAll() {
		return categoriaRepository.findAll();
	}

	public Categoria findById(Long id) {
		Optional<Categoria> obj = categoriaRepository.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException(
				"Objeto não encontrado! Id: " + id + ", Tipo: " + Categoria.class.getName()));
	}
	
	public Page<Categoria> findPage(Integer page, Integer linesPerPage, String orderBy, String direction ) {
		PageRequest pageRequest = PageRequest.of(page, linesPerPage, Direction.valueOf(direction), orderBy);
		return categoriaRepository.findAll(pageRequest);
	}

	public Categoria insert(Categoria categoria) {
		categoria.setId(null);
		Categoria categoriaInsert = categoriaRepository.save(categoria);
		return categoriaInsert;
	}

	public Categoria update(Long id, Categoria categoria) {
		Categoria categoriaUpdate = findById(id);
		BeanUtils.copyProperties(categoria, categoriaUpdate, "id", "produtos");

		return categoriaRepository.save(categoriaUpdate);
	}

	public void delete(Long id) {
		Categoria categoria = findById(id);
		try {
			categoriaRepository.delete(categoria);
		} catch (DataIntegrityViolationException e) {
			throw new DataIntegrityException("Não é possível excluir uma categoria que possui produto! Id: " + id
					+ ", Tipo: " + Categoria.class.getName());
		}
	}

	public Categoria fromDTO(CategoriaDTO objDTO) {
		return new Categoria(objDTO.getId(), objDTO.getNome());
	}

}
