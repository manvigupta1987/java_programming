package Hashing;

import java.util.HashMap;

public class fourSum {
    public static int findFourSum(int[] num1, int[] num2, int[] num3, int[] num4) {
        int res = 0;
        HashMap<Integer, Integer> map = new HashMap<>();
        for(int i = 0; i< num1.length; i++) {
            for(int j = 0; j< num2.length; j++) {
                int sum = num1[i] + num2[j];
                map.put(sum, map.getOrDefault(sum, 0) + 1);
            }
        }

        // now check if the opposite of the sum of num3 and num4 exists in the map.
        for(int i = 0; i< num3.length; i++) {
            for (int j = 0; j < num4.length; j++) {
                int sum = (num3[i] + num4[j]) * -1;
                if (map.containsKey(sum)) {
                    res += map.get(sum);
                }
            }
        }
        return res;
    }

    public static void main(String[] args) {

        int[] nums1 = {1,2}, nums2 = {-2,-1}, nums3 = {-1,2}, nums4 = {0,2};
        System.out.println(findFourSum(nums1, nums2, nums3, nums4));
    }
}
