package ru.job4j.comparator;

public class User implements Comparable<User> {
    private String name;
    private Integer age;

    public User() {
    }

    public User(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public Integer getAge() {
        return age;
    }

    @Override
    public int hashCode() {
        return super.hashCode();
    }

    @Override
    public boolean equals(Object obj) {
        return super.equals(obj);
    }

    public int compareTo(User o) {
        return this.age.compareTo(o.age);
    }


}
