package questao02;

//(Opcional) ajuste o package conforme seu projeto, ex:
//package lista02.questao2;

/**
* Classe que representa uma conta bancária, com:
* - numero: identificação da conta
* - titular: nome do titular
* - saldo: valor atual em dinheiro
*
* Usa ENCAPSULAMENTO:
* - atributos private
* - acesso por getters e setters
**/

public class ContaBancaria {// ======= ATRIBUTOS PRIVADOS =======
    private String numero;
    private String titular;
    private double saldo;

    // ======= GETTERS E SETTERS =======

    /**
     * Getter de numero.
     * Permite ler o número da conta.
     */
    public String getNumero() {
        return numero;
    }

    /**
     * Setter de numero.
     * Permite definir o número da conta.
     */
    public void setNumero(String numero) {
        this.numero = numero;
    }

    /**
     * Getter de titular.
     * Devolve o nome do titular da conta.
     */
    public String getTitular() {
        return titular;
    }

    /**
     * Setter de titular.
     * Permite definir/alterar o titular da conta.
     */
    public void setTitular(String titular) {
        this.titular = titular;
    }

    /**
     * Getter de saldo.
     * Observação: normalmente não temos um setter público para saldo em
     * um modelo real. O saldo deve mudar apenas por saque/deposito.
     */
    public double getSaldo() {
        return saldo;
    }

    // ======= REGRAS DE NEGÓCIO =======

    /**
     * Método para depositar um valor na conta.
     * Regras:
     * - Valor não pode ser negativo.
     * - Se for válido, soma ao saldo.
     */
    public void depositar(double valor) {
        if (valor < 0) {
            // Aqui podemos lançar exceção ou apenas ignorar; escolhi exceção.
            throw new IllegalArgumentException("Valor de depósito não pode ser negativo.");
        }
        // soma o valor do depósito ao saldo atual
        saldo += valor;
    }

    /**
     * Método para sacar um valor da conta.
     * Regras:
     * - Valor não pode ser negativo.
     * - Não pode sacar mais do que o saldo (não pode ficar negativo).
     */
    public void sacar(double valor) {
        if (valor < 0) {
            throw new IllegalArgumentException("Valor de saque não pode ser negativo.");
        }

        if (valor > saldo) {
            // Recusa saque que deixaria saldo negativo
            throw new IllegalArgumentException("Saldo insuficiente para saque.");
        }

        // Se chegou aqui, é porque o valor é válido
        saldo -= valor;
    }

    /**
     * Método para transferir dinheiro desta conta (origem) para outra conta (destino).
     * Regras:
     * - Utilizar as mesmas restrições do saque para a conta de origem.
     * - Se o saque for bem-sucedido, depositar na conta de destino.
     *
     * @param contaDestino conta que receberá o valor
     * @param valor valor a ser transferido
     */
    public void transferir(ContaBancaria contaDestino, double valor) {
        // Primeiro tenta sacar da conta de origem (this)
        this.sacar(valor);     // se não tiver saldo, lança exceção aqui
        // Se deu certo, deposita na conta de destino
        contaDestino.depositar(valor);
    }

}
