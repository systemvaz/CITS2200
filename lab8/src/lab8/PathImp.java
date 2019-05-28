package lab8;
import CITS2200.*;
import java.util.*;

public class PathImp implements Path
{
	static class ResultSet
	{
		int parent;
		int weight;
	}
	
	static class HeapNode
	{
		int vertex;
		int key;
	}
	
	@Override
	public int getMinSpanningTree(Graph myGraph) 
	{
		int totalWeight = 0;
		int numofvertices = myGraph.getNumberOfVertices();
		int[][] weights = myGraph.getEdgeMatrix();
		boolean[] inHeap = new boolean[numofvertices];
		int[] key = new int[numofvertices];
		HeapNode[] heapNodes = new HeapNode[numofvertices];
		ResultSet[] resultSet = new ResultSet[numofvertices];
		
		for(int i = 0; i < numofvertices; i++)
		{
			heapNodes[i] = new HeapNode();
			heapNodes[i].vertex = i;
			heapNodes[i].key = Integer.MAX_VALUE;
			resultSet[i] = new ResultSet();
			resultSet[i].parent = -1;
			inHeap[i] = true;
			key[i] = Integer.MAX_VALUE;
		}
		
		heapNodes[0].key = 0;
		MinHeap minHeap = new MinHeap9numofvertices);
		
		for(int i = 0; i < numofvertices; i++)
		{
			minHeap
		}
		
		return 0;
	}
	@Override
	public int[] getShortestPaths(Graph arg0, int arg1) {
		// TODO Auto-generated method stub
		return null;
	}
	
	
}
