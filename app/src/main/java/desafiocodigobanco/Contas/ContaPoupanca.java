package desafiocodigobanco.Contas;

public class ContaPoupanca extends Conta {
    private Double rendimento;
    public ContaPoupanca(Integer numero){
        setTipo("Conta Poupança");
        setNumero(numero);
        this.rendimento = 65d;
    }
    public Double getRendimento() { return rendimento;  }
    public void setRendimento(Double rendimento) {  this.rendimento = rendimento;   }
    
    @Override
    public String toString() {
        
        return super.toString() + "\nPorcentagem de rendimentos = " + rendimento/100 + "% ao mês";
    }
    
}
