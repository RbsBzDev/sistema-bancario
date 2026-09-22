public class ContaBancaria {

    private String titular;
    private String numeroConta;
    private double saldo;
    private int quantidadeDepositos;
    private int quantidadeSaques;
    private int quantidadeTransferencias;
    private static final double TAXA_SAQUE = 5.00;

    public ContaBancaria(String titular, String numeroConta, double saldoInicial) {
        this.titular = titular;
        this.numeroConta = numeroConta;
        this.saldo = saldoInicial;
    }

    public String getTitular() {
        return titular;
    }

    public String getQuantidadeDepositos() {
        return String.valueOf(quantidadeDepositos);
    }

    public String getQuantidadeSaques() {
        return String.valueOf(quantidadeSaques);
    }

    public String getQuantidadeTransferencias() {
        return String.valueOf(quantidadeTransferencias);
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
            quantidadeDepositos++;
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
            quantidadeSaques++;
        }
    }
    public void transferir(double valor, ContaBancaria contaDestino) {
        if (valor <= 0) {
            System.out.println("O valor da transferência deve ser maior que zero.");
        } else if (valor > saldo) {
            System.out.println("Saldo insuficiente para realizar a transferência.");
            System.out.printf("Saldo atual: R$ %.2f%n", saldo);
        } else {
            saldo -= valor;
            contaDestino.saldo += valor;
            System.out.printf("Transferência de R$ %.2f realizada com sucesso para a conta %s.\n", valor, contaDestino.numeroConta);
            System.out.printf("Saldo atual: R$ %.2f%n", saldo);
            quantidadeTransferencias++;
        }       
    }

    public void exibirExtrato() {
        System.out.println("Extrato da conta:");
        System.out.printf("Titular: %s%n", titular);
        System.out.printf("Conta: %s%n", numeroConta);
        System.out.printf("Saldo atual: R$ %.2f%n", saldo);
        System.out.printf("Quantidade de depósitos: %d%n", quantidadeDepositos);
        System.out.printf("Quantidade de saques: %d%n", quantidadeSaques);
        System.out.printf("Quantidade de Transferências: %d%n", quantidadeTransferencias);
    }





}