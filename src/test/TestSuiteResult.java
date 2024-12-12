package test;


import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Professor Cancian
 */
public class TestSuiteResult implements TestResultInterface {

    private final List<TestResultInterface> testResults = new ArrayList<>();

	/**
	 *
	 * @param testResult
	 */
	@Override
    public void add(TestResultInterface testResult) {
        testResults.add(testResult);
    }

	/**
	 *
	 * @return
	 */
	@Override
    public int getNumSuccess() {
        int sum = 0;
        for (TestResultInterface tr : testResults) {
            sum += tr.getNumSuccess();
        }
        return sum;
    }

	/**
	 *
	 * @return
	 */
	@Override
    public int getNumFails() {
        int sum = 0;
        for (TestResultInterface tr : testResults) {
            sum += tr.getNumFails();
        }
        return sum;
    }

	/**
	 *
	 * @return
	 */
	@Override
    public int getNumAsserts() {
        int sum = 0;
        for (TestResultInterface tr : testResults) {
            sum += tr.getNumAsserts();
        }
        return sum;
    }

	/**
	 *
	 * @return
	 */
	@Override
    public double getPossiblePoints() {
        double sum = 0;
        for (TestResultInterface tr : testResults) {
            sum += tr.getPossiblePoints();
        }
        return sum;
    }

	/**
	 *
	 * @return
	 */
	@Override
    public double getPossibleReductions() {
        double sum = 0;
        for (TestResultInterface tr : testResults) {
            sum += tr.getPossibleReductions();
        }
        return sum;
    }

	/**
	 *
	 * @return
	 */
	@Override
    public double getEarnedPoints() {
        double sum = 0;
        for (TestResultInterface tr : testResults) {
            sum += tr.getEarnedPoints();
        }
        return sum;
    }

	/**
	 *
	 * @return
	 */
	@Override
    public double getEarnedReductions() {
        double sum = 0;
        for (TestResultInterface tr : testResults) {
            sum += tr.getEarnedReductions();
        }
        return sum;
    }

    /**
     *
     * @return
     */
    @Override
    public String toString() {
        int fail, success;
        int fails = 0;
        int successes = 0;
        int noResults = 0;
        double earnedPoints = 0.0;
        double possiblePoints = 0.0;
        double earnedReductions = 0.0;
        double possibleReductions = 0.0;
        double finalGrade = 0.0;
        for (TestResultInterface tr : testResults) {
            success = tr.getNumSuccess();
            fail = tr.getNumFails();
            if (success == 0 && fail == 0) {
                noResults++;
            } else {
                if (fail > 0) {
                    fails++;
                } else {
                    successes++;
                }
            }
            earnedPoints += tr.getEarnedPoints();
            possiblePoints += tr.getPossiblePoints();
            earnedReductions += tr.getEarnedReductions();
            possibleReductions += tr.getPossibleReductions();
        }
        String res;
        if (fails == 0 && successes == 0) {
            return "Nenhum resultado fornecdido pelos testes (nem correto nem errado)";
        } else {
            res = "Resultados errados=" + fails;
            res += ", corretos=" + successes;
            res += ", pontos possíveis=" + possiblePoints;
            res += ", pontos ganhos=" + earnedPoints;
            if (possibleReductions > 0) {
                res += ", descontos possíveis=" + possibleReductions;
                res += ", descontos recebidos=" + earnedReductions;
            }
            finalGrade = earnedPoints * 10.0 / possiblePoints - earnedReductions;
        }
        res += " -->\nNota = 10.0(nota máxima) * " + earnedPoints+"(pontos recebidos) / " + possiblePoints + "(pontos possíveis)";
        if (possibleReductions > 0.0) {
            res += " - " + earnedReductions+"(descontos recebidos)";
        }
        res += " = " + finalGrade + "\n";
        res += "Grade :=>> " + finalGrade;
        return res;
    }

}
