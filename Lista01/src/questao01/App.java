package questao01;

public class App {

    public static void main(String[] args) {

        Pessoa p = new Pessoa();
        p.nome = "Pessoa Exemplo";
        p.altura = 1.75;
        p.peso = 78;

        double imc = p.calcularImc();

        System.out.println("IMC calculado = " + imc);
    }

}
