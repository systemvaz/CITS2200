package lab6;
import CITS2200.Graph;

public class TestSearch 
{
	public static void main(String[] args) throws Exception
	{
		Graph myGraph;
		SearchImp mySearch = new SearchImp();
		//myGraph = Graph.randomGraph(8, true, 6);
		myGraph = Graph.readFile("C:\\Users\\syste\\OneDrive\\Documents\\Education\\UWA\\2019\\S1\\CITS2200 - Data Structures and Algorithms\\CITS2200\\lab6\\src\\lab6\\matrix.txt", false, true);
		int[][] myMatrix = myGraph.getEdgeMatrix();
		int numVertices = myGraph.getNumberOfVertices();
		
		for(int i = 0; i < numVertices; i++)
		{
			for(int x = 0; x < numVertices; x++)
			{
				System.out.print(myMatrix[i][x] + "	");
			}
			System.out.println();
		}
		System.out.println();
		int[] parents = mySearch.getConnectedTree(myGraph, 0);
		int[] distance = mySearch.getDistances(myGraph,  0);
		int[][] time = mySearch.getTimes(myGraph, 0);
		
		System.out.println("Get parents......");
		for(int x = 0; x < parents.length; x++)
		{
			System.out.println(parents[x]+1);
		}
		System.out.println();
		System.out.println("Get distances.....");
		for(int x = 0; x < parents.length; x++)
		{
			System.out.println(distance[x]);
		}
		System.out.println();
		System.out.println("Get times.....");
		for(int x = 0; x < time.length; x++)
		{
			System.out.println(x + " - " + time[x][0] + " | " + time[x][1]);
		}
	}
}
