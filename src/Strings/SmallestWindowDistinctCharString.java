package Strings;

// Problem: Given a string, find the smallest window length with all distinct characters of the given string. For eg. str = “aabcbcdbca”, then the result would be 4 as of the smallest window will be “dbca” .

// Solution: Sliding Window algorithm:
//Basically a window of characters is maintained by using two pointers namely start and end. These start and end pointers can be used to shrink
// and increase the size of window respectively. Whenever the window contains all characters of given string, the window is shrinked from left side
// to remove extra characters and then its length is compared with the smallest window found so far.
//If in the present window, no more characters can be deleted then we start increasing the size of the window using the end until all the distinct
// characters present in the string are also there in the window. Finally, find the minimum size of each window.

//Time Complexity: O(N).
public class SmallestWindowDistinctCharString {
    static final int MAX_CHARS = 256;

    // Function to find smallest window containing
    // all distinct characters
    static String findSubString(String str)
    {
        if (str.isEmpty() || str.length() == 1) {
            return str;
        }
        int n = str.length();
        final int MAX_CHARS = 26;
        boolean visited[] = new boolean[MAX_CHARS];
        int dist_count = 0;

        //find the distinct character count in the string.
        for (int i=0; i< n; i++) {
            int index = str.charAt(i)-'a';
            if (!visited[index]) {
                visited[index] = true;
                dist_count++;
            }
        }

        int[] curr_count = new int[MAX_CHARS];
        int start = 0, start_index = -1;
        int min_len = Integer.MAX_VALUE;
        int count = 0;
        for (int i=0; i<n; i++) {
            int index = str.charAt(i) -'a';
            // fill the occurances of the character in the string.
            curr_count[index]++;

            // increment the count if the character is distinct.
            if (curr_count[index] == 1) {
                count++;
            }
            // count is equal to the distint string count.
            if (count == dist_count) {

                //Slide the window if the character at start index is present more than once.
                while (curr_count[str.charAt(start)-'a'] > 1) {
                    if (curr_count[str.charAt(start)-'a'] > 1) {
                        curr_count[str.charAt(start)-'a']--;
                    }
                    start++;
                }
                // Update window size
                int len_window = i - start + 1;
                if (min_len > len_window) {
                    min_len = len_window;
                    start_index = start;
                }
            }
        }
        return str.substring(start_index, start_index+min_len);
    }

    // Driver code
    public static void main(String args[])
    {
        String str = "aabcbcdbca";
        System.out.println("Smallest window containing all distinct"
                + " characters is: " + findSubString(str));
    }


}
