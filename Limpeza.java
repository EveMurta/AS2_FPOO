package Produto;

public class Limpeza extends Produto {

	private static final long serialVersionUID = 1L;

	public Limpeza(int codigo, String nome, String fornecedor) {
		super(codigo, nome, fornecedor);
		this.especie = "Limpeza";
	}
}
