package questao03;

import java.util.Scanner;

public class App {
	  public static void main(String[] args) {

	        Scanner sc = new Scanner(System.in);

	        Pessoa p1 = new Pessoa();
	        Pessoa p2 = new Pessoa();
	        Pessoa p3 = new Pessoa();

	        System.out.println("Digite dados da primeira pessoa:");
	        System.out.print("Altura: ");
	        p1.altura = sc.nextDouble();
	        System.out.print("Peso: ");
	        p1.peso = sc.nextDouble();

	        System.out.println("\nDigite dados da segunda pessoa:");
	        System.out.print("Altura: ");
	        p2.altura = sc.nextDouble();
	        System.out.print("Peso: ");
	        p2.peso = sc.nextDouble();

	        System.out.println("\nDigite dados da terceira pessoa:");
	        System.out.print("Altura: ");
	        p3.altura = sc.nextDouble();
	        System.out.print("Peso: ");
	        p3.peso = sc.nextDouble();

	        System.out.println("\nIMCs calculados:");
	        System.out.println("Pessoa 1: " + p1.calcularImc());
	        System.out.println("Pessoa 2: " + p2.calcularImc());
	        System.out.println("Pessoa 3: " + p3.calcularImc());

	        sc.close();
	    }
	

}
