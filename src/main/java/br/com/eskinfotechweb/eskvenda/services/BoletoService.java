package br.com.eskinfotechweb.eskvenda.services;

import java.time.LocalDate;

import org.springframework.stereotype.Service;

import br.com.eskinfotechweb.eskvenda.domain.PagamentoComBoleto;

@Service
public class BoletoService {

	public void preencherPagamentoBoleto(PagamentoComBoleto pagto, LocalDate instanteDoPedido) {
		pagto.setDataVencimento(instanteDoPedido.plusDays(7));
	}
}
