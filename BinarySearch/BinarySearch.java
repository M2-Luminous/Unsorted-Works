public class BinarySearch {
    public static int binarySearch(int[] array, int target) {
        int left = 0;
        int right = array.length - 1;

        while (left <= right) {
            int mid = left + (right - left) / 2;

            if (array[mid] == target) {
                return mid; // Target found, return its index.
            }

            if (array[mid] < target) {
                left = mid + 1; // Target is in the right half of the array.
            } else {
                right = mid - 1; // Target is in the left half of the array.
            }
        }

        return -1; // Target is not in the array.
    }

    public static void main(String[] args) {
        int[] sortedArray = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10}; // Sorted array.
        int target = 5; // Change this to the value you want to search for.

        int result = binarySearch(sortedArray, target);

        if (result != -1) {
            System.out.println("Element found at index " + result);
        } else {
            System.out.println("Element not found in the array.");
        }
    }
}
