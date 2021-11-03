package Structures;

import java.util.LinkedList;
import java.util.Stack;

public class Digraph {
    private final int V;
    private LinkedList<Integer>[] adj;

    public Digraph (int V) {
        this.V = V;
        adj = (LinkedList<Integer> []) new LinkedList[V];
        for (int i = 0; i < V; i++) {
            adj[i] = new LinkedList<>();
        }
    }

    public void addEdge(int v, int w) {
        adj[v].add(w);
    }

    public int V() {
        return V;
    }

    public Iterable<Integer> adj(int v) {
        return adj[v];
    }

    public Digraph reverse() {
        Digraph reverse = new Digraph(V);
        for (int v = 0; v < V; v++) {
            for (int w : adj(v))
                reverse.addEdge(w,v);
        }
        return reverse;
    }

    public void print() {
        for (int v = 0; v < V; v++) {
            for (int w : adj[v])
                System.out.print(v + "-" + w + "; ");
        }
        System.out.println();
    }

    public int degree(int v) {
        int degree = 0;
        for (int w : adj[v])
            degree++;
        return degree;
    }

    public int E() {
        int edges = 0;
        for (int i = 0; i < V; i++) {
            edges += adj[i].size();
        }
        return edges;
    }

    public static class DFSPath {
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

    public static class TopologicalSort {
        private boolean[] marked;
        private Stack<Integer> reversePost;

        public TopologicalSort(Digraph digraph) {
            marked = new boolean[digraph.V()];
            reversePost = new Stack<>();

            for (int i = 0; i < digraph.V(); i++) {
                if (!marked[i]) dfs(digraph, i);
            }
        }

        private void dfs(Digraph digraph, int v) {
            marked[v] = true;
            for (int w : digraph.adj(v)) {
                if (!marked[w]) dfs(digraph,w);
            }
            reversePost.push(v);
        }

        public Iterable<Integer> reversePost(){
            return reversePost;
        }
    }

    public static class KosarajuSharirCC {
        private boolean[] marked;
        private int[] id;
        private int count;

        public KosarajuSharirCC(Digraph G) {
            marked = new boolean[G.V()];
            id = new int[G.V()];
            count = 1;
            TopologicalSort ts = new TopologicalSort(G.reverse());
            while (!ts.reversePost.empty()) {
                int v = ts.reversePost.pop();
                if (!marked[v]) {
                    dfs(G, v);
                    count++;
                }
            }
        }

        private void dfs (Digraph G, int v) {
            marked[v] = true;
            id[v] = count;
            for (int w : G.adj(v))
                if (!marked[w])
                    dfs(G, w);
        }

        public int[] getId() { return id; }

        public boolean stronglyConnected (int v, int w) {
            return id[v] == id[w];
        }
    }
}
