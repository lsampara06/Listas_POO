package questao01;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;

public class AppL14Municipios {
	public static void main(String[] args) {

        // Caminho do arquivo CSV.
        // Se o arquivo estiver na raiz do projeto, pode deixar só o nome.
        // Se estiver em outra pasta, coloque o caminho relativo ou absoluto.
        String caminhoArquivo = "L14_municipios.csv";

        // Variáveis para guardar o município com menor e maior população
        Municipio municipioMenorPop = null;
        Municipio municipioMaiorPop = null;

        // Inicializamos os limites com valores extremos
        long menorPop = Long.MAX_VALUE; // começa bem alto
        long maiorPop = Long.MIN_VALUE; // começa bem baixo

        // try-with-resources: garante que o arquivo será fechado automaticamente
        try (BufferedReader br = Files.newBufferedReader(
                Paths.get(caminhoArquivo), StandardCharsets.UTF_8)) {

            String linha;

            // Lê a primeira linha (cabeçalho) e DESCARTA
            linha = br.readLine();
            if (linha == null) {
                // Arquivo vazio ou inexistente
                System.out.println("Arquivo vazio ou não encontrado.");
                return; // encerra o programa
            }

            // Lê as linhas de dados até o final do arquivo (quando readLine() retorna null)
            while ((linha = br.readLine()) != null) {

                // Ignora linhas vazias ou só com espaços
                if (linha.trim().isEmpty()) {
                    continue;
                }

                // Separa a linha pelos ';'
                String[] partes = linha.split(";");

                // Verifica se a linha tem ao menos 4 colunas
                // (ajuste esse número se o seu CSV tiver mais ou menos colunas)
                if (partes.length < 4) {
                    // Linha mal formatada, pulamos para a próxima
                    continue;
                }

                // Aqui assumimos a seguinte ordem no arquivo:
                // 0 - código do município
                // 1 - nome do município
                // 2 - UF
                // 3 - população
                //
                // Se no teu arquivo a ordem for diferente, é só mudar os índices.
                String codigo = partes[0];
                String nome = partes[1];
                String uf = partes[2];
                String populacaoStr = partes[3];

                // Remove espaços em branco extras
                populacaoStr = populacaoStr.trim();

                long populacao;

                try {
                    // Converte a string da população para número inteiro longo (long)
                    populacao = Long.parseLong(populacaoStr);
                } catch (NumberFormatException e) {
                    // Se não conseguir converter (ex: texto em vez de número), pula essa linha
                    System.out.println("Linha ignorada (população inválida): " + linha);
                    continue;
                }

                // Cria um objeto Municipio com os dados da linha
                Municipio municipioAtual = new Municipio(codigo, nome, uf, populacao);

                // Verifica se é a MENOR população encontrada até agora
                if (populacao < menorPop) {
                    menorPop = populacao;
                    municipioMenorPop = municipioAtual;
                }

                // Verifica se é a MAIOR população encontrada até agora
                if (populacao > maiorPop) {
                    maiorPop = populacao;
                    municipioMaiorPop = municipioAtual;
                }
            }

            // Após a leitura de TODAS as linhas,
            // verificamos se encontramos algum município
            if (municipioMenorPop != null && municipioMaiorPop != null) {
                System.out.println("Cidade com MENOR população:");
                System.out.println(municipioMenorPop); // usa o toString()

                System.out.println();

                System.out.println("Cidade com MAIOR população:");
                System.out.println(municipioMaiorPop); // usa o toString()
            } else {
                System.out.println("Nenhum município válido foi encontrado no arquivo.");
            }

        } catch (IOException e) {
            // Tratamento de erro de entrada/saída (arquivo não encontrado, problema de leitura, etc.)
            System.out.println("Erro ao ler o arquivo: " + e.getMessage());
        }
    }

}
