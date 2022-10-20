package desafiocodigobanco.Pessoa;

import desafiocodigobanco.Contas.Conta;
import desafiocodigobanco.Contas.ContaCorrente;
import desafiocodigobanco.Contas.ContaPoupanca;

public class Cliente extends Pessoa {
    private String agencia;
    private Conta conta = null;

    public Cliente(String nome, String CPF, String telefone, String agencia) {
        this.nome = nome;
        this.CPF = CPF;
        this.telefone = telefone;
        this.agencia = agencia;
    }
    
    public String getAgencia(){ return this.agencia;    }
    public void setAgencia(String agencia){ this.agencia = agencia; }

    public Conta getConta(){    return this.conta;   }

    public void criarContaCorrente(Integer numero){ this.conta = new ContaCorrente(numero);    }
    public void criarContaPoupanca(Integer numero){ this.conta = new ContaPoupanca(numero);    }

    @Override
    public String toString() {
        String retorno = "Nome: " + getNome() + "\nCPF: " + getCPF() + "\nEndereço: " + getEndereco() + "\nTelefone: " + getTelefone() + "\nAgencia: " + getAgencia();
        if(conta!=null)
            retorno +="\n---\n" + conta.toString() + "\n---\n";

        return retorno;
    }
}
