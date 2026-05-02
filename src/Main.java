/**
 *
 * @author ShaheerZK
 * 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
 */
public class Main 
{
    public static void main(String[] args) 
    {
        //stackExample();
        //arrayListExample();
        //queueExample();
        linkedListExample();
        //hashMapExample();
        //arrayDequeExample();
        //linkedListDeque();
    }
    public static void stackExample()
    {
        final int SIZE = 10;
        Stack<Integer> stackOfStrings = new Stack<>(SIZE);
        
        for (int i = 0; i < SIZE; i++)
        {
            stackOfStrings.push(i);
        }
        for (int i = 0; i < SIZE; i++)
        {
            System.out.println(stackOfStrings.pop());
        }
        System.out.println(stackOfStrings.getStackType());
    }
    public static void arrayListExample()
    {
        final int SIZE = 50;
        ArrayList<Integer> arrayList = new ArrayList<>(SIZE);
        for (int i = 0; i < SIZE * 2; i++)
        {
            arrayList.add(i);
        }
        for (Integer i : arrayList)
            System.out.println(i);
        arrayList.clear();
        for (int i = 0; i < arrayList.size(); i++)
        {
            System.out.println(arrayList.get(i));
        }
    }
    public static void queueExample()
    {
        final int SIZE = 20;
        Queue<Double> queue = new Queue<>(SIZE);
        
        for (int i = 0; i < SIZE; i++)
        {
            queue.enqueue((double)i);
        }
        for (int i = 0; i < SIZE; i++)
        {
            System.out.println(queue.dequeue());
        }
    }
    public static void linkedListExample()
    {
        final int size = 20;
        LinkedList<Integer> linkedList = new LinkedList();
        
        for (int i = 0; i < size; i++)
        {
            linkedList.add(i);
        }
        for (Integer i : linkedList)
            System.out.println(i);
    }
    public static void hashMapExample()
    {
        final int SIZE = 100;
        HashMap<Integer, String> hashmap = new HashMap<>();
        for (int i = 0; i < SIZE; i++)
        {
            hashmap.put(i, "Shaheer " + i);
        }
        for (int i = 0; i < SIZE; i++)
        {
            System.out.println(hashmap.get(i));
        }
    }
    public static void arrayDequeExample()
    {
        ArrayDeque<Integer> deque = new ArrayDeque<>();
        
        deque.insertStart(1);
        System.out.println(deque.getStart());
        
        deque.insertEnd(0);
        System.out.println(deque.getEnd());
    }
    public static void linkedListDeque()
    {
        LinkedListDeque deque = new LinkedListDeque();
        
        deque.insertStart(100);
        System.out.println(deque.getStart());
        
        deque.insertEnd(200);
        System.out.println(deque.getEnd());
    }
}
