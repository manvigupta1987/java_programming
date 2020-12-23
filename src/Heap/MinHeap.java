package Heap;

public class MinHeap {
    private int size;
    private int maxCapacity;
    private int[] heap;

    MinHeap(int maxCapacity) {
        this.maxCapacity = maxCapacity;
        heap = new int[maxCapacity];
//        heap[0] = Integer.MIN_VALUE;
    }

    private int parent(int pos) {
        return ((pos-1)/2);
    }

    private int leftChild(int pos) {
        return ((2 * pos) + 1);
    }
    private int rightChild(int pos) {
        return ((2 * pos) + 2);
    }
    private boolean leafNode(int pos) {
        return(pos >= (this.size /2) && pos <= this.size);
    }
    private void swap(int pos, int parentPos) {
        int temp = heap[pos];
        heap[pos] = heap[parentPos];
        heap[parentPos] = temp;
    }

    public void insert(int value) {
        if (size >= maxCapacity) {
            return;
        }
        int current = size;
        this.heap[size++] = value;
        while(heap[current] < heap[parent(current)] ){
            swap(current, parent(current));
            current = parent(current);
        }
    }

    public void print() {
        for (int i=0; i<=(size/2)-1; i++) {
            System.out.println(size + "Parent :" + heap[i] + " Left Child: " + heap[(2*i)+1] + " Right Child: " + heap[(2*i) + 2]);
            System.out.println();
        }
    }

    private void minHeapify(int pos) {
        if(leafNode(pos)) {
            return;
        }
        while (heap[pos] > heap[leftChild(pos)] ||
                heap[pos] > heap[rightChild(pos)]) {
            if(heap[leftChild(pos)] < heap[rightChild(pos)]) {
                swap(pos, leftChild(pos));
                minHeapify(leftChild(pos));
            } else {
                swap(pos, rightChild(pos));
                minHeapify(rightChild(pos));
            }
        }
    }

    public int extractMin() {
        int maxValue = this.heap[0];
        heap[0] = heap[size-1];
        size--;
        minHeapify(0);
        return maxValue;
    }

    public static void main(String[] args) {
        MinHeap minHeap = new MinHeap(15);
        minHeap.insert(5);
        minHeap.insert(3);
        minHeap.insert(17);
        minHeap.insert(10);
        minHeap.insert(84);
        minHeap.insert(19);
        minHeap.insert(6);
        minHeap.insert(22);
        minHeap.insert(9);
        minHeap.insert(1);
        minHeap.insert(2);

        minHeap.print();
        System.out.println("The min val is " + minHeap.extractMin());

        minHeap.print();
    }

}
