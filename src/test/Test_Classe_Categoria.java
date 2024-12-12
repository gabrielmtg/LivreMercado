package test;/*
 Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
import models.*;
/**

 @author cancian
 */
public class Test_Classe_Categoria extends TestCase {

//	@TestAnnotation(points = "1.0")
//	public void adicioneSubcategoria() {
//	}
	@TestAnnotation(points = "2.0")
	public void removaSubcategoria() {
	    System.out.println("|   |   |   Tentando criar cenário para invocar método sob teste...");
	    Categoria categoria1 = new Categoria("categoria1");
		Categoria categoria2 = new Categoria("categoria1->categoria2");
		Categoria categoria3 = new Categoria("categoria1->categoria3");
		Categoria categoria4 = new Categoria("categoria1->categoria3->categoria4");
		categoria1.adicioneSubcategoria(categoria2);
		categoria1.adicioneSubcategoria(categoria3);
		categoria3.adicioneSubcategoria(categoria4);
		Produto produto1 = new Produto("1", "1", "1", 1, categoria1);
		Produto produto2 = new Produto("2", "2", "2", 2, categoria2);
		Produto produto3 = new Produto("3", "3", "3", 3, categoria3);
		Produto produto4 = new Produto("4", "4", "4", 4, categoria4);

		System.out.println("|   |   |   Invocando categoria.removaSubcategoria(" + categoria3 + ", true)");
		categoria1.removaSubcategoria(categoria3, true);
		System.out.println("|   |   |   Começando verificações após execução do método");
		assertEquals(
				"Depois de remover a categoria3, a categoria 1 deve ter a categoria2 e categoria4 como subcateroria",
				categoria1.getSubcategorias().get(0).getNome(), "categoria1->categoria2");
		assertEquals(
				"Depois de remover a categoria3, a categoria 1 deve ter a categoria2 e categoria4 como subcateroria",
				categoria1.getSubcategorias().get(1).getNome(), "categoria1->categoria3->categoria4");
		assertEquals("Os produtos das subcategorias excluidas devem ter sido vinculados aa ctegoria pai",
				produto3.getCategoria().getNome(), categoria1.getNome());	}

	@TestAnnotation(points = "1.0")
	public void adicioneProduto() {
	    System.out.println("|   |   |   Tentando criar cenário para invocar método sob teste...");
		Categoria categoria1 = new Categoria("categoria1");
		Categoria categoria2 = new Categoria("categoria2");
		Categoria categoria3 = new Categoria("categoria3");
		Produto produto1 = new Produto("1", "1", "1", 1, categoria1);
		Produto produto2 = new Produto("2", "2", "2", 2, categoria2);

		System.out.println("|   |   |   Invocando categoria3.adicioneProduto(produto1");
        categoria3.adicioneProduto(produto1);
		System.out.println("|   |   |   Começando verificações após execução do método");
		assertEquals("Depois de mover o produto1 para a categoria3, a categoria do produto deve ter mudado",
				produto1.getCategoria(), categoria3);
		assertEquals("Depois de mover o produto1 para a categoria3, ele deve aparecer listado nessa categoria",
				categoria3.getProdutos().contains(produto1), true);
		assertEquals("Depois de mover o produto1 para a categoria3, ele nao deve mais estar na categoria antegior",
				categoria1.getProdutos().contains(produto1), false);
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
