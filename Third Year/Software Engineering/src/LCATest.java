import org.junit.Test;

import static org.junit.Assert.*;

public class LCATest {

    @Test
    public void testOne() {
        LCA.BT_NoParentPtr_Solution1 tree = new LCA.BT_NoParentPtr_Solution1();
        tree.root = new LCA.Node(1); tree.root.left = new LCA.Node(2);
        tree.root.right = new LCA.Node(3); tree.root.left.left = new LCA.Node(4);
        tree.root.left.right = new LCA.Node(5); tree.root.right.left = new LCA.Node(6);
        tree.root.right.right = new LCA.Node(7);
        /*

        SEARCH TREE VISUALISATION

        	  1
			/   \
		   2     3
		  / \   / \
		 4   5 6   7

         */

        assertEquals( 2,tree.findLCA(4, 5));
        assertEquals( 2,tree.findLCA(5, 4));
        assertEquals( 1,tree.findLCA(4, 6));
        assertEquals( 1,tree.findLCA(2, 3));
        assertEquals( 3,tree.findLCA(6, 7));
    }

    @Test
    public void testTwo() {
        LCA.BT_NoParentPtr_Solution1 tree = new LCA.BT_NoParentPtr_Solution1();
        tree.root = new LCA.Node(1);
        tree.root.left = new LCA.Node(2);
        tree.root.right = new LCA.Node(3);
        tree.root.right.left  = new LCA.Node(4);
        tree.root.right.right  = new LCA.Node(5);
        tree.root.right.left.left   = new LCA.Node(6);
        tree.root.right.left .right  = new LCA.Node(7);
        tree.root.right.right.left  = new LCA.Node(8);
        tree.root.right.right.right  = new LCA.Node(9);

        /*

        SEARCH TREE VISUALISATION

        	 1
		   /   \
		  2     3
		      /   \
		     4      5
			/ \    / \
		   6   7  8   9

         */

        assertEquals( 3,tree.findLCA(4, 5));
        assertEquals( 4,tree.findLCA(4, 6));
        assertEquals( 1,tree.findLCA(2, 3));
        assertEquals( 4,tree.findLCA(6, 7));
        assertEquals( 1,tree.findLCA(6, 2));
    }
}