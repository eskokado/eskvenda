package br.com.eskinfotechweb.eskvenda.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.eskinfotechweb.eskvenda.domain.Cliente;
import br.com.eskinfotechweb.eskvenda.repositories.ClienteRepository;
import br.com.eskinfotechweb.eskvenda.services.exceptions.ObjectNotFoundException;

@Service
public class ClienteService {

	@Autowired
	private ClienteRepository clienteRepository;;

	public List<Cliente> findAll() {
		return clienteRepository.findAll();
	}

	public Cliente findById(Long id) {
		Optional<Cliente> cliente = clienteRepository.findById(id);
		return cliente.orElseThrow(() -> new ObjectNotFoundException(
				"Objeto não encontrado! Id: " + id + ", Tipo: " + Cliente.class.getName()));
	}

	public Cliente insert(Cliente cliente) {
		cliente.setId(null);
		cliente.getEnderecos().forEach(e -> e.setCliente(cliente));
		Cliente clienteInsert = clienteRepository.save(cliente);
		return clienteInsert;
	}

	public Cliente update(Long id, Cliente cliente) {
		Cliente clienteUpdate = findById(id);

		clienteUpdate.getEnderecos().clear();
		clienteUpdate.getEnderecos().addAll(cliente.getEnderecos());
		clienteUpdate.getEnderecos().forEach(e -> e.setCliente(clienteUpdate));

		BeanUtils.copyProperties(cliente, clienteUpdate, "id", "enderecos");
		return clienteRepository.save(clienteUpdate);
	}

	public void delete(Long id) {
		Cliente cliente = findById(id);
		clienteRepository.delete(cliente);
	}
	
}
