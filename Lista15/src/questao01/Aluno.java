package questao01;

public class Aluno {
	private String nome;
    private String matricula;
    private double notaEnem;

    // Construtor: usado para criar um novo objeto Aluno
    public Aluno(String nome, String matricula, double notaEnem) {
        this.nome = nome;
        this.matricula = matricula;
        this.notaEnem = notaEnem;
    }

    // Getters e Setters (acessam e modificam os atributos privados)
    public String getNome() {
        return nome;
    }

    public String getMatricula() {
        return matricula;
    }

    public double getNotaEnem() {
        return notaEnem;
    }

    // Método toString: define como o aluno será impresso no JTextArea
    @Override
    public String toString() {
        return "Nome: " + nome
                + " | Matrícula: " + matricula
                + " | Nota ENEM: " + notaEnem;
    }

}
