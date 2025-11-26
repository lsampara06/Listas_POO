package questao01;

public class AppMp3 {
	
	public static void main(String[] args) {

        if (args.length != 1) {
            System.out.println("Uso correto: java AppMp3 <arquivo.mp3>");
            return;
        }

        try {

            ArquivoMp3 mp3 = new ArquivoMp3(args[0]);

            TagMp3 tag = mp3.getTagMp3();

            System.out.println("=== INFORMAÇÕES DO MP3 ===");
            System.out.println("Título: " + tag.getTitulo());
            System.out.println("Artista: " + tag.getArtista());
            System.out.println("Álbum: " + tag.getAlbum());
            System.out.println("Ano: " + tag.getAno());
            System.out.println("Comentário: " + tag.getComentario());

        } catch (Exception e) {
            System.out.println("Erro: " + e.getMessage());
        }
    }

}
