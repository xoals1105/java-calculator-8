package calculator.controller;

import calculator.model.StringCalculator;
import calculator.view.InputView;
import calculator.view.OutputView;

public class CalculatorController {
    public final InputView inputView = new InputView();
    public final OutputView outputView = new OutputView();
    private final StringCalculator stringCalculator = new StringCalculator();

    public void runCalculation() {
            String input = inputView.intputString();
            int result = stringCalculator.add(input);
            outputView.printResult(result);
    }
}
