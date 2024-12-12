package test;/*
 Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
import models.*;
/**

 @author cancian
 */
public class Test_Classe_Estoque extends TestCase {

	@TestAnnotation(points = "1.0")
	public void quantidadeEmEstoque() {
	    System.out.println("|   |   |   Tentando criar cenário para invocar método sob teste...");
		Categoria categoria = new Categoria("categoria");
		Produto produto1 = new Produto("nome1", "modelo1", "marca1", 1.0, categoria);
		Produto produto2 = new Produto("nome2", "modelo2", "marca2", 2.0, categoria);
		Produto produto3 = new Produto("nome3", "modelo3", "marca3", 3.0, categoria);
		Estoque estoque = new Estoque();
		estoque.adicioneItem(produto1, 10);
		estoque.adicioneItem(produto2, 5);

		int quantidade = estoque.quantidadeEmEstoque(produto2);
		assertEquals("A quantidade do produto2 eh 5 no estoque", quantidade, 5);

		quantidade = estoque.quantidadeEmEstoque(produto3);
		assertEquals("Um produto que nao estah no estoque deve ter quantidade 0", quantidade, 0);
	}

	@TestAnnotation(points = "1.5")
	public void reduzaQuantidade() {
	    System.out.println("|   |   |   Tentando criar cenário para invocar método sob teste...");
		Categoria categoria = new Categoria("categoria");
		Produto produto1 = new Produto("nome1", "modelo1", "marca1", 1.0, categoria);
		Produto produto2 = new Produto("nome2", "modelo2", "marca2", 2.0, categoria);
		Estoque estoque = new Estoque();
		estoque.adicioneItem(produto1, 10);
		estoque.adicioneItem(produto2, 5);
		
		System.out.println("|   |   |   invocando reduzaQuantidade([" + produto1 + "], 5)");
		estoque.reduzaQuantidade(produto1, 5);
		assertEquals("Depois de excluir 5 itens de 10 de um produto, ainda deve haver 5 itens do produto", estoque.
				getItens().get(0).getQuantidade(), 5);
		estoque.reduzaQuantidade(produto1, 5);
		assertEquals("Depois de excluir mais 5 itens de 10 de um produto, ainda deve haver 0 itens do produto", estoque.
				getItens().get(0).getQuantidade(), 0);
		System.out.println("reduzaQuantidade([" + produto2 + "], 6)");
		boolean gerou = false;
		try {
			estoque.reduzaQuantidade(produto2, 6);
		} catch (IllegalArgumentException e) {
			gerou = true;
		}
		assertEquals("Depois de excluir mais itns que ha no estoque, deve gerar uma excecao", gerou, true);
	}

	@TestAnnotation(points = "1.0")
	public void adicioneItem() {
	    System.out.println("|   |   |   Tentando criar cenário para invocar método sob teste...");
		Categoria categoria = new Categoria("categoria");
		Produto produto1 = new Produto("nome1", "modelo1", "marca1", 1.0, categoria);
		Produto produto2 = new Produto("nome2", "modelo2", "marca2", 2.0, categoria);
		Estoque estoque = new Estoque();

		estoque.adicioneItem(produto1, 10);
		assertEquals("Ao adicionar produto pela primeira vez, um novo item deve ser criado", estoque.getItens().size(),
				1);
		assertEquals("Ao adicionar produto pela primeira vez, o item deve ter a quantidade adicionada", estoque.
				getItens().get(0).getQuantidade(), 10);

		estoque.adicioneItem(produto1, 2);
		assertEquals("Ao adicionar mesmo produto pela segunda vez, nenhum um novo item deve ser criado", estoque.
				getItens().size(), 1);
		assertEquals("Ao adicionar mesmo produto pela segunda vez, o item deve ter a quantidade adicionada", estoque.
				getItens().get(0).getQuantidade(), 10 + 2);

		estoque.adicioneItem(produto2, 1);
		assertEquals("Ao adicionar produto pela primeira vez, um novo item deve ser criado", estoque.getItens().size(),
				2);
		assertEquals("Ao adicionar produto pela primeira vez, o item deve ter a quantidade adicionada", estoque.
				getItens().get(1).getQuantidade(), 1);

	}

	//quantidadeEmEstoque
	@Override
	public void add(TestInterface test) {
		// Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
	}

	@Override
	public void afterAll() {
		// Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
	}

	@Override
	public void afterEach() {
		// Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
	}

	@Override
	public void beforeAll() {
		// Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
	}

	@Override
	public void beforeEach() {
		// Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
	}

}
