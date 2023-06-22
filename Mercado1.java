package Produto;

import java.io.EOFException;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

public class Mercado1 {

	private ArrayList<Produtos> produtos;
	
	
	public Mercado1() {
		this.produtos = new ArrayList<Produtos>();
	}
	
	
	public void adicionaProduto(Produto prod) {
		this.produtos.add(prod);
	}
	
	
	public void listarProdutos() {
		for(Produto prod:produtos) {
			System.out.println(prod.toString());
		}
		System.out.println("Total = " + this.produtos.size() + " produtos listados com sucesso!\n");
	}
	
	
	public void excluirProdutos(Produto prod) {
		if (this.produtos.contains(prod)) {
			this.produtos.remove(prod);
			System.out.println("[Produto " + prod.toString() + "excluido com sucesso!]\n");
		}
		else
			System.out.println("Produto inexistente!\n");
	}

	
	public void excluirProdutos() {
		produtos.clear();
		System.out.println("Produtos excluidos com sucesso!\n");
	}
	
	
	public void gravarProdutos()  {
		ObjectOutputStream outputStream = null;
		try {
			outputStream = new ObjectOutputStream (new FileOutputStream("c:\\temp\\produtos.dat"));
			for(Produtos prod:produtos) {
				outputStream.writeObject(prod);
			}
		}catch (FileNotFoundException ex) {
			ex.printStackTrace();
		}catch (IOException ex) {
			ex.printStackTrace();
		}finally{
			try {
				if (outputStream != null ) {
					outputStream.flush();
					outputStream.close();
				}
			}catch (IOException ex) {
				ex.printStackTrace();
			}
		}
	}
	
	
	public void recuperarProdutos() {
		ObjectInputStream inputStream = null;
		try {
			inputStream	= new ObjectInputStream (new FileInputStream ("c:\\temp\\produtos.dat"));
			Object obj = null;
			while((obj = inputStream.readObject ()) != null) {
				if (obj instanceof Bebebida)  
					this.produtos.add((Bebebida)obj);
				else if (obj instanceof Laticinio)  
					this.produtos.add((Laticinio)obj);
				else if (obj instanceof Limpeza)  
					this.produtos.add((Limpeza)obj);
			}
		}catch (EOFException ex) {     // quando o EOF é alcançado
			System.out.println ("Final do arquivo atingido.");
		}catch (ClassNotFoundException ex) {
			ex.printStackTrace();
		}catch (FileNotFoundException ex) {
			ex.printStackTrace();
		}catch (IOException ex) {
			ex.printStackTrace();
		}finally{
			try {
				if (inputStream != null ) {
					inputStream.close();
					System.out.println("Produtos recuperados com sucesso!\n");
				}
			}catch (IOException ex) {
				ex.printStackTrace();
			}
		}
	}


	public static void main(String[] args) {
		Mercado1 listaMercado  = new Mercado1();

		Bebebida coca1L    = new Bebebida (0001,"Coca-Cola 1L","Distribuidora LTDA", "Bebebida");
		Bebebida pepsi500ml = new Bebebida (0002,"Pepsi 500ml","Distribuidora LTDA", "Bebebida");
		Laticinio  queijo1      = new Laticinio (0003,"Queijo Parma 500g","Distribuidora LTDA", "Laticinio");
		Limpeza  veja500ml     = new Limpeza (0004,"Veja Desinfetante 500ml","Distribuidora LTDA", "Limpeza");
		listaMercado.adicionaProduto(coca1L);
		listaMercado.adicionaProduto(pepsi500ml);
		listaMercado.adicionaProduto(queijo1);
		listaMercado.adicionaProduto(veja500ml);
		listaMercado.listarProdutos();
		listaMercado.gravarProdutos();
		listaMercado.excluirProduto(queijo1);
		listaMercado.listarProdutos();
		listaMercado.excluirProdutos();
		listaMercado.listarProdutos();
		listaMercado.recuperarProdutos();
		listaMercado.listarProdutos();
	}

}
