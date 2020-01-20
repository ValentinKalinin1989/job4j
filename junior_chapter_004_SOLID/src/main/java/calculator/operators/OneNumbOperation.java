package calculator.operators;

import java.math.BigDecimal;

public abstract class OneNumbOperation implements CalcOperation {
    /**
     * проведение операции над строкой и вывод результато
     *
     * @param task строка для извлечения переменных
     * @return результат операции
     */
    public abstract String operation(String task);

    /**
     * получение примера операций
     *
     * @return пример выражения для данной операции
     */
    public String exampleOper(String example) {
        return example;
    }

    /**
     * получение имя операции
     *
     * @return имя операции
     */
    public String nameOper(String name) {
        return name;
    }

    /**
     * получение двух значений из строки, возвращает true - если упешно
     *
     * @param str строка для вычисления
     * @return результат получения значений true или false
     */
    protected BigDecimal strAnalize(String str) {
        BigDecimal bigDecimal = null;
        String[] strings = str.split(" ");
        if (strings.length == 2) {
            try {
                bigDecimal = new BigDecimal(strings[1]);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return bigDecimal;
    }
}

