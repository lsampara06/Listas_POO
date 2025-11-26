package questao02;

public class App {
	public static void main(String[] args) {
        try {
            // Cria uma conta bancária
            ContaBancaria conta = new ContaBancaria("12345-6", "Camila");

            // Faz alguns lançamentos com intervalo de 1 segundo entre eles
            conta.depositar(1000.0);
            Thread.sleep(1000); // espera 1 segundo

            conta.sacar(200.0);
            Thread.sleep(1000);

            conta.depositar(500.0);
            Thread.sleep(1000);

            conta.sacar(50.0);
            Thread.sleep(1000);

            // Lista os movimentos na ordem em que foram adicionados
            System.out.println("Movimentos na ordem ORIGINAL (inserção):");
            conta.listarMovimentos();

            // Chama o método que ordena por hora decrescente
            conta.ordenaMovimentosHoraDecrescente();

            // Lista novamente os movimentos, agora ordenados por hora decrescente
            System.out.println("Movimentos ordenados por HORA decrescente:");
            conta.listarMovimentos();

        } catch (InterruptedException e) {
            // Tratamento caso a thread seja interrompida no Thread.sleep
            e.printStackTrace();
        }
    }

}
