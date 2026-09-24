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
        ContaBancaria contaSelecionada;
        ContaBancaria contaDestinoSelecionada;

        do {
            System.out.println("\n --- SISTEMA BANCÁRIO ---");
            System.out.println("1- Consultar dados da conta");
            System.out.println("2. Depositar");
            System.out.println("3. Sacar");
            System.out.println("4. Saldo");
            System.out.println("5. Transferência");
            System.out.println("6. Resumo de Operações");
            System.out.println("7. Extrato");
            System.out.println("0. Sair");
            System.out.print("Escolha uma opção: ");

            opcao = lerInteiro(scanner);

        switch (opcao) {
            case 1:
                contaSelecionada = escolherConta(scanner, conta, contaDestino);
                if (contaSelecionada != null) {
                    contaSelecionada.exibirDados();
                }
                break;

            case 2:
                contaSelecionada = escolherConta(scanner, conta, contaDestino);
                if (contaSelecionada != null) {
                    System.out.println("Digite o valor do depósito: ");
                    double valorDeposito = lerDouble(scanner);
                    contaSelecionada.depositar(valorDeposito);
                }
                break;

            case 3:
                contaSelecionada = escolherConta(scanner, conta, contaDestino);
                if (contaSelecionada != null) {
                    System.out.println("Digite o valor do saque: ");
                    double valorSaque = lerDouble(scanner);
                    contaSelecionada.sacar(valorSaque);
                }
                break;

            case 4:
                contaSelecionada = escolherConta(scanner, conta, contaDestino);
                if (contaSelecionada != null) {
                    contaSelecionada.exibirSaldo();
                }
                break;
            

            case 5:
                System.out.println("Escolha a conta de origem:");
                contaSelecionada = escolherConta(scanner, conta, contaDestino);
                if (contaSelecionada != null) {
                    System.out.println("Escolha a conta de destino:");
                    contaDestinoSelecionada = escolherConta(scanner, conta, contaDestino);
                    
                if (contaDestinoSelecionada != null) {
                    if (contaSelecionada == contaDestinoSelecionada) {
                        System.out.println("A conta de origem e destino devem ser diferentes.");
                    } else {
                        System.out.print("Digite o valor da transferência: ");
                        double valorTransferencia = lerDouble(scanner);
                        contaSelecionada.transferir(valorTransferencia, contaDestinoSelecionada);
                    }
                }
                }
                break;

            case 6:
                contaSelecionada = escolherConta(scanner, conta, contaDestino);
                if (contaSelecionada != null) {
                    contaSelecionada.exibirResumo();
                }
                break;

            case 7:
                contaSelecionada = escolherConta(scanner, conta, contaDestino);
                if (contaSelecionada != null) {
                    contaSelecionada.exibirExtrato();
                }
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
    
    private static ContaBancaria escolherConta(Scanner scanner, ContaBancaria conta, ContaBancaria contaDestino) {
        System.out.println("Escolha a conta:");
        System.out.println("1. Conta do titular: " + conta.getTitular());
        System.out.println("2. Conta do titular: " + contaDestino.getTitular());
        System.out.println("Digite a opção desejada: ");
        int opcaoConta = lerInteiro(scanner);
        if (opcaoConta == 1) {
            return conta;
        } else if (opcaoConta == 2) {
            return contaDestino;
        } else {
            System.out.println("Opção inválida.");
            return null;
        }
        

    }

    private static int lerInteiro(Scanner scanner) {
        while (!scanner.hasNextInt()) {
            System.out.print("Digite um número inteiro válido: ");
            scanner.next();
        }
        return scanner.nextInt();
    }

    private static double lerDouble(Scanner scanner) {
        while (!scanner.hasNextDouble()) {
            System.out.print("Digite um número válido: ");
            scanner.next();
        }
        return scanner.nextDouble();
    }

}