package ru.job4j.parser.vacancy;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.util.Objects;

public class Vacancy extends Object implements Comparable {

    private static final String LN = System.lineSeparator();
    @Getter @Setter private int id;
    @Getter @Setter private String name;
    @Getter @Setter private String info;
    @Getter @Setter private String link;
    @Getter @Setter private LocalDate localDate; //equals DATE in Postgres SQL


    public Vacancy(String name, String info, String link, LocalDate localDate) {
        this.name = name;
        this.info = info;
        this.link = link;
        this.localDate = localDate;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Vacancy vacancy = (Vacancy) o;
        return link == vacancy.link; //ссылка на каждую вакансию уникальна
    }
    @Override
    public int hashCode() {
        return Objects.hash(name);
    }
    @Override
    public String toString() {
        return "Вакансия " + LN
                + "Имя: " + name + LN
                + "Дата поступления: " + localDate + LN
                + "Описание: " + info + LN
                + "Ссылка: " + link + LN
                + "id: " + id + LN;
    }

    @Override
    public int compareTo(Object o) {
        Vacancy vac = (Vacancy) o;
        return this.localDate.compareTo(vac.localDate);
    }
}
