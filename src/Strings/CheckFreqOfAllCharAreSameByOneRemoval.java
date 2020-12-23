package Strings;

//Given a string which contains lower alphabetic characters, we need to remove at most one character from this string in such a way that
// frequency of each distinct character becomes same in the string.

//we can iterate over all characters one by one and decrease their frequency by one, if all frequencies become same then we will flag that
// it is possible to make character frequency same by at most one removal and if frequencies don’t match then we will increase that frequency
// again and loop for other characters.

public class CheckFreqOfAllCharAreSameByOneRemoval {
    static boolean allSame (int[] arr) {
        // find first non zero frequency character;
        int i =0;
        int sameFreq = 0;
        for (i = 0; i< 26; i++ ) {
            if (arr[i] > 0) {
                sameFreq = arr[i];
                break;
            }
        }

        for (;i< 26; i++) {
            if (arr[i] > 0 && arr[i] != sameFreq ) {
                return false;
            }
        }
        return true;
    }
    static boolean possibleSameCharFreqByOneRemoval(String str) {
        int[] arr = new int[26];
        for (int i =0; i< str.length(); i++) {
            arr[str.charAt(i) - 'a']++;
        }
        if (allSame(arr)) {
            return true;
        }

        // decrease the frequency by 1.
        for (int i =0; i<26; i++) {
            if (arr[i] > 0) {
                arr[i]--;

                if (allSame(arr)) {
                    return true;
                }
                arr[i]++;
            }
        }
        return false;
    }
    public static void main(String[] args) {
        String str = "xyyzz";
        if (possibleSameCharFreqByOneRemoval(str))
            System.out.println("Yes");
        else
            System.out.println("No");
    }
}
