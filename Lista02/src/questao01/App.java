// (Opcional) ajuste o package conforme seu projeto, ex:
package questao01;

import java.util.Scanner;

/**
 * Programa que:
 * - Lê nome, altura e peso de 3 pessoas;
 * - Armazena em um vetor de Pessoa;
 * - Exibe os dados e o IMC em ORDEM INVERSA.
 *
 * Esta é a adaptação da Questão 4 da Lista 01,
 * mas agora usando a classe Pessoa encapsulada.
 */
public class App {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        // Cria um vetor para armazenar 3 pessoas
        Pessoa[] pessoas = new Pessoa[3];

        // Entrada de dados das 3 pessoas
        for (int i = 0; i < pessoas.length; i++) {
            // Instancia uma nova Pessoa
            pessoas[i] = new Pessoa();

            System.out.println("\nDigite os dados da pessoa " + (i + 1) + ":");

            System.out.print("Nome: ");
            // nextLine() lê a linha inteira; dependendo do uso de next/nextDouble,
            // pode precisar de um sc.nextLine() extra. Para simplificar, uso next().
            String nome = sc.next();
            pessoas[i].setNome(nome);

            System.out.print("Altura (em metros): ");
            double altura = sc.nextDouble();
            pessoas[i].setAltura(altura);

            System.out.print("Peso (em kg): ");
            double peso = sc.nextDouble();
            pessoas[i].setPeso(peso);
        }

        // Exibe os dados em ordem inversa (3, 2, 1)
        System.out.println("\n=== Dados em ordem inversa ===");

        for (int i = pessoas.length - 1; i >= 0; i--) {
            Pessoa p = pessoas[i]; // referência para facilitar leitura

            // Usamos os getters para acessar os dados da pessoa
            System.out.println("\nPessoa " + (i + 1));
            System.out.println("Nome: " + p.getNome());
            System.out.println("Altura: " + p.getAltura());
            System.out.println("Peso: " + p.getPeso());
            System.out.println("IMC: " + p.calcularImc());
        }

        sc.close();
    }
}
