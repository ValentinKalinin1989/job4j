package calculator.operators;

import java.math.BigDecimal;
import java.math.MathContext;
import java.math.RoundingMode;

public class DivideOperation extends TwoNumbOperation{
    private String name = "/";
    private String example = "1 / 2";

    @Override
    public String operation(String task) {
        String result = "Неправильно введены данные";
        BigDecimal[] bigDecimals = super.strAnalize(task);
        result = String.valueOf(bigDecimals[0].divide(bigDecimals[1]).round(new MathContext(2, RoundingMode.HALF_UP)));
        return result;
    }

    @Override
    public String exampleOper() {
        return super.exampleOper(this.example);
    }

    @Override
    public String nameOper() {
        return super.nameOper(this.name);
    }
}
