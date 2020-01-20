package calculator.calculators;

import calculator.operators.CalcOperation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Calculator {
    /**
     * список доступных операций
     */
    private List<CalcOperation> listOper = new ArrayList<>();

    /**
     * добавление операций в калькулятор
     *
     * @param calcOperation операция
     */
    public void addOperation(CalcOperation calcOperation) {
        this.listOper.add(calcOperation);
    }

    /**
     * старт калькулятора
     */
    public void start() {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String result = "";
        String str = "";
        do {
            System.out.print(result);
            try {
                str = result + reader.readLine();
                if (str.contains("сброс")) {
                    result = "";
                    continue;
                }
                for (CalcOperation oper : this.listOper) {
                    if (str.contains(oper.nameOper())) {
                        result = oper.operation(str);
                    }
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        } while (!str.contains("стоп"));
    }
}
