/**
* Notes: This code runs fine on my machine and produces output which looks correct.
* However the automarker on csmarks is telling me otherwise and actually halts execution at
* line 78 of the automarker code, giving me 0 marks !?!?
* I have no idea why, everything runs and looks fine from here.....
* 
* @author Alexander Varano della Vergiliana
*/

//package lab6;
import CITS2200.Graph;
import CITS2200.Search;
import java.util.Queue;
import java.util.Stack;
import java.util.LinkedList;

public class SearchImp implements Search 
{
	
	/**
	 * Finds the parent vertices for each vertices in a Graph by performing
	 * a Breadth First Search
	 * 
	 * @param theGraph A directed un-weighted graph to be searched
	 * @param arg1 Starting vertex
	 * @return integer[] Array of parents in order or vertex.
	 */
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
		parent[node] = -2;
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

	/**
	 * Find the distance of each vertex from the supplied starting vertex.
	 * Performed using a Breadth First Search.
	 * 
	 * @param theGraph A directed un-weighted grapg to be searched
	 * @param arg1 Starting vertex
	 * @return integer[] Array of distances in order of vertex searched.
	 */
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
			for(int i = 1; i < numVertices; i++)
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

	/**
	 * Find the initial discovery time and last time a vertex is visited from a
	 * Depth First Search.
	 * 
	 * @param theGraph A directed un-weighted grapg to be searched
	 * @param arg1 Starting vertex
	 * @return Integer[][] Array containing discovery and last times visited for each vertex. 
	 */
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


