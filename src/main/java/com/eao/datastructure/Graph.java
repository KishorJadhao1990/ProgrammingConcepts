package com.eao.datastructure;

import java.util.*;
import java.util.LinkedList;
import java.util.Queue;

/*
[ 0 ]->[1, 2]

[ 1 ]->[0, 2, 3]

[ 2 ]->[0, 1, 4]

[ 3 ]->[1, 4]

[ 4 ]->[2, 3]
* */
public class Graph {

    private GraphNode []graphNodes;

    public static void main(String[] args) {
        Graph graph = new Graph(5);
        graph.addEdge(0, 1);
        graph.addEdge(0, 2);
        graph.addEdge(1, 0);
        graph.addEdge(1, 2);
        graph.addEdge(1, 3);
        graph.addEdge(2, 0);
        graph.addEdge(2, 1);
        graph.addEdge(2, 4);
        graph.addEdge(3, 1);
        graph.addEdge(3, 4);
        graph.addEdge(4, 2);
        graph.addEdge(4, 3);
        graph.printGraph();

        List<Integer> bfsPath = graph.findBfs(0);
        System.out.println("BfsPath: "+ bfsPath);
    }

    private List<Integer> findBfs(int node) {
        List<Integer> visited = new ArrayList<>();
        Queue<Integer> queue = new LinkedList<>();
        queue.add(node);
        while(!queue.isEmpty()) {
            GraphNode graphNode = get(queue.remove());
            visited.add(graphNode.getValue());

           // graphNode.getAdj().stream().filter(e-> !visited.contains(e)).
        }
        return visited;
    }

    public Graph () {
        graphNodes = new GraphNode[10];
        for (int i = 0; i < 10; i++) {
            graphNodes[i] = new GraphNode(i, new LinkedList<>());
        }
    }

    public Graph (int node) {
        graphNodes = new GraphNode[node];
        for (int i = 0; i < node; i++) {
            graphNodes[i] = new GraphNode(i, new LinkedList<>());
        }
    }

    public void addEdge(int node, int edge) {
        int index = 0;
        while(index < graphNodes.length) {
            if (graphNodes[index].getValue() == node) {
                graphNodes[index].getAdj().add(edge);
                break;
            }
            index++;
        }
    }

    public GraphNode get(int node) {
        return Arrays.stream(graphNodes)
                .filter(e -> e.getValue() == node)
                .findFirst().orElse(null);
    }

    public void printGraph() {
        for (int i = 0; i < graphNodes.length; i++) {
            System.out.println(graphNodes[i]);
        }
    }

    public static ArrayList<Integer> bfsOfGraph(int V, ArrayList<Boolean> adj[])
    {
        ArrayList<Boolean> vis = new ArrayList<>(V);
        ArrayList<Integer> bfs_traversal = new ArrayList<>();
        for (int i = 0; i < V; ++i) {
            // To check if already visited
            if (vis.get(i) == false) {
                Queue<Integer> q = new LinkedList<>();
                vis.set(i, true);
                q.add(i);

                // BFS starting from ith node
                while (!q.isEmpty()) {
                    int g_node = q.peek();
                    q.poll();
                    bfs_traversal.add(g_node);
                    for (int it = 0;
                         it < adj[g_node].toArray().length;
                         it++) {
                        if (adj[g_node].get(it) == true) {
                            if (vis.get(it) == false) {
                                vis.set(it, true);
                                q.add(it);
                            }
                        }
                    }
                }
            }
        }
        return bfs_traversal;
    }
}

class GraphNode {
    private int value;
    private List<Integer> adj;

    public GraphNode() {
        this.value = 0;
        this.adj = new LinkedList<>();
    }

    public GraphNode(int value, List<Integer> adj) {
        this.value = value;
        this.adj = adj;
    }

    public int getValue() {
        return value;
    }

    public List<Integer> getAdj() {
        return adj;
    }

    public void setAdj(List<Integer> adj) {
        this.adj = adj;
    }

    public void setValue(int value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return "[ " + value + " ]"+ "->" + adj +"\n";
    }
}
