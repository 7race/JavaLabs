package com.andrey.lab2;
import java.util.*;

public class Main {

    public static void main(String[] args) {

        System.out.println(min(1,2,3));
    }

    static int min(int x, int y, int z) {
        ArrayList<Integer> elements = new ArrayList<>();
        elements.add(x);
        elements.add(y);
        elements.add(z);

        return Collections.min(elements);
    }
}
