package LinkedList;

public class IntersectionOfLinkedList {
    static LinkedList findIntersection(LinkedList list1, LinkedList list2 ) {
        if (list1.count() == 0 || list2.count() == 0) {
            System.out.println("No intersection found");
            return null;
        }
        LinkedList intersectList = new LinkedList();
        LinkedList.Node list1_ptr = list1.getHead();
        LinkedList.Node list2_ptr = list2.getHead();

        // idea is to use two pointers. if data is equal, push the node to the intersection list. if node of list 1 is less than list2, increment the list 1 pointer
        // else list2 pointer.

        while (list1_ptr != null && list2_ptr != null) {
            if (list1_ptr.data == list2_ptr.data) {
                intersectList.append(list1_ptr.data);
                list1_ptr = list1_ptr.next;
                list2_ptr = list2_ptr.next;
            } else if (list1_ptr.data < list2_ptr.data) {
                list1_ptr = list1_ptr.next;
            } else {
                list2_ptr = list2_ptr.next;
            }
        }
        return intersectList;
    }
    public static void main(String[] args) {
        LinkedList list1 = new LinkedList();
        list1.pushAtFront(6);
        list1.pushAtFront(4);
        list1.pushAtFront(3);
        list1.pushAtFront(2);
        list1.pushAtFront(1);

        LinkedList list2 = new LinkedList();
        list2.pushAtFront(8);
        list2.pushAtFront(6);
        list2.pushAtFront(4);
        list2.pushAtFront(2);

        LinkedList intersectList = findIntersection(list1, list2);
        intersectList.printList();
    }
}
