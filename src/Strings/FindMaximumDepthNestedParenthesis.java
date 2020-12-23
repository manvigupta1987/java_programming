package Strings;

// We are given a string having parenthesis like below
//     “( ((X)) (((Y))) )”
//We need to find the maximum depth of balanced parenthesis, like 4 in the above example. Since ‘Y’ is surrounded by 4 balanced parentheses.
//If parenthesis is unbalanced then return -1.
public class FindMaximumDepthNestedParenthesis {
    static int maxDepth(String str) {
        int currentMax =0 , max = 0, i =0;
        while (i < str.length()) {
            if (str.charAt(i) == '(') {
                currentMax++;
            }
            if (currentMax > max) {
                max = currentMax;
            }
            if (str.charAt(i) == ')') {
                currentMax--;
            }
            i++;
        }

        if (currentMax > 0) {
            return -1;
        }
        return max;
    }
    public static void main(String[] args) {
        String s = "( a(b) (c) (d(e(f)g)h) I (j(k)l)m)";
        System.out.println(maxDepth(s));
    }
}
