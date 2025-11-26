package contadorLinhas;


import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class LeitorContaLinhas {
	
	 public static void main(String[] args) {

	        String caminhoArquivo = "texto.txt";
	        int contadorLinhas = 0;

	        try (BufferedReader br = new BufferedReader(new FileReader(caminhoArquivo))) {

	            String linha;

	            while ((linha = br.readLine()) != null) {
	                contadorLinhas++;
	            }

	            System.out.println("Total de linhas no arquivo: " + contadorLinhas);

	        } catch (IOException e) {
	            System.out.println("Erro ao ler o arquivo: " + e.getMessage());
	        }
	    }

}
