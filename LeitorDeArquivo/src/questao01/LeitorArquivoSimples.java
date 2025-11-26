package questao01;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class LeitorArquivoSimples {
	public static void main(String[] args) {

        // 1) Definir o caminho do arquivo
        // Se o arquivo estiver na raiz do projeto, basta colocar o nome
        // Você também pode usar caminho absoluto: "C:\\Users\\Camila\\Desktop\\texto.txt"
        String caminhoArquivo = "texto.txt";

        // 2) Leitura com BufferedReader + FileReader
        // try-with-resources: garante que o arquivo será fechado automaticamente
        try (BufferedReader br = new BufferedReader(new FileReader(caminhoArquivo))) {

            String linha;

            // 3) Laço para ler o arquivo linha por linha
            // readLine() retorna:
            // - a linha lida (String) OU
            // - null, quando chegar no fim do arquivo
            while ((linha = br.readLine()) != null) {
                System.out.println(linha);
            }

        } catch (IOException e) {
            // 4) Tratamento de erro de entrada/saída
            System.out.println("Erro ao ler o arquivo: " + e.getMessage());
        }
    }

}
