package ru.job4j.proffesion;

public class Teacher extends Proffesion {
    public Teacher(String name, String job) {
        this.name = name;
        this.job = job;
    }

    /**
     * Обучение
     * @param student студент
     * @return Student после получения знаний
     */
    public Student teach(Student student) {
        return new Student("Studet");
    }
}
