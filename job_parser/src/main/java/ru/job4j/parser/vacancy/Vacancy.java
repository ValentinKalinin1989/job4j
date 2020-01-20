package ru.job4j.parser.vacancy;

import java.time.LocalDate;
import java.util.Objects;

public class Vacancy extends Object implements Comparable {

    private static final String LN = System.lineSeparator();
    private int id;
    private String name;
    private String info;
    private String link;
    private LocalDate localDate; //equals DATE in Postgres SQL

    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setInfo(String info) {
        this.info = info;
    }

    public void setLink(String link) {
        this.link = link;
    }

    public void setLocalDate(LocalDate localDate) {
        this.localDate = localDate;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getInfo() {
        return info;
    }

    public String getLink() {
        return link;
    }

    public LocalDate getLocalDate() {
        return localDate;
    }

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
