package test;/*
 Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
import models.*;
/**

 @author cancian
 */
public class ProfCancian_PreenchedorContteudo {

	public static void AdicioneProdutosAoEstoqueDoVendedor1(Vendedor vendedor, Categoria todos) {
		Categoria eletrônicos = todos.getSubcategorias().get(0);
		Categoria moda = todos.getSubcategorias().get(1);
		Categoria casaJardim = todos.getSubcategorias().get(2);

		// Produtos do vendedor 1
		vendedor.adicioneProdutoAoEstoque(new Produto("Smartphone", "Modelo X", "Marca A", 499.99, eletrônicos), 10);
		vendedor.adicioneProdutoAoEstoque(new Produto("Vestido", "Floral", "Marca B", 79.99, moda), 15);
		vendedor.adicioneProdutoAoEstoque(new Produto("Sofá", "Couro", "Marca C", 1499.99, casaJardim), 5);
	}

	public static void AdicioneProdutosAoEstoqueDoVendedor2(Vendedor vendedor, Categoria todos) {
		Categoria eletrônicos = todos.getSubcategorias().get(0);
		Categoria moda = todos.getSubcategorias().get(1);
		Categoria casaJardim = todos.getSubcategorias().get(2);

		// Produtos do vendedor 2
		vendedor.adicioneProdutoAoEstoque(new Produto("Laptop", "Modelo Y", "Marca D", 2999.99, eletrônicos), 7);
		vendedor.adicioneProdutoAoEstoque(new Produto("Tênis", "Esportivo", "Marca E", 129.99, moda), 20);
		vendedor.adicioneProdutoAoEstoque(new Produto("Mesa", "Jantar", "Marca F", 699.99, casaJardim), 10);
	}

	public static void AdicioneProdutosAoEstoqueDoVendedor3(Vendedor vendedor, Categoria todos) {
		Categoria eletrônicos = todos.getSubcategorias().get(0);
		Categoria moda = todos.getSubcategorias().get(1);
		Categoria casaJardim = todos.getSubcategorias().get(2);

		// Produtos do vendedor 3
		vendedor.adicioneProdutoAoEstoque(new Produto("Fone de Ouvido", "Wireless", "Marca G", 199.99, eletrônicos), 15);
		vendedor.adicioneProdutoAoEstoque(new Produto("Calça", "Jeans", "Marca H", 89.99, moda), 12);
		vendedor.adicioneProdutoAoEstoque(new Produto("Cadeira", "Ergonômica", "Marca I", 399.99, casaJardim), 8);
	}

	public static void CrieCategorias() {
		Categoria todos = livreMercado.getCategorias().get(0);
		Categoria eletrônicos = new Categoria("Eletrônicos");
		Categoria moda = new Categoria("Moda");
		Categoria casaJardim = new Categoria("Casa e Jardim");

		// Subcategorias (exemplo)
		eletrônicos.adicioneSubcategoria(new Categoria("Smartphones"));
		eletrônicos.adicioneSubcategoria(new Categoria("Laptops"));
		eletrônicos.adicioneSubcategoria(new Categoria("Acessórios"));

		moda.adicioneSubcategoria(new Categoria("Roupas"));
		moda.adicioneSubcategoria(new Categoria("Calçados"));
		moda.adicioneSubcategoria(new Categoria("Acessórios"));

		casaJardim.adicioneSubcategoria(new Categoria("Móveis"));
		casaJardim.adicioneSubcategoria(new Categoria("Decoração"));
		casaJardim.adicioneSubcategoria(new Categoria("Utensílios"));

		todos.adicioneSubcategoria(eletrônicos);
		todos.adicioneSubcategoria(moda);
		todos.adicioneSubcategoria(casaJardim);
	}
/*
	public static void PreenchaMercado() {
		PreenchedorConteudo.CrieCategorias();
		PreenchedorConteudo.CrieVendedores();
		PreenchedorConteudo.CrieCompradores();
		PreenchedorConteudo.CrieProdutosDosVendedores();
		PreenchedorConteudo.CrieCarrinhosDeCompra();
	}
*/
	public static void SetMercado(Mercado mercado) {
		livreMercado = mercado;
	}

	static void CrieCarrinhosDeCompra() {
		Comprador comprador1 = livreMercado.getCompradores().get(0);
		Comprador comprador2 = livreMercado.getCompradores().get(1);
		Comprador comprador3 = livreMercado.getCompradores().get(2);

		Vendedor vendedor1 = livreMercado.getVendedores().get(0);
		Vendedor vendedor2 = livreMercado.getVendedores().get(1);
		Vendedor vendedor3 = livreMercado.getVendedores().get(2);

		// Comprador 1
		comprador1.adicioneProdutoAoCarrinho(vendedor1.getEstoque().getItens().get(0).getProduto(), vendedor1, 1);
		comprador1.adicioneProdutoAoCarrinho(vendedor2.getEstoque().getItens().get(1).getProduto(), vendedor2, 2);
		comprador1.adicioneProdutoAoCarrinho(vendedor3.getEstoque().getItens().get(0).getProduto(), vendedor3, 1);

		// Comprador 2
		comprador2.adicioneProdutoAoCarrinho(vendedor1.getEstoque().getItens().get(1).getProduto(), vendedor1, 1);
		comprador2.adicioneProdutoAoCarrinho(vendedor2.getEstoque().getItens().get(0).getProduto(), vendedor2, 2);
		comprador2.adicioneProdutoAoCarrinho(vendedor3.getEstoque().getItens().get(2).getProduto(), vendedor3, 1);

		// Comprador 3
		comprador3.adicioneProdutoAoCarrinho(vendedor1.getEstoque().getItens().get(2).getProduto(), vendedor1, 1);
		comprador3.adicioneProdutoAoCarrinho(vendedor2.getEstoque().getItens().get(1).getProduto(), vendedor2, 1);
		comprador3.adicioneProdutoAoCarrinho(vendedor3.getEstoque().getItens().get(0).getProduto(), vendedor3, 1);
	}

	static void CrieCompradores() {
		Comprador comprador1 = new Comprador("Ana");
		Comprador comprador2 = new Comprador("Luiz");
		Comprador comprador3 = new Comprador("Marcos");
		livreMercado.adicioneComprador(comprador1);
		livreMercado.adicioneComprador(comprador2);
		livreMercado.adicioneComprador(comprador3);
	}

	static void CrieProdutosDosVendedores() {
		Vendedor vendedor1 = livreMercado.getVendedores().get(0);
		Vendedor vendedor2 = livreMercado.getVendedores().get(1);
		Vendedor vendedor3 = livreMercado.getVendedores().get(2);
		Categoria todos = livreMercado.getCategorias().get(0);
		AdicioneProdutosAoEstoqueDoVendedor1(vendedor1, todos);
		AdicioneProdutosAoEstoqueDoVendedor2(vendedor2, todos);
		AdicioneProdutosAoEstoqueDoVendedor3(vendedor3, todos);
	}

	static void CrieVendedores() {
		Vendedor vendedor1 = new Vendedor("João");
		Vendedor vendedor2 = new Vendedor("Maria");
		Vendedor vendedor3 = new Vendedor("Carlos");
		livreMercado.adicioneVendedor(vendedor1);
		livreMercado.adicioneVendedor(vendedor2);
		livreMercado.adicioneVendedor(vendedor3);
	}

	private static Mercado livreMercado;
}
