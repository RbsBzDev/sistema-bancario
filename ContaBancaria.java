public class ContaBancaria {

    private String titular;
    private String numeroConta;
    private double saldo;
    private static final double TAXA_SAQUE = 5.00;

    public ContaBancaria(String titular, String numeroConta, double saldoInicial) {
        this.titular = titular;
        this.numeroConta = numeroConta;
        this.saldo = saldoInicial;
    }
    public void exibirSaldo() {
        System.out.printf("Saldo atual: R$ %.2f%n", saldo);
    }

    public void exibirDados() {
        System.out.println("Titular: " + titular);
        System.out.println("Conta: " + numeroConta);
        System.out.printf("Saldo: R$ %.2f%n", saldo);
    }

    public void depositar(double valor) {
        if (valor > 0) {
            saldo += valor;
            System.out.println("Depósito realizado com sucesso.");
            System.out.printf("Saldo atual: R$ %.2f%n", saldo);
        } else {
            System.out.println("O valor do depósito tem que ser maior que zero.");
        }
    }

    public void sacar(double valor) {
        if (valor <= 0) {
            System.out.println("O valor do saque deve ser maior que zero.");
        } else if (valor + TAXA_SAQUE > saldo) {
            System.out.println("Saldo insuficiente.");
            System.out.printf("Saldo atual: R$ %.2f%n", saldo);
        } else {
            saldo -= valor + TAXA_SAQUE;
            System.out.printf("Saque realizado com sucesso.\n");
            System.out.printf("Uma tarifa de R$ %.2f foi aplicada.", TAXA_SAQUE);
            System.out.printf("\nSaldo atual: R$ %.2f%n", saldo);
        }
    
    public void transferir(double valor, ContaBancaria contaDestino) {
        if (valor <= 0) {
            System.out.println("O valor da trasnferÇencia deve ser maior que zero.");
        } else if (valor > saldo) {
            System.out.println("Saldo insuficiente para realizar a transferência.");
            System.out.printf("Saldo atual: R$ %.2f%n", saldo);
        } else {
            saldo -= valor;
            contaDestino.saldo += valor;
            System.out.printf("Transferência de R$ %.2f realizada com sucesso para a conta %s.\n", valor, contaDestino.numeroConta);
            System.out.printf("Saldo atual: R$ %.2f%n", saldo);
        }   
    
    
    }
}