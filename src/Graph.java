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
		map.put(data, new LinkedList<T>());
		vertices++;
	}
	public void addEdge(T src, T dest)
	{
		if (!map.containsKey(src) || !map.containsKey(dest))
			return;
		map.get(src).put(dest);
		edges++;
	}
	public void dfs(T source)
	{
		Hashmap<T, Integer> visited = new Hashmap<>();
		if (!map.containsKey(source))
			return;
		dfsHelper(source, visited);
	}
	private void dfsHelper(T vertex, Hashmap<T, Integer> visited)
	{
		visited.add(vertex);
		System.out.print(vertex + " ");
		for (T neighbourVertex : map.get(T))
		{
			if (!visited.containsKey(neighbourVertex))
				dfsHelper(neighbourVertex, visited);
		}
	}
	public int getEdgeCount()
	{ 
		return edges;
	}
	public int getVertexCount()
	{
		return vertices;
	}
}
