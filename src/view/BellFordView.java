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
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import model.RW.LocationRW;
import model.base.Client;
import model.base.GenericUser;
import model.base.Graph;
import model.base.Loc;
import view.Login;

public class BellFordView {

    private Client generic;
    Loc source;
    Graph graph;

    public BellFordView(Client generic) {
        this.generic = generic;
    }

    public BellFordView() {
        super();
    }

    public void show(Stage st) {

        LocationRW rw = new LocationRW();

        Label src = new Label("Source Node: ");
        TextField srcF = new TextField();

        source = rw.checkLoc(srcF.getText());

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
         
                
            }
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
