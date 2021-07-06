// Given an integer array nums of unique elements, return all possible subsets (the power set).
//The solution set must not contain duplicate subsets. Return the solution in any order.
//
//Example 1:
//
//Input: nums = [1,2,3]
//Output: [[],[1],[2],[1,2],[3],[1,3],[2,3],[1,2,3]]

package Arrays;

import java.util.ArrayList;
import java.util.List;

public class findSubsets {
    static int[] nums ={0, 1, 2};
    static List<List<Integer>> result = new ArrayList();
    public static void findSubsetsOfArray(int index, List<Integer> curr_list) {
        result.add(new ArrayList<>(curr_list));
        for(int i =index; i< nums.length; ++i) {
            curr_list.add(nums[i]);
            findSubsetsOfArray(i+1, curr_list);
            curr_list.remove(curr_list.size() -1);
        }
    }

    public static void main(String[] args) {
        findSubsetsOfArray(0, new ArrayList<>());
        for(List<Integer> item : result) {
            System.out.print(item + " ");
        }
    }
}
