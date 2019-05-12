package ru.job4j.fuction;

import java.util.Arrays;
import java.util.Objects;

public class Student {
    private String name;
    private int scope;

    public Student(String name, int scope) {
        this.name = name;
        this.scope = scope;
    }

    public int getScope() {
        return this.scope;
    }

    @Override
    public int hashCode() {
        return this.scope;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Student student = (Student) o;
        return scope == student.scope
                && Objects.equals(name, student.name);
    }

    @Override
    public String toString() {
        return "Имя: " + this.name + "." + " Баллы: " + this.scope + ".";
    }
}
