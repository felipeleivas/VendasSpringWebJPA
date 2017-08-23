package teste;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Produtos")
public class Produto {
	@Id
	private int id;
	private String nome;
	private double preco;
	
	public Produto() {
		
	}

	public double getPreco() {
		return preco;
	}

	public void setPreco(double preco) {
		this.preco = preco;
	}

	public int getId() {
		return id;
	}

	public String getNome() {
		return nome;
	}

	public Produto(int id, String nome, double preco) {
		this.id = id;
		this.nome = nome;
		this.preco = preco;
	}
	
	
}
