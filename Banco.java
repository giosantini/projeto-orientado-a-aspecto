
import java.util.ArrayList;
import java.util.List;

public class Banco {
    private List<Conta> contas = new ArrayList<>();

    public void adicionarConta(Conta conta) {
        contas.add(conta);
    }

    public void realizarSaque(double valor) {
        for (Conta conta : contas) {
            if (conta.sacar(valor)) {
                System.out.println("Saque realizado com sucesso na conta com saldo inicial: " + conta.getSaldo());
                return;
            }
        }
        System.out.println("Saldo insuficiente em todas as contas.");
    }

    public static void main(String[] args) {
        Banco banco = new Banco();
        banco.adicionarConta(new ContaCorrente(1000));
        banco.adicionarConta(new ContaPoupanca(500));

        banco.realizarSaque(200); // Saque bem-sucedido
        banco.realizarSaque(1500); // Saldo insuficiente
    }
}
