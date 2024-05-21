package view;

import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;
import model.base.Client;
import model.base.GenericUser;

public class GenericView {

    private Client generic;

    public GenericView(Client generic) {
        this.generic = generic;
    }

    public GenericView() {
        super();
    }
    public void show(Stage st) {
        
        //MAP

        Button dijkstra = new Button("By Dijkstra's Algorithm");
        dijkstra.setFont(Font.font("Book Antiqua",
                FontWeight.BOLD, 16));
        dijkstra.setTextFill(Color.GREEN);
        Button bellFord = new Button("By Bellman-Ford's Algorithm");
        bellFord.setFont(Font.font("Book Antiqua",
                FontWeight.BOLD, 16));
        bellFord.setTextFill(Color.GREEN);
        Button back = new Button("Go back");
        back.setFont(Font.font("Book Antiqua",
                FontWeight.BOLD, 16));
        back.setTextFill(Color.GREEN);

        VBox v1 = new VBox();
        v1.getChildren().addAll(dijkstra,bellFord, back);
        v1.setSpacing(5);
        v1.setAlignment(Pos.CENTER);

        GridPane mainPane = new GridPane();
        mainPane.addRow(0, v1);
        mainPane.setId("actiontarget");
        mainPane.setAlignment(Pos.BOTTOM_LEFT);
        mainPane.setStyle("-fx-background-image: url('images/map.jpg');"
                + "-fx-background-size: 100% 100%;" + "-fx-background-attachment: fixed;"
                + "fx-background-position: center;");

        Scene sc = new Scene(mainPane, 700, 500);
        st.setScene(sc);
        st.setTitle("Generic User View");
//
//        button functions

        dijkstra.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent arg0) {
                (new DijkstraView()).show(st);
                st.show();
            }
        });
        bellFord.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent arg0) {
                (new BellFordView()).show(st);
                st.show();
            }
        });

        back.setOnAction(new EventHandler<ActionEvent>(){
			@Override
			public void handle(ActionEvent arg0) {
				(new Login()).show(st);
				st.show();
			}
		});
    }
}
