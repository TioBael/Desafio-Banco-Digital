package desafiocodigobanco.Pessoa;

import desafiocodigobanco.Endereco.*;

public class Pessoa {
    protected String nome;
    protected String CPF;
    protected String telefone;
    private Endereco endereco;
    
    public void criarEndereco(String rua, String CEP, Integer numero){
        this.endereco = new Endereco();
        endereco.setRua(rua);
        endereco.setNumero(numero);
        endereco.setCEP(CEP);
    }

    public String getNome() {   return nome;    }
    public void setNome(String nome) {  this.nome = nome;   }

    public String getCPF() {    return CPF; }
    public void setCPF(String CPF) {    this.CPF = CPF; }

    public String getTelefone() {   return telefone;    }
    public void setTelefone(String telefone) {  this.telefone = telefone;   }

    public String getEndereco() { return endereco.toString();    }    
}