package ru.job4j.parser.utill;

import java.time.LocalDate;
/**
 * convert date format(сегодня, вчера, 23 авг 15)
 * to java.sql.Date
 */
public class DateConverter {
    /**
     * convert date of String to java.time.LocalDate
     * @param date date format(сегодня, вчера, 23 авг 15) in String
     * @return Date
     */
    public static LocalDate convertToDate(String date) {
        LocalDate currentDate = null;
        String[] firstSplit = date.split(",");
        if (firstSplit[0].equals("сегодня")) {
            currentDate = LocalDate.now();
        } else if (firstSplit[0].equals("вчера")) {
            currentDate = LocalDate.now().minusDays(1);
        } else {
            Integer numbMonth = 0;
            String[] secondSplit = firstSplit[0].split(" ");
            switch (secondSplit[1]) {
                case ("янв"):
                    numbMonth = 1;
                    break;
                case ("фев"):
                    numbMonth = 2;
                    break;
                case ("мар"):
                    numbMonth = 3;
                    break;
                case ("апр"):
                    numbMonth = 4;
                    break;
                case ("май"):
                    numbMonth = 5;
                    break;
                case ("июн"):
                    numbMonth = 6;
                    break;
                case ("июл"):
                    numbMonth = 7;
                    break;
                case ("авг"):
                    numbMonth = 8;
                    break;
                case ("сен"):
                    numbMonth = 9;
                    break;
                case ("окт"):
                    numbMonth = 10;
                    break;
                case ("ноя"):
                    numbMonth = 11;
                    break;
                case ("дек"):
                    numbMonth = 12;
                    break;
                default:
                    break;
            }
            currentDate = LocalDate.of(Integer.parseInt("20".concat(secondSplit[2])), numbMonth, Integer.parseInt(secondSplit[0]));
        }
        return currentDate;
    }
}
