package entities;

public class Account {
	private int numero;
	private String titular;
	private double saldo;

	private final double taxaDeSaque = 5;

	public Account(int numero, String titular, double depositoInicial) {
		this.numero = numero;
		this.titular = titular;
		deposito(depositoInicial);
	}

	public Account(int numero, String titular) {
		this.numero = numero;
		this.titular = titular;
	}

	public int getNumero() {
		return numero;
	}

	public String getTitular() {
		return titular;
	}

	public void setTitular(String titular) {
		this.titular = titular;
	}

	public double getSaldo() {
		return saldo;
	}

	public void deposito(double qtde) {
		saldo += qtde;
	}

	public void saque(double qtde) {
		saldo -= (qtde + taxaDeSaque);
	}

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return "Conta " + numero + ", Titular: " + titular + ", Saldo: R$ " + String.format("%.2f", saldo);
	}
}
