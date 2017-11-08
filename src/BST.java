import java.util.ArrayList;
import java.util.Iterator;

/**
 * Implements a simple (not necessarily balanced) Binary Search Tree.
 *
 * @param <keyType> The type of the keys stored in this Binary Search Tree.
 */
public class BST<keyType extends Comparable<keyType> > {

    // CONSTRUCTORS

    /**
     * Constructs an empty Binary Search Tree
     */
    public BST() {
        key = null;
        left = null;
        right = null;
        nodeId=nodeIdCounter++;
    }

    /**
     * Constructs a one-node Binary Search Tree with the given key.
     *
     * @param theKey The key to insert into the empty BST.
     */
    public BST(keyType theKey) {
        this();
        insert(theKey);
    }

    /**
     * Constructs a Binary Search Tree by inserting the elements
     * in <code>keys</code>, in order, into the BST
     *
     * @param keys The keys to insert into the tree.
     */
    public BST(Iterable<keyType> keys) {
        this();
        for (keyType key : keys) {
            insert(key);
        }
    }


    // METHODS

    // ... getters
    public final int getNodeId() { return nodeId; }
    public final keyType getKey() { return key; }
    public BST<keyType> getLeft() { return left; }
    public BST<keyType> getRight() { return right; }

    // ... setters
    public void setNodeID(int newId) { nodeId=newId; }
    public void setLeft(BST<keyType> newLeft) { left=newLeft; }
    public void setRight(BST<keyType> newRight) { right=newRight; }
    public static void resetNodeIDCounter() { nodeIdCounter=0; }

    /**
     * Compute how to transform this BST into the BST {@code otherTree} using rotations.
     *
     * @param otherTree The into which we seek to transform the current tree.
     * @expects The keys of this object are {@link #equals(Object)}} to the keys of {@code otherTree}
     *          in a one-to-one correspondence.
     * @return An ArrayList of rotations indicating which rotations around which nodes
     *         must be performed to transform this object into {@code otherTree}
     */
    public ArrayList<BstRotation> transformTo(BST<keyType> otherTree) {
        throw new UnsupportedOperationException("This method should be properly implemented in a subclass.");
    }

    /**
     * Static version of {@link #transformTo(BST)}.
     * Only transforms a BST to another BST of the same key type.
     */
    public static <oneKeyType extends Comparable<oneKeyType> > ArrayList
    transform(BST<oneKeyType> firstTree, BST<oneKeyType> secondTree) {
        return firstTree.transformTo(secondTree);
    }

    /**
     * Inserts the new number as a key into the binary search tree
     *
     * @param newKey The new key to be inserted
     */
    public void insert(keyType newKey) {
        if (key == null) // insert here
            key = newKey;
        else if (newKey.compareTo(key) > 0) { // i.e. newKey > key
            // insert to the right
            if (right == null)
                right = new BST<>(newKey);
            else
                right.insert(newKey);
        } else // num<=key; insert to the left
            if (left == null)
                left = new BST<>(newKey);
            else
                left.insert(newKey);
    }

    /**
     * Return the BST rooted at this node as a human-readable string
     */
    public String toString() {
        return toString("|");
    }

    /**
     * Return the BST rooted at this node as a human-readable string,
     * indented by {@code depth} characters
     *
     * @param prefix The current prefix for the subtree being printed
     */
    String toString(String prefix) {
        String result = "";

        // output the key
        result += key + "(ID "+nodeId+")\n";

        // recurse
        result += prefix + "->" + (left == null ? "\n" : left.toString(prefix.concat("  |")));
        result += prefix + "->" + (right == null ? "\n": right.toString(prefix.replace("  |","   ").concat("  |")));
        return result;
    }


    // FIELDS
    protected keyType key; // the key stored by this node
    protected BST<keyType> left;    // the left child of this node
    protected BST<keyType> right;   // the right child of this node
    protected Integer nodeId;         // the current node ID
    private static Integer nodeIdCounter=0; // a counter for node IDs
}
