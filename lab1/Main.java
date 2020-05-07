package com.andrey.lab1;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class Main {

    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5};

        swap(0, 4, arr);

    }

    public static boolean swap(int i, int j, int[] anArray) {
        if (i >= anArray.length || j >= anArray.length) {
            return false;
        }

        int r = anArray[i];
        anArray[i] = anArray[j];
        anArray[j] = r;

        for (int a : anArray)
            System.out.print(a + " ");

        return true;
    }
}