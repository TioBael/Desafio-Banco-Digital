package desafiocodigobanco.Visoes;

import javax.swing.JOptionPane;

import desafiocodigobanco.ControleOperacional.ControleUsuarios;
import desafiocodigobanco.Exceptions.CadastroCanceladoException;
import desafiocodigobanco.Pessoa.Funcionario;


public class AdminView {
    ControleUsuarios cu = null;

    public AdminView() {
        cu = new ControleUsuarios();
    }

    public ControleUsuarios getCu() {
        return cu;
    }

    public void MenuAdministrador() {
        if (cu.getFuncionarios().size() == 0){
            for(Boolean exit = false; !exit;) {
                try {
                    cu.adicionarGerente();
                    exit=true;
                } catch (CadastroCanceladoException e) {
                    JOptionPane.showMessageDialog(null, "Não existe gerente, é necessario cadastra ao menos um!",
                            "Cadastro de gerente", JOptionPane.ERROR_MESSAGE);
                }
                if(exit == Boolean.TRUE)
                    break;
            }
        }
    }

    public void MenuAdministrador(Funcionario gerente) {
       
        String boasVindas = "Bem-vindo(a), " + gerente.getNome() + "\nQual opção deseja?";
        String[] options = { "Cadastro de cliente", "Cadastro de caixa", "Cadastro de gerente",
                "Ver clientes cadastrados" };

        for (Boolean exit = false; !exit;) {
            Integer op = JOptionPane.showOptionDialog(null, boasVindas, "Banco DIO", JOptionPane.DEFAULT_OPTION,
                    JOptionPane.QUESTION_MESSAGE,
                    null, options, options[0]);

            switch (op) {
                case 0:
                    for (Boolean i = false; i != true;) {
                        try {
                            cu.adicionarCliente();
                            exit=true;
                            i = true;
                        } catch (CadastroCanceladoException ex) {
                            Integer option = JOptionPane.showConfirmDialog(null, "Cadastro cancelado, deseja sair?",
                                    "Cadastro de conta", JOptionPane.YES_NO_OPTION);
                            if (option == JOptionPane.YES_OPTION)
                                break;
                        }
                    }
                    break;
                case 1:
                    for (Boolean i = false; i != true;) {
                        try {
                            cu.adicionarCaixa();
                            exit=true;
                            i = true;
                        } catch (CadastroCanceladoException ex) {
                            Integer option = JOptionPane.showConfirmDialog(null, "Cadastro cancelado, deseja sair?",
                                    "Cadastro de caixa", JOptionPane.YES_NO_OPTION);
                            if (option == JOptionPane.YES_OPTION)
                                break;
                        }
                    }
                    break;
                case 2:
                    for (Boolean i = false; !i;) {
                        try {
                            cu.adicionarGerente();
                            exit=true;
                            i = true;
                        } catch (CadastroCanceladoException e) {
                            Integer option = JOptionPane.showConfirmDialog(null, "Cadastro cancelado, deseja sair?",
                                    "Cadastro de gerente", JOptionPane.YES_NO_OPTION);
                            if (option == JOptionPane.YES_OPTION)
                                break;
                        }
                    }
                    break;
                case 3:
                    if (cu.getCliente().size() == 0)
                        JOptionPane.showMessageDialog(null, "Nenhum cliente cadastrado!");
                    else
                        JOptionPane.showMessageDialog(null, cu.getCliente().toString());
                    break;
                default:
                    Integer option = JOptionPane.showConfirmDialog(null, "Deseja sair da area do administrador?",
                            "Area do administrador", JOptionPane.YES_NO_OPTION);
                    if (option == JOptionPane.YES_OPTION)
                        exit = true;
                    break;
            }
        }
    }
}