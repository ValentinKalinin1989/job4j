package ru.job4j.comparator;

import java.util.Comparator;


public class ListCompare implements Comparator<String> {
    @Override
    public int compare(String left, String right) {
        int result = 0;
        for (int i = 0; i < left.length() && i < right.length(); i++) {
            Character leftChar = left.charAt(i);
            Character rightChar = right.charAt(i);
            result = leftChar.compareTo(rightChar);
            if (result != 0) {
                break;
            }
        }
        if (result == 0) {
            Integer leftInt = left.length();
            Integer rightInt = right.length();
            result = leftInt.compareTo(rightInt);
        }
        return result;
    }
}