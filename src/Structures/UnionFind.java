package Structures;

public class UnionFind {

    private int[] UFArray;
    private int[] size;

    public UnionFind (int N) {
        UFArray = new int[N];
        size = new int[N];
        for (int i = 0; i < N; i++) {
            UFArray[i] = i;
            size[i] = 1;
        }
    }

    public void union (int p, int q) {
        if (connected(p,q)) return;

        int i = root(p);
        int j = root(q);

        if (size[i] > size[j]) {
            UFArray[j] = i;
            size[i] += size[j];
        } else {
            UFArray[i] = j;
            size[j] += size[i];
        }
    }

    public boolean connected (int p, int q) {
        return root(p) == root(q);
    }

    public int getArrayIndex (int i) {
        return UFArray[i];
    }

    private int root (int p) {
        if (p == UFArray[p]) {
            return p;
        } else {
            int k = root(UFArray[p]);
            return k;
        }
    }
}
