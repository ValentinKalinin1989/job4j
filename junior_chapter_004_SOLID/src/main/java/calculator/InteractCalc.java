package calculator;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class InteractCalc {
    public void run() {
        System.out.println("Калькулятор поддерживает простые операции.");
        System.out.println("Сложение: 1 + 2");
        System.out.println("Вычитание: 1 - 2");
        System.out.println("Умножение: 1 * 2");
        System.out.println("Деление: 1 / 2");
        System.out.println("Для выхода введите стоп");
        String result = "";
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        do {
            System.out.print(result);
            try {
                result = UseOperation.operation(result + reader.readLine());
            } catch (IOException e) {
                e.printStackTrace();
            }
        } while (!result.equals("стоп"));
    }
}
