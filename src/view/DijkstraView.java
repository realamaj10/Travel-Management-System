package view;

import java.util.ArrayList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import model.RW.LocationRW;
import model.base.Client;
import model.base.Graph;
import model.base.Hotel;
import model.base.Loc;

public class DijkstraView {

    private Client generic;
    Loc source;
    Graph graph;

    public DijkstraView(Client generic) {
        this.generic = generic;
    }

    public DijkstraView() {
        super();
    }

    public void show(Stage st) {

        LocationRW rw = new LocationRW();

        Label src = new Label("Source Node: ");
        TextField srcF = new TextField();

        source = rw.checkLoc(srcF.getText());
        
        Text dijkstra  = new Text();
        

        Button go = new Button("Go");
        Button back = new Button("Return");

        HBox h1 = new HBox();
        h1.getChildren().addAll(src, srcF);
        h1.setSpacing(7);
        h1.setAlignment(Pos.CENTER);

        HBox h2 = new HBox();
        h1.getChildren().addAll(go, back);
        h1.setSpacing(7);
        h1.setAlignment(Pos.CENTER);

        VBox vb = new VBox();
        vb.getChildren().addAll(h1, h2);
        vb.setSpacing(7);
        vb.setAlignment(Pos.CENTER);

        Scene sc = new Scene(vb, 700, 700);
        st.setScene(sc);
        st.setTitle("Generic View");
        st.show();
//
//        button functions

        go.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent arg0) {
               
        
        Loc l1 = new Loc("Dajti", 0);
        Loc l2 = new Loc("Mon Cheri", 1);
        Loc l3 = new Loc("Era", 2);
        Loc l4 = new Loc("Anisa", 3);
        Hotel hotel1 = new Hotel("Mondial", 4, "very nice place", 3);

 
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
        
        double[] distance = graph.dijkstra(l1);
        for (int i = 0; i < distance.length; i++) {
            String distString = "To get from " + l1.getName() + " to " + locList.get(i).getName() + " the shortest distance is " + distance[i] + " km \n";
            System.out.println("\nThe time that it would take a car: " + distance[i] / 30 + " h.");
            System.out.println("\nThe time that it would take by foot: " + distance[i] / 5.0 + " h.");
            dijkstra.setText("By Dijkstra's algorithm: " + distString);
                
        }}
        });

        back.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent arg0) {
                (new GenericView()).show(st);
                st.show();
            }
        });
    }
}
