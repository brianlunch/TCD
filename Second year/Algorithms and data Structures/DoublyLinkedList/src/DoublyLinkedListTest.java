import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertNull;

import org.junit.Test;
import org.junit.Ignore;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

//-------------------------------------------------------------------------

/**
 * Test class for Doubly Linked List
 *
 * @author
 * @version 13/10/16 18:15
 */
@RunWith(JUnit4.class)
public class DoublyLinkedListTest {
    //~ Constructor ........................................................
    @Test
    public void testConstructor() {
        new DoublyLinkedList<Integer>();
    }

    //~ Public Methods ........................................................

    // ----------------------------------------------------------

    /**
     * Check if the insertBefore works
     */
    @Test
    public void testInsertBefore() {
        // test non-empty list
        DoublyLinkedList<Integer> testDLL = new DoublyLinkedList<Integer>();
        testDLL.insertBefore(0, 1);
        testDLL.insertBefore(1, 2);
        testDLL.insertBefore(2, 3);

        testDLL.insertBefore(0, 4);
        assertEquals("Checking insertBefore to a list containing 3 elements at position 0", "4,1,2,3", testDLL.toString());
        testDLL.insertBefore(1, 5);
        assertEquals("Checking insertBefore to a list containing 4 elements at position 1", "4,5,1,2,3", testDLL.toString());
        testDLL.insertBefore(2, 6);
        assertEquals("Checking insertBefore to a list containing 5 elements at position 2", "4,5,6,1,2,3", testDLL.toString());
        testDLL.insertBefore(-1, 7);
        assertEquals("Checking insertBefore to a list containing 6 elements at position -1 - expected the element at the head of the list", "7,4,5,6,1,2,3", testDLL.toString());
        testDLL.insertBefore(7, 8);
        assertEquals("Checking insertBefore to a list containing 7 elemenets at position 8 - expected the element at the tail of the list", "7,4,5,6,1,2,3,8", testDLL.toString());
        testDLL.insertBefore(700, 9);
        assertEquals("Checking insertBefore to a list containing 8 elements at position 700 - expected the element at the tail of the list", "7,4,5,6,1,2,3,8,9", testDLL.toString());

        // test empty list
        testDLL = new DoublyLinkedList<Integer>();
        testDLL.insertBefore(0, 1);
        assertEquals("Checking insertBefore to an empty list at position 0 - expected the element at the head of the list", "1", testDLL.toString());
        testDLL = new DoublyLinkedList<Integer>();
        testDLL.insertBefore(10, 1);
        assertEquals("Checking insertBefore to an empty list at position 10 - expected the element at the head of the list", "1", testDLL.toString());
        testDLL = new DoublyLinkedList<Integer>();
        testDLL.insertBefore(-10, 1);
        assertEquals("Checking insertBefore to an empty list at position -10 - expected the element at the head of the list", "1", testDLL.toString());
    }

    // TODO: add more tests here. Each line of code in DoublyLinkedList.java should
    // be executed at least once from at least one test.
    /*
    @Test
    public void testGetNode() {
        // test non-empty list
        DoublyLinkedList<Integer> testDLL = new DoublyLinkedList<Integer>();
        testDLL.insertBefore(0, 1);
        testDLL.insertBefore(1, 2);
        testDLL.insertBefore(2, 3);
        assertEquals("Checking getNode", 2, testDLL.getNode(1));
    }
    */
    @Test
    public void testGet() {
        // test non-empty list
        DoublyLinkedList<Integer> testDLL = new DoublyLinkedList<Integer>();
        testDLL.insertBefore(0, 1);
        testDLL.insertBefore(1, 2);
        testDLL.insertBefore(2, 3);
        assertEquals("Checking getNode", 2,(int) testDLL.get(1));
        assertEquals(null, testDLL.get(98));
        assertEquals(null, testDLL.get(-1));
    }
    @Test
    public void testDeleteAt() {
        // test non-empty list
        DoublyLinkedList<Integer> testDLL = new DoublyLinkedList<Integer>();
        testDLL.insertBefore(0, 1);
        testDLL.insertBefore(1, 2);
        testDLL.insertBefore(2, 3);
        testDLL.insertBefore(3, 4);

        testDLL.deleteAt(1);
        assertEquals("1,3,4", testDLL.toString());
        testDLL.deleteAt(2);
        assertEquals("1,3", testDLL.toString());
        testDLL.deleteAt (0);
        assertEquals("3", testDLL.toString());
        testDLL.deleteAt (0);
        assertEquals(false, testDLL.deleteAt(0));
        testDLL.insertBefore(0, 2);
        assertEquals(false, testDLL.deleteAt(9));
    }
    @Test
    public void testReverse() {
        // test non-empty list
        DoublyLinkedList<Integer> testDLL = new DoublyLinkedList<Integer>();
        testDLL.insertBefore(0, 1);
        testDLL.insertBefore(1, 2);
        testDLL.insertBefore(2, 3);
        testDLL.insertBefore(3, 4);
        testDLL.reverse();
        assertEquals("4,3,2,1", testDLL.toString());
        testDLL.insertBefore(0, 5);
        testDLL.reverse();
        assertEquals("1,2,3,4,5", testDLL.toString());
    }
    @Test
    public void testMakeUnique() {
        // test non-empty list
        DoublyLinkedList<Integer> testDLL = new DoublyLinkedList<Integer>();
        testDLL.insertBefore(0, 2);
        testDLL.insertBefore(1, 2);
        testDLL.insertBefore(2, 2);
        testDLL.insertBefore(3, 1);
        testDLL.insertBefore(4, 1);
        testDLL.insertBefore(5, 1);
        testDLL.insertBefore(6, 1);
        System.out.println(testDLL.toString());
        testDLL.makeUnique();
        assertEquals("2,1", testDLL.toString());
    }
    @Test
    public void testPush(){
        DoublyLinkedList<Integer> testDLL = new DoublyLinkedList<Integer>();
        testDLL.push(1);
        testDLL.push(2);
        testDLL.push(3);
        testDLL.push(4);
        assertEquals("4,3,2,1", testDLL.toString());
    }
    @Test
    public void testPop(){
        DoublyLinkedList<Integer> testDLL = new DoublyLinkedList<Integer>();
        testDLL.push(1);testDLL.push(2);testDLL.push(3);
        assertEquals(3, (int)testDLL.pop());
        assertEquals(2, (int)testDLL.pop());
        assertEquals(1, (int)testDLL.pop());
        assertEquals(null, testDLL.pop());
    }
    @Test
    public void testEnqueue(){
        DoublyLinkedList<Integer> testDLL = new DoublyLinkedList<Integer>();
        testDLL.enqueue(1);
        testDLL.enqueue(2);
        testDLL.enqueue(3);
        testDLL.enqueue(4);
        assertEquals("4,3,2,1", testDLL.toString());
    }
    @Test
    public void testDequeue(){
        DoublyLinkedList<Integer> testDLL = new DoublyLinkedList<Integer>();
        testDLL.enqueue(1);
        testDLL.enqueue(2);
        testDLL.enqueue(3);
        assertEquals(1, (int)testDLL.dequeue());
        assertEquals(2, (int)testDLL.dequeue());
        assertEquals(3, (int)testDLL.dequeue());
        assertEquals(null, testDLL.dequeue());
    }
}
