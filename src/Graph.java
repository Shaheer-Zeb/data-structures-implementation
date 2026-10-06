/**
* A generic, unweighted, and directed graph.
* @author ShaheerZK
*/
public class Graph<T>
{
	private Hashmap<T, LinkedList<T>> map = new Hashmap<>();
	private int vertices = 0, edges = 0;

	public void addVertex(T data)
	{
		if (map.contains(data))
			return;
		map.add(data, new LinkedList<T>());
		vertices++;
	}
	public void addEdge(T src, T dest)
	{
		if (!map.contains(src) || !map.contains(dest))
			return;
		map.get(src).add(dest);
		edges++;
	}
	public int getEdgeCount()
	{ 
		return egdes;
	}
	public int getVertexCount()
	{
		return vertices;
	}
}
