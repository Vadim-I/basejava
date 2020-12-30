package com.webapp;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class MainStreamAPI {

    public static void main(String[] args) {

        int[] arrayOne = {1,2,3,3,2,3};
        int[] arrayTwo = {9,8};
        int[] arrayThree = {5};
        System.out.println(minValue(arrayOne));
        System.out.println(minValue(arrayTwo));
        System.out.println(minValue(arrayThree));

        List<Integer> listOne = new ArrayList<>(Arrays.asList(1,2,3,4,5,6,7,8));
        List<Integer> listTwo = new ArrayList<>(Arrays.asList(1,2,3,4,5,6,7,8,9));
        List<Integer> listThree = new ArrayList<>(Collections.singletonList(5));
        List<Integer> listFour = new ArrayList<>(Collections.singletonList(2));
        System.out.println(oddOrEven(listOne));
        System.out.println(oddOrEven(listTwo));
        System.out.println(oddOrEven(listThree));
        System.out.println(oddOrEven(listFour));
    }

    public static int minValue(int[] values) {
        return Arrays.stream(values)
                .distinct()
                .sorted()
                .reduce(0, (x, y) -> (x * 10 + y));
    }

    public static List<Integer> oddOrEven(List<Integer> integers) {
        boolean isSumEven = (integers.stream()
                    .reduce(0, Integer::sum)) % 2 == 0;
        if (isSumEven) {
            return integers.stream()
                    .filter(x -> (x % 2 != 0))
                    .collect(Collectors.toList());
        } else {
            return integers.stream()
                    .filter(x -> (x % 2 == 0))
                    .collect(Collectors.toList());
        }
    }
}
