package ru.job4j.proffesion;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class TeacherTest {
    @Test
    public void testGetNameAndGetJob() {
        Teacher teacher = new Teacher("Татьяна", "Учитель");
        String resultName = teacher.getName();
        String resultJob = teacher.getJob();
        assertThat(resultName, is("Татьяна"));
        assertThat(resultJob, is("Учитель"));
    }

    @Test
    public void testTeach() {
        Teacher teacher = new Teacher("Татьяна", "Учитель");
        String result = (teacher.teach(new Student("Иван"))).getClass().getSimpleName();
        assertThat(result, is("Student"));
    }
}
