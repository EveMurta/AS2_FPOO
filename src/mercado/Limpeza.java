package mercado;

public class Limpeza extends Produto {

	private static final long serialVersionUID = 1L;

	public Limpeza(int codigo, String nome, String fornecedor) {
		super(codigo, nome, fornecedor);
		this.categoria = "Limpeza";
	}
}
