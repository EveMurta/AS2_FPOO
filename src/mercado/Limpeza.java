package mercado;

public class Limpeza extends Produto {

	private static final long serialVersionUID = 1L;

	public Limpeza(int codigo, String nome, String fornecedor) {
		super(codigo, nome, fornecedor);
		this.categoria = "Limpeza";
	}
	
	@Override
	public String toString() {
		String retorno = "";
		retorno += "Codigo do Produto de Limpeza: "     + this.codigo     + "\n";
		retorno += "Nome do Produto de Limpeza: "     + this.nome     + "\n";
		retorno += "Fornecedor: "    + this.fornecedor    + "\n";
		return retorno;
	}
}
