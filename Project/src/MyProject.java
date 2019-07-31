/************************************************************************************************
 * CITS2200 Project 2019.
 * Author: Alexander Varano della Vergiliana
 * Student ID: 22268701
 ************************************************************************************************/

import java.util.*;
import java.io.*;
import java.lang.*;

public class MyProject implements CITS2200Project
{
	private static LinkedList<String> nodeFrom;
	private static Integer count_adj, count_trans;
	private static HashMap<String, Integer> index, indexT;
	private static ArrayList<LinkedList<String>> adjacencyList, transposedList;
	
	public MyProject()
	{
		adjacencyList = new ArrayList<LinkedList<String>>();
		transposedList = new ArrayList<LinkedList<String>>();
		index = new HashMap<String, Integer>();
		indexT = new HashMap<String, Integer>();
		
		count_adj = 0;
		count_trans = 0;
	}
	
	/*******************************************************************************************
	 * Read in and build our two adjacency lists. One original and one transposed.
	 * For each vertex added, maintain a separate index of the vertex and its position in the
	 * adjacency list array.
	 * 
	 * @param urlFrom the vertex to read in
	 * @param urlTo an edge to another vertex
	 *******************************************************************************************/
	@Override
	public void addEdge(String urlFrom, String urlTo) 
	{	
		//Build Adjacency List of Graph
		int vertPos = addVert(urlFrom, adjacencyList, "adj");
		addVert(urlTo, adjacencyList, "adj");
		
		nodeFrom = adjacencyList.get(vertPos);
		nodeFrom.add(urlTo);
		
		//Build the transposed version - for use in Kosaraju's algorithm
		vertPos = addVert(urlTo, transposedList, "trans");
		addVert(urlFrom, transposedList, "trans");
		
		nodeFrom = transposedList.get(vertPos);
		nodeFrom.add(urlFrom);	
	}
	
	/*******************************************************************************************
	 * Helper method for addEdge(). If vertex does not exist in the adjacency list, add it
	 * to the appropriate adjacency list and also index it in the hashmap
	 * 
	 * @param url Vertex to check for and if doesn't exist add to the adjacency list and index
	 * @param myList The adjacency list we are working with
	 * @param whichList String referencing either "adj" or "trans", reffering to the lsit we are
	 * 		  working with.
	 * @return int The vertex position in the index and adjacency list.
	 *******************************************************************************************/
	public int addVert(String url, ArrayList<LinkedList<String>> myList, String whichList)
	{
		Boolean exists = false;
		//Check if vertex already exists in our adjacency lists
		if (whichList.equals("adj"))
		{
			if (index.containsKey(url))
			{
				exists = true;
				return index.get(url);
			}
		}
		else if (whichList.equals("trans"))
		{
			if (indexT.containsKey(url))
			{
				exists = true;
				return indexT.get(url);
			}
		}
		
		//Vertex doesn't exist, so let's add it as a new one
		if (exists == false)
		{
			LinkedList<String> newVert = new LinkedList<String>();
			newVert.add(url);
			myList.add(newVert);
			
			//Add our new vertex to our index hashmap
			if (whichList.equals("adj"))
			{
				index.put(url, count_adj);
				count_adj++;
			}
			else if (whichList.contentEquals("trans"))
			{
				indexT.put(url,  count_trans);
				count_trans++;
			}		
			return myList.indexOf(newVert);
		}	
		
		return -1;
	}
		
	
	/*******************************************************************************************
	 * QUESTION 1:)
	 * Find shortest path between to supplied vertices. This implementation utilises a breadth
	 * first search approach with a queue data structure to find the solution.
	 * 
	 * @param urlFrom The starting vertex
	 * @param urlTo The ending vertex
	 * @return int Distance of the shortest path. Otherwise -1 if none found.
	 *******************************************************************************************/
	@Override
	public int getShortestPath(String urlFrom, String urlTo) 
	{
		int numVerts = count_adj + 1;
		LinkedList<String> currentVert = new LinkedList<String>();
		
		int[] distance = new int[numVerts];
		Arrays.fill(distance,  -1);
		
		Boolean visited[] = new Boolean[numVerts];
		Arrays.fill(visited, false);
		
		//The queue for running BFS
		Queue<LinkedList<String>> myQueue = new LinkedList<>();
		
		int vertPos = index.get(urlFrom);
		int destination = index.get(urlTo);
		
		//Add the first vertex to the queue, that being urlFrom, set it as being visited and it's distance as 0
		myQueue.add(adjacencyList.get(vertPos));
		visited[vertPos] = true;
		distance[vertPos] = 0;
		
		//Start the BFS!
		while (!myQueue.isEmpty())
		{
			currentVert = myQueue.remove();	
			int parentPos = index.get(currentVert.get(0));
			
			//Visit adjacent vertices of current dequeued vertex (the parent)
			for (String check : currentVert)
			{					
				vertPos = index.get(check);
				
				if (visited[vertPos] == false)
				{
					//Add vertex to queue, set it as visited and record it's distance as the sum of the parents distance + 1
					myQueue.add(adjacencyList.get(vertPos));
					visited[vertPos] = true;
					distance[vertPos] = distance[parentPos] + 1;
				}
				
				//If vertex is our urlTo, we have reached our destination, so finish
				if (check.contentEquals(urlTo))
				{
					break;
				}				
			}
		}	
		
		//Return shortest path for the destination (urlTo). -1 if none found.
		return distance[destination];
	}
	

	/*******************************************************************************************
	 * QUESTION 2.)
	 * Find the Hamiltonian Path of the supplied graph. Utilises a brute force, depth first
	 * search with backtracking functionality approach.
	 * 
	 * @return String[] Array containing the Hamiltonion Path. If none found, returns empty.
	 *******************************************************************************************/
	@Override
	public String[] getHamiltonianPath() 
	{		
		String[] returnPath = new String[index.size()];
		returnPath[0] = null;
		
		//Perform a DFS on all vertices - Brute force attempt at finding Hamiltonian path
		for (String vert : adjacencyList.get(0))
		{
			Boolean[] visited = new Boolean[adjacencyList.size()];
			ArrayList<String> path = new ArrayList<String>();		
			Arrays.fill(visited,  false);
	
			path.add(vert);
			
			hamsDFS(vert, visited, path, returnPath);

			//If NOT null, our array has been filled and we have a hamiltonian path to return
			if (returnPath[0] != null)
			{
				break;
			}
		}
		
		//If this is null, we haven't found a hamiltonian path. Create resized array for returning
		if (returnPath[0] == null)
		{
			returnPath = new String[0];
		}
		
		return returnPath;
	}
	
	
	public void hamsDFS(String vert, Boolean[] visited, ArrayList<String> path, String[] returnPath)
	{
		int vertPos = index.get(vert);
		visited[vertPos] = true;
		
		//If we have filled path to the same size as the adjacency list, we have found a hamiltonian path
		if (path.size() == adjacencyList.size())
		{
			int i = 0;
			for (String toArray : path)
			{
				//Building array for our return value in getHamiltonianPath()
				returnPath[i] = toArray;
				i++;
			}
		}
		
		else
		{		
			LinkedList<String> currentVert = new LinkedList<String>();
			currentVert = adjacencyList.get(vertPos);
			
			for (String check : currentVert)
			{
				vertPos = index.get(check);
				if (!visited[vertPos])
				{
					path.add(check);
					
					hamsDFS(check, visited, path, returnPath);
					
					//Backtracking.....
					visited[vertPos] = false;
					path.remove(path.size() - 1);
				}
			}
		}	
	}
	

	/*******************************************************************************************
	 * QUESTION 3.)
	 * The following utilizes Kosaraju's algorithm to find the Strongly Connected Components
	 * in the supplied graph. Two depth first searches are performed. The first builds a
	 * stack data structure of vertices in order of finishing times. The second is performed
	 * against a transposed version of the graph, which was created earlier when vertices were
	 * added the the adjacency list data structures (addEdge & addVert). 
	 * 
	 *@return String[][] Array containing tree/forrests of Strongly Connected Components
	********************************************************************************************/
	@Override
	public String[][] getStronglyConnectedComponents() 
	{
		int numVerts = adjacencyList.size();
		
		Boolean visited[] = new Boolean[numVerts];
		Arrays.fill(visited, false);
		
		ArrayList<ArrayList<String>> returnSCC = new ArrayList<ArrayList<String>>();
				
		Stack<String> myStack = new Stack<String>();
		
		//Perform first DFS, creating stack of vertices ordered in finishing times
		for (int i = 0; i < numVerts; i++)
		{
			if (!visited[i])
			{				
				fillStackDFS(i, visited, myStack);
			}
		}
		
		//Transposed graph created already when calling addEdge....
		
		Arrays.fill(visited,  false);

		//Perform second DFS on transposed graph popping vertices from previously created stack
		while (!myStack.empty())
		{
			String currentVert = myStack.pop();
			int vertPos = indexT.get(currentVert);
			
			if (!visited[vertPos])
			{
				ArrayList<String> foundSCC = new ArrayList<String>();;
				stackDFS(vertPos, visited, foundSCC);
				returnSCC.add(foundSCC);
			}
		}
		
		//Convert found SCC's from ArraayLists to String[][] for return call
		int firstSize = returnSCC.size();
		int i = 0;
		
		String[][] finalSCC = new String[firstSize][];
		
		for (ArrayList<String> currentSCC : returnSCC)
		{
			finalSCC[i] = currentSCC.toArray(new String[currentSCC.size()]);
			i++;
		}
			
		return finalSCC;
	}
	
	//First DFS run - Kosaraju's algorithm for finding SCC
	public void fillStackDFS(int vert, Boolean[] visited, Stack<String> myStack)
	{
		LinkedList<String> currentVert = new LinkedList<String>();
		currentVert = adjacencyList.get(vert);
		visited[vert] = true;
		
		for (String check : currentVert)
		{
			int vertPos = index.get(check);
			
			if (!visited[vertPos])
			{
				fillStackDFS(vertPos, visited, myStack);
			}
		}		
		currentVert = adjacencyList.get(vert);
		myStack.add(currentVert.get(0));
	}
	
	//Second DFS run - Kosaraju's algorithm for finding SCC
	public void stackDFS(int vertPos, Boolean[] visited, ArrayList<String> foundSCC)
	{	
		LinkedList<String> currentVert = new LinkedList<String>();
		currentVert = transposedList.get(vertPos);
		foundSCC.add(currentVert.get(0));
		
		visited[vertPos] = true;
		currentVert = transposedList.get(vertPos);
		
		for (String check : currentVert)
		{
			vertPos = indexT.get(check);
			if (!visited[vertPos])
			{
				stackDFS(vertPos, visited, foundSCC);	
			}
		}
	}
	
	
	/*******************************************************************************************
	 * QUESTION 4.)
	 * Run iterative calls to getShortestPath to find the smallest of the largest shortest paths, 
	 * or vertices of minimum eccentricity. Known as Centers.
	 * Assumption: To be considered a center, the vertex must be able to reach all other vertices.
	 * 
	 * @return String[] Array containing all the Centers found. If none found return empty.
	 *******************************************************************************************/
	
	@Override
	public String[] getCenters() 
	{
		int max = 0;
		int min = Integer.MAX_VALUE;
		int count = 0;
		int[] maxSPs = new int[index.size()];
		LinkedList<String> currentVert = new LinkedList<String>();
		String to, from;
		
		//Run BFS shortest path on all vertices and record the largest shortest path for the vertex
		for (int i = 0; i < index.size(); i++)
		{
			max = 0;
			for (int j = 0; j < index.size(); j++)
			{
				//Run getShortestPath, but not against itself
				if (i != j)
				{
					currentVert = adjacencyList.get(i);
					from = currentVert.get(0);
					currentVert = adjacencyList.get(j);
					to = currentVert.get(0);
					
					count = getShortestPath(from, to);
				}		
				//If our vertex cannot reach another, set its max to -1 and break. Vertex will NOT be considered a center.
				if (count == -1)
				{
					max = -1;
					break;
				}
				//If shortest path returned is the largest we have seen for this vertex, record it
				else if (count > max)
				{
					max = count;
				}
			}
			//Record the biggest shortest path we found for this vertex
			maxSPs[i] = max;
		}
		
		//Find the smallest shortest path recorded out of all the vertices
		for (int i = 0; i < index.size(); i++)
		{
			if (maxSPs[i] < min && maxSPs[i] != -1)
			{
				min = maxSPs[i];
			}
		}
		
		//Populate String[] with our centers
		String[] tempCenters = new String[index.size()];
		int centersIndex = 0;
		
		for (int i = 0; i < maxSPs.length; i++)
		{
			if (maxSPs[i] == min)
			{
				currentVert = adjacencyList.get(i);
				String center = currentVert.get(0);
				tempCenters[centersIndex] = center;
				centersIndex++;
			}
		}
		
		//Resize our array for presenting to return
		String[] ourCenters = new String[centersIndex];
		System.arraycopy(tempCenters,  0, ourCenters, 0, centersIndex);
		
		return ourCenters;
	}

	
	
}	


//--------------------------------------------------------------------
//END
//--------------------------------------------------------------------

