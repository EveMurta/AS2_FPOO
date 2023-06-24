package mercado;

public class Bebida extends Produto {

	private static final long serialVersionUID = 1L;

	public Bebida(int codigo, String nome, String fornecedor) {
		super(codigo, nome, fornecedor);
		this.categoria = "Bebida";
	}
	
	@Override
	public String toString() {
		String retorno = "";
		retorno += "Codigo da Bebida: "     + this.codigo     + "\n";
		retorno += "Nome da Bebida: "     + this.nome     + "\n";
		retorno += "Fornecedor: "    + this.fornecedor    + "\n";
		return retorno;
	}
}
