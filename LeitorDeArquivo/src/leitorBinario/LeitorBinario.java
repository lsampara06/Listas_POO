package leitorBinario;

import java.io.FileInputStream;
import java.io.IOException;

public class LeitorBinario {
	public static void main(String[] args) {

        String caminhoArquivo = "arquivo.bin"; // pode ser um .mp3, .jpg etc.

        try (FileInputStream fis = new FileInputStream(caminhoArquivo)) {

            int byteLido;
            int contadorBytes = 0;

            // Lê byte por byte até chegar no fim (retorna -1)
            while ((byteLido = fis.read()) != -1) {
                contadorBytes++;
            }

            System.out.println("Total de bytes no arquivo: " + contadorBytes);

        } catch (IOException e) {
            System.out.println("Erro ao ler o arquivo: " + e.getMessage());
        }
    }
	

}
