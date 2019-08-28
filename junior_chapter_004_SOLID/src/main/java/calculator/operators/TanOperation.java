package calculator.operators;

import java.math.BigDecimal;

public class TanOperation extends OneNumbOperation {
    private String name = "tan";
    private String example = "tan 45";

    @Override
    public String operation(String task) {
        String result = "Неправильно введены данные";
        BigDecimal bigDecimal = super.strAnalize(task);
        result = String.valueOf(Math.tan(bigDecimal.doubleValue()));
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
