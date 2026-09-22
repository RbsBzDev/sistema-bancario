import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        ContaBancaria conta = new ContaBancaria(
                "Rubens",
                "12345-6",
                0.0
        );

        int opcao;

        do {
            System.out.println("\n --- SISTEMA BANCÁRIO ---");
            System.out.println("1- Consultar dados da conta");
            System.out.println("2. Depositar");
            System.out.println("3. Sacar");
            System.out.println("0. Sair");
            System.out.print("Escolha uma opção: ");

            opcao = scanner.nextInt();

        switch (opcao) {
            case 1:
                conta.exibirDados();
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