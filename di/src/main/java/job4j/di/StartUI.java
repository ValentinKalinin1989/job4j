package job4j.di;

import org.springframework.stereotype.Component;

@Component
public class StartUI {
    private final Store store;
    private final ConsoleInput consoleInput;

    public StartUI(Store store, ConsoleInput consoleInput) {
        this.store = store;
        this.consoleInput = consoleInput;
    }

    public void add(String value) {
        store.add(value);
    }

    public void addFormConsole() {
        consoleInput.addFromConsole();
    }

    public void print() {
        for (String value : store.getAll()) {
            System.out.println(value);
        }
    }

    public void printFromConsole() {
        for (String value : consoleInput.getAllFromConsole()) {
            System.out.println(value);
        }
    }
}
