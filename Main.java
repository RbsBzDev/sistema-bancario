import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        ContaBancaria conta = new ContaBancaria(
                "Rubens",
                "12345-6",
                0.0
        );
        
        ContaBancaria contaDestino = new ContaBancaria(
                "Gabriel",
                "98765-4",
                0.0
        );

        int opcao;
        

        do {
            System.out.println("\n --- SISTEMA BANCÁRIO ---");
            System.out.println("1- Consultar dados da conta");
            System.out.println("2. Depositar");
            System.out.println("3. Sacar");
            System.out.println("4. Saldo");
            System.out.println("5. Transferência");
            System.out.println("6. Resumo de Operações");
            System.out.println("0. Sair");
            System.out.print("Escolha uma opção: ");

            opcao = scanner.nextInt();

        switch (opcao) {
            case 1:
                int opcaoConta;
                System.out.println("Escolha a conta para exibir os dados:");
                System.out.println("1. Conta do titular: " + conta.getTitular());
                System.out.println("2. Conta do titular: " + contaDestino.getTitular());
                System.out.print("Digite a opção desejada: ");
                opcaoConta = scanner.nextInt();
                if (opcaoConta == 1) {
                    conta.exibirDados();
                } else if (opcaoConta == 2) {
                    contaDestino.exibirDados();
                } else {
                    System.out.println("Opção inválida.");
                }
                break;

            case 2:
                System.out.print("Digite o valor do depósito: ");
                double valorDeposito = scanner.nextDouble();
                conta.depositar(valorDeposito);
                break;

            case 3:
                System.out.print("Digite o valor do saque: ");
                double valorSaque = scanner.nextDouble();
                conta.sacar(valorSaque);
                break;

            case 4:
                conta.exibirSaldo();
                break;

            case 5:
                System.out.println("Digite o valor da transferência: ");
                double valorTransferencia = scanner.nextDouble();
                conta.transferir(valorTransferencia, contaDestino);
                break;

            case 6:
                System.out.println("Resumo de Operações:");
                System.out.println("Conta do titular: " + conta.getTitular());
                System.out.println("Quantidade de Depósitos: " + conta.getQuantidadeDepositos());
                System.out.println("Quantidade de Saques: " +  conta.getQuantidadeSaques());
                System.out.println("Quantidade de Transferências: " + conta.getQuantidadeTransferencias());
                break;
            
            case 0:
                System.out.println("Obrigado por utilizar o sistema.");
                break;

                default:
                    System.out.println("Opção Inválida");
        }


        } while (opcao != 0);

        scanner.close();

    }


}