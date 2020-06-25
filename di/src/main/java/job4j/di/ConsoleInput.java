package job4j.di;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ConsoleInput {
    private List<String> data = new ArrayList<String>();
    private Scanner scanner = new Scanner(System.in);

    public void add() {
        System.out.println("Input value:");
        data.add(scanner.nextLine());
    }

    public List<String> getAll() {
        return data;
    }
}
