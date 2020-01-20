package ru.job4j.coffeemachine;

import java.util.ArrayList;
import java.util.List;


public class CoffeeMachine {
    public int[] changes(int value, int price) {
        List<Integer> change = new ArrayList<>();
        int moneyCh = value - price;
        int[] coins = new int[]{10, 5, 2, 1};
        for (int coin
                : coins) {
            while ((moneyCh - coin) >= 0) {
                change.add(coin);
                moneyCh = moneyCh - coin;
            }
        }
        int[] arrayChange = new int[change.size()];
        for (int i = 0; i < change.size(); i++) {
            arrayChange[i] = change.get(i);
        }
        return arrayChange;
    }
}
