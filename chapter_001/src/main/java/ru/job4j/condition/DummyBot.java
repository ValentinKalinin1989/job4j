package ru.job4j.condition;

/**
 * @author Kalinin
 * @version 1.00
 * @since 08.01.2019
 */
public class DummyBot {
    /**
     * Отвечает на вопросы.
     *
     * @param question Вопрос от клиента.
     * @return Ответ.
     */
    public String answer(String question) {
        String rsl = "Это ставит меня в тупик. Спросите другой вопрос.";
        if ("Привет, Бот.".equals(question)) {

            rsl = "Привет, умник.";
        } else if ("Пока.".equals(question)) {

            rsl = "До скорой встречи.";
        }
        return rsl;
    }
}