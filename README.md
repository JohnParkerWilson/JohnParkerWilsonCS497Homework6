# JohnParkerWilsonCS497Homework6

Problem 1:
For this problem, since we are simply finding a path from a source to a destination on a graph, I used a breadth first search algorithm in order to find it. For a breadth first search, the time complexity is O(V+E) with a space complexity of O(V) with V being the vertices of the graph and E being the edges.

Problem 2:
In order to find the longest cycle of the graph, I needed to use a depth first search in order to find the various cycles of the paths while keeping track of the lengths of those paths. For most search algorithms involving graphs, the time complexity is O(V+E) and the space complexity is O(V), V being the vertices of the graph and E being the edges.

Problem 3:
For this problem, what making a city with the minimum cost is in essence is building a minimum spanning tree from the graph, so I used Prim's Algorithm in order to get a city with a minimum cost while keeping track of that cost for the return value. The time complexity and space complexity of Prim's Algorithm is O(V^2) and O(V) respectively.

Problem 4:
Similarly to problem 2, I used a DFS in order to find the various paths from start to end, keeping track of each path and adding those paths to a List of total paths. Since we are using a graph, the time complexity is O(V+E) and the space complexity is O(V).
