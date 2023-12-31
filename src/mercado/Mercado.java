package mercado;

import java.io.EOFException;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

import javax.swing.JOptionPane;


public class Mercado {
	private ArrayList<Produto> produtos;

	public Mercado() {
		this.produtos = new ArrayList<Produto>();
		Bebida coca1L = new Bebida (0001,"Coca-Cola 1L","Distribuidora LTDA");
		produtos.add(coca1L);
		Bebida pepsi500ml = new Bebida (0002,"Pepsi 500ml","Distribuidora LTDA");
		produtos.add(pepsi500ml);
		Laticinio queijo1 = new Laticinio (0003,"Queijo Parma 500g","Distribuidora LTDA");
		produtos.add(queijo1);
		Limpeza veja500ml = new Limpeza (0004,"Veja Desinfetante 500ml","Distribuidora LTDA");
		produtos.add(veja500ml);
	}
	
	public String[] leValores(String [] dadosIn){
		String [] dadosOut = new String [dadosIn.length];

		for (int i = 0; i < dadosIn.length; i++)
			dadosOut[i] = JOptionPane.showInputDialog  ("Entre com " + dadosIn[i]+ ": ");

		return dadosOut;
	}
	
	
	public Laticinio leLaticinio() {

		String [] valores = new String [3];
		String [] nomeVal = {"Codigo", "Nome", "Fornecedor"};
		valores = leValores (nomeVal);

		int codigo = this.retornaInteiro(valores[0]);

		Laticinio laticinio = new Laticinio (codigo,valores[1],valores[2]);
		return laticinio;
	}
	
	
	public Bebida leBebida() {

		String [] valores = new String [3];
		String [] nomeVal = {"Codigo", "Nome", "Fornecedor"};
		valores = leValores (nomeVal);

		int codigo = this.retornaInteiro(valores[0]);

		Bebida bebida = new Bebida(codigo,valores[1],valores[2]);
		return bebida;
	}
	
	
	public Limpeza leLimpeza() {

		String [] valores = new String [3];
		String [] nomeVal = {"Codigo", "Nome", "Fornecedor"};
		valores = leValores (nomeVal);

		int codigo = this.retornaInteiro(valores[0]);

		Limpeza limpeza = new Limpeza (codigo,valores[1],valores[2]);
		return limpeza;
	}
	
	
	private boolean intValido(String s) {
		try {
			Integer.parseInt(s); // M�todo est�tico, que tenta tranformar uma string em inteiro
			return true;
		} catch (NumberFormatException e) { // N�o conseguiu tranformar em inteiro e gera erro
			return false;
		}
	}
	
	
	@SuppressWarnings("unused")
	public int retornaInteiro(String entrada) { // retorna um valor inteiro
		int numInt;

		//Enquanto n�o for poss�vel converter o valor de entrada para inteiro, permanece no loop
		while (!this.intValido(entrada)) {
			
			menuMercado();
			entrada = JOptionPane.showInputDialog(null, "Valor incorreto!\n\nDigite um número inteiro.");
		}
		return Integer.parseInt(entrada);
	}
	
	
	public void salvaProdutos(ArrayList<Produto> produtos) {
		ObjectOutputStream outputStream = null;
		System.getProperty("user.dir");
		String userDir = System.getProperty("user.dir");
		String caminhoDir = userDir + "/produtos.dat";
		
		try {
			outputStream = new ObjectOutputStream 
					(new FileOutputStream(caminhoDir));
			for (int i=0; i < produtos.size(); i++)
				outputStream.writeObject(produtos.get(i));
		} catch (FileNotFoundException ex) {
			JOptionPane.showMessageDialog(null,"Impossível criar arquivo!");
			ex.printStackTrace();
		} catch (IOException ex) {
			ex.printStackTrace();
		} finally {  //Close the ObjectOutputStream
			try {
				if (outputStream != null) {
					outputStream.flush();
					outputStream.close();
				}
			} catch (IOException ex) {
				ex.printStackTrace();
			}
		}
	}
	
	
	@SuppressWarnings("finally")
	public ArrayList<Produto> recuperaProduto() {
		ArrayList<Produto> produtosTemp = new ArrayList<Produto>();

		ObjectInputStream inputStream = null;
		System.getProperty("user.dir");
		String userDir = System.getProperty("user.dir");
		String caminhoDir = userDir + "/produtos.dat";

		try {	
			inputStream = new ObjectInputStream
					(new FileInputStream(caminhoDir));
			Object obj = null;
			while ((obj = inputStream.readObject()) != null) {
				if (obj instanceof Produto) {
					produtosTemp.add((Produto) obj);
				}   
			}          
		} catch (EOFException ex) { // when EOF is reached
			System.out.println("Fim de arquivo.");
		} catch (ClassNotFoundException ex) {
			ex.printStackTrace();
		} catch (FileNotFoundException ex) {
			JOptionPane.showMessageDialog(null,"Arquivo com produtos NÃO existe!");
			ex.printStackTrace();
		} catch (IOException ex) {
			ex.printStackTrace();
		} finally {  //Close the ObjectInputStream
			try {
				if (inputStream != null) {
					inputStream.close();
				}
			} catch (final IOException ex) {
				ex.printStackTrace();
			}
			return produtosTemp;
		}
	}
	
	
	public void menuMercado() {

		String menu = "";
		String entrada;
		int    opc1, opc2;

		do {
			menu = "Controle de produtos do Mercado\n" +
					"Opções:\n" +
					"1. Entrar Produtos\n" +
					"2. Exibir Produtos\n" +
					"3. Limpar Produtos\n" +
					"4. Gravar Produtos\n" +
					"5. Recuperar Produtos\n" +
					"6. Imprimir Listas\n" +
					"9. Sair";
			entrada = JOptionPane.showInputDialog(menu + "\n\n");
			opc1 = this.retornaInteiro(entrada);

			switch (opc1) {
			case 1:// Entrar dados
				menu = "Entrada de Produtos\n" +
						"Opções:\n" +
						"1. Bebida\n" +
						"2. Laticinio\n" +
						"3. Limpeza\n" +
						"4. Menu Principal\n";

				entrada = JOptionPane.showInputDialog(menu + "\n\n");
				opc2 = this.retornaInteiro(entrada);
				switch (opc2){
				case 1: produtos.add((Produto)leBebida());
				break;
				case 2: produtos.add((Produto)leLaticinio());
				break;
				case 3: produtos.add((Produto)leLimpeza());
				break;
				case 4: menuMercado();
				break;
				default: 
					JOptionPane.showMessageDialog(null,"Tipo de produto para entrada não escolhido!");
				}
				break;
				
			case 2: // Exibir dados
				if (produtos.size() == 0) {
					JOptionPane.showMessageDialog(null,"Entre com tipo de produto primeiramente!");
					break;
				}
				String dados = "";
				for (int i=0; i < produtos.size(); i++)	{
					dados += produtos.get(i).toString() + "---------------\n";
				}
				JOptionPane.showMessageDialog(null,dados);
				break;
				
			case 3: // Limpar Dados
				if (produtos.size() == 0) {
					JOptionPane.showMessageDialog(null,"Entre com tipo de produto primeiramente");
					break;
				}
				produtos.clear();
				JOptionPane.showMessageDialog(null,"Dados LIMPOS com sucesso!");
				break;
				
			case 4: // Grava Dados
				if (produtos.size() == 0) {
					JOptionPane.showMessageDialog(null,"Entre com produtos primeiramente");
					break;
				}
				salvaProdutos(produtos);
				JOptionPane.showMessageDialog(null,"Dados SALVOS com sucesso!");
				break;
				
			case 5: // Recupera Dados
				produtos = recuperaProduto();
				if (produtos.size() == 0) {
					JOptionPane.showMessageDialog(null,"Sem dados para apresentar.");
					break;
				}
				JOptionPane.showMessageDialog(null,"Dados RECUPERADOS com sucesso!");
				break;
			
			case 6: // Imprimir Listas
				if (produtos.size() == 0) {
					JOptionPane.showMessageDialog(null,"Sem dados para apresentar.");
					break;
				}
				Produto.Imprimir(produtos);
				break;	
				
			case 9:
				JOptionPane.showMessageDialog(null,"Fim do aplicativo MERCADO");
				System.exit(0);
			}
		} while (opc1 != 9);
	}
	
	public static void main(String [] args) {

		Mercado mercado = new Mercado();
		mercado.menuMercado();

	}

}
