package conta;

public class ContaPoupanca extends Conta{
	private String titular;
	private double saldo;
	
	public ContaPoupanca(int numeroConta) {
		this.numeroConta = numeroConta;
		this.saldo = 100.00; 
	}
	
	public void setTitular(String titular) {
		this.titular = titular;
	}
	public String getTitular() {
		return titular;
	}
	public double getSaldo() {
		return saldo;
	}
	

	void saqueConta(double valor) { //polimorfismo
		if ((saldo - valor) < 0) //reescrita do metodo
			System.out.println("Saldo Insuficiente");
		else saldo = saldo - valor;
	}
	public void depositoConta(double valor) {
		saldo = saldo + valor;
	}
    

}
