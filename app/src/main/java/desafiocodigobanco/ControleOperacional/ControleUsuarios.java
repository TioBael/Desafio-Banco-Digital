package desafiocodigobanco.ControleOperacional;

import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

import desafiocodigobanco.Cadastro.CadastroCliente;
import desafiocodigobanco.Cadastro.CadastroFuncionario;
import desafiocodigobanco.Exceptions.CadastroCanceladoException;
import desafiocodigobanco.Pessoa.Cliente;
import desafiocodigobanco.Pessoa.Funcionario;

public class ControleUsuarios {
    private List<Cliente> cliente = new ArrayList<>();
    private List<Funcionario> funcionarios = new ArrayList<>();
    public ControleUsuarios() {
    }
    
    public List<Funcionario> getFuncionarios() {
        return funcionarios;
    }
    public List<Cliente> getCliente() {
        return cliente;
    }
    
    public List<Cliente> adicionarCliente() throws CadastroCanceladoException {
        CadastroCliente cc = new CadastroCliente();

        cliente.add(cc.CadastrarCliente(cliente.size()));
        JOptionPane.showMessageDialog(null, cliente.get(cliente.size()-1).toString(), "Detalhes Conta",
                JOptionPane.INFORMATION_MESSAGE);

        return cliente;
    }

    public List<Funcionario> adicionarCaixa() throws CadastroCanceladoException {
        CadastroFuncionario cf = new CadastroFuncionario();
        funcionarios.add(cf.CadastrarCaixa(funcionarios.size()));
        JOptionPane.showMessageDialog(null, funcionarios.get(funcionarios.size()-1).toString(), "Detalhes do novo caixa",
                JOptionPane.INFORMATION_MESSAGE);

        return funcionarios;
    }

    public List<Funcionario> adicionarGerente() throws CadastroCanceladoException {
        CadastroFuncionario cf = new CadastroFuncionario();
        for (Boolean i = false; i != true;) {
            funcionarios.add(cf.CadastrarGerente(funcionarios.size()));
            i = true;
            JOptionPane.showMessageDialog(null, funcionarios.get(funcionarios.size()-1).toString(),
                    "Detalhes do novo gerente",
                    JOptionPane.INFORMATION_MESSAGE);
        }
        return funcionarios;
    }
}