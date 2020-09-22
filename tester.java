package Graph;

public class tester {

	public static void main(String args[]) {
		
		Graph g1=new Graph();
				
		g1.addNode(1);
		g1.addNode(2);
		g1.addNode(3);
		g1.addNode(4);
		g1.addNode(5);
		g1.addNode(2);
		
		g1.addEdge(1, 2);
		g1.addEdge(2, 2);
		g1.addEdge(1, 4);
		g1.addEdge(2, 3);
		g1.addEdge(1, 3);
		g1.addEdge(1, 2);
		g1.addEdge(6, 5);
		g1.addEdge(7, 8);
		
		g1.removeNode(5);
		g1.removeEdge(4, 1);
		g1.removeEdge(1, 4);
		g1.removeNode(2);
		g1.removeEdge(1, 2);
		
	}
	
}
