package desafiocodigobanco.Contas;

public class ContaCorrente extends Conta {
    public ContaCorrente(Integer numero){
        setTipo("Conta Corrente");
        setNumero(numero);
    }
}
