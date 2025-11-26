package questao01;

import java.io.File;

public class SomaDiretorio {

    public static void main(String[] args) {

        if (args.length != 1) {
            System.out.println("Uso correto: java SomaDiretorio <diretorio>");
            return;
        }

        File diretorio = new File(args[0]);

        try {

            if (!diretorio.exists()) {
                throw new IllegalArgumentException("Diretório inexistente!");
            }

            if (!diretorio.isDirectory()) {
                throw new IllegalArgumentException("O caminho informado não é um diretório!");
            }

            long tamanhoTotal = calcularTamanho(diretorio);

            double tamanhoEmMB = tamanhoTotal / (1024.0 * 1024.0);

            System.out.println("Total em bytes: " + tamanhoTotal);
            System.out.printf("Total em MB: %.2f MB\n", tamanhoEmMB);

        } catch (IllegalArgumentException e) {
            System.out.println("Erro: " + e.getMessage());
        }
    }

    public static long calcularTamanho(File arquivo) {

        if (arquivo.isFile()) {
            return arquivo.length();
        }

        long soma = 0;

        File[] arquivos = arquivo.listFiles();

        if (arquivos == null) {
            return 0;
        }

        for (File f : arquivos) {
            soma += calcularTamanho(f);
        }

        return soma;
    }
}
