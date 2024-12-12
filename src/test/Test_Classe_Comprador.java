package test;/*
 Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
import models.*;
/**

 @author cancian
 */
public class Test_Classe_Comprador extends TestCase {

	@TestAnnotation(points = "2.0")
	public void efetuarCompra() {
	    System.out.println("|   |   |   Tentando criar cenário para invocar método sob teste...");
		Categoria categoria1 = new Categoria("categoria1");
		Categoria categoria2 = new Categoria("categoria2");
		Vendedor vendedor1 = new Vendedor("vendedor1");
		Produto produto1 = new Produto("nome1", "modelo1", "marca1", 1.0, categoria1);
		Produto produto2 = new Produto("nome2", "modelo2", "marca2", 2.0, categoria2);
		Produto produto3 = new Produto("nome3", "modelo3", "marca3", 3.0, categoria2);
		vendedor1.getEstoque().adicioneItem(produto1, 5);
		vendedor1.getEstoque().adicioneItem(produto2, 5);
		vendedor1.getEstoque().adicioneItem(produto3, 5);
		Comprador comprador = new Comprador("comprador");
		comprador.adicioneProdutoAoCarrinho(produto1, vendedor1, 4);

		System.out.println("|   |   |   Invocando comprador.efetuarCompra()");
		comprador.efetuarCompra();
		System.out.println("|   |   |   Começando verificações após execução do método");
		assertEquals("Depois da compra com todos os produtos em estoque, o carrinho deve estar vazio",
				comprador.getCarrinho().getItens().size(), 0);

	    System.out.println("|   |   |   Tentando criar cenário para invocar método sob teste...");
		comprador.adicioneProdutoAoCarrinho(produto2, vendedor1, 4);
		comprador.adicioneProdutoAoCarrinho(produto3, vendedor1, 4);
		vendedor1.getEstoque().reduzaQuantidade(produto2, 3);
		
		System.out.println("|   |   |   Invocando comprador.efetuarCompra()");
		comprador.efetuarCompra();
		System.out.println("|   |   |   Começando verificações após execução do método");
		assertEquals("Depois da compra com um produto faltando em estoque, o carrinho ainda deve ter o produto2",
				comprador.getCarrinho().getItens().size(), 1);
		assertEquals("Depois da compra com um produto faltando em estoque, o carrinho ainda deve ter o produto2",
				comprador.getCarrinho().getItens().get(0).getProduto(), produto2);
	}

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
