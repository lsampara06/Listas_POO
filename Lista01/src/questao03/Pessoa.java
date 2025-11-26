package questao03;

public class Pessoa {
	double peso;
	double altura;
	
	public double calcularImc() {
		return peso / (altura * altura);
	}

}
