/*
Stepping back in after a brief bit of busyness. UCD Prepwork.
*/

class ListNode {
    int val;
    ListNode next;
    ListNode(int val) {
        this.val = val;
        this.next = null;
    }
}

public class MyLinkedList {
    private ListNode head;
    private int size;
    MyLinkedList() {
        head = new ListNode(0);
        size = 0;
    }


    public int get(int index) {
        if (index >= size) return -1;   // Exceeds bounds of what is present
        ListNode cur = head.next;       // Indicates our head node as starting point
        for (int i = 0; i < index; i++) {
            cur = cur.next;
        }
        return cur.val;             // Returns value even if index indicated is 0
    }
    
    public void addAtHead(int val) {
        ListNode node = new ListNode(val);  // Initializing new node with param as val
        node.next = head.next;       // Priming original first node in sequence as the next node by assigning our new node's next method to it
        head.next = node;           // Inserting node into the sequence AFTER dummy
        size++;                     // Increase size
    }
    
    public void addAtTail(int val) {
        ListNode node = new ListNode(val);  // Initialize new node
        ListNode cur = head;    // Indicator for where we are working from while moving down the line of nodes
        while (cur.next != null){
            cur = cur.next;     // While we still have another node after where we currently are, proceed to move our current pointer to the next node
        }
        cur.next = node;
        size++;     // Increase size
    }
    
    public void addAtIndex(int index, int val) {
        if (index > size) return;
        ListNode cur = head;
        for (int i = 0; i < index; i++) {       // Moving sequentially through list of nodes to insert node at index
            cur = cur.next;
        }
        ListNode node = new ListNode(val);
        node.next = cur.next;       // Indicating what will be after new node
        cur.next = node;
        size++;
    }
    
    public void deleteAtIndex(int index) {
        if (index >= size) return;
        ListNode cur = head;
        for (int i = 0; i < index; i++) {
            cur = cur.next;
        }
        cur.next = cur.next.next;   // Effectively setting next to the node after next, cutting out the node at the index
        size--; // Reduce size of node list
    }
}

/**
 * Your MyLinkedList object will be instantiated and called as such:
 * MyLinkedList obj = new MyLinkedList();
 * int param_1 = obj.get(index);
 * obj.addAtHead(val);
 * obj.addAtTail(val);
 * obj.addAtIndex(index,val);
 * obj.deleteAtIndex(index);
 */