package Strings;

import java.util.Comparator;
import java.util.PriorityQueue;

//Given a string with repeated characters, the task is to rearrange characters in a string so that no two adjacent characters are same.
//
//Note : It may be assumed that the string has only lowercase English alphabets.
//
//Examples:
//
//Input: aaabc
//Output: abaca

//Time Complexity : O(nLog(n))

//Solution:
// 1. Build a Priority_queue or max_heap, pq that stores characters and their frequencies.
// 2. Create a temporary Key that will be used as the previously visited element Initialize it { char = ‘#’ , freq = ‘-1’ }
// 3. While pq is not empty.
//….. Pop an element and add it to the result.
//….. Push the previous element back into the priority_queue if it’s frequency > ‘0’
//….. Decrease frequency of the popped element by ‘1’
//….. Make the current element as the previous element for the next iteration.
// 4. If the length of the resultant string and original string is not equal, print “not possible”. Else print result.
public class RearrangeCharsNoSameCharAreTogether {
    static class KeyComparator implements Comparator<Key> {

        @Override
        public int compare(Key o1, Key o2) {
            if (o1.count < o2.count) {
                return 1;
            } else if (o1.count > o2.count) {
                return -1;
            } else {
                return 0;
            }
        }
    }
    static class Key {
        int count;
        Character ch;

        Key(int c, char ch) {
            this.count = c;
            this.ch = ch;
        }
    }

    static void rearrangeString(String str) {
        if (str.length() == 1) {
            return;
        }

        PriorityQueue<Key> pq = new PriorityQueue<>(new KeyComparator());
        int i =0;
        int countArr[] = new int[26];
        while (i < str.length()) {
            countArr[str.charAt(i)-'a'] ++;
            i++;
        }
        for (char c = 'a'; c < 'z'; c++) {
            int val = c - 'a';
            if (countArr[val] > 0 ) {
                pq.add(new Key(countArr[val], c));
            }
        }

        String result = "";
        Key prev = new Key(-1, '#');
        while (pq.size() != 0) {
            Key curr = pq.poll();
            result = result + curr.ch;

            if (prev.count > 0) {
                pq.add(prev);
            }

            curr.count--;
            prev = curr;
        }

        // If length of the resultant string and original
        // string is not same then string is not valid
        if (result.length() != str.length())
            System.out.println(" Not valid String ");
        else
            System.out.println(result);
    }
    public static void main(String[] args) {
        String str = "bbbaa" ;
        rearrangeString(str);
    }
}
