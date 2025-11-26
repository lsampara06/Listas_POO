package questao01;

public class Funcionario {// Atributos privados (encapsulamento)
    private String nome;
    private double salario;

    // ======= CONSTRUTORES =======

    public Funcionario() {
        // Construtor padrão (sem argumentos)
    }

    public Funcionario(String nome, double salario) {
        // Usa this para diferenciar atributo do parâmetro
        this.nome = nome;
        this.salario = salario;
    }

    // ======= GETTERS E SETTERS =======

    /**
     * Getter do nome.
     * Permite ler o nome fora da classe.
     */
    public String getNome() {
        return nome;
    }

    /**
     * Setter do nome.
     * Permite definir/alterar o nome.
     */
    public void setNome(String nome) {
        this.nome = nome;
    }

    /**
     * Getter do salário.
     */
    public double getSalario() {
        return salario;
    }

    /**
     * Setter do salário.
     * Na Lista 03 não foi pedido para rejeitar salário negativo
     * (isso aparece na Lista 04). Aqui só atribuímos.
     */
    public void setSalario(double salario) {
        this.salario = salario;
    }

    // ======= REGRA DE NEGÓCIO: CÁLCULO DO IRPF =======

    /**
     * Calcula o IRPF usando a tabela progressiva da Lista 03:
     *
     * Faixa      Faixa de Salário                 Alíquota
     * 1ª faixa   Até 1.903,98                     isento
     * 2ª faixa   1.903,99 até 2.826,65            7,5%
     * 3ª faixa   2.826,66 até 3.751,05            15,0%
     * 4ª faixa   3.751,06 até 4.664,68            22,5%
     * 5ª faixa   A partir de 4.664,69             27,5%
     *
     * O cálculo é PROGRESSIVO:
     * - Cada "faixa" cobra imposto apenas sobre a parte do salário que está nela.
     * - Somamos o imposto de todas as faixas até onde o salário alcançar.
     *
     * Exemplo do enunciado (R$ 3.000,00):
     * - 1ª faixa: até 1903,98 -> 0,00
     * - 2ª faixa: (2.826,65 - 1.903,98) * 7,5% = 922,67 * 0,075 = 69,20
     * - 3ª faixa: (3.000,00 - 2.826,65) * 15%  = 173,35 * 0,15 = 26,00
     * Total = 95,20  (conforme PDF).
     */
    public double calcularIrpf() {
        double s = this.salario;
        double imposto = 0.0;

        // Definimos os limites das faixas como constantes locais
        final double LIMITE_FAIXA1 = 1903.98;
        final double LIMITE_FAIXA2 = 2826.65;
        final double LIMITE_FAIXA3 = 3751.05;
        final double LIMITE_FAIXA4 = 4664.68;

        // Faixa 1: até 1.903,98 -> isento
        if (s <= LIMITE_FAIXA1) {
            return 0.0; // sem imposto, podemos retornar direto
        }

        // Faixa 2: de 1.903,99 até 2.826,65 -> 7,5% sobre a parte acima de 1.903,98
        if (s > LIMITE_FAIXA1) {
            // A base tributável nesta faixa é:
            // mínimo entre salário e limite da faixa 2, menos o limite da faixa 1.
            double baseFaixa2 = Math.min(s, LIMITE_FAIXA2) - LIMITE_FAIXA1;
            imposto += baseFaixa2 * 0.075; // 7,5% = 0.075
        }

        // Faixa 3: de 2.826,66 até 3.751,05 -> 15% sobre a parte acima de 2.826,65
        if (s > LIMITE_FAIXA2) {
            double baseFaixa3 = Math.min(s, LIMITE_FAIXA3) - LIMITE_FAIXA2;
            imposto += baseFaixa3 * 0.15; // 15% = 0.15
        }

        // Faixa 4: de 3.751,06 até 4.664,68 -> 22,5%
        if (s > LIMITE_FAIXA3) {
            double baseFaixa4 = Math.min(s, LIMITE_FAIXA4) - LIMITE_FAIXA3;
            imposto += baseFaixa4 * 0.225; // 22,5% = 0.225
        }

        // Faixa 5: acima de 4.664,68 -> 27,5%
        if (s > LIMITE_FAIXA4) {
            double baseFaixa5 = s - LIMITE_FAIXA4;
            imposto += baseFaixa5 * 0.275; // 27,5% = 0.275
        }

        // Retornamos o total de imposto calculado
        return imposto;
    }

}
