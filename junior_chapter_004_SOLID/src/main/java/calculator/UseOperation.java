package calculator;

public class UseOperation {
    public static String operation(String task) {
        final String LN = System.lineSeparator();
        String resulte;
        String strToSplit = task.replaceAll("Ошибка ввода", "");
        String[] strings = strToSplit.split(" ");
        if (task.contains("стоп")) {
            resulte = "стоп";
        } else if (strings.length < 3) {
            resulte = "Ошибка ввода" + LN;
        } else {
            switch (strings[1]) {
                case "+":
                    resulte = String.valueOf(SimpleOperation.PLUS.apply(Double.parseDouble(strings[0]), Double.parseDouble(strings[2])));
                    break;
                case "-":
                    resulte = String.valueOf(SimpleOperation.MINUS.apply(Double.parseDouble(strings[0]), Double.parseDouble(strings[2])));
                    break;
                case "*":
                    resulte = String.valueOf(SimpleOperation.TIMES.apply(Double.parseDouble(strings[0]), Double.parseDouble(strings[2])));
                    break;
                case "/":
                    resulte = String.valueOf(SimpleOperation.DIVIDE.apply(Double.parseDouble(strings[0]), Double.parseDouble(strings[2])));
                    break;
                default:
                    resulte = "Ошибка ввода" + LN;
            }
        }
        return resulte;
    }
}
