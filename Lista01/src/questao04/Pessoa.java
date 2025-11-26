package questao04;

public class Pessoa {
	String nome;
    double altura;
    double peso;

    public double calcularImc() {
        return peso / (altura * altura);
    }

}
