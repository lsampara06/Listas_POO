package questao02;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ContaBancaria {
	 private String numero;
	    private String titular;
	    private double saldo;

	    // Lista que guarda todos os movimentos da conta
	    private List<Movimento> movimentos;

	    public ContaBancaria(String numero, String titular) {
	        this.numero = numero;
	        this.titular = titular;
	        this.saldo = 0.0;
	        this.movimentos = new ArrayList<>();
	    }

	    // Método para depositar dinheiro na conta
	    public void depositar(double valor) {
	        if (valor <= 0) {
	            System.out.println("Valor de depósito inválido.");
	            return;
	        }

	        saldo += valor;

	        // Cria um novo movimento com a data/hora atual
	        Movimento mov = new Movimento(LocalDateTime.now(), "DEPÓSITO", valor);
	        movimentos.add(mov);
	    }

	    // Método para sacar dinheiro da conta
	    public void sacar(double valor) {
	        if (valor <= 0) {
	            System.out.println("Valor de saque inválido.");
	            return;
	        }

	        if (valor > saldo) {
	            System.out.println("Saldo insuficiente.");
	            return;
	        }

	        saldo -= valor;

	        // Cria um novo movimento com a data/hora atual
	        Movimento mov = new Movimento(LocalDateTime.now(), "SAQUE", valor);
	        movimentos.add(mov);
	    }

	    public double getSaldo() {
	        return saldo;
	    }

	    public List<Movimento> getMovimentos() {
	        return movimentos;
	    }

	    // Método pedido no enunciado:
	    // Ordena a lista de movimentos por HORA de forma DECRESCENTE,
	    // utilizando a ordenação natural (compareTo) e depois invertendo.
	    public void ordenaMovimentosHoraDecrescente() {
	        // Collections.reverseOrder() cria um comparador que inverte a ordem natural
	        Collections.sort(movimentos, Collections.reverseOrder());
	    }

	    // Apenas para exibir os movimentos no console
	    public void listarMovimentos() {
	        System.out.println("Movimentos da conta " + numero + " - Titular: " + titular);
	        for (Movimento m : movimentos) {
	            System.out.println(m);
	        }
	        System.out.println("------------------------");
	    }

}
