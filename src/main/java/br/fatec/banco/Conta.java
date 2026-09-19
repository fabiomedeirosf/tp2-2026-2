package br.fatec.banco;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

public class Conta {

	private Integer numero;
	
	private String cliente;
	
	private Double saldo;
	
	private Double valorFinanciamento;
	
	private List<String> extrato = new ArrayList<>();
	
	public Conta(Integer numero, String cliente) {
		this.numero = numero;
		this.cliente = cliente;
		this.saldo = 0D;
	}

	/**
	 * Método que atualiza o saldo da conta.
	 * @param valor negativo para retirada e posito para depósito
	 * @return saldo atualizado
	 */
	public Double atualizarSaldo(Double valor) {
		this.saldo += valor;
		
		SimpleDateFormat df = new SimpleDateFormat("dd/MM/YYYY HH:mm");
		String data = df.format(System.currentTimeMillis());
		
		String operacao = (valor > 0) ? "Deposito" : "Saque";
		
		extrato.add(data + " " + operacao + "  " + valor + " " + saldo);
		return this.saldo;
	}
	
	public void mostrarExtrato() {
		System.out.println("##### Extrato de Movimentações #########");
		this.extrato.forEach(e -> {
			System.out.println(e);
			});
	}
	
	public String getCliente() {
		return cliente;
	}

	public void setCliente(String cliente) {
		this.cliente = cliente;
	}

	public Integer getNumero() {
		return numero;
	}

	public Double getSaldo() {
		return saldo;
	}

	@Override
	public String toString() {
		return "Conta [numero=" + numero + ", cliente=" + cliente + ", saldo=" + saldo + "]";
	}

	public Double getValorFinanciamento() {
		return valorFinanciamento;
	}

	public void setValorFinanciamento(Double valorFinanciamento) {
		this.valorFinanciamento = valorFinanciamento;
	}
	
	
	
	
}
