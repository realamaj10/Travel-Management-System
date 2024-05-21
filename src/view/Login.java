package view;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.DialogPane;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import model.RW.UserRW;
import model.base.Client;
import model.base.User;
import model.base.UserType;

public class Login {

    public void show(Stage st) {

        Text[] err = new Text[2];
        err[0] = new Text("> 2 characters!!!");
        err[1] = new Text("> 2 characters!!!");
        for (int i = 0; i < err.length; i++) {
            err[i].setFont(Font.font("Times New Roman", FontWeight.BOLD, FontPosture.ITALIC, 12));
            err[i].setFill(Color.RED);
            err[i].setVisible(false);
        }
        Label welcome = new Label("Welcome to your Travel Buddy");
        welcome.setFont(Font.font("Tahoma",
                FontWeight.NORMAL, 28));
        welcome.setStyle(" -fx-background-color: white; -fx-text-fill: blue;");
        welcome.setPrefWidth(300);

        Label us = new Label("Username");
        us.setFont(Font.font("Book Antiqua",
                FontWeight.BOLD, 16));
        us.setTextFill(Color.BEIGE);
        Label pa = new Label("Password");
        pa.setFont(Font.font("Book Antiqua",
                FontWeight.BOLD, 16));
        pa.setTextFill(Color.BEIGE);

        TextField user = new TextField();
        user.setPromptText("Enter username");
        user.setOnKeyPressed(new EventHandler<KeyEvent>() {

            @Override
            public void handle(KeyEvent event) {
                if (user.getText().length() < 2) {
                    err[0].setVisible(true);
                } else {
                    err[0].setVisible(false);
                }

            }
        });

        PasswordField pass = new PasswordField();

        pass.setPromptText("Enter password");
        pass.setOnKeyPressed(new EventHandler<KeyEvent>() {

            @Override
            public void handle(KeyEvent event1) {
                if (pass.getText().length() < 2) {
                    err[1].setVisible(true);
                } else {
                    err[1].setVisible(false);
                }

            }
        });

        Button login = new Button("Login");
        login.setStyle("-fx-border-color: blue; -fx-border-width: 5px; -fx-background-color: beige; -fx-text-fill: blue;");

        Button cancel = new Button("Cancel");
        cancel.setStyle("-fx-border-color: blue; -fx-border-width: 5px; -fx-background-color: beige; -fx-text-fill: blue;");

        Button register = new Button("Register");
        register.setStyle("-fx-border-color: blue; -fx-border-width: 5px; -fx-background-color: beige; -fx-text-fill: blue;");

        HBox hb1 = new HBox(us, user, err[0]);
        hb1.setPadding(new Insets(5, 5, 5, 5));
        hb1.setAlignment(Pos.TOP_CENTER);

        HBox hb2 = new HBox(pa, pass, err[1]);
        hb2.setPadding(new Insets(5, 5, 5, 5));
        hb2.setAlignment(Pos.TOP_CENTER);

        HBox bx7 = new HBox();
        bx7.getChildren().addAll(login, cancel, register);
        bx7.setSpacing(5);
        bx7.setAlignment(Pos.CENTER);

        GridPane mainPane = new GridPane();
        welcome.setId("welcome-text");
        welcome.setFont(Font.font("Tahoma", FontWeight.NORMAL, 20));
        mainPane.addColumn(0, welcome, hb1, hb2, bx7);
        mainPane.setId("actiontarget");
        mainPane.setAlignment(Pos.TOP_CENTER);
        mainPane.setStyle("-fx-background-image: url('images/tirana.jpeg');"
                + "-fx-background-size: 100% 100%;" + "-fx-background-attachment: fixed;"
                + "fx-background-position: center;");
        Scene scene = new Scene(mainPane, 700, 500);
        st.setTitle("Login");
        st.setScene(scene);

        //BUTTON FUNCTIONS
        cancel.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent arg0) {
                System.exit(0);
            }
        });

        register.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent arg0) {
                (new WantQuiz()).show(st);
                st.show();
            }
        });

        login.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent arg0) {

                UserRW us = new UserRW();
                if (user.getText().isEmpty() || pass.getText().isEmpty()) {
                    Alert alert = new Alert(AlertType.WARNING);
                    alert.setTitle("Warning Dialog");
                    alert.setHeaderText("CAREFUL!!!");
                    alert.setContentText("Enter Data in Username and Password!!");

                    DialogPane dP = alert.getDialogPane();
                    dP.setStyle("-fx-background-color: beige;");
                    dP.getStyleClass().remove("alert");
                    GridPane grid = (GridPane) dP.lookup(".header-panel");
                    grid.setStyle("-fx-background-color: red; "
                            + "-fx-font-style: italic;"
                            + "-fx-text-fill: green");
                    alert.showAndWait();

                } else {
                    Client cli = us.checkUser(user.getText(), pass.getText());

                    if (cli == null) {
                        Alert alert = new Alert(AlertType.WARNING);
                        alert.setTitle("Warning Dialog");
                        alert.setHeaderText("CAREFUL!!!");
                        alert.setContentText("User and Password do not match!!");

                        DialogPane dP = alert.getDialogPane();
                        dP.setStyle("-fx-background-color: beige;");
                        dP.getStyleClass().remove("alert");
                        GridPane grid = (GridPane) dP.lookup(".header-panel");
                        grid.setStyle("-fx-background-color: red; "
                                + "-fx-font-style: italic;"
                                + "-fx-text-fill: green");
                        alert.showAndWait();

                    } else {
                        if (cli.getType().equals(UserType.Administrator)) {
                            (new AdminView(cli)).show(st);
                        } else if (cli.getType().equals(UserType.PersonalizedUser)) {
                            (new PersonalizedView()).show(st);
                        } else if (cli.getType().equals(UserType.GenericUser)) {
                            (new GenericView(cli)).show(st);

                        }
                    }
                }
            }
        });
    }
}
