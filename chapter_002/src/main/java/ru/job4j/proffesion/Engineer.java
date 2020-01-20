package ru.job4j.proffesion;

public class Engineer extends Proffesion {

    public Engineer(String name, String job) {
        super(name, job);
    }

    /**
     * Строит дом
     *
     * @param building строение
     * @return Building строение после строительных работ
     */
    public Building build(Building building) {

        return new Building("Building");
    }
}
