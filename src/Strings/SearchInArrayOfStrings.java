package Strings;

//Given an array of strings. The array has both empty and non-empty strings. All non-empty strings are in sorted order.
// Empty strings can be present anywhere between non-empty strings.

public class SearchInArrayOfStrings {
    static int compareString(String str1, String str2) {
        int i = 0;
        while (i < str1.length() -1 && str1.charAt(i) == str2.charAt(i)) {
            i++;
        }

        if (str1.charAt(i) > str2.charAt(i)) {
            return -1;
        } else if ( str1.charAt(i) < str2.charAt(i)) {
            return 1;
        } else {
            return 0;
        }
    }
    static int searchStr(String[] arr, String searchStr, int low, int high) {
        int mid = (low + high) / 2;

        if (arr[mid].isEmpty()) {
            int left = mid-1;
            int right = mid+1;
            while (true) {
                if (left < right && right > high) {
                    return -1;
                }
                if (right < high && !arr[right].isEmpty()) {
                    mid = right;
                    break;
                }
                if (left < right && !arr[left].isEmpty()) {
                    mid = left;
                    break;
                }
                left--;
                right++;
            }
        }

        if(compareString(searchStr, arr[mid]) == 0 ) {
            return mid;
        }
        if(compareString(searchStr, arr[mid]) < 0 ) {
            return searchStr(arr, searchStr, mid+1, high);
        }
        return searchStr(arr, searchStr, low, mid-1);

    }
    public static void main(String[] args) {
        String[] arr = { "for", "", "", "", "geeks", "ide", "", "practice", "", "", "quiz", "", "" };

        // input Search String
        String str = "quiz";
        int n = arr.length;

        System.out.println(searchStr(arr, str, 0, n - 1));
    }
}
