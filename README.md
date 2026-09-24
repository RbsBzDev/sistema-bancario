# Sistema Bancário

Projeto criado para praticar Java e orientação a objetos por meio de um sistema bancário simples no terminal.

## O que já foi implementado

- Criação de contas bancárias;
- Consulta de dados e saldo da conta;
- Depósito e saque com validações de valor e saldo;
- Tarifa fixa de R$ 5,00 por saque;
- Transferência entre contas, incluindo validação para impedir transferência para a própria conta;
- Resumo com a quantidade de depósitos, saques e transferências realizadas;
- Extrato individual com histórico das movimentações;
- Registro de transferências enviadas e recebidas em cada conta;
- Escolha da conta para realizar as operações do menu;
- Validação de entradas para evitar que o programa encerre ao receber texto no lugar de números.

## Estrutura do projeto

- `Main.java`: contém o menu e a leitura das opções digitadas pelo usuário.
- `ContaBancaria.java`: contém os dados, regras e operações de cada conta.

## Opções do menu

1. Consultar dados da conta
2. Depositar
3. Sacar
4. Consultar saldo
5. Transferir
6. Exibir resumo de operações
7. Exibir extrato
0. Sair

## Como executar

Compile os arquivos:

```bash
javac ContaBancaria.java Main.java
```

Depois, execute:

```bash
java Main
```

## Próximos passos de estudo

- Trabalhar com mais tipos de conta, como conta corrente e poupança;
- Salvar contas e extratos em arquivo;
- Adicionar data e hora às movimentações;
- Estudar `BigDecimal` para valores monetários.
