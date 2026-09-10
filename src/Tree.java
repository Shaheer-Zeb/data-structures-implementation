/**
 * A standard n-ary tree.
 * @author ShaheerZK
 */
public class Tree<T>
{
    private class Node<T>
    {
        T value;
        ArrayList<Node> children;
        Node(T value)
        {
            this.value = value;
            children = new ArrayList<>();
        }
        Node(){}
        public void addChild(T value)
        {
            if (children == null)
                children = new ArrayList<>();
            children.add(new Node(value));
        }
    }
    private Node root;
    protected int size;
    private Tree(T rootValue)
    {
        root = new Node(rootValue);
        size++;
    }
    public Tree(){}
    
    public void inorderTraversal(Node node)
    {
        if (node == null)
            return;
        for (var temp : node.children)
        {
            Node child = (Node)temp;
            inorderTraversal(child);
        }
        System.out.print(node.value);
    }
    
    public void preorderTraversal(Node node)
    {
        if (node == null)
            return;
        
        System.out.println(node.value);
        
        for (var temp : node.children)
        {
            Node child = (Node)temp;
            inorderTraversal(child);
        }
    }
    public void postorder(Node node)
    {
        if (node == null)
            return;
        
        for (var temp : node.children)
        {
            Node child = (Node)temp;
            inorderTraversal(child);
        }
        System.out.println(node.value);
    }
}