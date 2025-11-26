package questao01;

import java.util.Scanner;

public class App { 
	public static void main(String[] args) {

    Scanner sc = new Scanner(System.in);

    // Cria um novo funcionário vazio
    Funcionario f = new Funcionario();

    System.out.print("Digite o nome do funcionário: ");
    // nextLine() lê a linha inteira; se você tiver problemas com quebra de linha,
    // pode usar next() (sem espaços) ou tratar o \n anterior.
    String nome = sc.nextLine();
    f.setNome(nome); // guarda o nome no objeto

    System.out.print("Digite o salário do funcionário: ");
    double salario = sc.nextDouble();
    f.setSalario(salario); // guarda o salário no objeto

    // Calcula o IRPF usando o método da classe
    double irpf = f.calcularIrpf();

    // Exibe o resultado
    System.out.println("\nFuncionário: " + f.getNome());
    System.out.println("Salário: R$ " + f.getSalario());
    System.out.printf("IRPF a pagar: R$ %.2f%n", irpf);

    sc.close();
}

}
