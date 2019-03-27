package ru.job4j.list;

import java.util.ArrayList;
import java.util.List;

public class ConvertMatrix2List {
    public List<Integer> toList(int[][] array) {
        List<Integer> list = new ArrayList<>();
        for (int[] array2
                : array) {
            int j = 0;
            for (int arrayNumber
                    :array2) {
                list.add(arrayNumber);
            }
        }
        return list;
    }
}
