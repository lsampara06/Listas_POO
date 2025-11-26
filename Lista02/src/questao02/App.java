package questao02;

import java.util.Scanner;

/**
1) Solicita ao usuário número e titular de DUAS contas bancárias.
* 2) Realiza as operações:
*    a. Depósitos de 1000 e 700 na primeira conta.
*    b. Depósito de 5000 na segunda conta.
*    c. Saque de 3000 na segunda conta.
*    d. Transferência de 1800 da segunda conta para a primeira.
*    e. Exibe titular e saldo final de cada conta.
*
* Tudo seguindo o enunciado da Lista 02.
**/
public class App {

   public static void main(String[] args) {

       Scanner sc = new Scanner(System.in);

       // ======= CRIAÇÃO DAS DUAS CONTAS =======
       ContaBancaria conta1 = new ContaBancaria();
       ContaBancaria conta2 = new ContaBancaria();

       // Solicita dados da primeira conta
       System.out.println("=== Cadastro da primeira conta ===");
       System.out.print("Número da conta 1: ");
       String numero1 = sc.next();
       conta1.setNumero(numero1);

       System.out.print("Titular da conta 1: ");
       String titular1 = sc.next();
       conta1.setTitular(titular1);

       // Solicita dados da segunda conta
       System.out.println("\n=== Cadastro da segunda conta ===");
       System.out.print("Número da conta 2: ");
       String numero2 = sc.next();
       conta2.setNumero(numero2);

       System.out.print("Titular da conta 2: ");
       String titular2 = sc.next();
       conta2.setTitular(titular2);

       // ======= OPERAÇÕES A-E CONFORME ENUNCIADO =======

       // a. Depósitos na primeira conta: 1000 e 700
       conta1.depositar(1000.0);
       conta1.depositar(700.0);

       // b. Depósito na segunda conta: 5000
       conta2.depositar(5000.0);

       // c. Saque na 2ª conta: 3000
       conta2.sacar(3000.0);

       // d. Transferir 1800 da 2ª conta para a 1ª conta
       conta2.transferir(conta1, 1800.0);

       // e. Exibir o titular de cada conta e seu saldo
       System.out.println("\n=== Saldo final das contas ===");

       System.out.printf("Conta 1 - Titular: %s | Saldo: R$ %.2f%n",
               conta1.getTitular(), conta1.getSaldo());

       System.out.printf("Conta 2 - Titular: %s | Saldo: R$ %.2f%n",
               conta2.getTitular(), conta2.getSaldo());

       sc.close();
   }
}

