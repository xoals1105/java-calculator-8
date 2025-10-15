package calculator.controller;

import calculator.model.StringCalculator;
import calculator.view.InputView;
import calculator.view.OutputView;

public class CalculatorController {
    private final InputView inputView = new InputView();
    private final OutputView outputView = new OutputView();
    private final StringCalculator stringCalculator = new StringCalculator();

    public void runCalculation() {
        try {
            String input = inputView.intputString();
            int result = stringCalculator.add(input);
            outputView.printResult(result);
        } catch(IllegalArgumentException error) {
            outputView.printError(error.getMessage());
        }
    }
}
