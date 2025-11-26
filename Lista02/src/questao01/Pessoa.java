package questao01;

public class Pessoa { // Atributos privados: só a própria classe pode acessá-los diretamente.
    private String nome;
    private double altura; // em metros
    private double peso;   // em kg

    /**
     * Construtor vazio (padrão).
     * Você pode criar Pessoa p = new Pessoa(); e depois usar setters.
     */
    public Pessoa() {
    }

    /**
     * Construtor com parâmetros (opcional).
     * Facilita criar o objeto já preenchido.
     */
    public Pessoa(String nome, double altura, double peso) {
        this.nome = nome;
        this.altura = altura;
        this.peso = peso;
    }

    // ======= MÉTODOS GETTER E SETTER =======

    /**
     * Getter de nome.
     * Permite LER o atributo nome de fora da classe.
     */
    public String getNome() {
        return nome;
    }

    /**
     * Setter de nome.
     * Permite DEFINIR/MODIFICAR o nome de fora da classe.
     */
    public void setNome(String nome) {
        this.nome = nome;
    }

    public double getAltura() {
        return altura;
    }

    /**
     * Setter de altura.
     * Aqui poderíamos validar se a altura é > 0, por exemplo.
     */
    public void setAltura(double altura) {
        this.altura = altura;
    }

    public double getPeso() {
        return peso;
    }

    /**
     * Setter de peso.
     * Aqui também poderíamos validar se o peso é > 0, se quisermos.
     */
    public void setPeso(double peso) {
        this.peso = peso;
    }

    // ======= REGRAS DE NEGÓCIO =======

    /**
     * Calcula o IMC da pessoa.
     * Fórmula dada na Lista 01:
     *   IMC = peso / (altura^2)
     */
    public double calcularImc() {
        return peso / (altura * altura);
    }

}
