package test;/*
 Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
import models.*;
/**

 @author cancian
 */
public class Test_Classe_Mercado extends TestCase {

	@TestAnnotation(points = "1.0")
	public void adicionaCoisas() {
		Mercado mercado = new Mercado();

		Categoria categoria1 = new Categoria("categoria1");

		mercado.adicioneCategoria(categoria1);
		assertEquals("adicionar categoria nova deve incluir um item", mercado.getCategorias().size(), 1);

		mercado.adicioneCategoria(categoria1);
		assertEquals("adicionar categoria existente nao deve adicionar nada", mercado.getCategorias().size(), 1);

		Vendedor vendedor1 = new Vendedor("vendedor");
		mercado.adicioneVendedor(vendedor1);
		assertEquals("adicionar vendedor novo deve incluir um item", mercado.getVendedores().size(), 1);

		mercado.adicioneVendedor(vendedor1);
		assertEquals("adicionar vendedor existente nao deve adicionar nada", mercado.getVendedores().size(), 1);

		Comprador comprador1 = new Comprador("comprador");
		mercado.adicioneComprador(comprador1);
		assertEquals("adicionar compradornovo deve incluir um item", mercado.getCompradores().size(), 1);

		mercado.adicioneComprador(comprador1);
		assertEquals("adicionar comprador existente nao deve adicionar nada", mercado.getCompradores().size(), 1);
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
