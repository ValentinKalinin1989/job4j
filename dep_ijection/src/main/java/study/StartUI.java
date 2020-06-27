package study;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope("prototype")
public class StartUI {

    @Autowired
    private Store store;
    @Autowired
    private ConsoleInput consoleInput;

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
