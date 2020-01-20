package ru.job4j.fuction;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StudentSort {
    private Comparator<Student> comparator = (o1, o2) -> {
        if (o1 == null) {
            return 1;
        }
        if (o2 == null) {
            return -1;
        }
        return Integer.compare(o2.getScope(), o1.getScope());
    };

    List<Student> levelOf(List<Student> students, int bound) {
        return students.stream().sorted(comparator)
                .flatMap(Stream::ofNullable)
                .takeWhile(e -> e.getScope() > bound)
                .collect(Collectors.toList());
    }
}



