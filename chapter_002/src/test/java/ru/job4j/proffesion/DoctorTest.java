package ru.job4j.proffesion;

import org.junit.Test;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;


public class DoctorTest {

    @Test
    public void testGetNameAndGetJob() {
       Doctor doctor = new Doctor("Кашпировкий", "Доктор");
       String resultName = doctor.getName();
       String resultJob = doctor.getJob();
       assertThat(resultName, is("Кашпировкий"));
       assertThat(resultJob, is("Доктор"));

    }
    @Test
    public void testHeal() {
        Doctor doctor = new Doctor("Кашпировкий", "Доктор");
        String result = (doctor.heal(new Patient("Петя"))).getClass().getSimpleName();
        assertThat(result, is("Diagnose"));
    }
}
