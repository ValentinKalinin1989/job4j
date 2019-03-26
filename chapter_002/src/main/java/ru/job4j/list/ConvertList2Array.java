package ru.job4j.list;

import java.util.List;

public class ConvertList2Array {
    public int[][] toArray(List<Integer> list, int rows) {
        int cells = (list.size() % rows == 0 ? list.size() / rows : (int) list.size() / rows + 1);
        int[][] array = new int[rows][cells];
        int i = 0;
        for (int[] array2
                : array) {
            int j = 0;
            for (int arrayNumber
                    :array2) {
                if ((i * rows + j) < list.size()) {
                    array[i][j] = list.get(i * rows + j);
                } else{
                    array[i][j] = 0;
                }
                j++;
            }
            i++;
        }

        return array;
    }
}
