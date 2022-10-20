package desafiocodigobanco.Visoes;

import java.util.List;

import javax.naming.InsufficientResourcesException;
import javax.swing.JOptionPane;

import desafiocodigobanco.ControleOperacional.CaixaEletronico;
import desafiocodigobanco.Pessoa.Cliente;
import desafiocodigobanco.Pessoa.Funcionario;

public class CaixaView {

    public CaixaView() {
    }

    String outraConta = null;

    public void MenuCaixa(Funcionario funcionario, List<Cliente> cliente) {
        CaixaEletronico ce = new CaixaEletronico();
        String[] options = { "Sacar", "Depositar", "Transferir" };
        Integer index = null;
        Integer indexOutroCliente = null;

        for (Boolean exit = Boolean.FALSE; !exit;) {
            String numeroCliente = JOptionPane.showInputDialog(null, "Digite o numero do cliente para o atendimento: ",
                    "Area do caixa", JOptionPane.INFORMATION_MESSAGE);
            if (numeroCliente == null) {
                Integer op = JOptionPane.showConfirmDialog(null, "Deseja sair?", "Area do caixa",
                        JOptionPane.YES_NO_OPTION);
                if (op == JOptionPane.YES_OPTION)
                    break;
                else
                    continue;
                } 

            for (Cliente supostoCliente : cliente) {
                if (supostoCliente.getConta().getNumero().equals(Integer.parseInt(numeroCliente))) {
                    index = cliente.indexOf(supostoCliente);
                    exit = Boolean.TRUE;
                    break;
                }
            }
            if (exit)
                break;
            JOptionPane.showMessageDialog(null, "Conta não encontrada!", "Area do caixa", JOptionPane.ERROR_MESSAGE);
        }

        if (index != null) {
            for (Boolean exit = false; !exit;) {
                Integer op = JOptionPane.showOptionDialog(null, "Cliente selecionado: " + cliente.get(index).getNome() +
                        "\nQual opção deseja?", "Area do caixa", JOptionPane.DEFAULT_OPTION,
                        JOptionPane.QUESTION_MESSAGE, null, options, options[0]);

                switch (op) {
                    case 0:
                        for (Boolean exitSaque = false; !exit;) {
                            try {
                                String valor = JOptionPane.showInputDialog(null, "Digite o valor do saque: ",
                                "Area do caixa: Saque", JOptionPane.INFORMATION_MESSAGE);
                                if (valor == null) {
                                    Integer opSaidaSaque = JOptionPane.showConfirmDialog(null, "Deseja sair?",
                                            "Area do caixa: Transferencia",
                                            JOptionPane.YES_NO_OPTION);
                                    if (opSaidaSaque == JOptionPane.YES_OPTION) {
                                        exitSaque = true;
                                        break;
                                    } else {
                                        continue;
                                    }
                                }
                                ce.Sacar(cliente.get(index), Double.parseDouble(valor));
                                Integer opSaqueSucesso = JOptionPane.showConfirmDialog(null,
                                        "Saque efetuado com sucesso!\nNovo saldo de: "
                                                + cliente.get(index).getConta().getSaldo()
                                                + "R$\nGostaria de fazer alguma nova operação?",
                                        "Area do caixa: Saque",
                                        JOptionPane.YES_NO_OPTION);
                                if (opSaqueSucesso == JOptionPane.NO_OPTION)
                                    exitSaque = true;
                            } catch (InsufficientResourcesException ex) {
                                Integer opSaque = JOptionPane.showConfirmDialog(null,
                                        "Saque falho, saldo insuficiente\nDeseja tentar novamente?",
                                        "Area do caixa: Saque", JOptionPane.YES_NO_OPTION);
                                if (opSaque == JOptionPane.YES_OPTION)
                                    continue;
                                else
                                    break;
                            }
                        }
                        break;
                    case 1:
                        for (Boolean exitDeposito = false; !exitDeposito;) {
                            String valor = JOptionPane.showInputDialog(null, "Digite o valor do deposito: ",
                            "Area do caixa: Deposito", JOptionPane.INFORMATION_MESSAGE);

                            if (valor == null) {
                                Integer opSaidaDeposito = JOptionPane.showConfirmDialog(null, "Deseja sair?",
                                        "Area do caixa: Transferencia",
                                        JOptionPane.YES_NO_OPTION);
                                if (opSaidaDeposito == JOptionPane.YES_OPTION) {
                                    exitDeposito = true;
                                    break;
                                } else {
                                    continue;
                                }
                            }
                            
                            ce.Deposito(cliente.get(index), Double.parseDouble(valor));
                            Integer opDepositoSucesso = JOptionPane.showConfirmDialog(null,
                                    "Deposito efetuado com sucesso!\nNovo saldo de: "
                                            + cliente.get(index).getConta().getSaldo()
                                            + "R$\nGostaria de fazer alguma nova operação?",
                                    "Area do caixa: Deposito",
                                    JOptionPane.YES_NO_OPTION);
                            if (opDepositoSucesso == JOptionPane.NO_OPTION)
                                exitDeposito = true;
                        }

                        break;
                    case 2:

                        for (Boolean exitTransferencia = false; !exitTransferencia;) {

                            outraConta = JOptionPane.showInputDialog(null, "Digite o numero da conta destino: ",
                                    "Area do caixa: Transferencia", JOptionPane.INFORMATION_MESSAGE);

                            if (outraConta == null) {
                                Integer opSaidaTransferencia = JOptionPane.showConfirmDialog(null, "Deseja sair?",
                                        "Area do caixa: Transferencia",
                                        JOptionPane.YES_NO_OPTION);
                                if (opSaidaTransferencia == JOptionPane.YES_OPTION) {
                                    exitTransferencia = true;
                                    break;
                                }
                            }

                            for (Cliente supostoOutroCliente : cliente) {
                                if (supostoOutroCliente.getConta().getNumero().equals(Integer.parseInt(outraConta))) {
                                    indexOutroCliente = cliente.indexOf(supostoOutroCliente);
                                    exit = Boolean.TRUE;
                                    break;
                                }
                            }
                            if (exit)
                                break;
                            JOptionPane.showMessageDialog(null, "Conta não encontrada!", "Area do caixa",
                                    JOptionPane.ERROR_MESSAGE);
                        }

                        if (outraConta != null) {
                            for (Boolean exitTransferencia = false; !exitTransferencia;) {
                                String valor = JOptionPane.showInputDialog(null,
                                "Digite o valor para transferencia: ", "Area do caixa: Transferencia",
                                JOptionPane.INFORMATION_MESSAGE);

                                Double valorDouble = Double.parseDouble(valor);

                                System.out.println("Saldo primeira conta: " + cliente.get(index).getConta().getSaldo());
                                System.out.println("valor da transferencia: " + valorDouble);

                                try {
                                    ce.Transferencia(cliente.get(index), cliente.get(indexOutroCliente), Double.parseDouble(valor));
                                    Integer opTransferenciaSucesso = JOptionPane.showConfirmDialog(null,
                                            "Transferencia efetuado com sucesso!\nNovo saldo do(a) "
                                                    + cliente.get(index).getNome() + ": "
                                                    + cliente.get(index).getConta().getSaldo()
                                                    + "R$\nNovo saldo do(a)" + cliente.get(indexOutroCliente).getNome()
                                                    + ": " + cliente.get(indexOutroCliente).getConta().getSaldo() + "R$"
                                                    + "\nGostaria de fazer alguma nova operação?",
                                            "Area do caixa: Deposito",
                                            JOptionPane.YES_NO_OPTION);
                                    if (opTransferenciaSucesso == JOptionPane.NO_OPTION)
                                        exitTransferencia = true;
                                } catch (InsufficientResourcesException ex) {
                                    Integer opTransferenciaFalha = JOptionPane.showConfirmDialog(null,
                                            "Transferencia falha, saldo insuficiente\nDeseja tentar novamente?",
                                            "Area do caixa: Transferencia", JOptionPane.YES_NO_OPTION);
                                    if (opTransferenciaFalha == JOptionPane.YES_OPTION)
                                        continue;
                                    else
                                        break;
                                }
                            }
                        }
                        break;
                    default:
                    Integer option = JOptionPane.showConfirmDialog(null, "Deseja sair da area do caixa?",
                            "Area do caixa", JOptionPane.YES_NO_OPTION);
                    if (option == JOptionPane.YES_OPTION)
                        exit = true;
                    break;

                }
            }
        }
    }
}