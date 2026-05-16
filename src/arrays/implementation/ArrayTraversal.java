package arrays.implementation;

public class ArrayTraversal {

    //Time complexity: O(n)
    //Space complexity: O(1)
    public String traverseArray(int[] array) {
        validateArray(array);
        StringBuilder sb = new StringBuilder();
        for (int element : array) {
            sb.append(element).append(" ");
        }
        return sb.toString().trim();
    }

    //Time complexity: O(n)
    //Space complexity: O(1)
    public String reverseTraverseArray(int[] array) {
       validateArray(array);
        StringBuilder sb = new StringBuilder();
        for (int i = array.length - 1; i >= 0; i--) {
            sb.append(array[i]).append(" ");
        }
        return sb.toString().trim();
    }

    //Time complexity: O(n)
    //Space complexity: O(1)
    public int linearSearch(int[] array, int target){
        validateArray(array);
        for (int i = 0; i < array.length; i++) {
            if(array[i] == target){
                return i;
            }
        }
        return -1;
    }

    //Time complexity: O(1)
    //Space complexity: O(1)
    private void validateArray(int[] array) {
        if (array == null || array.length == 0) {
            throw new IllegalArgumentException("Array is null or empty");
        }
    }


}






