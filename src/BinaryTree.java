/**
 * A standard unordered binary tree implementation.
 * @author ShaheerZK
 */
public class BinaryTree<T>
{
    protected class Node<T>
    {
        T obj;
        Node left;
        Node right;
        Node(T obj, Node left, Node right)
        {
            this.obj = obj;
            this.left = left;
            this.right = right;
        }
        Node(T obj, Node left)
        {
            this(obj, left, null);
        }
        Node(T obj)
        {
            this(obj, null, null);
        }
    }
    protected Node root;
    protected int height;
    protected int size;
    public BinaryTree(T rootValue)
    {
        root = new Node(rootValue);
        size++;
    }
    public BinaryTree(){}
    /**
     * Traverses the tree in an inorder fashion i.e. left -> root -> right.
     * @param node 
     */
    public void inorderTraversal(Node node)
    {
        if (node == null)
            return;
        inorderTraversal(node.left);
        System.out.print(node.obj + " ");
        inorderTraversal(node.right);
    }
    /**
     * Traverses the tree like this: root -> left -> right
     * @param node 
     */
    public void preorderTraversal(Node node)
    {
        if (node == null)
            return;
        System.out.print(node.obj + " ");
        preorderTraversal(node.left);
        preorderTraversal(node.right);
    }
    /**
     * Traverses the tree like: left -> right -> root
     * @param node 
     */
    public void postorderTraversal(Node node)
    {
        if (node == null)
            return;
        postorderTraversal(node.left);
        postorderTraversal(node.right);
        System.out.print(node.obj + " ");
    }
    /**
     * Traverses the tree level by level. Each level is stored in an ArrayList and at last, the ArrayList containing all the levels is returned.
     * @param root
     * @return The ArrayList of ArrayList where each ArrayList contains the information of a particular level of a tree.
     */
    public ArrayList<ArrayList<T>> levelorderTraversal(Node root)
    {
        if (root == null)
            return new ArrayList<>();
        
        Queue<Node> queue = new Queue();
        ArrayList<ArrayList<T>> result = new ArrayList<>();
        
        queue.enqueue(root);
        int level = 0;
        
        while (!queue.isEmpty())
        {
            result.add(new ArrayList<>());
            
            for (int i = 0; i < queue.getSize(); i++)
            {
                Node node = queue.dequeue();
                result.get(level).add((T)node.obj);
                
                if (node.left != null)
                    queue.enqueue(node.left);
                if (node.right != null)
                    queue.enqueue(node.right);
            }
            level++;
        }
        return result;
    }
    /**
     * Traverses the tree in a level-order fashion and inserts the node in the first found empty place.
     * @param value The value that the new node will contain.
     */
    public void insert(T obj)
    {
        if (root == null)
        {
            root = new Node(obj);
            return;
        }
        
        Queue<Node> queue = new Queue();
        queue.enqueue(root);
        
        while (!queue.isEmpty())
        {
            for (int i = 0; i < queue.getSize(); i++)
            {
                Node node = queue.dequeue();
                
                if (node.left == null)
                {
                    node.left = new Node(obj);
                    size++;
                    return;
                }
                else
                    queue.enqueue(node.left);
                
                if (node.right == null)
                {
                    node.right = new Node(obj);
                    size++;
                    return;
                }
                else
                    queue.enqueue(node.right);
            }
        }
    }
    /**
     * Returns whether the given value (object) exists in the tree.
     * @param obj The obj passed
     * @return True if obj exists in the tree, false otherwise.
     */
    public boolean search(T obj)
    {
        if (root != null && root.obj == obj)
            return true;
        
        Queue<Node> queue = new Queue<>();
        
        Node node = root;
        if (node != null)
            queue.enqueue(node);
        
        while (!queue.isEmpty())
        {
            node = queue.dequeue();
            
            if (node.obj == obj)
                return true;
            
            if (node.left != null)
                queue.enqueue(node.left);
            if (node.right != null)
                queue.enqueue(node.right);
        }
        return false;
    }
    /**
     * Removes the provided value (object) if it exists in the Binary Tree. It actually replaces the target node with the deepest right most node and replaces it, and then deletes that deepest right most node.
     * @param obj The object you intend to remove.
     * @return True if the object was removed successfully, false if it wasn't found or something.
     */
    public boolean remove (T obj)
    {
        if (root == null)
            return false;
        
        boolean removed = false;
        
        Node targetNode = null, deepestRightNode = null, parentOfDeepestRightNode = null;
        Queue<Node> queue = new Queue();
        queue.enqueue(root);
        
        while (!queue.isEmpty())
        {
            Node node = queue.dequeue();
            if (node.obj == obj)
            {
                targetNode = node;
                removed = true;
            }
            if (node.left != null)
                queue.enqueue(node.left);
            if (node.right != null)
                queue.enqueue(node.right);
            
            if (node.right != null && (node.right.left == null && node.right.right == null))
                parentOfDeepestRightNode = node;
            
            deepestRightNode = node;
        }
        targetNode.obj = deepestRightNode.obj;
        parentOfDeepestRightNode.right = null;
        
        size--;
        
        return removed;
    }
    /**
     * Returns the root node of the tree.
     * @return The root node of course.
     */
    public Node getRoot()
    {
        return root;
    }
    /**
     * Returns the size of the whole tree i.e. the total number of nodes in the tree.
     * @return 
     */
    public int getSize()
    {
        return size;
    }
    /**
     * Traverses the tree in a level order manner and returns the height. I can't find another better way in which I could just track the height of the tree while inserting new values.
     * Height is basically the number of edges from the root to the node with the most depth.
     * @return the total height of the tree.
     */
    public int getHeight(Node root)
    {
        if (root == null)
            return -1;
        
        int leftHeight = getHeight(root.left);
        int rightHeight = getHeight(root.right);
        
        return Math.max(leftHeight, rightHeight) + 1;
    }
}
