package Exercicios_prova;


public class Cafe {
	private String nome;
	private double preco;
	
	// Construtor (Exercício 1)
    public Cafe(String nome, double preco) {
        this.nome = nome;
        this.preco = preco;
    }
	
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public double getPreco() {
		return preco;
	}
	public void setPreco(double novoPreco) {
		if(novoPreco>0) {
			this.preco = novoPreco;
		}else {
			System.out.println("Valor invalido!");
		}
		
	}
	

}
