package test;


import java.util.ArrayList;
import java.util.List;


/**
 *
 * @author Professor Cancian
 */
public class TestSuite implements TestInterface{
    private final List<TestInterface> tests = new ArrayList<>();
    private final String name;
    
	/**
	 *
	 * @param name
	 */
	public TestSuite(String name) {
        this.name = name;
    }
    
	/**
	 *
	 * @param testResult
	 */
	@Override
    public void run(TestResultInterface testResult) {
        System.out.println("Iniciando TestSuite '"+this.name+"'");
        for (TestInterface t:tests) {
            t.run(testResult);
        }
        System.out.println("Finalizando TestSuite '"+this.toString()+"'");
    }
    
	/**
	 *
	 * @param test
	 */
	@Override
    public void add(TestInterface test) {
        tests.add(test);
    }
    
	/**
	 *
	 * @return
	 */
	@Override
    public String toString() {
        return name + " ("+ tests.size()+" testes)";
    }
    
}
