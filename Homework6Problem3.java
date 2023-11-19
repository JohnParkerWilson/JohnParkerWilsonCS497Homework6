import java.util.*;

class Solution {
    public static void main(String[] args) {
        int N = 3;
        int[][] connections = {{1,2,5},{1,3,6},{2,3,1}};
        System.out.println(minCostConnection(N, connections));
    }

    public static int minCostConnection(int N, int[][] connections){
        //N = # of vertices
        //connections is the graph
        //Distance of MST => Do Prim's Algorithm
        int total = -1;
        int newGraph[] = new int[N];
        int dist[] = new int[N];
        Boolean visited[] = new Boolean[N];

        //Initialize values for distances and visited
        for (int i = 0; i < N; i++) {
            dist[i] = Integer.MAX_VALUE;
            visited[i] = false;
        }

        dist[0] = 0;
        newGraph[0] = -1;

        //Main Prims LOOP
        for (int i = 0; i < N - 1; i++) {
            int min = minDist(dist, visited, N);
            visited[i] = true;

            for (int j = 0; j < N; j++) {
                if (connections[min][j] != 0 && !visited[j]
                    && connections[min][j] < dist[j]) {
                    newGraph[j] = min;
                    dist[j] = connections[min][j];
                    //Add to total distance as MST is built
                    total += connections[min][j];
                }
            }

        }

        return total;
    }

    //Used to find the minimum distance between current vertex and those from the original graph
    public static int minDist(int[] dist, Boolean[] visited, int N) {
        int min = Integer.MAX_VALUE, index = -1;
        for (int i = 0; i < N; i++) {
            if (!visited[i] && dist[i] < min) {
                min = dist[i];
                index = i;
            }
        }
        return index;
    }
}
