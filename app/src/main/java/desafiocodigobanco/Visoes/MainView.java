package desafiocodigobanco.Visoes;

import javax.swing.JOptionPane;

import desafiocodigobanco.Pessoa.Cliente;
import desafiocodigobanco.Pessoa.Funcionario;

public class MainView {
    Integer index = null;
    AdminView av = null;
    ClientView cv = null;
    CaixaView cav = null;

    protected AdminView getAdminView(){
        return this.av;
    }
    
    public void MenuPrincipal() {
        for (Boolean operation = false; !operation;) {
            String[] options = { "Espaço do cliente", "Espaço dos funcionarios", "Area administrativa" };
            Integer op = JOptionPane.showOptionDialog(null, "Qual area deseja acessar?", "Banco DIO",
                    JOptionPane.DEFAULT_OPTION, JOptionPane.QUESTION_MESSAGE, null, options, options[0]);

            switch (op) {
                case 0:
                    if(av==null || cv==null){
                        JOptionPane.showMessageDialog(null, "Nenhum cliente cadastrado!", "Banco DIO", JOptionPane.ERROR_MESSAGE);
                    } else {
                        for(Boolean exit = Boolean.FALSE; !exit ; ){
                            String numero = JOptionPane.showInputDialog(null, "Digite o numero do cliente: ", "NUMERO", JOptionPane.PLAIN_MESSAGE);
                            for(Cliente supostoCliente : av.getCu().getCliente()){
                            
                                if(supostoCliente.getConta().getNumero().equals(Integer.parseInt(numero))){
                                    index = av.getCu().getCliente().indexOf(supostoCliente);
                                    exit = Boolean.TRUE;
                                    break;
                                }
                            }
                            if(exit)
                                break;
                        JOptionPane.showMessageDialog(null, "Conta não encontrada!", "Espaço do cliente", JOptionPane.ERROR_MESSAGE);
                        }
                    }
                    if(index != null)
                        cv.MenuCliente(av.getCu().getCliente().get(index));
                    break;
                case 1:
                if (av == null){
                    JOptionPane.showMessageDialog(null, "Nenhum caixa cadastrado!", "Banco DIO", JOptionPane.ERROR_MESSAGE);
                } else {
                    for(Boolean exit = Boolean.FALSE; !exit; ){
                        String mat = JOptionPane.showInputDialog(null, "Digite a matricula do caixa: ", "MATRICULA", JOptionPane.PLAIN_MESSAGE);
                            for (Funcionario supostoCaixa : av.getCu().getFuncionarios()) {
                                if(supostoCaixa.getMatricula().equals(mat)){
                                    if(supostoCaixa.getCargo().equals("Caixa")){
                                        index = av.getCu().getFuncionarios().indexOf(supostoCaixa);
                                        exit = Boolean.TRUE;
                                        break;
                                    }
                                    else{
                                        JOptionPane.showMessageDialog(null, "A matricula não é de um caixa!", "Espaço dos funcionarios", JOptionPane.ERROR_MESSAGE);
                                        exit = Boolean.TRUE;
                                        break;
                                    }
                                }
                            }
                            if(exit == Boolean.TRUE)
                                break;
                            JOptionPane.showMessageDialog(null, "Matricula não encontrada!", "Espaço dos funcionarios", JOptionPane.ERROR_MESSAGE);
                        }
                    if(index != null)
                        cav.MenuCaixa(av.getCu().getFuncionarios().get(index), av.getCu().getCliente());
                    index = null;
                }
                    break;
                case 2:
                    if (av == null){
                        av = new AdminView();
                        av.MenuAdministrador();
                    } else {
                        for(Boolean exit = Boolean.FALSE; !exit; ){
                            String mat = JOptionPane.showInputDialog(null, "Digite a matricula do gerente: ", "MATRICULA", JOptionPane.PLAIN_MESSAGE);
                            for (Funcionario supostoGerente : av.getCu().getFuncionarios()) {
                                if(supostoGerente.getMatricula().equals(mat)){
                                    if(supostoGerente.getCargo().equals("Gerente")){
                                        index = av.getCu().getFuncionarios().indexOf(supostoGerente);
                                        exit = Boolean.TRUE;
                                        break;
                                    }
                                    else{
                                        JOptionPane.showMessageDialog(null, "A matricula não é de um gerente!", "Area administrativa", JOptionPane.ERROR_MESSAGE);
                                        exit = Boolean.TRUE;
                                        break;
                                    }
                                }
                            }
                            if(exit == Boolean.TRUE)
                                break;
                            JOptionPane.showMessageDialog(null, "Matricula não encontrada!", "Area administrativa", JOptionPane.ERROR_MESSAGE);
                        }
                        if(index != null)
                            av.MenuAdministrador(av.getCu().getFuncionarios().get(index));
                        cv = new ClientView();
                        cav = new CaixaView();
                        index = null;
                    }
                    break;
                default:
                    Integer option = JOptionPane.showConfirmDialog(null, "Deseja fechar a aplicação?",
                            "Banco DIO", JOptionPane.YES_NO_OPTION);
                    if (option == JOptionPane.YES_OPTION)
                        operation = true;
                    break;
            }
        }
    }
}