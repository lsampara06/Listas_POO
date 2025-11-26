package questao01;

public class Main {
	 public static void main(String[] args) {
	        // Garante que a interface gráfica será criada na thread de GUI
	        javax.swing.SwingUtilities.invokeLater(new Runnable() {
	            @Override
	            public void run() {
	                TelaAlunos tela = new TelaAlunos();
	                tela.setVisible(true);
	            }
	        });
	    }

}
