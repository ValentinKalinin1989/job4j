package ru.job4j.coffeemachine;

import java.util.ArrayList;
import java.util.List;

public class CoffeeMachine {
    public int[] changes(int value, int price) {
        List<Integer> change = new ArrayList<>();
        int moneyCh = value - price;
        while (true) {
            if ((moneyCh - 10) >= 0) {
                change.add(10);
                moneyCh = moneyCh - 10;
                System.out.println("add(10)");
            } else if ((moneyCh - 5) >= 0) {
                change.add(5);
                moneyCh = moneyCh - 5;
                System.out.println("add(5)");
            } else if ((moneyCh - 2) >= 0) {
                change.add(2);
                moneyCh = moneyCh - 2;
                System.out.println("add(2)");
            } else if ((moneyCh - 1) >= 0) {
                change.add(1);
                System.out.println("add(1)");
                moneyCh = moneyCh - 1;
            } else {
                break;
            }
        }
        int[] arrayChange = new int[change.size()];
        for (int i = 0; i < change.size(); i++) {
            arrayChange[i] = change.get(i);
        }
        return arrayChange;
    }
}
