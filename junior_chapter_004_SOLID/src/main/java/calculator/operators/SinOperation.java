package calculator.operators;

import java.math.BigDecimal;

public class SinOperation extends OneNumbOperation {
    private String name = "sin";
    private String example = "sin 45";

    @Override
    public String operation(String task) {
        String result = "Неправильно введены данные";
        BigDecimal bigDecimal = super.strAnalize(task);
        result = String.valueOf(Math.sin(bigDecimal.doubleValue()));
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
