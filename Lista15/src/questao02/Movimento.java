package questao02;

import java.time.LocalDateTime;

public class Movimento implements Comparable<Movimento> {
	
	 private LocalDateTime dataHora;
	    private String tipo; // "DEPÓSITO" ou "SAQUE"
	    private double valor;

	    public Movimento(LocalDateTime dataHora, String tipo, double valor) {
	        this.dataHora = dataHora;
	        this.tipo = tipo;
	        this.valor = valor;
	    }

	    public LocalDateTime getDataHora() {
	        return dataHora;
	    }

	    public String getTipo() {
	        return tipo;
	    }

	    public double getValor() {
	        return valor;
	    }

	    // Ordenação natural: por data/hora CRESCENTE
	    @Override
	    public int compareTo(Movimento outro) {
	        // LocalDateTime já implementa Comparable, então podemos delegar
	        return this.dataHora.compareTo(outro.dataHora);
	    }

	    @Override
	    public String toString() {
	        return "Data/Hora: " + dataHora +
	                " | Tipo: " + tipo +
	                " | Valor: " + valor;
	    }

}
