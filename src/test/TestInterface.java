package test;


/**
 *
 * @author Professor Cancian
 */
public interface TestInterface {

	/**
	 *
	 * @param test
	 */
	void add(TestInterface test);

	/**
	 *
	 * @param testResult
	 */
	void run(TestResultInterface testResult);
}