import java.util.*;

class Solution {
    public static void main(String[] args) {
        int[][] graph = {{1,2},{3},{3},{}};
        System.out.println(allPaths(graph));
    }

    public static List<List<Integer>> allPaths(int[][] graph){
        if(graph.length < 2 || graph.length > 15) return null;
        //List of Paths
        List<List<Integer>> results = new ArrayList<>();
        //List for current path from start to end
        List<Integer> curPath = new ArrayList<>();
        Boolean [] visited = new Boolean[graph.length];
        //Do DFS for every possible path
        //Add starting node to curPath
        curPath.add(0);
        //Start DFS recursion from Node 0
        pathsRecur(graph, 0, results, curPath, visited);
        return results;
    }

    public static void pathsRecur(int[][] graph, int curNode, List<List<Integer>> results, List<Integer> curPath, Boolean [] visited){
        //If the end is reached, add path to list of results
        if (curNode == graph.length-1) {
            results.add(curPath);
            return;
        }
        visited[curNode] = true;
        for(int i = 0; i < graph[curNode].length; i++) {
            if(!visited[i]) {
                //Add Current Node
                curPath.add(i);
                pathsRecur(graph, i, results, curPath, visited);
                //Remove Current Node
                curPath.remove(i);
            }
        }
    }
}
