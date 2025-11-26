package Scanne;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

import java.util.Scanner;

public class LeitorComScanner {
	public static void main(String[] args) {

    String caminhoArquivo = "texto.txt";

    try {
        // Scanner pode ler de arquivo também
        Scanner sc = new Scanner(new File(caminhoArquivo));

        // Enquanto tiver próxima linha
        while (sc.hasNextLine()) {
            String linha = sc.nextLine();
            System.out.println(linha);
        }

        sc.close();

    } catch (FileNotFoundException e) {
        System.out.println("Arquivo não encontrado: " + e.getMessage());
    }
}

}
