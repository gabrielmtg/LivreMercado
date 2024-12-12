package test;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import models.*;
/**

 @author Professor Cancian
 */
public abstract class TestCase implements TestInterface {

	class I extends TestIndentation { // just an ALIAS
	}

	/**
	 <p>
	 */
	public abstract void afterAll();

	/**
	 <p>
	 */
	public abstract void afterEach();

	/**

	 @param valueReturned
	 @param valueExpected
	 */
	public void assertEquals(Object valueReturned, Object valueExpected) {
		assertEquals("sem mensagem", valueReturned, valueExpected);
	}

	/**

	 @param valueReturned
	 @param valueExpected
	 */
	public void assertEquals(double valueReturned, double valueExpected) {
		assertEquals("sem mensagem", valueReturned, valueExpected);
	}

	/**

	 @param message
	 @param valueReturned
	 @param valueExpected
	 */
	public void assertEqualsDouble(String message, double valueReturned, double valueExpected) {
		String msg = "(" + valueReturned + "(retornado) == " + valueExpected + "(esperado) ) --> ";
		if (checkAssert(valueReturned, valueExpected)) {
			successes++;
			msg += "Correto  :-)";
		} else {
			fails++;
			msg += "Errado  :-(";
		}
		//System.out.println(I.Indent() + "Verificando \""+message +"\": "+ msg);
		System.out.println(I.Indent() + message + ": " + msg);
	}

	/**

	 @param message
	 @param valueReturned
	 @param valueExpected
	 */
	public void assertEquals(String message, Object valueReturned, Object valueExpected) {
		if (valueReturned instanceof Double) {
			this.assertEqualsDouble(message, doubleRelativePrecision, doubleRelativePrecision);
			return;
		}
		String msg = "(" + valueReturned + "(retornado) == " + valueExpected + "(esperado) ) --> ";
		if (checkAssert(valueReturned, valueExpected)) {
			successes++;
			msg += "Correto  :-)";
		} else {
			fails++;
			msg += "Errado  :-(";
		}
		//System.out.println(I.Indent() + "Verificando \""+message +"\": "+ msg);
		System.out.println(I.Indent() + message + ": " + msg);
	}

	/**
	 <p>
	 */
	public abstract void beforeAll();

	/**
	 <p>
	 */
	public abstract void beforeEach();

	/**

	 @param testResult
	 */
	@Override
	public void run(TestResultInterface testResult) {
		Method[] methods = this.getClass().getDeclaredMethods();
		//Method[] methodss = SetorTest.class.getDeclaredMethods();
		runTests(this, methods, testResult);
	}

	private boolean checkAssert(Object valueReturned, Object valueExpected) {
		if (valueReturned != null)
			return valueReturned.equals(valueExpected);
		else
			return valueReturned == valueExpected;

	}

	private boolean checkAssert(double valueReturned, double valueExpected) {
		if (valueExpected == 0.0)
			return Math.abs(valueReturned) < doubleRelativePrecision;
		return Math.abs(valueReturned - valueExpected) / valueExpected < doubleRelativePrecision;
	}

	/**

	 @param obj
	 @param methods
	 @param testSuiteResult
	 */
	protected final void runTests(Object obj, Method[] methods, TestResultInterface testSuiteResult) {
		I.Set(1);
		System.out.println(I.PosInc() + "Iniciando testes da classe " + obj.getClass().getName());
		beforeAll();
		int savedIndent = I.Get();
		//sumPossiblePoints = 0.0;
		//sumNota = 0.0;
		//sumEarnedReductions = 0.0;
		for (Method method : methods) {
			method.getName();
			TestAnnotation[] annots = method.getAnnotationsByType(TestAnnotation.class);
			if (annots.length > 0) {
				Double points = Double.valueOf(annots[0].points());
				Double reductions = Double.valueOf(annots[0].reductions());
				I.Set(savedIndent);
				System.out.print(
						"\n" + I.PosInc() + "Iniciando teste \"" + method.getName() + "\", vale " + points + " pontos");
				if (reductions > 0)
					System.out.print(" e pode descontar " + reductions + " pontos");
				System.out.println();
				beforeEach();
				fails = 0;
				successes = 0;
				//sumPossiblePoints += points;
				try {
					Object returnObj = method.invoke(obj, (Object[]) null);
				} catch (IllegalAccessException | InvocationTargetException e) {
					System.out.println(I.Indent() + "ERRO: Exceção ao executar o teste: " + e.getMessage());
					fails++;
				}
				TestResultInterface testCaseResult = new TestCaseResult(obj.getClass().getName() + "." + method.
						getName(), successes, fails, points, reductions);
				testSuiteResult.add(testCaseResult);
				//sumNota += testCaseResult.getGrade();
				afterEach();
				//System.out.Println(I.Indent()+"Resultado do teste: "+getResult());
				//System.out.println(I.PosDec() + "Finalizando teste '" + methodName + "': " + testCaseResult.toString());
				System.out.println(I.PosDec() + "Finalizando teste: " + testCaseResult.toString());
			}
		}
		afterAll();
		System.out.print(I.PreDec() + "Finalizando testes da classe " + obj.getClass().getName() + ".\n");
		//System.out.print("Ganhou "+sumNota+" de "+sumPossiblePoints+" pontos.\n");
		System.out.println();
	}
	private final double doubleRelativePrecision = 0.001; //0.1%
	private int fails;
	private int successes;
}
