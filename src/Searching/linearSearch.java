package Searching;

// time complexity of this program is O(n)
public class linearSearch {
    private static int search(int arr[], int x) {
        for (int i = 0; i< arr.length; i++) {
            if(x == arr[i]) {
                return i;
            }
        }
        return -1;
    }
    public static void main(String[] args) {
        int arr[] = { 2, 3, 4, 10, 40 };
        int x = 10;

        int result = search(arr, x);
        if(result == -1) {
            System.out.println("Element is not present in the array");
        } else {
            System.out.println("Element is present in the array: " + result );
        }
    }
}
