package test;
import models.*;

/**
 *
 * @author Professor Cancian
 */
public class TestCaseResult implements TestResultInterface {

    private static boolean showTestName;
    private final String name;
    private final int success;
    private final int fail;
    private final double earnedPoints;
    private final double possiblePoints;
    private final double earnedReductions;
    private final double possibleReductions;
    //private final double nota;

	/**
	 *
	 * @param name
	 * @param success
	 * @param fail
	 * @param possiblePoints
	 */
	public TestCaseResult(String name, int success, int fail, double possiblePoints) {
        this.name = name;
        this.success = success;
        this.fail = fail;
        this.possiblePoints = possiblePoints;
        this.possibleReductions = 0.0;
        this.earnedReductions = 0.0;
        this.earnedPoints = success > 0 && fail == 0 ? possiblePoints : 0;
    }

	/**
	 *
	 * @param name
	 * @param success
	 * @param fail
	 * @param possiblePoints
	 * @param possibleReductions
	 */
	public TestCaseResult(String name, int success, int fail, double possiblePoints, double possibleReductions) {
        this.name = name;
        this.success = success;
        this.fail = fail;
        this.possiblePoints = possiblePoints;
        this.possibleReductions = possibleReductions;
        if (fail > 0) {
            this.earnedPoints = 0.0;
            this.earnedReductions = possibleReductions;
        } else if (success > 0) {
            this.earnedPoints = possiblePoints;
            this.earnedReductions = 0.0;
        } else {
            this.earnedPoints = 0.0;
            this.earnedReductions = 0.0;
        }
    }

	/**
	 *
	 * @param testResult
	 */
	@Override
    public void add(TestResultInterface testResult) {
    }

	/**
	 *
	 * @return
	 */
	@Override
    public int getNumSuccess() {
        return success;
    }

	/**
	 *
	 * @return
	 */
	@Override
    public int getNumFails() {
        return fail;
    }

	/**
	 *
	 * @return
	 */
	@Override
    public int getNumAsserts() {
        return success + fail;
    }

    /**
     *
     * @return
     */
    @Override
    public String toString() {
        String passou, caseResultName = "";
        if (TestCaseResult.isShowTestName()) {
            caseResultName = this.name + ": ";
        }
        if (fail == 0 && success == 0) {
            return caseResultName + "nenhum resultado forncedido pelo teste (nem correto nem errado)";
        } else {
            if (fail > 0) {
                passou = "Reprovou";
            } else {
                passou = "Passou";
            }
        }
        caseResultName += "corretos=" + success + ", errados=" + fail + " --> " + passou + " no teste --> ";
        if (this.earnedReductions > 0.0) {
            caseResultName += "Desconto de "+earnedReductions+" pontos";            
        } else {
            caseResultName += "Ganhou "+earnedPoints+" de "+possiblePoints +" pontos";
        }
        return caseResultName;
    }



    /**
     * @return the showName
     */
    public static boolean isShowTestName() {
        return showTestName;
    }

    /**
     * @param aShowName the showName to set
     */
    public static void setShowName(boolean aShowName) {
        showTestName = aShowName;
    }

	/**
	 *
	 * @return
	 */
	@Override
    public double getEarnedPoints() {
        return earnedPoints;
    }

    /**
     * @return the reductions
     */
    public double getPossibleReductions() {
        return possibleReductions;
    }

	/**
	 *
	 * @return
	 */
	@Override
    public double getPossiblePoints() {
        return possiblePoints;
    }

	/**
	 *
	 * @return
	 */
	@Override
    public double getEarnedReductions() {
        return earnedReductions;
    }
}
