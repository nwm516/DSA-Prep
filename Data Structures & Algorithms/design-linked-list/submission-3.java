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
Doubly Linked List (Optimal)

This optimizes traversal time, choosing the shorter path.
First half of list? Traverse from head, and vice versa.
"getPrev(index)" returns predecesspr node using this bidirectional approach,
cutting worse-case traversal roughly in half on average.

Time: 
- O(1) for initialization
- O(1) for addAtHead()
- O(n) for get(), addAtTail(), addAtIndex(), deleteAtIndex()

Space:
- O(n)
*/

class ListNode {
    int val;
    ListNode prev;
    ListNode next;

    ListNode(int val){
        this(val, null, null);
    }

    ListNode(int val, ListNode next, ListNode prev) {
        this.val = val;
        this.next = next;
        this.prev = prev;
    }
}

class MyLinkedList {
    ListNode head;
    ListNode tail;
    int size;

    public MyLinkedList() {
        head = new ListNode(0);
        tail = new ListNode(0);
        head.next = tail;
        tail.prev = head;
        size = 0;
    }
    
    /* 
   If "index <= size / 2", traverse forward from head for "index" steps.
   Otherwise, traverse backward from tail for "size - index + 1" steps.
   Return predecessor node.
    */
    private ListNode getPrev(int index) {
        if (index <= size / 2) {
            ListNode cur = head;
            for (int i = 0; i < index; i++) {
                cur = cur.next;
            }
            return cur;
        } else {
            ListNode cur = tail;
            for (int i = 0; i < size - index + 1; i++) {
                cur = cur.prev;
            }
            return cur;
        }
    }


    public int get(int index) {
        if (index >= size) return -1;
        return getPrev(index).next.val;
    }
    
    public void addAtHead(int val) {
        addAtIndex(0, val);
    }
    
    public void addAtTail(int val) {
        addAtIndex(size, val);
    }
    
    public void addAtIndex(int index, int val) {
       if (index > size) return;
       ListNode node = new ListNode(val);
       ListNode prev = getPrev(index);
       ListNode next = prev.next;
       prev.next = node;
       node.prev = prev;
       node.next = next;
       next.prev = node;
       size++;
    }
    
    public void deleteAtIndex(int index) {
       if (index >= size) return;
       ListNode prev = getPrev(index);
       ListNode cur = prev.next;
       ListNode next = cur.next;
       prev.next = next;
       next.prev = prev;
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