package desafiocodigobanco.Visoes;

import javax.swing.JOptionPane;

import desafiocodigobanco.Pessoa.Cliente;

public class ClientView {
    public ClientView() {
    }

    public void MenuCliente(Cliente cliente){
        String boasVindas = "Bem-vindo(a), " + cliente.getNome() + "\nQual opção deseja?";
        String[] options = { "Ver saldo", "Informações da conta" };
        for (Boolean exit = false; !exit;) {
            Integer op = JOptionPane.showOptionDialog(null, boasVindas, "Area do cliente", JOptionPane.DEFAULT_OPTION,
                    JOptionPane.QUESTION_MESSAGE,
                    null, options, options[0]);

            switch (op) {
                case 0:
                    JOptionPane.showMessageDialog(null, "Seu saldo é de: " + cliente.getConta().getSaldo() + "R$", "Saldo", JOptionPane.INFORMATION_MESSAGE);
                    break;
                case 1:
                JOptionPane.showMessageDialog(null, cliente.toString(), "Informações da conta", JOptionPane.INFORMATION_MESSAGE);
                    break;
                default:
                    Integer option = JOptionPane.showConfirmDialog(null, "Deseja sair da area do cliente?",
                            "Area do cliente", JOptionPane.YES_NO_OPTION);
                    if (option == JOptionPane.YES_OPTION)
                        exit = true;
                    break;
            }
        }
    }
}
