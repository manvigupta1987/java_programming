package Arrays;

// Time Complexity : O(n)
//Auxiliary Space : O(1)

// Please note that it can be solved using HashSet but Auxiliary space would be O(n).

public class FindOnlyRepetitiveElement {
    static int findRepeating(int[] arr, int len) {
        int sum = 0;
        for (int i=0; i< len; i++) {
            sum += arr[i];
        }
        return (sum - (len*(len-1)/2));
    }
    public static void main(String[] args) {
        int[] arr = { 9, 8, 2, 6, 1, 8, 5, 3, 4, 7 };
        int n = arr.length;
        System.out.println(findRepeating(arr, n));
    }
}
