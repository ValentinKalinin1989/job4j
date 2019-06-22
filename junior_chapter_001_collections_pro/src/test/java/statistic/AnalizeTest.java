package statistic;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

public class AnalizeTest {

    @Test
    public void whenTestInfoChanged3Deleted3Added3() {
        List<Analize.User> listPrevios = new ArrayList<>();
        listPrevios.add(new Analize.User(12, "Федя"));
        listPrevios.add(new Analize.User(13, "Ваня"));
        listPrevios.add(new Analize.User(14, "Петя"));
        listPrevios.add(new Analize.User(15, "Аня"));
        listPrevios.add(new Analize.User(16, "Саня"));
        listPrevios.add(new Analize.User(17, "Таня"));
        List<Analize.User> listCurrent = new ArrayList<>();
        listCurrent.add(new Analize.User(12, "Аня"));
        listCurrent.add(new Analize.User(13, "Саня"));
        listCurrent.add(new Analize.User(14, "Петр"));
        listCurrent.add(new Analize.User(19, "Аня"));
        listCurrent.add(new Analize.User(10, "Саня"));
        listCurrent.add(new Analize.User(11, "Таня"));
        Analize analizeTest = new Analize();
        Analize.Info result = analizeTest.diff(listPrevios, listCurrent);
        assertThat(result.getAdded(), is(3));
        assertThat(result.getChanged(), is(3));
        assertThat(result.getDeleted(), is(3));
    }

}