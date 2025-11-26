package questao02;

import java.util.Scanner;

public class App {

	    public static void main(String[] args) {

	        Scanner sc = new Scanner(System.in);

	        // Cria um vetor para armazenar 5 objetos Funcionario
	        Funcionario[] funcionarios = new Funcionario[5];

	        System.out.println("=== Cadastro de 5 funcionários ===");

	        // Laço para ler os dados e preencher o vetor
	        for (int i = 0; i < funcionarios.length; i++) {

	            System.out.println("\nFuncionário " + (i + 1) + ":");

	            // ---------- LER NOME ----------
	            System.out.print("Nome: ");
	            // Usa nextLine() para pegar o nome (pode ter espaço se quiser)
	            String nome = sc.nextLine();

	            // ---------- LER SALÁRIO ----------
	            System.out.print("Salário: ");
	            // Aqui usamos nextDouble() direto, é mais simples do que parseDouble
	            double salario = sc.nextDouble();

	            // Depois de usar nextDouble(), ainda fica um '\n' no buffer
	            // então limpamos com nextLine() para a próxima iteração não pular o nome
	            sc.nextLine();

	            // Cria o objeto Funcionario e configura os atributos
	            Funcionario f = new Funcionario();
	            f.setNome(nome);
	            f.setSalario(salario);

	            // Armazena no vetor
	            funcionarios[i] = f;
	        }

	        // Agora percorremos o vetor novamente para exibir os dados
	        System.out.println("\n=== Relação de funcionários, salários e IRPF ===");

	        for (int i = 0; i < funcionarios.length; i++) {
	            Funcionario f = funcionarios[i];

	            // chama o método da classe Funcionario para calcular o IRPF
	            double irpf = f.calcularIrpf();

	            System.out.println("-----------------------------------");
	            System.out.println("Funcionário: " + f.getNome());
	            System.out.printf("Salário: R$ %.2f%n", f.getSalario());
	            System.out.printf("IRPF: R$ %.2f%n", irpf);
	        }

	        sc.close();
	    }

}
