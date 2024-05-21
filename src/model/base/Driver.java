/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.base;

import static model.base.Graph.INF;
import java.util.ArrayList;
import javafx.application.Application;
import static javafx.application.Application.launch;
import javafx.stage.Stage;
import view.Login;

public class Driver extends Application {

    public static void main(String[] args) {
        int vertices = 5;
        Graph graph = new Graph(vertices);
        String traffic = "high";

        Loc l1 = new Loc("Dajti", 0);
        Loc l2 = new Loc("Mon Cheri", 1);
        Loc l3 = new Loc("Era", 2);
        Loc l4 = new Loc("Anisa", 3);
        Hotel hotel1 = new Hotel("Mondial", 4, "very nice place", 3);

        int mapMatrix[][] = {
            {0, 4, 3, INF, INF},
            {4, 0, 1, 2, INF},
            {3, 1, 0, INF, INF},
            {INF, 2, INF, 0, 10},
            {INF, INF, INF, 10, 0}
        };

        graph.addEdge(l1, l2, 4);
        graph.addEdge(l1, l3, 3);
        graph.addEdge(l2, l3, 1);
        graph.addEdge(l2, l4, 2);
        graph.addEdge(l4, hotel1, 10);

        ArrayList<Loc> locList = new ArrayList<>();

        locList.add(l1);
        locList.add(l2);
        locList.add(l3);
        locList.add(l4);
        locList.add(hotel1);
        System.out.println("By Flowd Washall");
        graph.floydWarshall(mapMatrix);

        graph.dijkstra(l1);

        double[] d = Graph.bellmanFord(graph.adjacencylist, vertices, l1);
        System.out.println("\n\nBy Bellman Ford Algorithm:");

        for (int i = 0; i < locList.size(); i++) {
            System.out.printf("To get from " + locList.get(0).name+ " to " + locList.get(i).name + ", the shortest distance is " + d[i] + " km.\n");
            System.out.println("\nThe time that it would take a car: " + d[i] / 30 + " h.");
            System.out.println("\nThe time that it would take by foot: " + d[i] / 5.0 + " h.");

        }

        double[] distance = graph.dijkstra(l1);
        System.out.println("\n\nBy Dijkstra Algorithm:");
        for (int i = 0; i < vertices; i++) {
            System.out.println("To get from " + locList.get(0).name + " to " + locList.get(i).name + " the shortest distance is " + distance[i] + " km \n");
            System.out.println("\nThe time that it would take a car: " + distance[i] / 30 + " h.");
            System.out.println("\nThe time that it would take by foot: " + distance[i] / 5.0 + " h.");

        }

        launch(args);
    }

    public static double accountForTraffic(String traffic) {
        if (traffic == "low") {
            return 1;
        } else if (traffic == "moderate") {
            return 1.5;
        } else if (traffic == "high") {
            return 2;
        } else {
            return 1;
        }
    }

    @Override
    public void start(Stage st) throws Exception {
        (new Login()).show(st);
        st.show();

    }
}
