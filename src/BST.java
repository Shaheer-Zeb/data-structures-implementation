/**
 * A generic BST implementation for the objects that implement the Comparable interface. We need an obj of Comparable because 
 * we need to maintain an order in the BST. And yeah, the BST doesn't entertain duplicates.
 * @author ShaheerZK
 */
public class BST<T extends Comparable<? super T>> extends BinaryTree<T>
{
    public BST (T rootValue)
    {
        super(rootValue);
    }
    public BST(){}
    
    /**
     * Overrides the insert method so that the new nodes are inserted in a sorted manner. It doesn't allow duplication of elements;
     * @param obj The value that the node will contain.
     */
    @Override
    public void insert(T obj)
    {
        Comparable comparableObj = null;
        if (obj instanceof Comparable)
            comparableObj = (Comparable)obj;
        Node lastNode = null;
        boolean insertInLeft = false;
        
        for (Node node = root; node != null;)
        { 
            lastNode = node;
            
            Comparable comparableNode = (Comparable)node.obj;
            
            if (comparableObj.compareTo(comparableNode) == 0)
                return;
            else if (comparableObj.compareTo(comparableNode) < 0)
            {
                node = node.left;
                insertInLeft = true;
            }
            else if (comparableObj.compareTo(comparableNode) > 0)
            {
                node = node.right;
                insertInLeft = false;
            }
        }
        if (insertInLeft)
            lastNode.left = new Node(obj);
        else
            lastNode.right = new Node(obj);
    }
    /**
     * Searches the BST and returns whether the passed obj was found or not.
     * @param obj
     * @return True if the obj was found, false else wise.
     */
    @Override
    public boolean search(T obj)
    {
        Comparable comparableObj = null;
        if (obj instanceof Comparable)
            comparableObj = (Comparable)obj;
        else
            return false;
        for (Node node = root; node != null;)
        {
            Comparable comparableNode = (Comparable)node.obj;
            
            if (comparableObj.compareTo(comparableNode) == 0)
                return true;
            else if (comparableObj.compareTo(comparableNode) < 0)
                node = node.left;
            else if (comparableObj.compareTo(comparableNode) > 0)
                node = node.right;
        }
        return false;
    }
    /**
     * Removes the provided obj if found. Handles three cases, if the node is leaf node, if the node has only one child, and in case if the node has two children, we can either replace it with its inorder predecessor or inorder successor.
     * Inorder successor means the smallest value in right sub-tree.
     * Inorder predecessor means the largest value in the left sub-tree.
     * My approach replaces the inorder predecessor.
     * @param obj
     * @return whether the obj was found and successfully removed or not.
     */
    public boolean remove(T obj)
    {
        Comparable comparableObj = null;
        if (obj instanceof Comparable)
            comparableObj = (Comparable)obj;
        
        boolean wasRemoved = false;
        
        for (Node node = root; node != null;)
        {
            Comparable comparableNode = (Comparable)node.obj;
            
            if (comparableObj.compareTo(comparableNode) == 0)
            {
                if (node.left == null && node.right == null)
                    removeImpotentNode(node);
                else if ((node.left != null && node.right == null) || (node.left == null && node.right != null))
                    removeOneChildNode(node, node.left, node.right);
                else if (node.left != null && node.right != null)
                    removeTwoChildrenNode(node, node.left, node.right);
                wasRemoved = true;
                break;
            }
            else if (comparableObj.compareTo(comparableNode) < 0)
                node = node.left;
            else if (comparableObj.compareTo(comparableNode) > 0)
                node = node.right;
        } 
        return wasRemoved;
    }
    /**
     * Traverses the BST in a level order fashion and removes the node.
     * @param node 
     */
    private void removeImpotentNode(Node node)
    {
        if (node == root)
            root = null;
        Queue<Node> queue = new Queue();
        if (root != null)
            queue.enqueue(root);
        
        while (!queue.isEmpty())
        {
            Node removedNode = queue.dequeue();
            
            if (removedNode.left == node)
                removedNode.left = null;
            else if (removedNode.right == node)
                removedNode.right = null;
            
            if (removedNode.left != null)
                queue.enqueue(removedNode.left);
            if (removedNode.right != null)
                queue.enqueue(removedNode.right);
        }
    }
    /**
     * Again, traverses the BST in a level order fashion and if it finds the node, then it checks its left and right nodes, and if all matches, it assigns the parent its grand-child.
     * @param node
     * @param left
     * @param right 
     */
    private void removeOneChildNode(Node node, Node left, Node right)
    {
        Node childToMove = null;
        
        if (left == null)
            childToMove = right;
        else
            childToMove = left;
        
        if (node == root)
            root = childToMove;
        
        Queue<Node> queue = new Queue<>();
        
        queue.enqueue(root);
        
        while (!queue.isEmpty())
        {
            Node removedNode = queue.dequeue();
            
            if (removedNode.left == node || removedNode.right == node)
            {
                if (removedNode.left.left == childToMove || removedNode.left.right == childToMove)
                    removedNode.left = childToMove;
                else if (removedNode.right.left == childToMove || removedNode.right.right == childToMove)
                    removedNode.right = childToMove;
            }
        }
    }
    private void removeTwoChildrenNode(Node node, Node left, Node right)
    {
        
    }
}
