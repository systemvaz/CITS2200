import CITS2200.*;
import java.util.Arrays;
import java.util.ArrayList;
import java.util.PriorityQueue;

public class PathImp implements Path
{
	
	// Prim's algo
	@Override
	public int getMinSpanningTree(Graph myGraph) 
	{
		int totalWeight = 0;
		int numofvertices = myGraph.getNumberOfVertices();
		int[] key = new int[numofvertices];
		int[][] weights = myGraph.getEdgeMatrix();
		PriorityQueue<Edge> msf = new PriorityQueue<Edge>();

		
		msf.add(new Edge(0, 0));
		Arrays.fill(key,  -1);
		key[0] = 0;
		
		while(!msf.isEmpty())
		{
			int vertex = msf.remove().vertex;
			for(int i = 1; i < numofvertices; i++)
			{
				int weight = weights[vertex][i];
				if(weight != 0 && !msf.contains(weights[vertex][i]))
				{
					if(key[i] != -1 || weight < key[i])
					{
						key[i] = weight;
						msf.add(new Edge(i, weight));
					}
				}
			}
			
			for(int i = 0; i < numofvertices; i++)
			{
				totalWeight = totalWeight + key[i];
			}
		}
		
		
		return totalWeight;
	}

	// Dijkstra's algo
	@Override
	public int[] getShortestPaths(Graph myGraph, int source) 
	{
		
		return null;
	}
	
	private class Edge
	{
		public int vertex;
		public int edgeWeight;
		
		public Edge(int vertex, int weight)
		{
			this.vertex = vertex;
			edgeWeight = weight;
		}
		
		public int Comparable(Edge current) {
			int currentWeight = current.edgeWeight;
			
			if(edgeWeight < currentWeight){
				return -1;
			}
			else if(edgeWeight > currentWeight){
				return 1;
			}
			else return 0;
		}
	}
	
}
