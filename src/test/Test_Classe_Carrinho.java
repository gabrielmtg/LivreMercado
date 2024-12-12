package test;/*
 Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
import models.*;
/**

 @author cancian
 */
public class Test_Classe_Carrinho extends TestCase {

	@TestAnnotation(points = "1.0")
	public void removaItem() {
	    System.out.println("|   |   |   Tentando criar cenário para poder invocar o método sob teste...");
	    Carrinho carrinho = null;
	    Produto produto4 = null;
	    try {
		Vendedor vendedor = new Vendedor("vendedor");
		Categoria categoria = new Categoria("categoria");
		Produto produto1 = new Produto("nome1", "modelo1", "marca", 1, categoria);
		Produto produto2 = new Produto("nome2", "modelo2", "marca", 2, categoria);
		Produto produto3 = new Produto("nome3", "modelo3", "marca", 3, categoria);
		produto4 = new Produto("nome3", "modelo3", "marca", 3, categoria);
		vendedor.adicioneProdutoAoEstoque(produto1, 2);
		vendedor.adicioneProdutoAoEstoque(produto2, 2);
		vendedor.adicioneProdutoAoEstoque(produto3, 2);
		carrinho = new Carrinho();
		carrinho.adicioneItem(produto1, vendedor, 1);
		carrinho.adicioneItem(produto2, vendedor, 1);
		carrinho.adicioneItem(produto3, vendedor, 1);
	    } catch(Exception e) {
	        System.out.println("|   |   |   ERRO: Houve um erro ao criar o cenário, antes de invocar o método sob teste.");
	    }

		System.out.println("|   |   |   Invocando carrinho.removaItem(produto4)");
		carrinho.removaItem(produto4);
		System.out.println("|   |   |   Começando verificações após execução do método");
		assertEquals("Apos remover um produto que nao estah no carrinho, ele continua com a quantidade de antes",
				carrinho.getItens().size(), 3);
        System.out.println("|   |   |   Tentando acessar \"carrinho.getItens().get(1)\"");
		ItemCompra item = carrinho.getItens().get(1);
		carrinho.removaItem(item.getProduto());
		assertEquals("Apos remover um produto que estah no carrinho, ele diminui um",
				carrinho.getItens().size(), 2);
		assertEquals("Apos remover um produto que estah no carrinho, ele nao deve mais estar la",
				carrinho.getItens().contains(item), false);
	}

	@TestAnnotation(points = "1.0")
	public void adicioneItem() {
	    System.out.println("|   |   |   Tentando criar cenário para invocar método sob teste...");
		Vendedor vendedor = new Vendedor("vendedor");
		Produto produto = new Produto("nome", "modelo", "marca", 1.1, new Categoria("categoria"));
		vendedor.adicioneProdutoAoEstoque(produto, 5);
		Carrinho carrinho = new Carrinho();
		System.out.println("adicioneItem([" + produto + "], [" + vendedor + "], 4)");
		try {
			carrinho.adicioneItem(produto, vendedor, 4);
		} catch (IllegalArgumentException e) {

		}
		assertEquals("Depois de adicionar quantidade existente de um produto, carrinho deve ter 1 item", carrinho.
				getItens().size(), 1);
		assertEquals("... e o item deve ser de 4 unidades", carrinho.
				getItens().get(0).getQuantidade(), 4);
		System.out.println("adicioneItem([" + produto + "], [" + vendedor + "], 6)");
		try {
			carrinho.adicioneItem(produto, vendedor, 6);
		} catch (IllegalArgumentException e) {

		}
		assertEquals(
				"Depois de adicionar quantidade maior que a do estoque de um produto, carrinho nao aumenta quantidade do item",
				carrinho.
						getItens().size(), 1);
		assertEquals("... e o item ainda deve ser de 4 unidades", carrinho.
				getItens().get(0).getQuantidade(), 4);
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
		//Mercado mercado = new Mercado();
		//ProfCancian_PreenchedorContteudo.SetMercado(mercado);
		//ProfCancian_PreenchedorContteudo.PreenchaMercado();
	}

	@Override
	public void beforeEach() {
		// Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
	}

}
