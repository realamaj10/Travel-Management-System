package model.base;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.PriorityQueue;
import javafx.util.Pair;

public class Graph {

    int vertices;
    LinkedList<Edge>[] adjacencylist;

   public Graph(int vertices) {
        this.vertices = vertices;
        adjacencylist = new LinkedList[vertices];

        for (int i = 0; i < vertices; i++) {
            adjacencylist[i] = new LinkedList<>();
        }
    }

    public void addEdge(Loc source, Loc destination, int weight) {
        //undirected graph
        Edge edge = new Edge(source, destination, weight);
        adjacencylist[source.x].addFirst(edge);

        edge = new Edge(destination, source, weight);
        adjacencylist[destination.x].addFirst(edge); 
    }

    public double[] dijkstra(Loc sourceVertex) {

        boolean[] SPT = new boolean[vertices];
        double[] distance = new double[vertices];

        //Initialize all the distance to infinity
        for (int i = 0; i < vertices; i++) {
            distance[i] = Integer.MAX_VALUE;
        }
  
        PriorityQueue<Pair<Integer, Integer>> pq = new PriorityQueue<>(vertices, new Comparator<Pair<Integer, Integer>>() {
            @Override
            public int compare(Pair<Integer, Integer> p1, Pair<Integer, Integer> p2) {
                //sort using distance values
                int key1 = p1.getKey();
                int key2 = p2.getKey();
                return key1 - key2;
            }
        });

        distance[0] = 0;
        Pair<Integer, Integer> p0 = new Pair<>((int)distance[0], 0);
         pq.offer(p0);

     
        while (!pq.isEmpty()) {
            //extract the minimum
            Pair<Integer, Integer> extractedPair = pq.poll();

            
            int extractedVertex = extractedPair.getValue();
            if (SPT[extractedVertex] == false) {
                SPT[extractedVertex] = true;

                LinkedList<Edge> list = adjacencylist[extractedVertex];
                for (int i = 0; i < list.size(); i++) {
                    Edge edge = list.get(i);
                    Loc destination = edge.destination;
               
                    if (SPT[destination.x] == false) {
                       
                        int newKey = (int)distance[extractedVertex] + edge.weight;
                        int currentKey = (int)distance[destination.x];
                        if (currentKey > newKey) {
                            Pair<Integer, Integer> p = new Pair<>(newKey, destination.x);
                            pq.offer(p);
                            distance[destination.x] = newKey;
                        }
                    }
                }
            }
        }
        return distance;
    }

    
    
    final static int INF = 99999, V = 5; 
  
    void floydWarshall(int graph[][]) 
    { 
        int dist[][] = new int[V][V]; 
        int i, j, k; 
  
     
        for (i = 0; i < V; i++) 
            for (j = 0; j < V; j++) 
                dist[i][j] = graph[i][j]; 
  
        for (k = 0; k < V; k++) 
        { 
          
            for (i = 0; i < V; i++) 
            { 
              
                for (j = 0; j < V; j++) 
                { 
                    // If vertex k is on the shortest path from 
                    // i to j, then update the value of dist[i][j] 
                    if (dist[i][k] + dist[k][j] < dist[i][j]) 
                        dist[i][j] = dist[i][k] + dist[k][j]; 
                } 
            } 
        } 
  
        printFloydWarshall(dist); 
    } 
  
    void printFloydWarshall(int dist[][]) 
    { 
        System.out.println("The following matrix shows the shortest distances between every pair of vertices: " ); 
        for (int i=0; i<V; ++i) 
        { 
            for (int j=0; j<V; ++j) 
            { 
                if (dist[i][j]==INF) 
                    System.out.print("INF "); 
                else
                    System.out.print(dist[i][j]+"\t"); 
            } 
            System.out.println(); 
        } 
    } 

    public static double[] bellmanFord(LinkedList<Edge>[] adjacencyList, int V, Loc source) {

        // Initialize the distance to all nodes to be infinity
        // except for the start node.
        double[] dist = new double[V];
        java.util.Arrays.fill(dist, Double.POSITIVE_INFINITY);
        dist[source.x] = 0;

        // For each vertex, apply relaxation for all the edges
        for (int i = 0; i < V - 1; i++) {
            for (LinkedList<Edge> edges : adjacencyList) {
                for (Edge edge : edges) {
                    if (dist[edge.source.x] + edge.weight < dist[edge.destination.x]) {
                        dist[edge.destination.x] = dist[edge.source.x] + edge.weight;
                    }
                }
            }
        }

        // Detect which nodes are part of a negative cycle.
        // A negative cycle has occurred if we can find a better path.
        
        for (int i = 0; i < V - 1; i++) {
            for (LinkedList<Edge> edges : adjacencyList) {
                for (Edge edge : edges) {
                    if (dist[edge.source.x] + edge.weight < dist[edge.destination.x]) {
                        dist[edge.destination.x] = Double.NEGATIVE_INFINITY;
                    }
                }
            }
        }
        return dist;

    }

}
