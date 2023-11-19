import java.util.*;

class Solution {
    public static void main(String[] args) {
        int n = 3, source = 0, destination = 2;
        int [][] edges = {{0,1},{1,2},{2,0}};
        if(pathExists(edges, source, destination, n)) {
            System.out.println("Path exists");
        }
        else {
            System.out.println("Path DOES NOT exists");
        }
    }

    //Breadth First Search
    public static Boolean pathExists(int[][] edges, int source, int destination, int n){
        Boolean [] visited = new Boolean[n];
        LinkedList<Integer> queue = new LinkedList<Integer>();

        //Convert edges into a regular graph
        List<List<Integer>> graph = new ArrayList<List<Integer>>(n);
        for(int i = 0; i < n-1; i++) {
            graph.set(i, new ArrayList<Integer>());
        }
        for(int i = 0; i < n-1; i++) {
            graph.get(edges[i][0]).add(edges[i][1]);
            graph.get(edges[i][1]).add(edges[i][0]);
        }

        //Do the BFS
        while (queue.size() != 0){
            int cur = queue.poll();
            //If at destination
            if (cur == destination) return true;

            for (int i = 0; i < graph.get(cur).size(); i++) {
                if (!visited[graph.get(cur).get(i)]) {
                    visited[graph.get(cur).get(i)] = true;
                    queue.push(graph.get(cur).get(i));
                }
            }
        }
        //When the destination isn't found

        return false;
    }
}
