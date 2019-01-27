package ru.job4j.proffesion;

import org.junit.Test;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class EngineerTest {
    @Test
    public void testGetNameAndGetJob() {
        Engineer engineer = new Engineer("Федя", "Инженер");
        String resultName = engineer.getName();
        String resultJob = engineer.getJob();
        assertThat(resultName, is("Федя"));
        assertThat(resultJob, is("Инженер"));
    }
    @Test
    public void testBuild() {
        Engineer engineer = new Engineer("Федя", "Инженер");
        String result = (engineer.build(new Building("Дом"))).getClass().getSimpleName();
        assertThat(result, is("Building"));
    }
}

