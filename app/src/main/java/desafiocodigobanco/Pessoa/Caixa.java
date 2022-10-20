package desafiocodigobanco.Pessoa;

public class Caixa extends Funcionario{
    public Caixa(String nome, String CPF, String telefone) {
        this.nome = nome;
        this.CPF = CPF;
        this.telefone = telefone;
        this.cargo = "Caixa";
        setSalario(5000.00);
    }

    @Override
    public String toString() {
        return "Nome: " + getNome() + "\nCPF: " + getCPF() + "\nMatricula: " + getMatricula() + "\nCargo: " + getCargo() + "\nSalario: " + getSalario();
    }    

    
}