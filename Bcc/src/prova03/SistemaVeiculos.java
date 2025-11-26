package prova03;

import java.io.IOException;
import java.util.List;

// Classe que o professor espera que a GUI use para tudo

public class SistemaVeiculos {
	
	private static final String CAMINHO_ARQUIVO = "veiculos.dat";

    private RepositorioVeiculos repositorio;

    public SistemaVeiculos() {
        this.repositorio = new RepositorioVeiculos();
    }

    // Chamado ao iniciar o programa
    public void carregar() {
        try {
            repositorio.carregar(CAMINHO_ARQUIVO);
        } catch (IOException e) {
            // Em uma prova, normalmente o professor aceita só um print de erro
            System.out.println("Não foi possível carregar os dados: " + e.getMessage());
        }
    }

    // Chamado ao fechar o programa, ou após alterações
    public void salvar() {
        try {
            repositorio.salvar(CAMINHO_ARQUIVO);
        } catch (IOException e) {
            System.out.println("Não foi possível salvar os dados: " + e.getMessage());
        }
    }

    // Cadastra um veículo novo
    public void cadastrarVeiculo(String placa, String modelo, String marca, int ano) {
        Veiculo v = new Veiculo(placa, modelo, marca, ano);
        repositorio.adicionar(v);
        salvar(); // salva automaticamente ao cadastrar
    }

    // Retorna a lista de veículos para preencher a tabela da GUI
    public List<Veiculo> getListaVeiculos() {
        return repositorio.listar();
    }

    /**
     * Adiciona um abastecimento para o veículo selecionado na tabela.
     * O índice vem da JTable (linha selecionada).
     */
    public void adicionarAbastecimento(int indexVeiculo,
                                       double km,
                                       double litros,
                                       double precoLitro) {
        List<Veiculo> lista = repositorio.listar();

        if (indexVeiculo < 0 || indexVeiculo >= lista.size()) {
            throw new IllegalArgumentException("Índice de veículo inválido.");
        }

        Veiculo v = lista.get(indexVeiculo);
        v.adicionarAbastecimento(new Abastecimento(km, litros, precoLitro));

        salvar(); // salva automaticamente depois de alterar
    }

    /**
     * Calcula a média da última abastecida para o veículo selecionado.
     * A GUI chamaria isso e exibiria o resultado em JOptionPane.
     */
    public double calcularUltimaMedia(int indexVeiculo) {
        List<Veiculo> lista = repositorio.listar();

        if (indexVeiculo < 0 || indexVeiculo >= lista.size()) {
            throw new IllegalArgumentException("Índice de veículo inválido.");
        }

        Veiculo v = lista.get(indexVeiculo);
        return v.getUltimaMedia();
    }

}
