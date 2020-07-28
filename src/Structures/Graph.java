package Structures;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class Graph {

    private final int V;
    private LinkedList<Integer>[] adj;

    @SuppressWarnings("unchecked")
    public Graph(int V) {
        this.V = V;
        adj = (LinkedList<Integer> []) new LinkedList[V];
        for (int v = 0; v < V; v++) {
            adj[v] = new LinkedList<Integer>();
        }
    }

    void addEdge(int v, int w) {
        adj[v].add(w);
        adj[w].add(v);
    }

    /**
     * @param Graph object , int vertex
     * @return degree of that vertex
     *
     * static method
     * */
    public static int degree(Graph G, int v) {
        int degree = 0;
        for (int w : G.adj(v))
            degree++;
        return degree;
    }

    public Iterable<Integer> adj(int v) {  return adj[v];    }

    /**
     * @param Graph object
     * @return maximum degree vertex of Graph object
     *
     * static method
     * */
    public static int maxDegree(Graph G) {
        int max = 0;
        for (int v = 0; v < G.V(); v++) {
            if (degree(G, v) > max)
                max = degree(G,v);
        }
        return max;
    }

    public static double averageDegree(Graph G) {
        return 2.0 * G.E() / G.V();
    }

    /**
     * @param Graph G
     * @return int selfLoops
     *
     *  static methods
     */
    public static int numberOfSelfLoops(Graph G) {
        int count = 0;
        for (int v = 0; v < G.V(); v++) {
            for (int w : G.adj(v))
                if (v == w)
                    count++;
        }
        return count;
    }

    public int V() {
        return V;
    }

    public int E() {
        int degree = 0;
        for (int v = 0; v < V; v++) {
            degree += adj[v].size();
        }
        return degree / 2;
    }

    public void print() {
        for (int v = 0; v < V; v++) {
            for (int  w : adj[v])
                System.out.print(v + "-" + w + "; ");
        }
        System.out.println();
    }

    //public String toString() {

    //}

    public class DFSPath {
        private boolean[] marked;
        private int[] edgeTo;
        private int s;

        public DFSPath(Graph graph, int v) {
            marked = new boolean[graph.V()];
            edgeTo = new int[graph.V()];
            s = v;

            dfs(graph, v);
        }

        private void dfs(Graph graph, int v) {
            marked[v] = true;
            for (int w : graph.adj(v)) {
                if (!marked[w]) {
                    dfs(graph,w);
                    edgeTo[w] = v;
                }
            }
        }

        public boolean hasPathTo(int w) { return marked[w]; }

        public Iterable<Integer> path(int w) {
            if (!hasPathTo(w)) return null;
            Stack<Integer> stack = new Stack<>();
            for (int i = w; i != s; i = edgeTo[i]) {
                stack.push(i);
            }
            stack.push(s);
            return stack;
        }
    }

    public class BFSPath {
        private boolean[] marked;
        private int[] edgeTo;
        private int[] distanceTo;
        private int s;

        public BFSPath(Graph graph, int v) {
            s = v;
            marked = new boolean[graph.V()];
            distanceTo = new int[graph.V()];
            edgeTo = new int[graph.V()];

            bfs(graph, v);
        }

        private void bfs(Graph graph, int s) {
            Queue<Integer> queue = new LinkedList<>();
            marked[s] = true;
            distanceTo[s] = 0;
            queue.add(s);

            while (!queue.isEmpty()) {
                //do it with Queue, then add others until queue is empty
                // then you have got short distances from original vertex to any other adjacent one
            }
        }
    }

    public class CC {
        private boolean[] marked;
        private int[] id;
        private int count;

        public CC (Graph graph) {
            marked = new boolean[graph.V()];
            id = new int[graph.V()];

            for (int v = 0; v < graph.V(); v++) {
                if (!marked[v]) {
                    dfs(graph,v);
                    count++;
                }
            }
        }

        public int count () { return count + 1; }

        public int id(int v) { return id[v]; }

        private void dfs(Graph graph, int v) {
            marked[v] = true;
            id[v] = count;
            for (int w : graph.adj(v)) {
                if (!marked[w]) {
                    dfs(graph,w);
                }
            }
        }
    }

}