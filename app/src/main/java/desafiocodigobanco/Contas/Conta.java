package desafiocodigobanco.Contas;

import javax.naming.InsufficientResourcesException;

public class Conta {
    private Integer numero;
    private String tipo;
    private Double saldo=0.0;
    
    public Integer getNumero() {    return numero;  }
    public void setNumero(Integer numero) { this.numero = numero;   }
    
    public String getTipo() {   return tipo;    }
    public void setTipo(String tipo) {  this.tipo = tipo;   }
    
    public Double getSaldo() {  return saldo;   }
    public void setSaldo(Double saldo) {    this.saldo = saldo; }


    public void depositar(Double valor){
        setSaldo(getSaldo()+valor);
    }
    public void sacar(Double valor) throws InsufficientResourcesException{
        if( valor.compareTo(getSaldo()) > 0 ) 
            throw new InsufficientResourcesException("Saldo insuficiente!");
        
        this.setSaldo(getSaldo()-valor);
    }
    @Override
    public String toString() {
        return "Tipo da conta: " + tipo + "\nNumero da conta: " + numero;
    }
}