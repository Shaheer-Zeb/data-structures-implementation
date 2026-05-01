/**
 *
 * @author ShaheerZK
 */
public class Main 
{
    public static void main(String[] args) 
    {
        //stackExample();
        //arrayListExample();
        //queueExample();
        //linkedListExample();
        hashMapExample();
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
        for (int i = 0; i < arrayList.size(); i++)
        {
            System.out.println(arrayList.get(i));
        }
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
        LinkedList<Integer> linkedList = new LinkedList(size);
        
        for (int i = 0; i < size; i++)
        {
            linkedList.add(i);
        }
        for (int i = 0; i < size; i++)
        {
            System.out.println(linkedList.get(i));
        }
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
}
