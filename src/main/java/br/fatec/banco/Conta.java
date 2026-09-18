package br.fatec.banco;

public class Conta {

	private Integer numero;
	
	private String cliente;
	
	private Double saldo;
	
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
		
		return this.saldo;
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
	
	
	
	
}
