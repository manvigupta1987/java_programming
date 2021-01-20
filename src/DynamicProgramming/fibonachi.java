package DynamicProgramming;

public class fibonachi {

    // qb is the question bank which stores the result of the previously calculated numbers.
    static int Calculatefibonachi(int n, int[] qb) {
        if (n == 0 || n ==1 ) {
            return n;
        }
        if (qb[n] != 0) {
            return qb[n];
        }

        int fibN  = Calculatefibonachi(n-1, qb) + Calculatefibonachi(n-2 , qb);
        qb[n] = fibN;
        return fibN;
    }
    public static void main(String[] args) {
        int N = 10;

        System.out.println(Calculatefibonachi(N, new int[N+1]));
    }


}
