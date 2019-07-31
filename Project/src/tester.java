import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class tester
{

	public static void main(String[] args) throws IOException
	{
		
		MyProject testProject = new MyProject();
		long startTime, endTime;

		startTime = System.currentTimeMillis();
		
		try {
			BufferedReader reader = new BufferedReader(new FileReader("C:\\Users\\syste\\OneDrive\\Documents\\Education\\UWA\\2019\\S1\\CITS2200 - Data Structures and Algorithms\\CITS2200\\Project\\src\\data\\medium_graph.txt"));
			while (reader.ready()) {
				String from = reader.readLine();
				String to = reader.readLine();
				System.out.println("Adding edge from " + from + " to " + to);
				testProject.addEdge(from, to);
			}
		} catch (Exception e) {
			System.out.println("There was a problem:");
			System.out.println(e.toString());
		}
		
		endTime = System.currentTimeMillis();
		System.out.println("");
		System.out.println("Graph loading time: " + (endTime - startTime));
		System.out.println("============================================");
		
//		testProject.printVerts();
				
		
		System.out.println("");
		System.out.println("Getting Shortest Path.............");
		startTime = System.currentTimeMillis();
		int path = testProject.getShortestPath("/wiki/Australia", "/wiki/United+Kingdom");
		endTime = System.currentTimeMillis();
		System.out.println("Shortest Path: " + path);
		System.out.println("");
		System.out.println("SP Run time: " + (endTime - startTime));
		System.out.println("============================================");
		
		System.out.println("");
		System.out.println("Getting Strongly Connected Components.......");
		startTime = System.currentTimeMillis();
		String[][] mySCC = testProject.getStronglyConnectedComponents();
		endTime = System.currentTimeMillis();
		
		for (int i = 0; i < mySCC.length; i++)
		{
			for (int j = 0; j < mySCC[i].length; j++)
			{
				System.out.print(mySCC[i][j] + " ");
			}
			System.out.println("");
		}
		System.out.println("");
		System.out.println("SCC Run time: " + (endTime - startTime));
		System.out.println("============================================");
		
		System.out.println("");
		System.out.println("Getting centers ......");
		startTime = System.currentTimeMillis();
		String[] myCenters = testProject.getCenters();
		endTime = System.currentTimeMillis();
		
		for (String center : myCenters)
		{
			System.out.println(center);
		}
		System.out.println("");
		System.out.println("Centers Run time: " + (endTime - startTime));
		System.out.println("============================================");
		
	
		System.out.println("Checking for hamiltonian path...");
		startTime = System.currentTimeMillis();
		String[] hamPath = testProject.getHamiltonianPath();
		endTime = System.currentTimeMillis();
		System.out.println("Done.");
		
		for (String thepath : hamPath)
		{
			System.out.print(thepath + " -> ");
		}
		
		System.out.println("");
		System.out.println("Hamiltonian path time: " + (endTime - startTime));
		System.out.println("============================================");
		
		System.out.println("");
		System.out.println("END!!");
	}
	
}
