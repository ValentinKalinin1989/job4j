package ru.job4j.proffesion;

public class Proffesion {
    private String job;
    private String name;

    public Proffesion(String name, String job) {
        this.name = name;
        this.job = job;
    }

    public String getName() {
        return this.name;
    }
    public String getJob() {
        return this.job;
    }
}
