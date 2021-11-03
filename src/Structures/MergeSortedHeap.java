package Structures;

import java.util.ArrayList;

public class MergeSortedHeap {
    private ArrayList<Integer> sortedArray;
    private HeapNode[] heap;
    private int[][] arr;

    private class HeapNode {
        int nextIndex;
        int arrIndex;
        int E;
        public HeapNode(int E, int arrIndex, int nextIndex){
            this.E = E;
            this.arrIndex = arrIndex;
            this.nextIndex = nextIndex;
        }
    }

    public MergeSortedHeap(int[][] arr) {
        this.arr = arr;
        sortedArray = new ArrayList<>();
        heap = new HeapNode[arr.length];

        for (int i = 0; i < arr.length; i++) {
            heap[i] = new HeapNode(arr[i][0], i, 1);
        }
        heapify();
    }

    public void merge() {
        while (heap[0].E != Integer.MAX_VALUE) {
            HeapNode min = new HeapNode(heap[0].E, heap[0].arrIndex, heap[0].nextIndex);
            swap(0, heap.length - 1);
            if (min.nextIndex < arr[min.arrIndex].length)
                heap[heap.length - 1] = new HeapNode(arr[min.arrIndex][min.nextIndex], min.arrIndex, min.nextIndex + 1);
            else
                heap[heap.length - 1].E = Integer.MAX_VALUE;
            sink(0);
            sortedArray.add(min.E);
        }
    }

    public String toString() {
        return sortedArray.toString();
    }

    private void heapify() {
        int half = (heap.length - 2) / 2;
        for (int i = half ; i > -1; i--) {
            sink(i);
        }
    }

    private void swap(int i, int j) {
        HeapNode temp = heap[i];
        heap[i] = heap[j];
        heap[j] = temp;
    }

    private void sink(int i) {
        int half = (heap.length - 2) / 2;
        int child = (heap[leftChild(i)].E <= heap[rightChild(i)].E) ? leftChild(i) : rightChild(i);
        while (i <= half && heap[i].E > heap[child].E) {
            swap(i, child);
            i = child;
        }
    }

    private int leftChild(int i) { return 2*i + 1; }

    private int rightChild(int i) { return 2*i + 2; }

    public static void main(String[] args) {
        int[][] array = {{1,5,7,9}, {3,6,10,14}, {2,8,11,12}};
        MergeSortedHeap sortedHeap = new MergeSortedHeap(array);
        sortedHeap.merge();
        System.out.println(sortedHeap.toString());
    }

}
