import java.util.ArrayList;
import java.math.BigDecimal;

public class ContaBancaria {

    private String titular;
    private String numeroConta;
    private BigDecimal saldo;
    private int quantidadeDepositos;
    private int quantidadeSaques;
    private int quantidadeTransferencias;
    private int quantidadeTransferenciasRecebidas;
    private static final BigDecimal TAXA_SAQUE = new BigDecimal("5.00");
    private ArrayList<String> historico;


    public ContaBancaria(String titular, String numeroConta, BigDecimal saldoInicial) {
        this.titular = titular;
        this.numeroConta = numeroConta;
        this.saldo = saldoInicial;
        this.historico = new ArrayList<>();
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

    private void registrarHistorico(String registro) {
        this.historico.add(registro);
    }
    
    private void registrarTransferenciasRecebidas() {
        quantidadeTransferenciasRecebidas++;
    }

    public void exibirResumo() {
        System.out.println("Resumo da conta:");
        System.out.printf("Titular: %s%n", titular);
        System.out.printf("Conta: %s%n", numeroConta);
        System.out.printf("Saldo atual: R$ %.2f%n", saldo);
        System.out.printf("Quantidade de depósitos: %d%n", quantidadeDepositos);
        System.out.printf("Quantidade de saques: %d%n", quantidadeSaques);
        System.out.printf("Quantidade de Transferências enviadas: %d%n", quantidadeTransferencias);
        System.out.printf("Quantidade de Transferências Recebidas: %d%n ", quantidadeTransferenciasRecebidas);
    }

    public void exibirExtrato() {
        System.out.printf("Extrato da conta de: %s%n", titular);
        if (historico.isEmpty()) {
            System.out.println("Nenhuma operação realizada.");
        } else {
            int numero = 1;
            for (String registro : historico) {
                System.out.printf("%d. %s%n", numero, registro);
                numero++;
            }
        }
    }


    public void depositar(BigDecimal valor) {
        if (valor.compareTo(BigDecimal.ZERO) > 0) {
            saldo = saldo.add(valor);
            System.out.println("Depósito realizado com sucesso.");
            System.out.printf("Saldo atual: R$ %.2f%n", saldo);
            quantidadeDepositos++;
            String registroDeposito = String.format("Depósito de R$ %.2f.", valor);
            registrarHistorico(registroDeposito);
        } else {
            System.out.println("O valor do depósito tem que ser maior que zero.");
        }
    }

    public void sacar(BigDecimal valor) {
        if (valor.compareTo(BigDecimal.ZERO) <= 0) {
            System.out.println("O valor do saque deve ser maior que zero.");
        } else if (valor.add(TAXA_SAQUE).compareTo(saldo) > 0) {
            System.out.println("Saldo insuficiente.");
            System.out.printf("Saldo atual: R$ %.2f%n", saldo);
        } else {
            saldo = saldo.subtract(valor.add(TAXA_SAQUE));
            System.out.printf("Saque realizado com sucesso.\n");
            System.out.printf("Uma tarifa de R$ %.2f foi aplicada.", TAXA_SAQUE);
            System.out.printf("\nSaldo atual: R$ %.2f%n", saldo);
            quantidadeSaques++;
            String registroSaque = String.format("Saque de R$ %.2f. Tarifa de R$ %.2f aplicada.", valor, TAXA_SAQUE);
            registrarHistorico(registroSaque);
        }
    }
    public void transferir(BigDecimal valor, ContaBancaria contaDestino) {
        if (valor.compareTo(BigDecimal.ZERO) <= 0) {
            System.out.println("O valor da transferência deve ser maior que zero.");
        } else if (valor.compareTo(saldo) > 0) {
            System.out.println("Saldo insuficiente para realizar a transferência.");
            System.out.printf("Saldo atual: R$ %.2f%n", saldo);
        } else {
            saldo = saldo.subtract(valor);
            contaDestino.saldo = contaDestino.saldo.add(valor);
            System.out.printf("Transferência de R$ %.2f realizada com sucesso para a conta %s.\n", valor, contaDestino.numeroConta);
            System.out.printf("Saldo atual: R$ %.2f%n", saldo);
            quantidadeTransferencias++;
            String registroTransferencia = String.format("Transferência de R$ %.2f enviada para %s.", valor, contaDestino.numeroConta);
            registrarHistorico(registroTransferencia);
            String registroRecebimento = String.format("Transferência recebida de R$ %.2f de %s.", valor, titular);
            contaDestino.registrarHistorico(registroRecebimento);
            contaDestino.registrarTransferenciasRecebidas();
        }       
    }





}