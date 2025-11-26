package leitorGenerico;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class LeitorGenerico {
	 public static void main(String[] args) {

	        // Verifica se o usuário forneceu o nome do arquivo
	        if (args.length != 1) {
	            System.out.println("Uso correto: java LeitorGenerico <nome_arquivo>");
	            return;
	        }

	        String caminhoArquivo = args[0];

	        try (BufferedReader br = new BufferedReader(new FileReader(caminhoArquivo))) {

	            String linha;

	            while ((linha = br.readLine()) != null) {
	                System.out.println(linha);
	            }

	        } catch (IOException e) {
	            System.out.println("Erro ao ler o arquivo: " + e.getMessage());
	        }
	    }

}
