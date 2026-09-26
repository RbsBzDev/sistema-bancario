# Sistema Bancário

Projeto criado para praticar Java e orientação a objetos por meio de um sistema bancário simples executado no terminal.

Durante o desenvolvimento, fui adicionando regras bancárias, histórico de operações e testes separados do menu. A ideia é evoluir o projeto aos poucos enquanto estudo conceitos de Java na prática.

## Funcionalidades implementadas

- Criação de contas bancárias;
- Consulta de dados e saldo da conta;
- Depósito e saque com validação de valores;
- Tarifa fixa de R$ 5,00 por saque;
- Transferência entre contas;
- Bloqueio de transferência para a própria conta;
- Limite de R$ 500,00 por transferência;
- Validação de saldo antes de realizar saque ou transferência;
- Resumo com depósitos, saques, transferências enviadas e recebidas;
- Extrato individual com histórico numerado;
- Registro de transferências enviadas e recebidas em cada conta;
- Data e hora incluídas em cada registro do extrato;
- Escolha da conta para realizar as operações pelo menu;
- Validação de entradas para evitar erros ao digitar texto no lugar de números;
- Uso de `BigDecimal` para trabalhar com valores monetários.

## Testes criados

Também foi criada a classe `TesteSistemaBancario.java` para testar as regras principais sem depender do menu.

Atualmente, os testes verificam:

- Saldos das contas após depósito, saque e transferência válidos;
- Quantidade de depósitos, saques e transferências enviadas ou recebidas;
- Quantidade de registros no histórico;
- Depósito com valor inválido;
- Saque com valor zero ou maior que o saldo disponível, considerando a tarifa;
- Transferência acima do limite;
- Transferência sem saldo suficiente, sem alterar origem ou destino;
- Tentativa de transferência para a própria conta;
- Manutenção de saldo, contadores e histórico após operações recusadas.

## Estrutura do projeto

- `Main.java`: contém o menu e a leitura das opções digitadas pelo usuário.
- `ContaBancaria.java`: contém os dados, regras e operações de cada conta.
- `TesteSistemaBancario.java`: executa testes das regras do sistema sem depender do menu.

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

Para executar o sistema pelo menu:

```bash
javac ContaBancaria.java Main.java
java Main
```

Para executar os testes:

```bash
javac ContaBancaria.java TesteSistemaBancario.java
java TesteSistemaBancario
```

## Próximos passos de estudo

- Organizar os cenários de teste em métodos menores;
- Criar uma classe para controlar várias contas do banco;
- Cadastrar novas contas pelo menu;
- Criar tipos diferentes de conta, como conta corrente e poupança;
- Salvar contas e extratos em arquivo.
