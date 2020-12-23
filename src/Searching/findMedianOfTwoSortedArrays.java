package Searching;

//There are 2 sorted arrays A and B of size n each. Write an algorithm to find the median of the array obtained
// after merging the above 2 arrays(i.e. array of length 2n). The complexity should be O(log(n)).
// https://www.youtube.com/watch?v=LPFhl65R7ww
public class findMedianOfTwoSortedArrays {
    private static double findMedianOfSortedArrays(int input1[], int input2[]) {
        //since we are performing binary search on input1, input1 should be smaller than smaller2.
        if(input1.length > input2.length) {
            return findMedianOfSortedArrays(input2, input1);
        }

        int x = input1.length;
        int y = input2.length;

        int start = 0;
        int end = x;

        while (start < end) {
            int partitionX = (start + end) / 2;
            int partitionY = (x + y + 1) / 2 - partitionX;

            //partitionX or partitionY is 0, means there is nothing at the left side.
            int maxLeftX = (partitionX == 0) ? Integer.MIN_VALUE : input1[partitionX - 1];
            int maxLeftY = (partitionY == 0) ? Integer.MIN_VALUE : input2[partitionY - 1];

            //partitionX or partitionY is equal to the length of the array, means there is nothing at the right side.
            int minRightX = (partitionX == x) ? Integer.MAX_VALUE : input1[partitionX];
            int minRightY = (partitionY == y) ? Integer.MAX_VALUE : input2[partitionY];

            if (maxLeftX <= minRightY && maxLeftY <= minRightX) {
                if ((x + y) % 2 == 0) {
                    return ((double) Math.max(maxLeftX, maxLeftY) + Math.min(minRightX, minRightY)) / 2;
                } else {
                    return (double) Math.max(maxLeftX, maxLeftY);
                }
            } else if (maxLeftX > minRightY) {
                end = partitionX - 1; // we are too far on the right side for partitionX. Go on left side.
            } else {
                start = partitionX + 1; // we are too far on the left side for partitionX. Go on right side.
            }
        }
        // throws this exception only when the input arrays are not sorted.
        throw new IllegalArgumentException();
    }
    public static void main(String[] args) {
        int[] x = {1, 3, 8, 9, 15};
        int[] y = {7,11, 18, 19,21, 25};

        double median = findMedianOfSortedArrays(x, y);
        System.out.println("Median is : "+ median);
    }
}
