import java.util.*;
import java.io.*;

public class MyProject implements CITS2200Project
{
	private static LinkedList<String> nodeFrom;
	private static ArrayList<String> index, indexT;
	private static ArrayList<LinkedList<String>> adjacencyList, transposedList;
	
	public MyProject()
	{
		adjacencyList = new ArrayList<LinkedList<String>>();
		transposedList = new ArrayList<LinkedList<String>>();
		index = new ArrayList<String>();
		indexT = new ArrayList<String>();
	}
	
	@Override
	public void addEdge(String urlFrom, String urlTo) 
	{	
		//Build Adjacency List of Graph
		int vertPos = addVert(urlFrom, adjacencyList);
		addVert(urlTo, adjacencyList);
		
		nodeFrom = adjacencyList.get(vertPos);
		nodeFrom.add(urlTo);
		
		//Build the transposed version - for use in Kosaraju's algorithm
		vertPos = addVert(urlTo, transposedList);
		addVert(urlFrom, transposedList);
		
		nodeFrom = transposedList.get(vertPos);
		nodeFrom.add(urlFrom);		
	}
	
	
	public int addVert(String url, ArrayList<LinkedList<String>> myList)
	{
		Boolean exists = false;
		int vertPos;
		
		for (LinkedList<String> getVert : myList)
		{
			if (getVert.get(0).equals(url))
			{
				vertPos = myList.indexOf(getVert);
				exists = true;
				return vertPos;
			}
		}
		
		if (exists == false)
		{
			LinkedList<String> newVert = new LinkedList<String>();
			newVert.add(url);
			myList.add(newVert);
			return myList.indexOf(newVert);
		}
		
		return -1;
	}
	

	public void indexVerts()
	{
		for (LinkedList<String> getVert : adjacencyList)
		{
			index.add(getVert.get(0));
		}
	}
	
	public void indexTransposed()
	{
		for (LinkedList<String> getVert : transposedList)
		{
			indexT.add(getVert.get(0));
		}
	}
	

	//Utilizes BFS to find shortest path
	@Override
	public int getShortestPath(String urlFrom, String urlTo) 
	{
		int numVerts = adjacencyList.size();
		
		int[] distance = new int[numVerts];
		Arrays.fill(distance,  -1);
		
		Boolean visited[] = new Boolean[numVerts];
		Arrays.fill(visited, false);
		
		Queue<LinkedList<String>> myQueue = new LinkedList<>();
		
		indexVerts();
		int vertPos = index.indexOf(urlFrom);
		int destination = index.indexOf(urlTo);
		
		myQueue.add(adjacencyList.get(vertPos));
		visited[vertPos] = true;
		distance[vertPos] = 0;
		
		while (!myQueue.isEmpty())
		{
			LinkedList<String> currentVert = new LinkedList<String>();
			currentVert = myQueue.remove();
			
			int parentPos = index.indexOf(currentVert.get(0));
			
			for (String check : currentVert)
			{					
				vertPos = index.indexOf(check);
				
				if (visited[vertPos] == false)
				{
					myQueue.add(adjacencyList.get(vertPos));
					visited[vertPos] = true;
					distance[vertPos] = distance[parentPos] + 1;
				}
				
				if (check.contentEquals(urlTo))
				{
					break;
				}				
			}
		}	
		return distance[destination];
	}

	
	
	@Override
	public String[] getCenters() 
	{
		
		return null;
	}

	
	//The follow utilizes Kosaraju's algorithm to find the strongly connected components
	@Override
	public String[][] getStronglyConnectedComponents() 
	{
		int numVerts = adjacencyList.size();
		
		Boolean visited[] = new Boolean[numVerts];
		Arrays.fill(visited, false);
		
		ArrayList<ArrayList<String>> returnSCC = new ArrayList<ArrayList<String>>();
				
		Stack<String> myStack = new Stack<String>();
	
		indexVerts();
		
		//Perform first DFS, creating stack of vertices ordered in finishing times
		for (int i = 0; i < numVerts; i++)
		{
			if (!visited[i])
			{				
				fillStackDFS(i, visited, myStack);
			}
		}
		
		//Transposed graph created already when calling addEdge, just need to index
		indexTransposed();
		
		Arrays.fill(visited,  false);

		//Perform second DFS on transposed graph popping vertices from previously created stack
		while (!myStack.empty())
		{
			String currentVert = myStack.pop();
			int vertPos = indexT.indexOf(currentVert);
			
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
			int vertPos = index.indexOf(check);
			
			if (!visited[vertPos])
			{
				fillStackDFS(vertPos, visited, myStack);
			}
		}		
		myStack.add(index.get(vert));
	}
	
	//Second DFS run - Kosaraju's algorithm for finding SCC
	public void stackDFS(int vertPos, Boolean[] visited, ArrayList<String> foundSCC)
	{	
		foundSCC.add(indexT.get(vertPos));
		
		visited[vertPos] = true;
		LinkedList<String> currentVert = new LinkedList<String>();
		currentVert = transposedList.get(vertPos);
		
		for (String check : currentVert)
		{
			vertPos = indexT.indexOf(check);
			if (!visited[vertPos])
			{
				stackDFS(vertPos, visited, foundSCC);	
			}
		}
	}
	

	@Override
	public String[] getHamiltonianPath() 
	{
		
		return null;
	}
	
	
	
	
	//--------------------------------------------------------------------
	//--------------------------------------------------------------------
	
	public void printVerts()
	{
		System.out.println("Adjacency List");
		System.out.println("==============");
		System.out.println(adjacencyList.size());
		for (LinkedList<String> getVert : adjacencyList)
		{
			for (String vert : getVert)
			{
				System.out.print(vert + " |  ");
			}
			
			System.out.println();
		}
		
		System.out.println("");
		System.out.println("Transposed List");
		System.out.println("===============");
		System.out.println(transposedList.size());
		for (LinkedList<String> getVert : transposedList)
		{
			for (String vert : getVert)
			{
				System.out.print(vert + " |  ");
			}
			
			System.out.println();
		}
		
		
		indexVerts();
		for (int i = 0; i < index.size(); i++)
		{
			System.out.println(index.get(i));
		}
	}

}
