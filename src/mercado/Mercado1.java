package mercado;

import java.io.EOFException;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

public class Mercado1 {

	private ArrayList<Produto> produtos;


	public Mercado1() {
		this.produtos = new ArrayList<Produto>();
	}
	
	
	public void adicionaProduto(Produto prod) {
		this.produtos.add(prod);
	}
	
	
	public void listarProduto() {
		for(Produto prod:produtos) {
			System.out.println(prod.toString());
		}
		System.out.println("Total = " + this.produtos.size() + "Produtos listados com sucesso!\n");
	}
	
	
	public void excluirProduto(Produto prod) {
		if (this.produtos.contains(prod)) {
			this.produtos.remove(prod);
			System.out.println("Produto " + prod.toString() + " excluido com sucesso!\n");
		}
		else
			System.out.println("Produto inexistente!\n");
	}
	
	
	public void excluirProduto() {
		produtos.clear();
		System.out.println("Produtos excluidos com sucesso!\n");
	}
	
	
	public void gravarProduto() {
		ObjectOutputStream outputStream = null;
		System.getProperty("user.dir");
		String userDir = System.getProperty("user.dir");
		String caminhoDir = userDir + "/produtos.dat";
		
		try {
			outputStream = new ObjectOutputStream(new FileOutputStream(caminhoDir));
			for(Produto prod:produtos) {
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
	
	
	public void recuperarProduto() {
		ObjectInputStream inputStream = null;
		System.getProperty("user.dir");
		String userDir = System.getProperty("user.dir");
		String caminhoDir = userDir + "/produtos.dat";
		
		try {
			inputStream	= new ObjectInputStream (new FileInputStream (caminhoDir));
			Object obj = null;
			while((obj = inputStream.readObject ()) != null) {
				if (obj instanceof Bebida)
					this.produtos.add((Bebida)obj);
				else if (obj instanceof Laticinio)  
					this.produtos.add((Laticinio)obj);
				else if (obj instanceof Limpeza)  
					this.produtos.add((Limpeza)obj);
			}
		}catch (EOFException ex) {     // when EOF is reached
			System.out.println ("End of file reached");
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
}
