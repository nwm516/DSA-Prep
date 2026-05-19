/*
Design Linked List

Design your implementation of the linked list. You can choose to use a singly or doubly linked list.
A node in a singly linked list should have two attributes: val and next.val is the value of the current node, and next is a pointer/reference to the next node.
If you want to use the doubly linked list, you will need one more attribute prev to indicate the previous node in the linked list. Assume all nodes in the linked list are 0-indexed.

Implement the MyLinkedList class:

    MyLinkedList() Initializes the MyLinkedList object.
    int get(int index) Get the value of the index-th node in the linked list. If the index is invalid, return -1.
    void addAtHead(int val) Add a node of value val before the first element of the linked list. After the insertion, the new node will be the first node of the linked list.
    void addAtTail(int val) Append a node of value val as the last element of the linked list.
    void addAtIndex(int index, int val) Add a node of value val before the index-th node in the linked list. If index equals the length of the linked list, the node will be appended to the end of the linked list. If index is greater than the length, the node will not be inserted.
    void deleteAtIndex(int index) Delete the index-th node in the linked list, if the index is valid.


Example 1:

Input:
["MyLinkedList", "addAtHead", "addAtTail", "addAtIndex", "get", "deleteAtIndex", "get"]
[[], [1], [3], [1, 2], [1], [1], [1]]
Output:
[null, null, null, null, 2, null, 3]

Explanation:
MyLinkedList myLinkedList = new MyLinkedList();
myLinkedList.addAtHead(1);
myLinkedList.addAtTail(3);
myLinkedList.addAtIndex(1, 2);    // linked list becomes 1->2->3
myLinkedList.get(1);              // return 2
myLinkedList.deleteAtIndex(1);    // now the linked list is 1->3
myLinkedList.get(1);              // return 3


Constraints:

    0 <= index, val <= 1000
    Please do not use the built-in LinkedList library.
    At most 2000 calls will be made to get, addAtHead, addAtTail, addAtIndex and deleteAtIndex.
*/

/*
Singly Linked List (Optimal Solution)

The introduction of a helper function "getPrev(index)"
that returns the node immediately before the target index.
This reduces code duplication since both insertion and deletion require
access to the predecessor node.

The "addAtHead()" and "addAtTail()" operations now simply call "addAtIndex()",
making the implementation cleaner and easier to maintain.

Time: 
- O(1) for initialization
- O(1) for addAtHead()
- O(n) for get(), addAtTail(), addAtIndex(), deleteAtIndex()

Space:
- O(n)
*/

class ListNode {
    int val;
    ListNode next;
    ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }
    ListNode(int val){
        this(val, null);
    }
}

class MyLinkedList {
    ListNode head;
    int size;

    public MyLinkedList() {
        head = new ListNode(0, null);
        size = 0;
    }

    // Starts from dummy head, traverse "index" steps and returns that node
    private ListNode getPrev(int index) {
        ListNode cur = head;
        for (int i = 0; i < index; i++) {
            cur = cur.next;
        }
        return cur;
    }
    
    // Out of bounds? Returns -1.
    // Call "getPrev(index)" and returns value of its next node.
    public int get(int index) {
        if (index >= size) {
            return -1;
        }
        return getPrev(index).next.val;
    }
    
    public void addAtHead(int val) {
        addAtIndex(0, val);
    }
    
    public void addAtTail(int val) {
        addAtIndex(size, val);
    }
    
    /* Index greater than size? Return.
     Get predecessor w/ "getPrev(index)", create a new node pointing to
     predecessor's next, and update predecessor's next to the new node.
     Increment size.
    */
    public void addAtIndex(int index, int val) {
        if (index > size) {
            return;
        }
        ListNode prev = getPrev(index);
        ListNode node = new ListNode(val, prev.next);
        prev.next = node;
        size++;
    }
    
    /* Out of bounds? Return.
    Get predecessor using "getPrev(index)" and skip over target node. 
    Decrement size.
    */
    public void deleteAtIndex(int index) {
        if (index >= size) {
            return;
        }
        ListNode prev = getPrev(index);
        prev.next = prev.next.next;
        size--;
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