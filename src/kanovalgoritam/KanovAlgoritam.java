/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kanovalgoritam;
import java.util.*; 
  
// Class to represent a graph 
class Graph { 
    // No. of vertices 
    int V; 
  
    // An Array of List which contains 
    // references to the Adjacency List of 
    // each vertex 
    List<Integer> adj[]; 
    // Constructor 
    public Graph(int vertices) 
    { 
        this.V = vertices; 
        adj = new ArrayList[V]; 
        for (int i = 0; i < V; i++) 
            adj[i] = new ArrayList<Integer>(); 
            
    } 
  
    // Function to add an edge to graph 
    public void addEdge(int u, int v) 
    { 
        adj[u].add(v); 
    } 
    // prints a Topological Sort of the 
    // complete graph 
    public void topologicalSort() 
    { 
        // Create a array to store 
        // indegrees of all 
        // vertices. Initialize all 
        // indegrees as 0. 
        int indegree[] = new int[V]; 
           System.out.println(Arrays.toString(indegree)); 
               
        // Traverse adjacency lists 
        // to fill indegrees of 
        // vertices. This step takes 
        // O(V+E) time 
        for (int i = 0; i < V; i++) { 
            ArrayList<Integer> temp 
                = (ArrayList<Integer>)adj[i]; 
            System.out.println(temp);
            //System.exit(0);
            for (int node : temp) { 
                indegree[node]++;  
            } 
            
                
        } 
             //System.out.println(Arrays.toString(indegree)); System.exit(0);
        // Create a queue and enqueue 
        // all vertices with indegree 0 
        Queue<Integer> q 
            = new LinkedList<Integer>(); 
        for (int i = 0; i < V; i++) { 
            if (indegree[i] == 0) 
                q.add(i); 
        } 
        //System.out.println(q); System.exit(0);
        // Initialize count of visited vertices 
        int cnt = 0; 
  
        // Create a vector to store result 
        // (A topological ordering of the vertices) 
        Vector<Integer> topOrder = new Vector<Integer>(); 
        while (!q.isEmpty()) { 
            // Extract front of queue 
            // (or perform dequeue) 
            // and add it to topological order 
            int u = q.poll(); 
            topOrder.add(u); 
  
            // Iterate through all its 
            // neighbouring nodes 
            // of dequeued node u and 
            // decrease their in-degree 
            // by 1 
            for (int node : adj[u]) { 
                // If in-degree becomes zero, 
                // add it to queue 
                if (--indegree[node] == 0) 
                    q.add(node); 
            } 
            
            cnt++; 
        } 
        //System.out.println(topOrder); System.exit(0);
        // Check if there was a cycle 
        if (cnt != V) { 
            System.out.println( 
                "There exists a cycle in the graph"); 
            return; 
        } 
  
        // Print topological order 
        for (int i : topOrder) { 
            System.out.print(i + " "); 
        } 
    } 
} 
/**
 *
 * @author dejan
 */
public class KanovAlgoritam {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Graph g = new Graph(6); 
        System.out.println(Arrays.toString(g.adj)); 
        
        g.addEdge(5, 2); 
        System.out.println(Arrays.toString(g.adj)); 
        
        g.addEdge(5, 0); 
        g.addEdge(4, 0); 
        g.addEdge(4, 1); 
        g.addEdge(2, 3); 
        g.addEdge(3, 1); 
        System.out.println(Arrays.toString(g.adj)); 
              
        
        System.out.println( 
            "Following is a Topological Sort"); 
        g.topologicalSort(); 
    }
    
}
