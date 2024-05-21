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
import model.RW.UserRW;
import model.base.Client;
import model.base.Date;
import model.base.UserType;

public class RegisterView {

    private Client cli;

    public RegisterView(Client cli) {
        this.cli = cli;
    }

    public RegisterView() {
        super();
    }

    public void show(Stage st) {

        Label username = new Label("Username: ");
        username.setFont(Font.font("Book Antiqua",
                FontWeight.BOLD, 18));
        username.setTextFill(Color.GREEN);
        Label password = new Label("Password: ");
        password.setFont(Font.font("Book Antiqua",
                FontWeight.BOLD, 18));
        password.setTextFill(Color.GREEN);

        TextField userField = new TextField();
        TextField passField = new TextField();

        HBox bx1 = new HBox();
        bx1.getChildren().addAll(username, userField);
        bx1.setSpacing(5);
        bx1.setAlignment(Pos.CENTER);

        HBox bx2 = new HBox();
        bx2.getChildren().addAll(password, passField);
        bx2.setSpacing(5);
        bx2.setAlignment(Pos.CENTER);

        Label emer = new Label("Name: ");
        emer.setFont(Font.font("Book Antiqua",
                FontWeight.BOLD, 18));
        emer.setTextFill(Color.GREEN);
        Label mbiemer = new Label("Surname: ");
        mbiemer.setFont(Font.font("Book Antiqua",
                FontWeight.BOLD, 18));
        mbiemer.setTextFill(Color.GREEN);

        TextField name = new TextField();
        TextField surname = new TextField();

        HBox bx4 = new HBox();
        bx4.getChildren().addAll(emer, name);
        bx4.setSpacing(5);
        bx4.setAlignment(Pos.CENTER);

        HBox bx5 = new HBox();
        bx5.getChildren().addAll(mbiemer, surname);
        bx5.setSpacing(5);
        bx5.setAlignment(Pos.CENTER);

        DatePicker dp = new DatePicker();
        Label date = new Label("Birthday:");
        date.setFont(Font.font("Book Antiqua",
                FontWeight.BOLD, 18));
        date.setTextFill(Color.GREEN);

        HBox bx6 = new HBox();
        bx6.getChildren().addAll(date, dp);
        bx6.setSpacing(5);
        bx6.setAlignment(Pos.CENTER);

        TextField phoneField = new TextField();
        TextField emailField = new TextField();

        Label phone = new Label("Phone number: ");
        phone.setFont(Font.font("Book Antiqua",
                FontWeight.BOLD, 18));
        phone.setTextFill(Color.GREEN);
        Label email = new Label("E-mail : ");
        email.setFont(Font.font("Book Antiqua",
                FontWeight.BOLD, 18));
        email.setTextFill(Color.GREEN);

        HBox bx8 = new HBox();
        bx8.getChildren().addAll(phone, phoneField);
        bx8.setSpacing(5);
        bx8.setAlignment(Pos.CENTER);

        HBox bx9 = new HBox();
        bx9.getChildren().addAll(email, emailField);
        bx9.setSpacing(5);
        bx9.setAlignment(Pos.CENTER);

        Button create = new Button("Create");
        create.setFont(Font.font("Book Antiqua",
                FontWeight.BOLD, 16));
        create.setTextFill(Color.GREEN);
        Button back = new Button("Back");
        back.setFont(Font.font("Book Antiqua",
                FontWeight.BOLD, 16));
        back.setTextFill(Color.GREEN);

        HBox bx7 = new HBox();
        bx7.getChildren().addAll(create, back);
        bx7.setSpacing(5);
        bx7.setAlignment(Pos.CENTER);

        VBox vb = new VBox();
        vb.getChildren().addAll(bx1, bx2, bx4, bx5, bx6, bx8, bx9, bx7);
        vb.setSpacing(5);
        vb.setAlignment(Pos.CENTER);

        GridPane mainPane = new GridPane();
        mainPane.addColumn(0, vb);
        mainPane.setId("actiontarget");
        mainPane.setAlignment(Pos.CENTER);
        mainPane.setStyle("-fx-background-image: url('images/city.jpg');"
                + "-fx-background-size: 100% 100%;" + "-fx-background-attachment: fixed;"
                + "fx-background-position: center;");
        Scene scene = new Scene(mainPane, 800, 600);
        st.setTitle("Register");
        st.setScene(scene);

        //button functions
        back.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent arg0) {
                (new WantQuiz()).show(st);
                st.show();
            }
        });
        create.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent arg0) {
                if (userField.getText() != null && passField.getText() != null
                        && name.getText() != null && surname.getText() != null
                        && dp.getValue().toString() != null
                        && email.getText() != null && phone.getText() != null) {

                    UserRW user = new UserRW();
                    
                   if (cli.getType().equals(UserType.PersonalizedUser)) {
                 user.addCli(new model.base.PersonalizedUser(userField.getText(), passField.getText(),
                            name.getText(), surname.getText(),
                            new Date(dp.getValue().toString().replace("-", "/")),
                            email.getText(), phone.getText()));
                    (new Login()).show(st);
                    st.show();
                   }else{
                    user.addCli(new model.base.GenericUser(userField.getText(), passField.getText(),
                            name.getText(), surname.getText(),
                            new Date(dp.getValue().toString().replace("-", "/")),
                            email.getText(), phone.getText()));

                    (new Login()).show(st);
                    st.show();
                   }
                }
            }

        });
    }

}
