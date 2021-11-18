import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;

public abstract class Conta implements IConta {

    private static final int AGENCIA_PADRAO = 1;
    private static int SEQUENCIAL = 1;

    @Getter @Setter private Cliente cliente;
    @Setter(AccessLevel.PROTECTED) protected int agencia;
    @Setter(AccessLevel.PROTECTED) protected int numero;
    @Setter(AccessLevel.PROTECTED) protected double saldo;

    public Conta(Cliente cliente) {
        this.agencia = Conta.AGENCIA_PADRAO;
        this.numero = SEQUENCIAL++;
        this.cliente = cliente;
    }

    @Override
    public void depositar(double valor) {
        this.saldo += valor;
    }

    @Override
    public void sacar(double valor) {
        this.saldo -= valor;
    }

    @Override
    public void transferir(double valor, Conta contaATransferir) {
        this.sacar(valor);
        contaATransferir.depositar(valor);
    }

    protected void infoComum() {
        System.out.println(String.format("Titular: %s", cliente.nome));
        System.out.println(String.format("Agencia: %d", agencia));
        System.out.println(String.format("Numero: %d", numero));
        System.out.println(String.format("Saldo: %.2f", saldo));
    }
}
