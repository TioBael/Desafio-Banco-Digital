package desafiocodigobanco.Pessoa;

public class Gerente extends Funcionario{

    public Gerente(String nome, String CPF, String telefone) {
        this.nome = nome;
        this.CPF = CPF;
        this.telefone = telefone;
        this.cargo = "Gerente";
        setSalario(20000.00);
    }

    public String toString() {

        return "Nome: " + getNome() + "\nCPF: " + getCPF() + "\nEndereço: " + getEndereco() + "\nTelefone: " + getTelefone();
    }
}