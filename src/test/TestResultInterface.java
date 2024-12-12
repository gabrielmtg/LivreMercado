package test;


/**
 *
 * @author Professor Cancian
 */
public interface TestResultInterface {

	/**
	 *
	 * @param testResult
	 */
	void add(TestResultInterface testResult);

	/**
	 *
	 * @return
	 */
	int getNumSuccess();

	/**
	 *
	 * @return
	 */
	int getNumFails();

	/**
	 *
	 * @return
	 */
	int getNumAsserts();

	/**
	 *
	 * @return
	 */
	double getPossiblePoints();

	/**
	 *
	 * @return
	 */
	double getPossibleReductions();

	/**
	 *
	 * @return
	 */
	double getEarnedPoints();

	/**
	 *
	 * @return
	 */
	double getEarnedReductions();
}
