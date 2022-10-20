package desafiocodigobanco.ControleOperacional;

import javax.naming.InsufficientResourcesException;
import desafiocodigobanco.Pessoa.Cliente;

public class CaixaEletronico {
    public void Sacar(Cliente cliente, Double valor) throws InsufficientResourcesException{
        cliente.getConta().sacar(valor);
    }
    public void Deposito(Cliente cliente, Double valor){
        cliente.getConta().depositar(valor);
    }
    public void Transferencia(Cliente clienteA, Cliente clienteB, Double valor) throws InsufficientResourcesException{
        clienteA.getConta().sacar(valor);
        clienteB.getConta().depositar(valor);
    }
    public String toString(Cliente cliente) {
        return "Nome: " + cliente.getNome() + "\nConta: " + cliente.getConta().getTipo() + "\nNumero: " + cliente.getConta().getNumero();
    }   
}