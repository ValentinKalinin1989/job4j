package calculator.operators;

import java.math.BigDecimal;

public class CosOperation extends OneNumbOperation {
    private String name = "cos";
    private String example = "cos 45";

    @Override
    public String operation(String task) {
        String result = "Неправильно введены данные";
        BigDecimal bigDecimal = super.strAnalize(task);
        result = String.valueOf(Math.cos(bigDecimal.doubleValue()));
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
