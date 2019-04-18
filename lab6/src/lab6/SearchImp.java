package lab6;
import CITS2200.Graph;
import CITS2200.Search;
import java.util.Queue;
import java.util.Stack;
import java.util.LinkedList;

public class SearchImp implements Search 
{
	
	@Override
	public int[] getConnectedTree(Graph theGraph, int arg1) 
	{
		int node = arg1;
		int[][] myMatrix = theGraph.getEdgeMatrix();
		int numVertices = theGraph.getNumberOfVertices();
		String[] colour = new String[numVertices];
		int[] parent = new int[numVertices];
		
		for(int x = 0; x < numVertices; x++)
		{
			colour[x] = "white";
		}

		Queue<Integer> myQueue = new LinkedList<Integer>();
		colour[node] = "grey";
		parent[node] = -1;
		myQueue.add(node);
		
		while(!myQueue.isEmpty())
		{
			node = myQueue.poll();
			for(int i = 0; i < numVertices; i++)
			{
				if(myMatrix[i][node] == 1 && colour[i] == "white") 
				{
					colour[i] = "grey";  //set as grey
					parent[i] = node;	//set parent
					myQueue.add(i);
				}
			}
			colour[node] = "black";		//set as black
		}
		return parent;
	}

	@Override
	public int[] getDistances(Graph theGraph, int arg1) 
	{
		int node = arg1;
		int[][] myMatrix = theGraph.getEdgeMatrix();
		int numVertices = theGraph.getNumberOfVertices();
		String[] colour = new String[numVertices];
		int[] distance = new int[numVertices];
		
		for(int x = 0; x < numVertices; x++)
		{
			colour[x] = "white";
		}

		Queue<Integer> myQueue = new LinkedList<Integer>();
		colour[node] = "grey";
		distance[node] = 0;
		myQueue.add(node);
		
		while(!myQueue.isEmpty())
		{
			node = myQueue.poll();
			for(int i = 0; i < numVertices; i++)
			{
				if(myMatrix[i][node] == 1 && colour[i] == "white") 
				{
					colour[i] = "grey";  //set as grey
					distance[i] = distance[node]+1;	//set distance
					myQueue.add(i);
				}
			}
			colour[node] = "black";		//set as black
		}
		return distance;
	}

	@Override
	public int[][] getTimes(Graph theGraph, int arg1) 
	{
		int node = arg1;
		int[][] myMatrix = theGraph.getEdgeMatrix();
		int numVertices = theGraph.getNumberOfVertices();
		int[][] time = new int[numVertices][2];
		int discovery = 0;
		String[] colour = new String[numVertices];
		
		for(int x = 0; x < numVertices; x++)
		{
			colour[x] = "white";
		}
		
		Stack<Integer> myStack = new Stack<Integer>();
		myStack.push(node);

		while(!myStack.isEmpty())
		{
			node = myStack.pop();
			time[node][0] = discovery;
			discovery++;
			
			if(colour[node] == "white")
			{
				colour[node] = "black";
				for(int i = 0; i < numVertices; i++)
				{
					if(myMatrix[node][i] == 1 && colour[i] == "white")
					{
						myStack.push(i);
						discovery++;
					}
				}				
			}
			time[node][1] = discovery;
		}		
		return time;
	}

}


