package Heap;

public class MaxHeap {
    private int size;
    private int maxCapacity;
    private int[] heap;

    MaxHeap(int maxCapacity) {
        this.maxCapacity = maxCapacity;
        heap = new int[maxCapacity +1 ];
        heap[0] = Integer.MAX_VALUE;
    }

    private int parent(int pos) {
        return (pos/2);
    }

    private int leftChild(int pos) {
        return (2 * pos);
    }
    private int rightChild(int pos) {
        return ((2 * pos) + 1);
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
        this.heap[++size] = value;
        int current = size;
        while(heap[current] > heap[parent(current)] ){
            swap(current, parent(current));
            current = parent(current);
        }
    }

    public void print() {
        for (int i=1; i<=size/2; i++) {
            System.out.println(size+ "Parent :" + heap[i] + " Left Child: " + heap[2*i] + " Right Child: " + heap[2*i + 1]);
            System.out.println();
        }
    }

    private void maxHeapify(int pos) {
        if(leafNode(pos) ) {
            return;
        }
        System.out.println(pos);
        while (heap[pos] < heap[leftChild(pos)] ||
                heap[pos] < heap[rightChild(pos)]) {
            if(heap[leftChild(pos)] > heap[rightChild(pos)]) {
                swap(pos, leftChild(pos));
                maxHeapify(leftChild(pos));
            } else {
                swap(pos, rightChild(pos));
                maxHeapify(rightChild(pos));
            }
        }
    }
    public int extractMax() {
        int maxValue = this.heap[1];
        heap[1] = heap[size--];
        maxHeapify(1);
        return maxValue;

    }

    public static void main(String[] args) {

        MaxHeap maxHeap = new MaxHeap(15);
        maxHeap.insert(5);
        maxHeap.insert(3);
        maxHeap.insert(17);
        maxHeap.insert(10);
        maxHeap.insert(84);
        maxHeap.insert(19);
        maxHeap.insert(6);
        maxHeap.insert(22);
        maxHeap.insert(9);

        maxHeap.insert(1);
        maxHeap.insert(2);

        maxHeap.print();
        System.out.println("The max val is " + maxHeap.extractMax());

        maxHeap.print();
    }
}
