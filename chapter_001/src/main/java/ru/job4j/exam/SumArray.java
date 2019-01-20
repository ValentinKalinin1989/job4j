package ru.job4j.exam;

public class SumArray {
    public int[] sumfunc(int[] firstArray, int[] secondArray) {
        int[] sum = new int[firstArray.length + secondArray.length];
        int i = 0, j = 0;
        for (int k = 0; k < sum.length; k++) {
            if (i > firstArray.length - 1) {
                int a = secondArray[j];
                sum[k] = a;
                j++;
            } else if (j > secondArray.length - 1) {
                int a = firstArray[i];
                sum[k] = a;
                i++;
            } else if (firstArray[i] < secondArray[j]) {
                int a = firstArray[i];
                sum[k] = a;
                i++;
            } else {
                int a = secondArray[j];
                sum[k] = a;
                j++;
            }
        }
       return sum;
    }
}
