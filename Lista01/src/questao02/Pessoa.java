package questao02;

public class Pessoa {

    String nome;
    double peso;
    double altura;

    public double calcularImc() {
        return peso / (altura * altura);
    }
}
