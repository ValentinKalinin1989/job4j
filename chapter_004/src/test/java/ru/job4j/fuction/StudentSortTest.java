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
        List<Student> students = new ArrayList<>(4);
        students.add(new Student("Вася", 79));
        students.add(new Student("Федя", 81));
        students.add(null);
        students.add(new Student("Коля", 45));
        students.add(new Student("Оля", 120));
        students.add(null);
        students.add(new Student("Таня", 99));
        students.add(new Student("Саня", 89));
        students.add(null);
        students.add(new Student("Толик", 80));

        StudentSort studSort = new StudentSort();

        List<Student> studentAfterSort = studSort.levelOf(students, 80);

        assertThat(120, is(studentAfterSort.get(0).getScope()));
        assertThat(99, is(studentAfterSort.get(1).getScope()));
        assertThat(89, is(studentAfterSort.get(2).getScope()));
        assertThat(81, is(studentAfterSort.get(3).getScope()));

    }
}