# Desafio DIO - Banco digital

Desafio de codigo proposto no bootcamp DIO - Quebec, onde o objetivo é fazer um simulador basico de um banco digital.

---
Minha base foi criar uma interface para acesso à três areas:

- Gerente:
    
    É aquele que pode cadastrar novos clientes e caixas, e ele tem a relação de todos os clientes. 
    
    Ele consegue acessar essa interface usando a "Area administrativa".


- Caixa:

    É aquele que pode fazer as operações bancarias, como: deposito, saque e transferencias.

    Ele consegue acessar essa interface usando o "Espaço dos funcionarios".

- Cliente:

    O cliente do banco, ele pode acessar o seu próprio saldo, e suas informações.

    Ele consegue acessar essa interface usando o "Espaço do cliente".

    ![image](./assets/menuPrincipal.png)

---

## Gerente:

Abrindo pela primeira vez, não será possivel acessar o "Espaço do cliente" e nem o "Espaço dos funcionarios", pois não tem nenhum cliente nem funcionario cadastrado.

Sendo assim, ao acessar a "Area administrativa", como não existe também nenhum gerente cadastrado, será pedido para cadastrar um gerente.

![image](./assets/cadastroGerente.png) 
![image](./assets/confirmacaoCadastroGerente.png)

E com isso, assim da confirmação dos dados, será mandado de volta ao menu principal, onde pode voltar a "Area administrativa", onde será pedido a matricula do gerente.

O numero da matricula é atribuido conforme for adicionando os funcionarios, logo, como esse é o primeiro funcionario, a matricula será "0". E com isso, será possivel acessar os menus do gerente.

![image](./assets/menuGerente.png)

Aqui como dito anteriormente é possivel fazer o cadastro de cliente, de caixa, de outros gerentes e a relação de clientes cadastrados.

- Cadastro do cliente:

    ![image](./assets/cadastroCliente.png)
    ![image](./assets/cadastroClienteConta.png)
    ![image](./assets/cadastroClienteDetalhes.png)

- Cadastro de caixa:

    ![image](./assets/cadastroCaixa.png)
    ![image](./assets/cadastroCaixaDetalhes.png)

- Ver clientes cadastrados:

    ![image](./assets/verClientesCadastrados.png)

---

## Caixa

Depois de cadastrar o primerio caixa, se torna possivel acessar a area do caixa, onde vai ser perguntado a matricula antes do acesso.

![image](./assets/espacoFuncionarioMatricula.png)

E logo que for indicado a matricula, imediatamente depois vai perguntar qual cliente quer ser atendido.

![image](./assets/areaDoCaixaCliente.png)

E com isso, se o numero do cliente existir, ele irá para o menu do caixa, indicando quais operações gostaria de fazer com o cliente selecionado.

![image](./assets/areaDoCaixaMenu.png)

- Deposito

    ![image](./assets/areaDoCaixaDeposito.png)
    ![iamge](./assets/areaDoCaixaDepositoConfirmacao.png)

- Sacar

    ![image](./assets/areaDoCaixaSacar.png)
    ![image](./assets/areaDoCaixaSacarConfirmacao.png)

- Transfererir

    ![image](./assets/areaDoCaixaTransferirDestino.png)
    ![image](./assets/areaDoCaixaTransferirValor.png)
    ![image](./assets/areaDoCaixaTransferirConfirmacao.png)

---

## Cliente

Agora que o cliente foi cadastrado, é possivel acessar a area do cliente, informando o numero da conta dele assim que for acessado.

![image](./assets/espacoClienteNumero.png)
![image](./assets/espacoClienteMenu.png)

E como foi dito anteriormente, o cliente pode fazer duas operações, "Ver saldo" e "Informações da conta".

- Ver saldo:

    ![image](./assets/espacoClienteSaldo.png)

- Informações da conta:

    ![image](./assets/espacoClienteConta.png)

---

## Problemas a serem corrigidos:

Boa parte das exceções de codigo foi corrigida, mas ainda existe algumas ~~como por exemplo: Se durante qualquer um dos cadastros for deixado um espaço em branco, o programa irá crashar, e se estiver sendo executado numa IDE, será retornado um `NumberFormatException`.~~

Em algumas partes do programa, o `cancelar` ou o `não` não ira retornar ao menu anterior, porém nenhum deles ficará em loop.

O programa não exporta os dados AINDA, então toda vez que fechar, será necessario fazer os cadastros novamente (Como esse codigo foi um aprendizado, persistencia de dados foi ignorado no primeiro momento).