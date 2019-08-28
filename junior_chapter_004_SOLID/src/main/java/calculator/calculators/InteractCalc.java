package calculator.calculators;

import calculator.operators.DivideOperation;
import calculator.operators.MinusOperation;
import calculator.operators.MultipOperation;
import calculator.operators.SumOperation;

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
        calculator.start();
    }
}
