import java.util.Iterator;
import java.util.ListIterator;
import java.util.NoSuchElementException;

// -------------------------------------------------------------------------
/**
 * This class contains the methods of Doubly Linked List.
 *
 * @author  Brian Lynch
 * @version 09/10/18 11:13:22
 */


/**
 * Class DoublyLinkedList: implements a *generic* Doubly Linked List.
 * @param <T> This is a type parameter. T is used as a class name in the
 * definition of this class.
 *
 * When creating a new DoublyLinkedList, T should be instantiated with an
 * actual class name that extends the class Comparable.
 * Such classes include String and Integer.
 *
 * For example to create a new DoublyLinkedList class containing String data:
 *    DoublyLinkedList<String> myStringList = new DoublyLinkedList<String>();
 *
 * The class offers a toString() method which returns a comma-separated sting of
 * all elements in the data structure.
 *
 * This is a bare minimum class you would need to completely implement.
 * You can add additional methods to support your code. Each method will need
 * to be tested by your jUnit tests -- for simplicity in jUnit testing
 * introduce only public methods.
 */
class DoublyLinkedList<T extends Comparable<T>> {

    /**
     * private class DLLNode: implements a *generic* Doubly Linked List node.
     */
    private class DLLNode {
        public final T data; // this field should never be updated. It gets its
        // value once from the constructor DLLNode.
        public DLLNode next;
        public DLLNode prev;

        /**
         * Constructor
         * @param theData : data of type T, to be stored in the node
         * @param prevNode : the previous Node in the Doubly Linked List
         * @param nextNode : the next Node in the Doubly Linked List
         * @return DLLNode
         */
        public DLLNode(T theData, DLLNode prevNode, DLLNode nextNode) {
            data = theData;
            prev = prevNode;
            next = nextNode;
        }
    }

    // Fields head and tail point to the first and last nodes of the list.
    private DLLNode head, tail;
    private int size = 0;

    /**
     * Constructor of an empty DLL
     * @return DoublyLinkedList
     */
    public DoublyLinkedList() {
        head = null;
        tail = null;
    }

    /**
     * Tests if the doubly linked list is empty
     * @return true if list is empty, and false otherwise
     *
     * Worst-case asymptotic running time cost: TODO
     *
     * Justification:
     *  TODO
     */
    public boolean isEmpty() {
        if (head == null )
            return true;
        else
            return false;
    }

    /**
     * Inserts an element in the doubly linked list
     * @param pos : The integer location at which the new data should be
     *      inserted in the list. We assume that the first position in the list
     *      is 0 (zero). If pos is less than 0 then add to the head of the list.
     *      If pos is greater or equal to the size of the list then add the
     *      element at the end of the list.
     * @param data : The new data of class T that needs to be added to the list
     * @return none
     *
     * Worst-case asymptotic running time cost: TODO
     * theta(n-1)
     * Justification:
     *  TODO
     *  Because worst case is if it goes to the else statement, goes into get node which is a for loop.
     *  This will run a max of n-1 times because the last eleemnt it can possibly be is the second last element.
     *  Because if its the last element it would satisfy an earlier if statement
     */
    public void insertBefore(int pos, T data) {
        //TODO
        if (isEmpty()) {
            DLLNode newNode = new DLLNode(data, null, null);
            head = newNode;
            tail = newNode;
            size++;
        } else if (pos <= 0) {
            DLLNode newNode = new DLLNode(data, null, head);
            head = newNode;
            newNode.next.prev = head;
            size++;
        } else if (pos >= size) {
            DLLNode newNode = new DLLNode(data, tail, null);
            tail = newNode;
            newNode.prev.next = tail;
            size++;
        } else {
            DLLNode tmp = getNode(pos);
            DLLNode newNode = new DLLNode(data, tmp.prev, tmp);
            tmp.prev.next = newNode;
            tmp.prev = newNode;
            size++;
        }
        return;
    }

    public DLLNode getNode(int pos) {
        DLLNode node = head;
        for (int i = pos; i != 0; i--) {
            node = node.next;
        }
        return node;
    }

    /**
     * Returns the data stored at a particular position
     * @param pos : the position
     * @return the data at pos, if pos is within the bounds of the list, and null otherwise.
     *
     * Worst-case asymptotic running time cost: TODO
     *
     * Justification:
     *  TODO
     *
     */
    public T get(int pos) {
        T data = null;
        if (pos >= 0 && pos < size)
            data = getNode(pos).data;

        return data;
    }

    /**
     * Deletes the element of the list at position pos.
     * First element in the list has position 0. If pos points outside the
     * elements of the list then no modification happens to the list.
     * @param pos : the position to delete in the list.
     * @return true : on successful deletion, false : list has not been modified.
     *
     * Worst-case asymptotic running time cost: TODO
     *
     * Justification:
     *  TODO
     */
    public boolean deleteAt(int pos) {
        if (isEmpty())
            return false;
        else if(pos == 0 && size == 1) {
            head = null;
            tail=null;
            size--;
            return true;
        }
        else if (pos > 0 && pos < size - 1) {
            DLLNode node = getNode(pos);
            node.prev.next = node.next;
            node.next.prev = node.prev;
            size--;
            return true;
        } else if (pos == 0) {
            DLLNode node = getNode(pos);
            node.next.prev = null;
            head = node.next;
            size--;
            return true;
        } else if (pos == (size - 1)) {
            DLLNode node = getNode(pos);
            node.prev.next = null;
            size--;
            return true;
        }
        else
            return false;
    }

    /**
     * Reverses the list.
     * If the list contains "A", "B", "C", "D" before the method is called
     * Then it should contain "D", "C", "B", "A" after it returns.
     *
     * Worst-case asymptotic running time cost: TODO
     *
     * Justification:
     *  TODO
     */
    public void reverse() {
        //TODO
        DLLNode current = head;
        DLLNode tmp = null;
        while (current != null && !isEmpty()) {
            tmp = current.prev;
            current.prev = current.next;
            current.next = tmp;
            current = current.prev;
        }
        head = tmp.prev;
    }

    /**
     * Removes all duplicate elements from the list.
     * The method should remove the _least_number_ of elements to make all elements uniqueue.
     * If the list contains "A", "B", "C", "B", "D", "A" before the method is called
     * Then it should contain "A", "B", "C", "D" after it returns.
     * The relative order of elements in the resulting list should be the same as the starting list.
     *
     * Worst-case asymptotic running time cost: TODO
     *
     * Justification:
     *  TODO
     */
    public void makeUnique()
    {
        //TODO

        if(!isEmpty()&& size> 1) {
            DLLNode compare = this.head;
            for (int i = 0; i < size-1 && compare.next != null; i++) {
                DLLNode toCompare = compare.next;
                for (int j = i+1; j<size; j++){
                    if(compare.data == toCompare.data){
                        DLLNode previous = toCompare.prev;
                        DLLNode next = toCompare.next;
                        if(next !=null) {
                            next.prev = previous;
                            previous.next = next;
                        }
                        else
                            previous.next = null;
                        size--;
                        j--;
                    }
                    toCompare= toCompare.next;
                }
                compare = compare.next;
            }
        }
    }


    /*----------------------- STACK API
     * If only the push and pop methods are called the data structure should behave like a stack.
     */

    /**
     * This method adds an element to the data structure.
     * How exactly this will be represented in the Doubly Linked List is up to the programmer.
     * @param item : the item to push on the stack
     *
     * Worst-case asymptotic running time cost: TODO
     *
     * Justification:
     *  TODO
     */
    public void push(T item) {
        //TODO
        insertBefore(0,item);
    }

    /**
     * This method returns and removes the element that was most recently added by the push method.
     * @return the last item inserted with a push; or null when the list is empty.
     *
     * Worst-case asymptotic running time cost: TODO
     *
     * Justification:
     *  TODO
     */
    public T pop() {
        //TODO
        T value=null;
        if(size > 0)
        {
            value = get(0);
            deleteAt(0);
        }
        return value;
    }

    /*----------------------- QUEUE API
     * If only the enqueue and dequeue methods are called the data structure should behave like a FIFO queue.
     */

    /**
     * This method adds an element to the data structure.
     * How exactly this will be represented in the Doubly Linked List is up to the programmer.
     * @param item : the item to be enqueued to the stack
     *
     * Worst-case asymptotic running time cost: TODO
     *
     * Justification:
     *  TODO
     */
    public void enqueue(T item) {
        //TODO
        push(item);
    }

    /**
     * This method returns and removes the element that was least recently added by the enqueue method.
     * @return the earliest item inserted with an equeue; or null when the list is empty.
     *
     * Worst-case asymptotic running time cost: TODO
     *
     * Justification:
     *  TODO
     */
    public T dequeue() {
        //TODO
        T value=null;
        if(size > 0)
        {
            value = get(size -1);
            deleteAt(size -1);
        }
        return value;
    }


    /**
     * @return a string with the elements of the list as a comma-separated
     * list, from beginning to end
     *
     * Worst-case asymptotic running time cost:   Theta(n)
     *
     * Justification:
     *  We know from the Java documentation that StringBuilder's append() method runs in Theta(1) asymptotic time.
     *  We assume all other method calls here (e.g., the iterator methods above, and the toString method) will execute in Theta(1) time.
     *  Thus, every one iteration of the for-loop will have cost Theta(1).
     *  Suppose the doubly-linked list has 'n' elements.
     *  The for-loop will always iterate over all n elements of the list, and therefore the total cost of this method will be n*Theta(1) = Theta(n).
     */
    public String toString() {
        StringBuilder s = new StringBuilder();
        boolean isFirst = true;

        // iterate over the list, starting from the head
        for (DLLNode iter = head; iter != null; iter = iter.next) {
            if (!isFirst) {
                s.append(",");
            } else {
                isFirst = false;
            }
            s.append(iter.data.toString());
        }

        return s.toString();
    }
}


