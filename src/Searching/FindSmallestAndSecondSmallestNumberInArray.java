package Searching;

//find smallest and second smallest element in an array.
// time complexity : O(n)
public class FindSmallestAndSecondSmallestNumberInArray {

    private static void findSmallestAndSecondSmallest(int[] arr) {
        if(arr.length < 2) {
            throw new IllegalArgumentException();
        }

        int firstSmall = Integer.MAX_VALUE, secondSmall = Integer.MAX_VALUE;
        for (int i =0; i < arr.length; i++) {
            if(arr[i] < firstSmall) {
                secondSmall = firstSmall;
                firstSmall = arr[i];
            }

            if(arr[i] < secondSmall && arr[i] != firstSmall) {
                secondSmall = arr[i];
            }
        }
        if(secondSmall == Integer.MAX_VALUE) {
            System.out.println("There is no second smallest number in the array.");
            return;
        }
        System.out.println("Two smallest numbers in the array are: "+ firstSmall + " " + secondSmall);
    }
    public static void main(String[] args) {
        int[] arr = {12, 13, 1, 10, 34, 1};
        findSmallestAndSecondSmallest(arr);

    }
}
