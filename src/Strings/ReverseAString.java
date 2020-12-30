package Strings;

public class ReverseAString {
    static String reverseString(String str) {
        if (str.length() == 1) {
            return str;
        }
        int left = 0, right = str.length() -1;
        char[] ch = str.toCharArray();
        while (left != right) {
            int temp = ch[left];
            ch[left] = ch[right];
            ch[right] = ch[left];
            left++;
            right--;
        }
        return new String(ch);
    }

    static void reverseStringUsingRecursion(String str) {
        if (str == null || str.length() < 1) {
            System.out.println(str);
        } else {
            System.out.print(str.charAt(str.length()-1));
            reverseStringUsingRecursion(str.substring(0, str.length()-1));
        }
    }

    static void reverseStringUsingRecursionInPlace(char[] str, int i) {
        int n = str.length;
        if ( i == n/2) {
            return;
        }
        swap(str, i, n-i-1);
        reverseStringUsingRecursionInPlace(str, i+1);
    }

    static char[] swap(char []arr, int i, int j)
    {
        char temp= arr[i];
        arr[i]=arr[j];
        arr[j]=temp;
        return arr;
    }

    public static void main(String[] args) {
        String str = "GeeksForGeeks";
        System.out.println(reverseString(str));

        reverseStringUsingRecursion(str);
        char[] str1 = str.toCharArray();
        reverseStringUsingRecursionInPlace(str1, 0);

        System.out.println(String.valueOf(str1));

    }
}
