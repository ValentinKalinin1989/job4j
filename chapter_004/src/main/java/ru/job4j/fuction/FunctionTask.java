package ru.job4j.fuction;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;

public class FunctionTask {
    List<Double> diapason(int start, int end, Function<Double, Double> func) {
        List<Double> result = new ArrayList<Double>();
        for (int i = start; i < end; i++) {
            result.add(func.apply(Double.valueOf(i)));
        }
        return result;
    }


}

