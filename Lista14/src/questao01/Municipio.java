package questao01;

public class Municipio {
	
	 // Atributos básicos do município
    private String codigo;
    private String nome;
    private String uf;
    private long populacao;

    // Construtor: usado para criar um novo objeto Municipio
    public Municipio(String codigo, String nome, String uf, long populacao) {
        this.codigo = codigo;
        this.nome = nome;
        this.uf = uf;
        this.populacao = populacao;
    }

    // Getters: permitem acessar os dados do município
    public String getCodigo() {
        return codigo;
    }

    public String getNome() {
        return nome;
    }

    public String getUf() {
        return uf;
    }

    public long getPopulacao() {
        return populacao;
    }

    // toString: define como o município será impresso no System.out
    @Override
    public String toString() {
        return nome + " - " + uf + " (população: " + populacao + ")";
    }

}
