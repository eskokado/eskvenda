package br.com.eskinfotechweb.eskvenda.services.validations;

import java.util.ArrayList;
import java.util.List;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import org.springframework.beans.factory.annotation.Autowired;

import br.com.eskinfotechweb.eskvenda.domain.Cliente;
import br.com.eskinfotechweb.eskvenda.domain.enums.TipoCliente;
import br.com.eskinfotechweb.eskvenda.dto.ClienteNewDTO;
import br.com.eskinfotechweb.eskvenda.repositories.ClienteRepository;
import br.com.eskinfotechweb.eskvenda.resources.exceptions.FieldMessage;
import br.com.eskinfotechweb.eskvenda.services.validations.utils.BR;

public class ClienteInsertValidator implements ConstraintValidator<ClienteInsert, ClienteNewDTO> {
	
	@Autowired
	private ClienteRepository clienteRepository;
	
	@Override
	public void initialize(ClienteInsert ann) {
	}

	@Override
	public boolean isValid(ClienteNewDTO clienteDto, ConstraintValidatorContext context) {
		List<FieldMessage> list = new ArrayList<>();

		// inclua os testes aqui, inserindo erros na lista
		if (clienteDto.getTipo().equals(TipoCliente.PESSOAFISICA.getCod())
				&& !BR.isValidCPF(clienteDto.getCpfOuCnpj())) {
			list.add(new FieldMessage("cpfOuCnpj", "CPF inválido"));
		}

		if (clienteDto.getTipo().equals(TipoCliente.PESSOAJURIDICA.getCod())
				&& !BR.isValidCNPJ(clienteDto.getCpfOuCnpj())) {
			list.add(new FieldMessage("cpfOuCnpj", "CNPJ inválido"));
		}

		Cliente clienteAux = clienteRepository.findByEmail(clienteDto.getEmail());
		if (clienteAux != null) {
			list.add(new FieldMessage("email", "Email já existente"));
		}
				
		for (FieldMessage e : list) {
			context.disableDefaultConstraintViolation();
			context.buildConstraintViolationWithTemplate(e.getMessage()).addPropertyNode(e.getFieldName())
					.addConstraintViolation();
		}
		return list.isEmpty();
	}
}
