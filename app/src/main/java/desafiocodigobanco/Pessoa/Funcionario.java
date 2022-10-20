package desafiocodigobanco.Pessoa;

public class Funcionario extends Pessoa {
    protected String cargo;
    protected String matricula;
    private Double salario;
    public Funcionario() { }
    
    public String getCargo() {  return cargo;   }
    public void setCargo(String cargo) {    this.cargo = cargo; }

    public String getMatricula() {  return matricula;   }
    public void setMatricula(String matricula) {    this.matricula = matricula; }
    
    public Double getSalario() {    return salario; }
    public void setSalario(Double salario) {    this.salario = salario; }

    
}
