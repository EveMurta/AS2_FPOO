package mercado;

public class Laticinio extends Produto {

	private static final long serialVersionUID = 1L;

	public Laticinio(int codigo, String nome, String fornecedor) {
		super(codigo, nome, fornecedor);
		this.categoria = "Laticinio";
	}
	
	@Override
	public String toString() {
		String retorno = "";
		retorno += "Codigo do Laticinio: "     + this.codigo     + "\n";
		retorno += "Nome do Laticinio: "     + this.nome     + "\n";
		retorno += "Fornecedor: "    + this.fornecedor    + "\n";
		return retorno;
	}
}
