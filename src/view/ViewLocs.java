package view;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import model.RW.LocationRW;
import model.base.Loc;

public class ViewLocs {

    private Loc loc;

    public ViewLocs(Loc loc) {
        this.loc = loc;
    }

    public ViewLocs() {
        super();
    }

    public void show(Stage st) {

        LocationRW rw = new LocationRW();

        Button back = new Button("Return");
        back.setStyle("-fx-border-color: green; -fx-border-width: 5px; -fx-background-color: beige; -fx-text-fill: green;");

        Button addEdge = new Button("Add Edge");
        addEdge.setStyle("-fx-border-color: green; -fx-border-width: 5px; -fx-background-color: beige; -fx-text-fill: green;");

        VBox vb = new VBox();
        vb.getChildren().addAll(back, addEdge);
        vb.setSpacing(5);
        vb.setAlignment(Pos.CENTER);
        GridPane gp = new GridPane();
        gp.setHgap(20);
        gp.setVgap(20);
        gp.setPadding(new Insets(5, 5, 5, 5));
        gp.setAlignment(Pos.CENTER);

        GridPane mainPane = new GridPane();
        mainPane.addRow(0, vb);
        mainPane.setId("actiontarget");
        mainPane.setAlignment(Pos.CENTER);
        mainPane.setStyle("-fx-background-color: beige;"
                + "-fx-background-size: 100% 100%;" + "-fx-background-attachment: fixed;"
                + "fx-background-position: center;");

        Scene sc = new Scene(mainPane, 700, 500);
        st.setScene(sc);
        st.setTitle("View Locations");
        st.show();

        for (Loc l : rw.readLoc()) {
            vb.getChildren().add(new Text(l.toString()));
        }

        back.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent arg0) {
                (new AdminView()).show(st);
                st.show();
            }
        });

        addEdge.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent arg0) {
                (new AddEdgeView()).show(st);
                st.show();
            }
        });

    }

}
