import java.io.*;
import java.util.*;

public class CITS2200ProjectTester {
	public static void loadGraph(CITS2200Project project, String path) {
		// The graph is in the following format:
		// Every pair of consecutive lines represent a directed edge.
		// The edge goes from the URL in the first line to the URL in the second line.
		try {
			BufferedReader reader = new BufferedReader(new FileReader(path));
			while (reader.ready()) {
				String from = reader.readLine();
				String to = reader.readLine();
				System.out.println("Adding edge from " + from + " to " + to);
				project.addEdge(from, to);
			}
		} catch (Exception e) {
			System.out.println("There was a problem:");
			System.out.println(e.toString());
		}
	}

	public static void main(String[] args) {
		// Change this to be the path to the graph file.
		String pathToGraphFile = "C:\\Users\\syste\\OneDrive\\Documents\\Education\\UWA\\2019\\S1\\CITS2200 - Data Structures and Algorithms\\CITS2200\\Project\\src\\data\\example_graph.txt";
		// Create an instance of your implementation.
		MyProject proj = new MyProject();
		// Load the graph into the project.
		loadGraph(proj, pathToGraphFile);

		// Write your own tests!
	}
}