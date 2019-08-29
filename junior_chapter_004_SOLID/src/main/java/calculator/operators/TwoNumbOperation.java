package calculator.operators;

import java.math.BigDecimal;

public abstract class TwoNumbOperation implements CalcOperation {
    /**
     * проведение операции над строкой и вывод результато
     * @param task строка для извлечения переменных
     * @return результат операции
     */
    public abstract String operation(String task);
    /**
     * получение примера операций
     * @return пример выражения для данной операции
     */
    public String exampleOper(String example) {
        return example;
    }
    /**
     * получение имя операции
      * @return имя операции
     */
    public String nameOper(String name) {
        return name;
    }
    /**
     * получение двух значений из строки, возвращает true - если упешно
     * @param str строка для вычисления
     * @return результат получения значений true или false
     */
    protected BigDecimal[] strAnalize(String str) {
        BigDecimal[] bigDecimals = new BigDecimal[2];
        String[] strings = str.split(" ");
        if (strings.length == 3) {
            try {
                bigDecimals[0] = new BigDecimal(strings[0]);
                bigDecimals[1] = new BigDecimal(strings[2]);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return bigDecimals;
    }
}
