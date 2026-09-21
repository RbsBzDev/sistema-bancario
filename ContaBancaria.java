public class ContaBancaria {

    private String titular;
    private String numeroConta;
    private double saldo;}

    public contaBancaria(String titular, String numeroConta, double saldoInicial) {
        this.titular = titular;
        this.numeroConta = numeroConta;
        this.saldo = saldoInicial;
    }

    public void exibirDados() {
        System.out.println("Titular: " + titular);
        System.out.println("Conta: " + numeroConta);
        System.out.printf("Saldo: R$ $.2f%n", saldo);
    }

    public void depositar(double valor) {
        if (valor > 0) {
            saldo += valor;
            System.out.println("Depósito realizado com sucesso.");
        } else {
            System.out.println("O valor do depósito tem que ser maior que zero.");
        }
    }

    public void sacar(double valor) {
        if (valor <=0) {
            System.out.println("O valor do saque deve ser maior que zero.");
        } else if (valor > saldo) {
            System.out.println("Saldo insuficiente");
        } else {
            saldo -= valor;
            System.out.println("Saque realizado com sucesso");
        }
    }