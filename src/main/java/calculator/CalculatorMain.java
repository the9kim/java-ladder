package calculator;

public class CalculatorMain {
    public static void main(String[] args) {
        String formula = InputView.inputFormula();
        OutputView.printResult(Calculator.calSumNumber(Calculator.convertNumber(formula)));
    }
}
