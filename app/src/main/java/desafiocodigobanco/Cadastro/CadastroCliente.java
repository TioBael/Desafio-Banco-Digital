package desafiocodigobanco.Cadastro;

import javax.swing.JOptionPane;
import javax.swing.JTextField;

import desafiocodigobanco.Exceptions.CadastroCanceladoException;
import desafiocodigobanco.Pessoa.Cliente;

public class CadastroCliente {

    public Cliente CadastrarCliente(Integer numero) throws CadastroCanceladoException {
        Cliente cliente = null;
        String[] options = { "Conta Corrente", "Conta Poupança" };
        JTextField nome = new JTextField();
        JTextField CPF = new JTextField();
        JTextField telefone = new JTextField();
        JTextField agencia = new JTextField();
        JTextField rua = new JTextField();
        JTextField numeroCasa = new JTextField();
        JTextField CEP = new JTextField();

        Object message[] = {
                "Nome: ", nome,
                "CPF: ", CPF,
                "Telefone: ", telefone,
                "Agencia: ", agencia,
                "\n---Endereço do cliente---\nRua: ", rua,
                "Numero: ", numeroCasa,
                "CEP: ", CEP
        };

        int result = JOptionPane.showConfirmDialog(null, message, "Cadastro cliente", JOptionPane.OK_CANCEL_OPTION);
        if (result == JOptionPane.OK_OPTION) {
            cliente = new Cliente(
                    nome.getText(),
                    CPF.getText(),
                    telefone.getText(),
                    agencia.getText());

            cliente.criarEndereco(
                    rua.getText(),
                    
                    CEP.getText(),
                    Integer.parseInt(numeroCasa.getText()));

            Integer op = JOptionPane.showOptionDialog(null, "Qual tipo de conta deseja criar: ", "Criar conta",
                    JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, null, options, options[0]);

            switch (op) {
                case 0:
                    cliente.criarContaCorrente(numero);
                    break;
                case 1:
                    cliente.criarContaPoupanca(numero);
                    break;
                default:
                    break;
            }
            return cliente;
        } else
            throw new CadastroCanceladoException();
    }
}