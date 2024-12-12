package test;

/**

 @author Professor Cancian
 */
public class TestMain {

	/**

	 @param args
	 */
	public static void main(String[] args) {

		TestCaseResult.setShowName(false);
		TestResultInterface testResult = new TestSuiteResult();
		TestInterface testador = new TestSuite("Desenvolvimento de Software DS1 2024.2");
		testador.add(new Test_Classe_Carrinho());
		testador.add(new Test_Classe_Categoria());
		testador.add(new Test_Classe_Comprador());
		testador.add(new Test_Classe_Estoque());
		testador.add(new Test_Classe_Mercado());
		testador.run(testResult);
		System.out.println(testResult.toString());

	}
}
