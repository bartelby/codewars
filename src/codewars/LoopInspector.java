package codewars;

/**
 * Created by bartelby on 2/18/17.
 */
/*
    https://www.codewars.com/kata/52a89c2ea8ddc5547a000863/train/java

    You are given a node that is the beginning of a linked list. This list always contains a tail and a loop.

    Your objective is to determine the length of the loop.

    For example in the following picture the tail's size is 3 and the loop size is 11.
    Image and video hosting by TinyPic

    // Use the `getNext()` method to get the following node.

    node.getNext()

 */
public class LoopInspector {

    public int loopSize(Node node) {
        Node loopNode = findLoopPoint(node);
        int loopSize = findLoopSize(loopNode);
        return loopSize;
    }

    private Node findLoopPoint(Node start) {
        Node slow;
        Node fast;
        slow = fast = start;
        while(true) {
            if(slow.getNext() == null ||
                    fast.getNext() == null ||
                    fast.getNext().getNext() == null) return null;
            slow = slow.getNext();
            fast = fast.getNext().getNext();
            if(slow == fast) return slow;
        }
    }

    private int findLoopSize(Node node) {
        int size = 0;
        Node first = node;
        while(first != node.getNext()) {
            node = node.getNext();
            size++;
        }
        return size;
    }
}

class Node {
    private Node next = null;


    public Node getNext() {
        return next;
    }

    private void setNext(Node node) {
        this.next = node;
    }

    public static Node createChain(int tail, int loop) {
        Node head = new Node();
        Node first = head;
        for (int i = 0; i < tail; i++) {
            head.setNext(new Node());
            head = head.getNext();
        }
        Node branch = head;
        for (int i = 0; i < loop; i++) {
            head.setNext(new Node());
            head = head.getNext();
        }
        head.setNext(branch);

        return first;
    }



}