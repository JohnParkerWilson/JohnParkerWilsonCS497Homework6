import java.util.*;

class Solution {
    public static void main(String[] args) {
        int [] edges = {3,3,4,2,3};

        System.out.println(longestCycle(edges.length, edges));

    }


    public static int longestCycle(int n, int[] edges){
        int result = -1;
        //Search using DFS
        List<Boolean> visited = new ArrayList<Boolean>(n);
        int curNode = 0;
        //DFS loop
        for(int i = 0; i < n; i++) {
            //Recur for adjacent nodes
            if(!visited.get(curNode)) {
                //To keep track of distances of cycles
                Map<Integer, Integer> maxDist = new HashMap<>();
                maxDist.put(curNode, 1);
                //Go to DFS recursion
                cycleRecur(result, curNode, edges, maxDist, visited);
            }
            curNode++;
        }

        return result;
    }

    //DFS Recursion
    public static void cycleRecur(int result, int curNode, int[] edges, Map<Integer, Integer> maxDist, List<Boolean> visited){
        visited.set(curNode, true);
        int adj = edges[curNode];
        //Keep searching for max
        if (!visited.get(adj)) {
            maxDist.put(adj, maxDist.get(curNode)+1);
            cycleRecur(result, curNode, edges, maxDist, visited);
        }
        else { //Reached a cycle
            result = Math.max(result, maxDist.get(curNode) - maxDist.get(adj) + 1);
        }

    }
}
