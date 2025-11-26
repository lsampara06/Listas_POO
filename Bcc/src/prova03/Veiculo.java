package prova03;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Veiculo implements Serializable{
	
	private static final long serialVersionUID = 1L;

    private String placa;
    private String modelo;
    private String marca;
    private int ano;

    // Lista de abastecimentos associados a este veículo
    private List<Abastecimento> abastecimentos;

    public Veiculo(String placa, String modelo, String marca, int ano) {
        this.placa = placa;
        this.modelo = modelo;
        this.marca = marca;
        this.ano = ano;
        this.abastecimentos = new ArrayList<>();
    }

    public String getPlaca() {
        return placa;
    }

    public String getModelo() {
        return modelo;
    }

    public String getMarca() {
        return marca;
    }

    public int getAno() {
        return ano;
    }

    // Adiciona um novo abastecimento para este veículo
    public void adicionarAbastecimento(Abastecimento abast) {
        if (abast == null) {
            throw new IllegalArgumentException("Abastecimento não pode ser nulo.");
        }
        abastecimentos.add(abast);
    }

    // Retorna uma cópia imutável da lista (boa prática)
    public List<Abastecimento> getAbastecimentos() {
        return Collections.unmodifiableList(abastecimentos);
    }

    /**
     * Calcula a média de consumo da ÚLTIMA abastecida:
     * média = (kmAtual - kmAnterior) / litrosDaÚltimaAbastecida
     *
     * Se existir apenas um abastecimento, NÃO há referência anterior,
     * então aqui eu lanço uma exceção. Na prova, a GUI trataria isso
     * e mostraria a mensagem pro usuário.
     */
    public double getUltimaMedia() {
        int tamanho = abastecimentos.size();

        if (tamanho < 2) {
            // na prova ele diz: "exibir mensagem informando que não é possível calcular"
            // aqui no domínio eu sinalizo isso com uma exceção
            throw new IllegalStateException(
                    "Não é possível calcular a média: menos de dois abastecimentos.");
        }

        Abastecimento ultimo = abastecimentos.get(tamanho - 1);
        Abastecimento anterior = abastecimentos.get(tamanho - 2);

        double kmAtual = ultimo.getKm();
        double kmAnterior = anterior.getKm();
        double litrosUltimo = ultimo.getLitros();

        if (litrosUltimo <= 0) {
            throw new IllegalStateException("Litros da última abastecida inválidos.");
        }

        return (kmAtual - kmAnterior) / litrosUltimo;
    }

    // Opcional: usado na tabela (model) para mostrar info do veículo
    @Override
    public String toString() {
        return placa + " - " + modelo + " (" + marca + ", " + ano + ")";
    }

}
