package DynamicProgramming;

// Suppose that we wish to know which stories in a 36-story building are safe to drop eggs from, and which will cause the eggs to break on landing. We make a few assumptions:
//
//…..An egg that survives a fall can be used again.
//…..A broken egg must be discarded.
//…..The effect of a fall is the same for all eggs.
//…..If an egg breaks when dropped, then it would break if dropped from a higher floor.
//…..If an egg survives a fall then it would survive a shorter fall.
//…..It is not ruled out that the first-floor windows break eggs, nor is it ruled out that the 36th-floor do not cause an egg to break.
//
//If only one egg is available and we wish to be sure of obtaining the right result, the experiment can be carried out in only one way. Drop the egg from the first-floor window; if it survives, drop it from the second-floor window. Continue upward until it breaks. In the worst case, this method may require 36 droppings. Suppose 2 eggs are available. What is the least number of egg-droppings that is guaranteed to work in all cases?
//The problem is not actually to find the critical floor, but merely to decide floors from which eggs should be dropped so that the total number of trials are minimized.

//  https://www.youtube.com/watch?v=UvksR0hR9nA
// https://www.geeksforgeeks.org/egg-dropping-puzzle-dp-11/

public class EggDroppingProblem {
    static int eggDrop(int eggs, int floors) {
        int[][] eggsFloor = new int[eggs+1][floors+1];
        if (eggs == 0 || floors == 0) {
            return 0;
        }
        // if there is only one egg
        for (int i = 0; i<=floors; i++) {
            eggsFloor[1][i] = i;
        }
        // start with 2 eggs. So there are two cases, if egg survives on the kth floor, then remaining eggs are e and floors to try on (floors - k).
        // if egg breaks on the floor k, then remaining eggs are e-1 and floors to try on is (k -1).

        for (int e = 2; e<=eggs; e++) {
            for (int f =1; f<= floors; f++) {
                eggsFloor[e][f] = Integer.MAX_VALUE;

                // Findout the max value of egg breaking or surviving on a particular floor and then calculate min of all the max values.
                for (int k = 1; k<=f; k++) {
                    int c = Math.max(eggsFloor[e-1][k-1], eggsFloor[e][f-k]);
                    if (c < eggsFloor[e][f]) {
                        eggsFloor[e][f] = 1 + c;
                    }
                }
            }
        }
        return eggsFloor[eggs][floors];

    }
    public static void main(String[] args) {
        int n = 2, k = 10;
        System.out.println("Minimum number of trials in worst"
                + " case with "
                + n + "  eggs and "
                + k + " floors is " + eggDrop(n, k));
    }
}
