package Structures;

import java.util.ArrayList;
import java.util.LinkedList;

public class EdgeWeightedGraph {
    private final int V;
    private final LinkedList<Edge>[] adj;
    private ArrayList<Edge> edges;

    public EdgeWeightedGraph(int V) {
        this.V = V;
        adj = (LinkedList<Edge> []) new LinkedList[V];
        for (int i = 0; i < V; i++) {
            adj[i] = new LinkedList<>();
        }
    }

    public void addEdge(Edge edge) {
        int v = edge.either(); int w = edge.other(v);
        adj[v].add(edge);
        adj[w].add(edge);
        edges.add(edge);
    }

    public Iterable<Edge> adj (int v) {
        return adj[v];
    }

    public Iterable<Edge> edges () {
        return edges;
    }

    public int V() { return V; }

    public int E() {
        int degree = 0;
        for (int v = 0; v < V; v++) {
            degree += adj[v].size();
        }
        return degree / 2;
    }

    public String toString() {
        return super.toString();
    }

    public class KruskalMST {
        private LinkedList<Edge> mst = new LinkedList<>();

        public KruskalMST(EdgeWeightedGraph G) {
            MinPQ<Edge> pq = new MinPQ<>();
            for (Edge e : G.edges)
                pq.insert(e);
            UnionFind uf = new UnionFind(G.V());
            while(!pq.isEmpty() && mst.size() < G.V() - 1) {
                Edge e = pq.delMin();
                int v = e.either();
                int w = e.other(v);
                if (!uf.connected(v,w)) {
                    uf.union(v,w);
                    mst.add(e);
                }
            }
        }

        public LinkedList<Edge> getMst() { return mst; }

    }

    public class PrimMST {

    }

}
