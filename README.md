# Sistema Bancário

Projeto criado para praticar Java e orientação a objetos por meio de um sistema bancário simples executado no terminal.

Ao longo do desenvolvimento, fui adicionando regras bancárias, histórico de operações e uma classe separada para testar o funcionamento das contas sem depender do menu.

## Funcionalidades implementadas

- Criação de contas bancárias;
- Consulta de dados e saldo da conta;
- Depósito e saque com validação de valores;
- Tarifa fixa de R$ 5,00 por saque;
- Transferência entre contas;
- Bloqueio de transferência para a própria conta;
- Limite de R$ 500,00 por transferência;
- Resumo com depósitos, saques, transferências enviadas e recebidas;
- Extrato individual com histórico numerado;
- Registro de transferências enviadas e recebidas em cada conta;
- Data e hora incluídas em cada registro do extrato;
- Escolha da conta para realizar as operações pelo menu;
- Validação de entradas para evitar erros ao digitar texto no lugar de números;
- Uso de `BigDecimal` para trabalhar com valores monetários.

## Testes criados

Também foi criada a classe `TesteSistemaBancario.java` para testar as regras principais sem precisar usar o menu.

Atualmente, os testes verificam:

- Saldo final das duas contas após depósito, saque e transferência;
- Quantidade de depósitos, saques e transferências;
- Quantidade de registros no histórico;
- Bloqueio de transferência acima do limite;
- Manutenção de saldo, contadores e histórico após uma transferência recusada.

## Estrutura do projeto

- `Main.java`: contém o menu e a leitura das opções digitadas pelo usuário.
- `ContaBancaria.java`: contém os dados, regras e operações de cada conta.
- `TesteSistemaBancario.java`: executa testes manuais automatizados das regras do sistema.

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

- Criar testes para depósitos e saques inválidos;
- Criar tipos diferentes de conta, como conta corrente e poupança;
- Salvar contas e extratos em arquivo;
- Criar uma opção para cadastrar novas contas pelo menu.
