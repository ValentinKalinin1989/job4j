package menu;

import menu.action.ExampleAction;
import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class MenuTest {

    private ExampleActionMenu root;
    private ExampleActionMenu example1;
    private ExampleActionMenu example11;
    private ExampleActionMenu example12;

    @Before
    public void initMenu() {
        root = new ExampleActionMenu(new SimpleMenu("Задача (1)"), new ExampleAction());
        example1 = new ExampleActionMenu(new SimpleMenu("Задача (1.1)"), new ExampleAction());
        example11 = new ExampleActionMenu(new SimpleMenu("Задача (1.1.1)"), new ExampleAction());
        example12 = new ExampleActionMenu(new SimpleMenu("Задача (1.1.2)"), null);
        ExampleActionMenu example2 = new ExampleActionMenu(new SimpleMenu("Задача (1.2)"), new ExampleAction());
        ExampleActionMenu example21 = new ExampleActionMenu(new SimpleMenu("Задача (1.2.1)"), new ExampleAction());
        ExampleActionMenu example3 = new ExampleActionMenu(new SimpleMenu("Задача (1.3)"), null);
        ExampleActionMenu example31 = new ExampleActionMenu(new SimpleMenu("Задача (1.3.1)"), new ExampleAction());
        ExampleActionMenu example32 = new ExampleActionMenu(new SimpleMenu("Задача (1.3.2)"), new ExampleAction());
        ExampleActionMenu example33 = new ExampleActionMenu(new SimpleMenu("Задача (1.3.3)"), new ExampleAction());

        root.addMenuItem(example1);
        root.addMenuItem(example2);
        root.addMenuItem(example3);
        example1.addMenuItem(example11);
        example1.addMenuItem(example12);
        example2.addMenuItem(example21);
        example3.addMenuItem(example31);
        example3.addMenuItem(example32);
        example3.addMenuItem(example33);
    }

    @Test
    public void when3LevelBulletMenuShouldPrint3LevelWithBullet() {

        String actual = root.getFullMenu();

        String expected = "Задача (1) 1"
                + "-- Задача (1.1) 1.1"
                + "---- Задача (1.1.1) 1.1.1"
                + "---- Задача (1.1.2) 1.1.2"
                + "-- Задача (1.2) 1.2"
                + "---- Задача (1.2.1) 1.2.1"
                + "-- Задача (1.3) 1.3"
                + "---- Задача (1.3.1) 1.3.1"
                + "---- Задача (1.3.2) 1.3.2"
                + "---- Задача (1.3.3) 1.3.3";

        assertThat(actual, is(expected));

    }

    @Test
    public void whenDoActionShouldDoRightAction() {
        ByteArrayOutputStream br = new ByteArrayOutputStream();
        PrintStream ps = new PrintStream(br);
        System.setOut(ps);

        example1.doAction();
        assertThat(br.toString(), is("some print action" + System.lineSeparator()));
        br.reset();

        example1.doAction();
        assertThat(br.toString(), is("some print action" + System.lineSeparator()));
        br.reset();

        System.setOut(System.out);
    }

    @Test(expected = NoSuchMenuAction.class)
    public void whenNoActionShouldException() {
        example12.doAction();
    }
}
