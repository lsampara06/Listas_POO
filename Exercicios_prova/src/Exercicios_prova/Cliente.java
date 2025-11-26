package Exercicios_prova;

public class Cliente {
	private String nome;
	private int id;
	
	public Cliente(String nome, int id) {
		setNome(nome);
		setId(id);
	}
	
	public void pedirCafe(Cafe cafe) {
		String nomeCafe = cafe.getNome();
        double precoCafe = cafe.getPreco();
		System.out.println("O cliente"+this.getNome()+"pediu o cafe"+nomeCafe+"por R$"+precoCafe);
	}
	
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	
}
