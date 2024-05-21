package view;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;
import model.RW.LocationRW;
import model.base.Graph;
import model.base.Loc;

public class AddEdgeView {

    Graph graph;
    Loc source;
    Loc destination;
    Loc loc;
    final  int vertices = 5;

    public AddEdgeView(Loc loc) {
        this.loc = loc;
    }

    public AddEdgeView() {
        super();
    }

    public void show(Stage st) {

        Label src = new Label("Source:");
        src.setFont(Font.font("Book Antiqua",
                FontWeight.BOLD, 18));
        src.setTextFill(Color.GREEN);
        Label dest = new Label("Destination:");
        dest.setFont(Font.font("Book Antiqua",
                FontWeight.BOLD, 18));
        dest.setTextFill(Color.GREEN);
        Label dist = new Label("Distance:");
        dist.setFont(Font.font("Book Antiqua",
                FontWeight.BOLD, 18));
        dist.setTextFill(Color.GREEN);

        TextField srcField = new TextField();
        TextField destField = new TextField();
        TextField distField = new TextField();

        Button back = new Button("Return");
        back.setStyle("-fx-border-color: green; -fx-border-width: 5px; -fx-background-color: beige; -fx-text-fill: green;");

        Button add = new Button("Add Edge");
        add.setStyle("-fx-border-color: green; -fx-border-width: 5px; -fx-background-color: beige; -fx-text-fill: green;");

        HBox hb1 = new HBox();
        hb1.getChildren().addAll(src, srcField);
        hb1.setPadding(new Insets(5, 5, 5, 5));
        hb1.setAlignment(Pos.CENTER);

        HBox hb2 = new HBox();
        hb2.getChildren().addAll(dest, destField);
        hb2.setPadding(new Insets(5, 5, 5, 5));
        hb2.setAlignment(Pos.CENTER);

        HBox hb3 = new HBox();
        hb3.getChildren().addAll(dist, distField);
        hb3.setPadding(new Insets(5, 5, 5, 5));
        hb3.setAlignment(Pos.CENTER);

        HBox hb4 = new HBox();
        hb4.getChildren().addAll(back,add);
        hb4.setSpacing(5);
        hb4.setPadding(new Insets(5, 5, 5, 5));
        hb4.setAlignment(Pos.CENTER);
     
        GridPane gp = new GridPane();
        gp.setHgap(20);
        gp.setVgap(20);
        gp.setPadding(new Insets(5, 5, 5, 5));
        gp.setAlignment(Pos.CENTER);
        
        VBox vb = new VBox();
        vb.getChildren().addAll(hb1,hb2,hb3,hb4);
        vb.setSpacing(5);
        vb.setAlignment(Pos.CENTER_RIGHT);
        
        GridPane mainPane = new GridPane();
        mainPane.addRow(0, vb);
        mainPane.setId("actiontarget");
        mainPane.setAlignment(Pos.CENTER);
        mainPane.setStyle("-fx-background-color: beige;"
                + "-fx-background-size: 100% 100%;" + "-fx-background-attachment: fixed;"
                + "fx-background-position: center;");

        Scene sc = new Scene(mainPane, 700, 500);
        st.setScene(sc);
        st.setTitle("Add Edge");
        st.show();

        LocationRW rw = new LocationRW();
        
          for (Loc l : rw.readLoc()) {
         source = rw.checkLoc(srcField.getText());
         destination = rw.checkLoc(destField.getText());
        }
          
         
         graph = new Graph(vertices);
        
           
        back.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent arg0) {
                (new ViewLocs()).show(st);
                st.show();
            }
        });

        add.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent arg0) {
                graph.addEdge(source, destination, Integer.parseInt(distField.getText()));
                      (new AdminView()).show(st);
                st.show();
            }
        });

    }

}
