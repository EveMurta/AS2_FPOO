package Mercado;

public class Laticinio extends Produto {

	private static final long serialVersionUID = 1L;

	public Laticinio(int codigo, String nome, String fornecedor) {
		super(codigo, nome, fornecedor);
		this.categoria = "Laticinio";
	}
}
