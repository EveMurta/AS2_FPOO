package mercado;

import java.io.Serializable;
import java.util.ArrayList;

public abstract class Produto implements Serializable {

	private static final long serialVersionUID = 1L;
	protected   int codigo;
	protected   String nome;
	protected   String fornecedor;
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
		retorno += "Fornecedor: "    + this.fornecedor    + "\n";
		retorno += "Categoria: "     + this.categoria     + "\n";
		return retorno;
	}
	
	
	public static void Imprimir(ArrayList<Produto> produtos) {
		String dados = "";
		for (int i=0; i < produtos.size(); i++)	{
			dados += produtos.get(i).toString() + "---------------\n";
		}
		System.out.println("\n> Os produtos são:\n"+dados);
	}
}
