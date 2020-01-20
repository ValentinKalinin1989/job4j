package args;

import java.util.HashMap;
import java.util.Map;
import java.util.NoSuchElementException;

public class Args {

    private Map<String, String> args = new HashMap<>(6);

    public Args(String[] args) {
        if (args == null) {
            throw new NoSuchElementException("Отсутствуют аргументы командной строки");
        }

        for (int i = 0; i < 6; i += 2) {
            if (args[i] == null) {
                throw new NoSuchElementException("Отсутствует код аргумента");
            }
            if (args[i + 1] == null) {
                throw new NoSuchElementException("Отсутвует значение для аргумента");
            }
            this.args.put(args[i], args[i + 1]);
        }

        if (!this.args.containsKey("-d")) {
            throw new NoSuchElementException("Отсутвует директория для архивации");
        }
        if (!this.args.containsKey("-e")) {
            throw new NoSuchElementException("Отсутвует информация о расширении файлов исключения");
        }
        if (!this.args.containsKey("-o")) {
            throw new NoSuchElementException("Отсутвует директория для сохранения");
        }
    }

    public String directory() {
        return this.args.get("-d");
    }

    public String excule() {
        String ext = this.args.get("-e");
        ext.replaceAll("[*.]", "");

        return ext;
    }

    public String output() {
        return this.args.get("-o");
    }
}