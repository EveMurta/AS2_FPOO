package Produto;

import java.io.Serializable;

public abstract class Produto implements Serializable {

	private static final long serialVersionUID = 1L;
	private   int codigo;
	private   String nome;
	private   String fornecedor;
	private   String categoria;
	
	public Produto(int codigo, String nome, String fornecedor, String categoria) {
		this.codigo = codigo;
		this.nome = nome;
		this.fornecedor = fornecedor;
		this.categoria = categoria;
	}
	public String toString() {
		String retorno = "";
		retorno += "Codigo: "     + this.codigo     + "\n";
		retorno += "Nome: "     + this.nome     + "\n";
		retorno += "Fornecedor: "    + this.fornecedor    + " anos\n";
		retorno += "Categoria: "     + this.categoria     + "\n";
		return retorno;
	}
}
