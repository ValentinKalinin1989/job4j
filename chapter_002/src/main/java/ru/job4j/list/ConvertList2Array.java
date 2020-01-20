package ru.job4j.list;

import java.util.ArrayList;
import java.util.List;

public class ConvertList2Array {
    public int[][] toArray(List<Integer> list, int rows) {
        int cells = (list.size() % rows == 0 ? list.size() / rows : (int) list.size() / rows + 1);
        int[][] array = new int[rows][cells];
        int index = 0;
        for (int numOfList
                : list) {
            array[(int) index / rows][(int) index % rows] = numOfList;
            index++;
        }

        return array;
    }

    public List<Integer> convert(List<int[]> list) {
        List<Integer> resultList = new ArrayList<Integer>();
        for (int[] arrayInt
                : list) {
            for (int numbberOfArray
                    : arrayInt) {
                resultList.add(numbberOfArray);
            }
        }
        return resultList;
    }
}
