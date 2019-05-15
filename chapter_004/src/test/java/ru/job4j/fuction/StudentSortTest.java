package ru.job4j.fuction;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class StudentSortTest {
    @Test
    public void whenTestStudentSortWithOutNullObjects() {
        List<Student> students = List.of(
                new Student("Вася", 79),
                new Student("Федя", 81),
                new Student("Коля", 45),
                new Student("Оля", 120),
                new Student("Таня", 99),
                new Student("Саня", 89),
                new Student("Толик", 80)
        );

        StudentSort studSort = new StudentSort();

        List<Student> studentAfterSort = studSort.levelOf(students, 80);

        assertThat(120, is(studentAfterSort.get(0).getScope()));
        assertThat(99, is(studentAfterSort.get(1).getScope()));
        assertThat(89, is(studentAfterSort.get(2).getScope()));
        assertThat(81, is(studentAfterSort.get(3).getScope()));

    }
}