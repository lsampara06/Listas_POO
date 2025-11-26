package prova03;

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class RepositorioVeiculos implements Serializable{
	
	private static final long serialVersionUID = 1L;

    private List<Veiculo> veiculos;

    public RepositorioVeiculos() {
        this.veiculos = new ArrayList<>();
    }

    // Adiciona um novo veículo ao repositório
    public void adicionar(Veiculo veiculo) {
        if (veiculo == null) {
            throw new IllegalArgumentException("Veículo não pode ser nulo.");
        }
        veiculos.add(veiculo);
    }

    // Retorna uma lista só para leitura (boa prática)
    public List<Veiculo> listar() {
        return Collections.unmodifiableList(veiculos);
    }

    /**
     * Salva o repositório inteiro em arquivo binário.
     * O arquivo pode ser algo como "veiculos.dat".
     */
    public void salvar(String caminhoArquivo) throws IOException {
        try (ObjectOutputStream oos = new ObjectOutputStream(
                new FileOutputStream(caminhoArquivo))) {
            oos.writeObject(veiculos);
        }
    }

    /**
     * Carrega os veículos de um arquivo binário.
     * Se o arquivo não existir, mantém a lista vazia.
     */
    @SuppressWarnings("unchecked")
    public void carregar(String caminhoArquivo) throws IOException {
        File arq = new File(caminhoArquivo);
        if (!arq.exists()) {
            // nada a carregar, lista permanece vazia
            return;
        }

        try (ObjectInputStream ois = new ObjectInputStream(
                new FileInputStream(arq))) {
            Object obj = ois.readObject();
            this.veiculos = (List<Veiculo>) obj;
        } catch (ClassNotFoundException e) {
            throw new IOException("Erro ao carregar dados: classe não encontrada.", e);
        }
    }

}
