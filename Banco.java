import java.util.ArrayList;

public class Banco {
    
    private ArrayList<ContaBancaria> contas;

    public Banco() {
        this.contas = new ArrayList<>();
    }

    public boolean adicionarConta(ContaBancaria novaConta) {
        ContaBancaria contaExistente = buscarContaPorNumero(
            novaConta.getNumeroConta()
        );

        if (contaExistente != null) {
            return false;
        }

        contas.add(novaConta);
        return true;
    }

    public int getQuantidadeContas() {
        return contas.size();
    }

    public ContaBancaria buscarContaPorNumero(String numeroConta) {
        
        for (ContaBancaria conta : contas) {
            if (conta.getNumeroConta().equals(numeroConta)) {
                return conta;
            }
         }
            return null;
    }

}
