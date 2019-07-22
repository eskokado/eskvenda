package br.com.eskinfotechweb.eskvenda.domain;

import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.Table;

import br.com.eskinfotechweb.eskvenda.domain.enums.EstadoPagamento;

@Entity
@Table(name = "pagamentos_com_boleto")
public class PagamentoComBoleto extends Pagamento {
	private static final long serialVersionUID = 1L;

	private LocalDate dataVencimento;
	private LocalDate dataPagamento;

	public PagamentoComBoleto() {
	}

	public PagamentoComBoleto(Long id, EstadoPagamento estado, Pedido pedido, LocalDate dataVencimento,
			LocalDate dataPagamento) {
		super(id, estado, pedido);
		this.dataVencimento = dataVencimento;
		this.dataPagamento = dataPagamento;
	}

	public LocalDate getDataVencimento() {
		return dataVencimento;
	}

	public void setDataVencimento(LocalDate dataVencimento) {
		this.dataVencimento = dataVencimento;
	}

	public LocalDate getDataPagamento() {
		return dataPagamento;
	}

	public void setDataPagamento(LocalDate dataPagamento) {
		this.dataPagamento = dataPagamento;
	}

}
