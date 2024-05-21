package view;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;
import model.base.User;

public class AdminView {

    private User admin;

    public AdminView(User admin) {
        this.admin = admin;
    }

      public AdminView() {
       super();
    }


    public void show(Stage st) {

        TextField welcome = new TextField("Welcome to Admin View");
        welcome.setFont(Font.font("Tahoma",
                FontWeight.BOLD, 20));
        welcome.setStyle(" -fx-background-color: beige; -fx-text-fill: green; fx-background-position: center;");
        welcome.setPrefSize(280, 200);

        Button hotel = new Button("Add Hotel");
        hotel.setStyle("-fx-border-color: green; -fx-border-width: 7px; -fx-background-color: beige; -fx-text-fill: green;");
    
        Button viewUsers = new Button("View Users");
        viewUsers.setStyle("-fx-border-color: green; -fx-border-width: 7px; -fx-background-color: beige; -fx-text-fill: green;");
      
        Button viewLocs = new Button("View Locations");
        viewLocs.setStyle("-fx-border-color: green; -fx-border-width: 7px; -fx-background-color: beige; -fx-text-fill: green;");

        Button bar = new Button("Add Bar / Restaurant");
        bar.setStyle("-fx-border-color: green; -fx-border-width: 7px; -fx-background-color: beige; -fx-text-fill: green;");

        Button historic = new Button("Add Historic Spot");
        historic.setStyle("-fx-border-color: green; -fx-border-width: 7px; -fx-background-color: beige; -fx-text-fill: green;");

        Button night = new Button("Add NightLife");
        night.setStyle("-fx-border-color: green; -fx-border-width: 7px; -fx-background-color: beige; -fx-text-fill: green;");

        Button out = new Button("Add Outdoor Activity");
        out.setStyle("-fx-border-color: green; -fx-border-width: 7px; -fx-background-color: beige; -fx-text-fill: green;");
     
        Button back = new Button("Go back");
        back.setStyle("-fx-border-color: green; -fx-border-width: 7px; -fx-background-color: beige; -fx-text-fill: green;");

        GridPane gp = new GridPane();
        gp.setHgap(20);
        gp.setVgap(20);
        gp.setPadding(new Insets(5, 5, 5, 5));
        gp.setAlignment(Pos.CENTER);
        VBox vb = new VBox(hotel, bar, historic, night, out, back, viewLocs, viewUsers);
        vb.setSpacing(8);
        vb.setAlignment(Pos.CENTER);

        GridPane mainPane = new GridPane();
        welcome.setId("welcome-text");
        mainPane.addRow(0, vb);
        mainPane.setId("actiontarget");
        mainPane.setAlignment(Pos.CENTER);
        mainPane.setStyle("-fx-background-color : beige ;"
                + "-fx-background-size: 100% 100%;" + "-fx-background-attachment: fixed;"
                + "fx-background-position: center;");

        hotel.setOnAction(new EventHandler<ActionEvent>() {

            @Override
            public void handle(ActionEvent arg0) {
                (new AddHotel(admin)).show(st);
                st.show();
            }

        });
        bar.setOnAction(new EventHandler<ActionEvent>() {

            @Override
            public void handle(ActionEvent arg0) {
                (new AddBarRestaurant(admin)).show(st);
                st.show();
            }

        });
      

        viewLocs.setOnAction(new EventHandler<ActionEvent>() {

            @Override
            public void handle(ActionEvent arg0) {
                (new ViewLocs()).show(st);
                st.show();
            }

        });
        viewUsers.setOnAction(new EventHandler<ActionEvent>() {

            @Override
            public void handle(ActionEvent arg0) {
                (new ViewUsers()).show(st);
                st.show();
            }

        });

        historic.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent arg0) {
                (new AddHistoricalSpot(admin)).show(st);
                st.show();
            }
        });
        night.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent arg0) {
                (new AddNightLife(admin)).show(st);
                st.show();
            }
        });
        out.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent arg0) {
                (new AddOutdoorActivity(admin)).show(st);
                st.show();
            }
        });

        back.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent arg0) {
                (new Login()).show(st);
                st.show();
            }
        });

        Scene sc = new Scene(mainPane, 700, 500);
        st.setScene(sc);
        st.setTitle("Admin View");

    }

}
