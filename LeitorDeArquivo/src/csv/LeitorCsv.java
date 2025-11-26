package csv;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class LeitorCsv {
	public static void main(String[] args) {

        String caminhoArquivo = "dados.csv";

        try (BufferedReader br = new BufferedReader(new FileReader(caminhoArquivo))) {

            String linha;

            // Lê e ignora a primeira linha (cabeçalho)
            linha = br.readLine();

            while ((linha = br.readLine()) != null) {

                // Divide a linha pelo caractere ';'
                String[] partes = linha.split(";");

                // Verifica se tem ao menos 3 colunas
                if (partes.length < 3) {
                    continue; // linha mal formada, pula
                }

                String nome = partes[0];
                String idadeStr = partes[1];
                String cidade = partes[2];

                int idade = Integer.parseInt(idadeStr);

                System.out.println("Nome: " + nome +
                                   " | Idade: " + idade +
                                   " | Cidade: " + cidade);
            }

        } catch (IOException e) {
            System.out.println("Erro ao ler o arquivo: " + e.getMessage());
        } catch (NumberFormatException e) {
            System.out.println("Erro ao converter idade para número: " + e.getMessage());
        }
    }

}
