package ru.job4j.proffesion;

public class Doctor extends Proffesion {
    public Doctor(String name, String job) {
        super(name, job);
    }

    /**
     * лечение пациента
     *
     * @param patient пациент
     * @return Diagnose (возвращает диагноз)
     */
    public Diagnose heal(Patient patient) {

        return new Diagnose("Diagnose");
    }
}
