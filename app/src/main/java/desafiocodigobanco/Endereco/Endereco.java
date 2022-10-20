package desafiocodigobanco.Endereco;

public class Endereco {
    private String rua;
    private String CEP;
    private Integer numero;

    public Endereco() {
    }

    public String getRua() {
        return rua;
    }

    public void setRua(String rua) {
        this.rua = rua;
    }

    public String getCEP() {
        return CEP;
    }

    public void setCEP(String cEP) {
        CEP = cEP;
    }

    public Integer getNumero() {
        return numero;
    }

    public void setNumero(Integer numero) {
        this.numero = numero;
    }

    @Override
    public String toString() {
        return "Rua: " + rua + "\nNumero: " + numero + "\nCEP: " + CEP;
    }
    
    
    
}