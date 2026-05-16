package arrays.implementation;

import java.util.Arrays;

public class ArrayCreation {

    // Time complexity: O(1)
    // Space complexity: O(n)
    public int[] createEmptyArray(int size) {
        return new int[size];
    }

    // Time complexity: O(n)
    // Space complexity: O(n)
    public int[] createFilledArray(int size) {
        int[] array = new int[size];
        for (int i = 0; i < size; i++) {
            array[i] = i;
        }
        return array;
    }

    // Time complexity: O(n)
    // Space complexity: O(n)
    public int[] createFilledArrayUsingArraysFill(int size, int value) {
        int[] array = new int[size];
        Arrays.fill(array, value);
        return array;
    }
}