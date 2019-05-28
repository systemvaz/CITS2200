import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class tester
{

	public static void main(String[] args) throws IOException
	{
		
		MyProject testProject = new MyProject();
//		testProject.loadGraph("C:\\Users\\syste\\OneDrive\\Documents\\Education\\UWA\\2019\\S1\\CITS2200 - Data Structures and Algorithms\\CITS2200\\Project\\src\\data\\medium_graph.txt");
//		testProject.printVerts();		
		
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
		
		//testProject.printVerts();
		
		int path = testProject.getShortestPath("/wiki/Australia", "/wiki/United+Kingdom");	
		System.out.println("Shortest Path: " + path);
		
		String[][] mySCC = testProject.getStronglyConnectedComponents();
		
		for (int i = 0; i < mySCC.length; i++)
		{
			for (int j = 0; j < mySCC[i].length; j++)
			{
				System.out.print(mySCC[i][j] + " ");
			}
			System.out.println("");
		}
	}
	
}
