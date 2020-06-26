package job4j.di;

import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

@Component
public class ConsoleInput {
    private List<String> data = new ArrayList<String>();
    private Scanner scanner = new Scanner(System.in);

    public void addFromConsole() {
        System.out.println("Input value:");
        data.add(scanner.nextLine());
    }

    public List<String> getAllFromConsole() {
        return data;
    }
}
