package mercado;

import java.io.Serializable;

public abstract class Produto implements Serializable {

	private static final long serialVersionUID = 1L;
	private   int codigo;
	private   String nome;
	private   String fornecedor;
	protected   String categoria;
	
	
	protected Produto(int codigo, String nome, String fornecedor) {
		this.codigo = codigo;
		this.nome = nome;
		this.fornecedor = fornecedor;
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