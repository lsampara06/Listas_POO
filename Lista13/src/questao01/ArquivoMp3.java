package questao01;

import java.io.RandomAccessFile;
import java.io.File;

public class ArquivoMp3 {
	
	private File arquivo;

    public ArquivoMp3(String caminho) throws Exception {
        arquivo = new File(caminho);//

        // Verifica existência
        if (!arquivo.exists()) {
            throw new java.io.FileNotFoundException("Arquivo não encontrado!");
        }

        // Verifica se é diretório
        if (arquivo.isDirectory()) {
            throw new IllegalArgumentException("O argumento informado é um diretório!");
        }
    }

    public TagMp3 getTagMp3() throws Exception {

    	// Abre o arquivo MP3 para leitura binária
        RandomAccessFile raf = new RandomAccessFile(arquivo, "r");

        // Pula até os últimos 128 bytes
        raf.seek(arquivo.length() - 128);

        byte[] buffer = new byte[128];
        raf.read(buffer);
        raf.close();

        // Verifica se começa com "TAG"
        String flag = new String(buffer, 0, 3);

        if (!flag.equals("TAG")) {
            throw new Exception("O arquivo não possui TAG MP3.");
        }

        // Cria objeto Tag
        TagMp3 tag = new TagMp3();

        tag.setTitulo(new String(buffer, 3, 30).trim());
        tag.setArtista(new String(buffer, 33, 30).trim());
        tag.setAlbum(new String(buffer, 63, 30).trim());
        tag.setAno(new String(buffer, 93, 4).trim());
        tag.setComentario(new String(buffer, 97, 28).trim());

        return tag;
    }

}
