package mercado;

public class Bebida extends Produto {

	private static final long serialVersionUID = 1L;

	public Bebida(int codigo, String nome, String fornecedor) {
		super(codigo, nome, fornecedor);
		this.categoria = "Bebida";
	}
}
