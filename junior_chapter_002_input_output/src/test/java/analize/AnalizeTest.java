package analize;

import config.Config;
import org.junit.Test;
import java.io.*;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

public class AnalizeTest {

    @Test
    public void testAnalize() {
        try (PrintWriter out = new PrintWriter(new FileOutputStream("unavailable.csv"))) {
            out.println("200 10:02:32");
            out.println("400 11:12:32");
            out.println("500 11:14:32");
            out.println("200 11:17:32");
            out.println("300 11:23:32");
            out.println("200 11:30:32");
            out.println("400 11:50:32");
        } catch (Exception e) {
            e.printStackTrace();
        }

        Analizy analizy = new Analizy();
        analizy.unavailable("unavailable.csv", "result.csv");

        Config config = new Config("result.csv");
        String result = config.toString();
        String forTest = "11:12:32 - 11:17:32" + System.lineSeparator() + "11:50:32 - ";
        assertThat(result, is(forTest));
    }

}
