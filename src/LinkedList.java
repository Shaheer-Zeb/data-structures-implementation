/**
 * @author ShaheerZK
 */
public class LinkedList<T>
{
    private int size;
    private static final int DEFAULTSIZE = 100;
    private int capacity;
    
    private Node<T> head;
    private Node<T> tail;
    private Node<T> last;
    
    private class Node<T>
    {
        T obj;
        Node<T> previous;
        Node<T> next;
        Node(T obj, Node previous, Node next)
        {
            this.obj = obj;
            this.previous = previous;
            this.next = next;
        }
        Node(T obj, Node previous)
        {
            this(obj, previous, null);
        }
        Node()
        {
            this(null, null, null);
        }
    }
    public LinkedList(int capacity)
    {
        initHeadAndTail();
        if (capacity > 0)
            this.capacity = capacity;
        else
        {
            System.out.println("The capacity has to be positive. Default capacity of " + DEFAULTSIZE + " has been assigned.");
            this.capacity = DEFAULTSIZE;
        }
    }
    public LinkedList()
    {
        this(DEFAULTSIZE);
    }
    private void initHeadAndTail()
    {
        head = new Node();
        tail = new Node();
        last = new Node();
        
        head.next = tail;
        tail.previous = head;
    }
    /**
     * Adding an element to the end of the list.
     * @param obj 
     */
    public void add(T obj)
    {
        Node<T> node;
        if (head == null && tail == null && size < capacity)
        {
            node = new Node(obj, null, null);
            head = node;
            tail = node;
            last = node;
            
            size++;
        }
        else if (size < capacity)
        {
            node = new Node(obj, last, null);
            last.next = node;
            tail = node;
            
            size ++;
        }
        else
            System.out.println("The LinkedList overflowed perhaps. Try calling the ensureCapacity() method.");
    }
    /**
     * Adds the object at the beginning of the list.
     * @param obj 
     */
    public void addFirst(T obj)
    {
        Node node = new Node(obj, null, head);
        head.previous = node;
        head = node;
    }
    /**
     * Literally the same thing as add(), don't know why you'd use addLast() instead of add().
     * @param obj 
     */
    public void addLast(T obj)
    {
        add(obj);
    }
    public void clear()
    {
        for (Node node = head; node != null; node = node.next)
        {
            node.obj = null;
            node.previous = null;
        }
        head = null;
        tail = null;
        size = 0;
    }
    /**
     * Returns whether the LinkedList contains the provided object.
     * @param obj
     * @return 
     */
    public boolean contains(T obj)
    {
        for (Node node = head; node != null; node = node.next)
        {
            if (obj != null && node.obj.equals(obj))
                return true;
            else if (obj == null && node.obj == null)
                return true;
        }
        return false;
    }
    /**
     * Returns the object at the specified index, and null if the index isn't valid or the object isn't found.
     * @param index
     * @return 
     */
    public T get(int index)
    {
        if (index < 0)
            return null;
        Node node = head;
        for (int i = 0; node != null; node = node.next, i++)
        {
            if (i == index)
                return (T)node.obj;
        }
        return null;
    }
    /**
     * Are you an idiot? It of course returns the first element of the LinkedList.
     * @return 
     */
    public T getFirstElement()
    {
        return head.obj;
    }
    /**
     * As the name says, it returns the last element of the LinkedList.
     * @return 
     */
    public T getLastElement()
    {
        return tail.obj;
    }
    /**
     * Returns the first index of the first matching specified object in the LinkedList, if not found, it returns -1.
     * @param obj
     * @return 
     */
    public int indexOf(T obj)
    {
        Node node = head;
        for (int i = 0; node != null; node = node.next, i++)
        {
            if (obj != null && node.obj.equals(obj))
                return i;
            else if (obj == null && node.obj == null)
                return i;
        }
        return -1;
    }
    /**
     * Returns the last index of the first matching specified object in the LinkedList, if not found, it returns -1.
     * @param obj
     * @return 
     */
    public int lastIndexOf(T obj)
    {
        Node node = tail;
        for (int i = size - 1; node != null; node = node.previous, i--)
        {
            if (obj != null && node.obj.equals(obj))
                return i;
            else if (obj == null && node.obj == null)
                return i;
        }
        return -1;
    }
    public int size()
    {
        return size;
    }
}