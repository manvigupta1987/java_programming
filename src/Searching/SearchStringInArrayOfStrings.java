package Searching;

//Given an array of strings. The array has both empty and non-empty strings. All non-empty strings are in sorted order.
// Empty strings can be present anywhere between non-empty strings.

//binary search, we compare given str with middle string. If middle string is empty, we find the closest non-empty string x
// (by linearly searching on both sides). Once we find x, we do standard binary search, i.e., we compare given str with x.
// If str is same as x, we return index of x. if str is greater, we recur for right half, else we recur for left half.
public class SearchStringInArrayOfStrings {
    private static int findNonEmptyString(String[] arr, int mid) {
        int left = mid -1;
        int right = mid + 1;

        while (left > 0 && right < arr.length) {
            if (!arr[left].isEmpty() ) {
                return left;
            } else if (!arr[right].isEmpty()) {
                return right;
            }

            left --;
            right ++;
        }
        return mid;
    }
    private static int searchStr(String[] arr, String str, int low, int high ) {
        if (low == high && arr[low].equals(str)) {
            return low;
        }

        while (low < high) {
            int mid = low + (high - low)/2;
            System.out.println("Low " + low + "High "+ high + " mid " + mid);
            if (arr[mid].isEmpty()) {
                mid = findNonEmptyString(arr, mid);
            }
            if (arr[mid].equalsIgnoreCase(str)) {
                return mid;
            }
            if (arr[mid].compareToIgnoreCase(str) < 0 ) {
                low = mid + 1;
            } else {
                high = mid -1;
            }
        }
        return -1;
    }
    public static void main(String[] args) {
        // Input arr of Strings.
        String[] arr = { "for", "", "", "", "geeks", "ide", "", "practice", "", "", "quiz", "", "" };

        // input Search String
        String str = "eeks";
        int n = arr.length;

        System.out.println(searchStr(arr, str, 0, n - 1));
    }
}
