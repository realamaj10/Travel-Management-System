package view;

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
import model.RW.LocationRW;
import static model.base.Category.Bar_Restaurant;
import model.base.User;

public class AddBarRestaurant {

    private User admin;

    public AddBarRestaurant(User admin) {
        this.admin = admin;
    }

    public void show(Stage st) {

        Label name = new Label("Name: ");
        name.setFont(Font.font("Book Antiqua",
                FontWeight.BOLD, 18));
        name.setTextFill(Color.CADETBLUE);
        Label nodeNo = new Label("Node number: ");
        nodeNo.setFont(Font.font("Book Antiqua",
                FontWeight.BOLD, 18));
        nodeNo.setTextFill(Color.CADETBLUE);
        Label des = new Label("Description: ");
        des.setFont(Font.font("Book Antiqua",
                FontWeight.BOLD, 18));
        des.setTextFill(Color.CADETBLUE);
        Label type = new Label("Type of Restaurant: ");
        type.setFont(Font.font("Book Antiqua",
                FontWeight.BOLD, 18));
        type.setTextFill(Color.CADETBLUE);

        TextField naField = new TextField();
        TextField desField = new TextField();
        TextField nodeNoField = new TextField();
        TextField typeField = new TextField();

        HBox bx1 = new HBox();
        bx1.getChildren().addAll(name, naField);
        bx1.setSpacing(5);
        bx1.setAlignment(Pos.CENTER);

        HBox bx2 = new HBox();
        bx2.getChildren().addAll(nodeNo, nodeNoField);
        bx2.setSpacing(5);
        bx2.setAlignment(Pos.CENTER);

        HBox bx3 = new HBox();
        bx3.getChildren().addAll(type, typeField);
        bx3.setSpacing(5);
        bx3.setAlignment(Pos.CENTER);

        HBox bx4 = new HBox(des, desField);
        bx1.getChildren().addAll(des, desField);
        bx1.setSpacing(5);
        bx1.setAlignment(Pos.CENTER);

        Button create = new Button("Create");
        create.setFont(Font.font("Book Antiqua",
                FontWeight.BOLD, 16));
        create.setTextFill(Color.CADETBLUE);
        Button back = new Button("Back");
        back.setFont(Font.font("Book Antiqua",
                FontWeight.BOLD, 16));
        back.setTextFill(Color.CADETBLUE);

        HBox bx7 = new HBox();
        bx7.getChildren().addAll(create, back);
        bx7.setSpacing(5);
        bx7.setAlignment(Pos.CENTER);

        VBox vb = new VBox();
        vb.getChildren().addAll(bx1, bx2, bx3, bx4, bx7);
        vb.setSpacing(5);
        vb.setAlignment(Pos.CENTER_RIGHT);

        GridPane mainPane = new GridPane();
        mainPane.addRow(0, vb);
        mainPane.setId("actiontarget");
        mainPane.setAlignment(Pos.CENTER_RIGHT);
        mainPane.setStyle("-fx-background-image: url('images/page.jpeg');"
                + "-fx-background-size: 100% 100%;" + "-fx-background-attachment: fixed;"
                + "fx-background-position: center;");

        Scene sc = new Scene(mainPane, 700, 500);
        st.setScene(sc);
        st.setTitle("Add Bar/Restaurant");

        //button functions
        back.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent arg0) {
                (new AdminView(admin)).show(st);
                st.show();
            }
        });
        create.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent arg0) {
                if (naField.getText() != null && nodeNoField.getText() != null
                        && desField.getText() != null && typeField.getText() != null) {

                    LocationRW loc = new LocationRW();
                    loc.addLoc(new model.base.Bar_Restaurant(naField.getText(), Integer.parseInt(nodeNoField.getText()),
                            desField.getText(), typeField.getText()));

                    (new AdminView(admin)).show(st);
                    st.show();
                }
            }

        });
    }

}
