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

        BigDecimal saldoEsperadoRubens = new BigDecimal("575.00");
        BigDecimal saldoEsperadoGabriel = new BigDecimal("300.00");

        verificarSaldo("Rubens", saldoEsperadoRubens, conta.getSaldo());
        verificarSaldo("Gabriel", saldoEsperadoGabriel, contaDestino.getSaldo());
       
        verificarQuantidade(
            "Rubens",
            "depositos",
            1,
            conta.getQuantidadeDepositos()
        );
    
        verificarQuantidade(
            "Gabriel",
            "depositos",
            0,
            contaDestino.getQuantidadeDepositos()    
        );
       
        verificarQuantidade(
            "Rubens",
            "saques",
            1,
            conta.getQuantidadeSaques()
        );

        verificarQuantidade(
            "Gabriel",
            "saques",
            0,
            contaDestino.getQuantidadeSaques()
        );

        verificarQuantidade(
            "Rubens",
            "transferencias enviadas",
            1,
            conta.getQuantidadeTransferencias()
        );

        verificarQuantidade(
            "Gabriel",
            "transferencias enviadas",
            0,
            contaDestino.getQuantidadeTransferencias()
        );

        verificarQuantidade(
            "Rubens",
            "transferencias recebidas",
            0,
            conta.getQuantidadeTransferenciasRecebidas()
        );

        verificarQuantidade(
            "Gabriel",
            "transferencias recebidas",
            1,
            contaDestino.getQuantidadeTransferenciasRecebidas()
        );

        verificarQuantidade(
            "Rubens",
            "registros no histórico",
            3,
            conta.getQuantidadeRegistrosHistorico()
        );

        verificarQuantidade(
            "Gabriel",
            "registros no histórico",
            1,
            contaDestino.getQuantidadeRegistrosHistorico()
        );

        BigDecimal transferenciaAcimaDoLimite = new BigDecimal("500.01");
        conta.transferir(transferenciaAcimaDoLimite, contaDestino);
            System.out.println("\n--- Verificando transferência recusada ---");

        verificarSaldo(
            "Rubens após transferência recusada",
            saldoEsperadoRubens,
            conta.getSaldo()
        );

        verificarSaldo(
            "Gabriel após transferência recusada",
            saldoEsperadoGabriel,
            contaDestino.getSaldo()
        );

        verificarQuantidade(
            "Rubens",
            "transferências enviadas após recusa",
            1,
            conta.getQuantidadeTransferencias()
        );

        verificarQuantidade(
            "Gabriel",
            "transferências recebidas após recusa",
            1,
            contaDestino.getQuantidadeTransferenciasRecebidas()
        );
        
        verificarQuantidade(
            "Rubens",
            "registros no histórico",
            3,
            conta.getQuantidadeRegistrosHistorico()
        );

        verificarQuantidade(
            "Gabriel",
            "registros no histórico",
            1,
            contaDestino.getQuantidadeRegistrosHistorico()
        );

        System.out.println("\n --- Verificando depósito inválido ---");
        BigDecimal depositoInvalido = new BigDecimal("-50.00");
        conta.depositar(depositoInvalido);

        verificarSaldo(
            "Rubens após depósito inválido",
            saldoEsperadoRubens,
            conta.getSaldo()
        );
        
        verificarQuantidade(
            "Rubens",
            "depósitos após depósito inválido",
            1,
            conta.getQuantidadeDepositos()
        );

        verificarQuantidade(
            "Rubens",
            "registros no histórico após depósito inválido",
            3,
            conta.getQuantidadeRegistrosHistorico()
        );


        System.out.println("\n --- Verificando saque inválido ---");
        BigDecimal saqueInvalido = BigDecimal.ZERO;
        conta.sacar(saqueInvalido);
        
        verificarSaldo(
           "Rubens após saque inválido",
            saldoEsperadoRubens,
            conta.getSaldo()
        );
        
        verificarQuantidade(
            "Rubens",
            "saques esperados após saque inválido",
            1,
            conta.getQuantidadeSaques()
        );

        verificarQuantidade(
            "Rubens",
            "registros após sáque inválido",
            3,
            conta.getQuantidadeRegistrosHistorico()
        );

        System.out.println("\n Verificando saque maior que saldo ---");
        BigDecimal saqueMaiorQueSaldo = new BigDecimal("571.00");
        conta.sacar(saqueMaiorQueSaldo);

        verificarSaldo(
            "Rubens após saque maior que saldo",
            saldoEsperadoRubens,
            conta.getSaldo()
        );

        verificarQuantidade(
            "Rubens",
            "saques esperados",
            1,
            conta.getQuantidadeSaques()
        );

        verificarQuantidade(
            "Rubens",
            "histórico após saque maior que saldo",
            3,
            conta.getQuantidadeRegistrosHistorico()
        );

        testarTransferenciaSemSaldo();

        testarTransferenciaParaMesmaConta();

        testarCadastroDeConta();

        conta.exibirSaldo();
        contaDestino.exibirSaldo();

        conta.exibirExtrato();
        contaDestino.exibirExtrato();
        
    }

    private static void testarTransferenciaParaMesmaConta() {
        ContaBancaria contaMaria = new ContaBancaria(
            "Maria",
            "4",
            new BigDecimal("500.00")
        );

        BigDecimal valorTransferenciaParaMesmaConta = new BigDecimal("200.00");
        BigDecimal saldoEsperadoMaria = new BigDecimal("500.00");

        contaMaria.transferir(valorTransferenciaParaMesmaConta, contaMaria);

        verificarSaldo(
            "Maria",
            saldoEsperadoMaria,
            contaMaria.getSaldo()
        );

        verificarQuantidade(
            "Maria",
            "transferencias enviadas",
            0,
            contaMaria.getQuantidadeTransferencias()
        );

        verificarQuantidade(
            "Maria",
            "transferencias recebidas",
            0,
            contaMaria.getQuantidadeTransferenciasRecebidas()
        );

        verificarQuantidade(
            "Maria",
            "registros no historico",
            0,
            contaMaria.getQuantidadeRegistrosHistorico()
        );
    }

    private static void testarTransferenciaSemSaldo() {

        BigDecimal saldoAna = new BigDecimal("100.00");
        BigDecimal transferenciaSemSaldo = new BigDecimal("200.00");

        ContaBancaria contaAna = new ContaBancaria(
            "Ana",
            "1",
            new BigDecimal("100.00")
        );

        ContaBancaria contaGabriel = new ContaBancaria(
            "Gabriel",
            "2",
            BigDecimal.ZERO
        );

        contaAna.transferir(transferenciaSemSaldo, contaGabriel);

        verificarSaldo(
            "Ana",
            saldoAna,
            contaAna.getSaldo()
        );

        verificarQuantidade(
            "Ana",
            "transferência enviada",
            0,
            contaAna.getQuantidadeTransferencias()
        );

        verificarQuantidade(
            "Ana",
            "registro no histórico",
            0,
            contaAna.getQuantidadeRegistrosHistorico()
        );

        verificarSaldo(
            "Gabriel",
            BigDecimal.ZERO,
            contaGabriel.getSaldo()
        );

        verificarQuantidade(
            "Gabriel",
            "tranferencia recebida",
            0,
            contaGabriel.getQuantidadeTransferenciasRecebidas()
        );

        verificarQuantidade(
            "Gabriel",
            "registro no histórico",
            0,
            contaGabriel.getQuantidadeRegistrosHistorico()
        );
    }

    private static void testarCadastroDeConta() {

        Banco banco = new Banco();
        ContaBancaria contaTeste = new ContaBancaria(
            "Teste",
            "10",
            BigDecimal.ZERO
        );

        ContaBancaria segundaConta = new ContaBancaria(
            "Segunda",
            "10",
            BigDecimal.ZERO
        );
        
        boolean primeiraContaCadastrada = banco.adicionarConta(contaTeste);
        boolean segundaContaCadastrada = banco.adicionarConta(segundaConta);



        ContaBancaria contaEncontrada = banco.buscarContaPorNumero("10");

        if (contaEncontrada == contaTeste) {
            System.out.println("Conta encontrada.");
        } else {
            System.out.println("Conta não encontrada");
        }

        ContaBancaria contaNaoEncontrada = banco.buscarContaPorNumero("99");

        if (contaNaoEncontrada == null) {
            System.out.println("A conta não foi encontrada");
        } else {
            System.out.println("O teste falhou");
        }


        verificarQuantidade(
            "banco",
            "contas cadastradas",
            1,
            banco.getQuantidadeContas()
        );
    }

    

    private static void verificarSaldo(
        String nomeConta,
        BigDecimal saldoEsperado,
        BigDecimal saldoAtual
    ) {
         if (saldoAtual.compareTo(saldoEsperado) == 0) {
            System.out.printf("Teste de saldo de %s aprovado.%n", nomeConta);
        } else {
            System.out.printf("Teste de saldo %s falhou. Esperado: R$ %.2f | Atual: R$ %.2f%n",
                nomeConta,
                saldoEsperado,
                saldoAtual
            );
        }
    }
   
    private static void verificarQuantidade(
        String nomeConta, 
        String nomeOperacao,
        int quantidadeEsperada,
        int quantidadeAtual
    ) {
        if (quantidadeAtual == quantidadeEsperada) {
            System.out.printf("Teste de %s de %s aprovado.%n",
                nomeOperacao,
                nomeConta
            );
        } else {
            System.out.printf("Teste de %s de %s falhou. Esperado: %d | Atual: %d.%n",
                nomeOperacao,
                nomeConta,
                quantidadeEsperada,
                quantidadeAtual
            );
        }
    }

}
