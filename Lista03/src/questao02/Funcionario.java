package questao02;

public class Funcionario {// Atributos privados (encapsulamento)
    private String nome;
    private double salario;

    // ===== CONSTRUTORES =====

    // Construtor padrão sem parâmetros
    public Funcionario() {
    }

    // Construtor opcional com nome e salário
    public Funcionario(String nome, double salario) {
        this.nome = nome;
        this.salario = salario;
    }

    // ===== GETTERS E SETTERS =====

    // Retorna o nome do funcionário
    public String getNome() {
        return nome;
    }

    // Define o nome do funcionário
    public void setNome(String nome) {
        this.nome = nome;
    }

    // Retorna o salário
    public double getSalario() {
        return salario;
    }

    // Define o salário
    public void setSalario(double salario) {
        this.salario = salario;
    }

    // ===== REGRA DE NEGÓCIO: CÁLCULO DO IRPF =====
    //
    // Essa função é exatamente a que a sua App chama:
    //   f.calcularIrpf()
    //
    // Então, se essa função não existia na sua classe,
    // o erro na App é justamente "não encontra o método".

    public double calcularIrpf() {

        double s = this.salario;
        double imposto = 0.0;

        // Limites das faixas da tabela da lista 3
        final double LIMITE_FAIXA1 = 1903.98;
        final double LIMITE_FAIXA2 = 2826.65;
        final double LIMITE_FAIXA3 = 3751.05;
        final double LIMITE_FAIXA4 = 4664.68;

        // 1ª faixa: até 1903,98 → isento
        if (s <= LIMITE_FAIXA1) {
            return 0.0;
        }

        // 2ª faixa: 1903,99 a 2826,65 → 7,5%
        if (s > LIMITE_FAIXA1) {
            double baseFaixa2 = Math.min(s, LIMITE_FAIXA2) - LIMITE_FAIXA1;
            imposto += baseFaixa2 * 0.075;
        }

        // 3ª faixa: 2826,66 a 3751,05 → 15%
        if (s > LIMITE_FAIXA2) {
            double baseFaixa3 = Math.min(s, LIMITE_FAIXA3) - LIMITE_FAIXA2;
            imposto += baseFaixa3 * 0.15;
        }

        // 4ª faixa: 3751,06 a 4664,68 → 22,5%
        if (s > LIMITE_FAIXA3) {
            double baseFaixa4 = Math.min(s, LIMITE_FAIXA4) - LIMITE_FAIXA3;
            imposto += baseFaixa4 * 0.225;
        }

        // 5ª faixa: acima de 4664,68 → 27,5%
        if (s > LIMITE_FAIXA4) {
            double baseFaixa5 = s - LIMITE_FAIXA4;
            imposto += baseFaixa5 * 0.275;
        }

        return imposto;
    }

}
