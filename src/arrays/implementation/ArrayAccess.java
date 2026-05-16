package arrays.implementation;

public class ArrayAccess {

    // Time complexity: O(1)
    // Space complexity: O(1)
    public int getElementByIndex(int[] array, int index) {
        if (validateIndex(index, array)) {
            throw new IndexOutOfBoundsException("Invalid index");
        }
        return array[index];
    }

    // Time complexity: O(1)
    // Space complexity: O(1)
    public void setElement(int[] array, int index, int value) {
        if (validateIndex(index, array)) {
            throw new IndexOutOfBoundsException("Invalid index");
        }
        array[index] = value;
    }

    // Time complexity: O(1)
    // Space complexity: O(1)
    private boolean validateIndex(int index, int[] array) {
        return index < 0 || index >= array.length;
    }
}