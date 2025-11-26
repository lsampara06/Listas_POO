package prova03;

import java.io.Serializable;

//Representa um único abastecimento de um veículo
//implements Serializable: permite gravar em arquivo binário

public class Abastecimento implements Serializable {
	
	 private static final long serialVersionUID = 1L;

	    private double km;
	    private double litros;
	    private double precoLitro;

	    // Construtor: recebe os dados da abastecida
	    public Abastecimento(double km, double litros, double precoLitro) {
	        this.km = km;
	        this.litros = litros;
	        this.precoLitro = precoLitro;
	    }

	    public double getKm() {
	        return km;
	    }

	    public double getLitros() {
	        return litros;
	    }

	    public double getPrecoLitro() {
	        return precoLitro;
	    }

	    // Opcional: facilidade pra debugar/imprimir
	    @Override
	    public String toString() {
	        return "Abastecimento{" +
	                "km=" + km +
	                ", litros=" + litros +
	                ", precoLitro=" + precoLitro +
	                '}';
	    }

}
