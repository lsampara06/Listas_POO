package questao02;

import java.util.Scanner;

public class App {
	public static void main(String[] args) {

    Scanner sc = new Scanner(System.in);

    Pessoa p = new Pessoa();

    System.out.print("Informe sua altura (em metros): ");
    p.altura = sc.nextDouble();

    System.out.print("Informe seu peso (em kg): ");
    p.peso = sc.nextDouble();

    double imc = p.calcularImc();

    System.out.println("Seu IMC é = " + imc);

    sc.close();
}

}
