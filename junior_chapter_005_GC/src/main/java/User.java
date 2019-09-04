import org.openjdk.jol.info.ClassLayout;
import org.openjdk.jol.vm.VM;

import java.util.ArrayList;

import static java.lang.System.out;
import static java.lang.System.setOut;

public class User {
    String name;

    public User(String name) {
        this.name = name;
        System.out.println("Create object: " + name);
    }

    @Override
    public String toString() {
        return "Delete object: " + name + ".";
    }

    @Override
    protected void finalize() throws Throwable {
        System.out.println("Объект User:" + this.name + "был уничтожен.");
    }

    public static void main(String[] args) {
        Runtime runtime = Runtime.getRuntime();
        info(runtime);
        for (int i = 1; i < 51; i++) {
            User user = new User("User" + i);
            out.println();
            out.println("Перед вызовом сборщика мусора");
            info(runtime);
            runtime.gc();
            out.println();
            out.println("После вызова сборщика мусора");
            info(runtime);
        }
        info(runtime);
        out.println(VM.current().details());
        out.println(ClassLayout.parseClass(User.class).toPrintable());
    }

    public static void info(Runtime runtime) {
        short bbb = 1024;
        System.out.println("Свободно памяти: " + runtime.freeMemory() / bbb + " байт.");
        System.out.println("Всего пямяти: " + runtime.totalMemory() / bbb + " байт.");
        System.out.println("Используется памяти " + (runtime.totalMemory() / bbb - runtime.freeMemory() / bbb) + "байт.");
    }


}
