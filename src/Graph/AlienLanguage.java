package Graph;


import java.util.ArrayList;
import java.util.Iterator;
import java.util.Stack;

// Given a sorted dictionary (array of words) of an alien language, find order of characters in the language.
//Examples:
//
//Input:  words[] = {"baa", "abcd", "abca", "cab", "cad"}
//Output: Order of characters is 'b', 'd', 'a', 'c'
//Note that words are sorted and in the given language "baa"
//comes before "abcd", therefore 'b' is before 'a' in output.
//Similarly we can find other orders.



public class AlienLanguage {
    // This function fidns and prints order of characer from a sorted
// array of words. n is size of words[].  alpha is set of possible
// alphabets.
// For simplicity, this function is written in a way that only
// first 'alpha' characters can be there in words array.  For
// example if alpha is 7, then words[] should have only 'a', 'b',
// 'c' 'd', 'e', 'f', 'g'

    static void printOrder(String[] words, int len) {
        Graph graph = new Graph(len);

        // Creates the graph from the first mismatched character of the words.
        for (int i =0; i< words.length-1; i++) {
            String word1 = words[i];
            String word2 = words[i+1];

            for (int j =0; j < Math.min(word1.length(), word2.length()); j++) {
                if (word1.charAt(j) != word2.charAt(j)) {
                    graph.addEdge(word1.charAt(j) - 'a' , word2.charAt(j) -'a' );
                    break;
                }
            }
        }
        // calls the topological sort on the graph.
        graph.topologicalSort();
    }

    public static void main(String[] args) {
        String[] words = {"baa", "abcd", "abca", "cab", "cad"};
        printOrder(words, 4);
    }
}

class Graph {
    ArrayList<ArrayList<Integer>> adj;
    void addEdge(int u, int v) {
        adj.get(u).add(v);
    }

    Graph(int v) {
        adj = new ArrayList<>();
        for (int i =0; i<v; i++) {
            adj.add(new ArrayList<>());
        }
    }
    void toplogicalSortUtil(int u, boolean[] visited, Stack<Integer> stack) {
        visited[u] = true;

        Iterator<Integer> iterator = adj.get(u).listIterator();
        while (iterator.hasNext()) {
            int node = iterator.next();
            if (!visited[node]) {
                toplogicalSortUtil(node, visited, stack);
            }
        }
        // push the node only when all of its children are visited.
        stack.push(u);
    }
    void topologicalSort() {
        Stack<Integer> stack = new Stack<>();
        boolean[] visited = new boolean[adj.size()];

        for (int u =0; u< adj.size(); u++) {
            if (!visited[u]) {
                toplogicalSortUtil(u, visited, stack);
            }
        }
        while (!stack.isEmpty()) {
            System.out.print((char) (stack.pop() + 'a') + " ");
        }
    }
}
