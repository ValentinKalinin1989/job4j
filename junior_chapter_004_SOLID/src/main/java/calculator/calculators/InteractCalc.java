package calculator.calculators;

import calculator.operators.*;

public class InteractCalc extends Calculator {
    /**
     * запуск калькулятора с добавлен необходимых операций
     */
    public void start() {
        Calculator calculator = new Calculator();
        calculator.addOperation(new SumOperation());
        calculator.addOperation(new MinusOperation());
        calculator.addOperation(new DivideOperation());
        calculator.addOperation(new MultipOperation());
        calculator.addOperation(new CosOperation());
        calculator.addOperation(new SinOperation());
        calculator.addOperation(new TanOperation());
        calculator.start();
    }
}
