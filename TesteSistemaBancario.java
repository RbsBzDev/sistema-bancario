import java.math.BigDecimal;



public class TesteSistemaBancario {
    public static void main(String[] args) {
            
        ContaBancaria conta = new ContaBancaria(
                "Rubens",
                "1",
                BigDecimal.ZERO
            );

        ContaBancaria contaDestino = new ContaBancaria(
                "Gabriel",
                "2",
                BigDecimal.ZERO);

        conta.exibirDados();
        contaDestino.exibirDados();

        BigDecimal valorDeposito = new BigDecimal("1000.00");
        conta.depositar(valorDeposito);

        BigDecimal valorSaque = new BigDecimal("120.00");
        conta.sacar(valorSaque);

        BigDecimal valorTransferencia = new BigDecimal("300.00");
        conta.transferir(valorTransferencia, contaDestino);

        conta.exibirSaldo();
        contaDestino.exibirSaldo();

        conta.exibirExtrato();
        contaDestino.exibirExtrato();
    }
    
}
