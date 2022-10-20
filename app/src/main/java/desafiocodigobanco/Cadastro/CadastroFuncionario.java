package desafiocodigobanco.Cadastro;

import javax.swing.JOptionPane;
import javax.swing.JTextField;

import desafiocodigobanco.Exceptions.CadastroCanceladoException;
import desafiocodigobanco.Pessoa.Caixa;
import desafiocodigobanco.Pessoa.Gerente;

public class CadastroFuncionario {
    public Gerente CadastrarGerente(Integer matricula) throws CadastroCanceladoException{
        Gerente gerente = null;
        JTextField nome = new JTextField();
        JTextField CPF = new JTextField();
        JTextField telefone = new JTextField();
        JTextField rua = new JTextField();
        JTextField numeroCasa = new JTextField();
        JTextField CEP = new JTextField();
        Object message[] = {
            "Nome: ", nome,
            "CPF: ", CPF,
            "Telefone: ", telefone,
            "\n---Endereço do gerente---\nRua: ", rua,
            "Numero: ", numeroCasa,
            "CEP: ", CEP
        };
        int result = JOptionPane.showConfirmDialog(null, message, "Cadastro de gerente", JOptionPane.OK_CANCEL_OPTION);
        if (result == JOptionPane.OK_OPTION) {
                gerente = new Gerente(
                        nome.getText(),
                        CPF.getText(),
                        telefone.getText());
                gerente.setMatricula(String.valueOf(matricula));

                gerente.criarEndereco(
                        rua.getText(),
                        CEP.getText(),
                        Integer.parseInt(numeroCasa.getText()));
        return gerente;
    } else
        throw new CadastroCanceladoException();
    }

    public Caixa CadastrarCaixa(Integer matricula) throws CadastroCanceladoException{
        Caixa caixa = null;
        JTextField nome = new JTextField();
        JTextField CPF = new JTextField();
        JTextField telefone = new JTextField();
        JTextField rua = new JTextField();
        JTextField numeroCasa = new JTextField();
        JTextField CEP = new JTextField();
        Object message[] = {
            "Nome: ", nome,
            "CPF: ", CPF,
            "Telefone: ", telefone,
            "\n---Endereço do caixa---\nRua: ", rua,
            "Numero: ", numeroCasa,
            "CEP: ", CEP
        };
        int result = JOptionPane.showConfirmDialog(null, message, "Cadastro de caixa", JOptionPane.OK_CANCEL_OPTION);
        if (result == JOptionPane.OK_OPTION) {
                caixa = new Caixa(
                        nome.getText(),
                        CPF.getText(),
                        telefone.getText());
                caixa.setMatricula(String.valueOf(matricula));

                caixa.criarEndereco(
                        rua.getText(),
                        CEP.getText(),
                        Integer.parseInt(numeroCasa.getText()));
        return caixa;
    } else
        throw new CadastroCanceladoException();
    }
}