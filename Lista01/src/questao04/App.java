package questao04;

import java.util.Scanner;

public class App {
	public static void main(String[] args) {

    Scanner sc = new Scanner(System.in);

    Pessoa[] pessoas = new Pessoa[3];

    for (int i = 0; i < pessoas.length; i++) {
        pessoas[i] = new Pessoa();

        System.out.println("\nDigite os dados da pessoa " + (i + 1) + ":");

        System.out.print("Nome: ");
        pessoas[i].nome = sc.next();

        System.out.print("Altura (m): ");
        pessoas[i].altura = sc.nextDouble();

        System.out.print("Peso (kg): ");
        pessoas[i].peso = sc.nextDouble();
    }

    System.out.println("\n=== Dados em ordem inversa ===");

    for (int i = pessoas.length - 1; i >= 0; i--) {
        Pessoa p = pessoas[i];
        System.out.println("\nPessoa " + (i + 1));
        System.out.println("Nome: " + p.nome);
        System.out.println("Altura: " + p.altura);
        System.out.println("Peso: " + p.peso);
        System.out.println("IMC: " + p.calcularImc());
    }

    sc.close();
}

}
