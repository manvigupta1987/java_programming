package Stack;
import java.util.Stack;

//Given a string consisting of opening and closing parenthesis, find the length of the longest valid parenthesis substring.
//
//Examples:
//
//Input : ((()
//Output : 2
//Explanation : ()
public class FindMAxLen {
    static int findMaxLen(String str)
    {
        int result = 0;
        int i = 0;
        Stack<Integer> stack = new Stack<>();
        stack.push(-1);
        while (i < str.length()) {
            if (str.charAt(i) == '(') {
                stack.push(i);
            } else {
                if (!stack.isEmpty()) {
                    stack.pop();
                }

                if (!stack.isEmpty()) {
                    result = Math.max(result, i- stack.peek());
                } else {
                    // If stack is empty. push current index as base for next valid substring (if any)
                    stack.push(i);
                }
            }
            i++;
        }
        return result;
    }

    // Driver code
    public static void main(String[] args)
    {
        String str = "((()()";

        // Function call
        System.out.println(findMaxLen(str));

        str = "()(()))))";

        // Function call
        System.out.println(findMaxLen(str));
    }
}
