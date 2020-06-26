package job4j.di;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class SpringDI {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
        context.scan("job4j.di");
        context.refresh();
        StartUI ui = context.getBean(StartUI.class);

        ui.add("Petr Arsentev");
        ui.add("Ivan Ivanov");
        ui.print();

        ui.addFormConsole();
        ui.addFormConsole();
        ui.printFromConsole();
    }
}
