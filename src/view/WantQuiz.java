package view;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;
import model.base.Client;

public class WantQuiz {

    private Client cli;

    public WantQuiz(Client cli) {
        this.cli = cli;
    }

    public WantQuiz() {
        super();
    }

    public void show(Stage st) {

        Label question = new Label("Would you like to take a personalized quiz? ");
        question.setStyle(" -fx-border-width: 12px; -fx-text-fill: green;");
        question.setFont(Font.font("Book Antiqua",
                FontWeight.BOLD, 20));
        Button yes = new Button("Yes");
        yes.setStyle("-fx-border-color: green; -fx-border-width: 5px; -fx-background-color: beige; -fx-text-fill: green;");
        yes.setFont(Font.font("Book Antiqua",
                FontWeight.BOLD, 14));
        yes.setTextFill(Color.GREEN);
        Button no = new Button("No");
        no.setStyle("-fx-border-color: green; -fx-border-width: 5px; -fx-background-color: beige; -fx-text-fill: green;");
        no.setFont(Font.font("Book Antiqua",
                FontWeight.BOLD, 14));
        no.setTextFill(Color.GREEN);
        Button back = new Button("Back");
        back.setFont(Font.font("Book Antiqua",
                FontWeight.BOLD, 14));
        back.setTextFill(Color.GREEN);

        HBox hb1 = new HBox(yes, no);
        hb1.setPadding(new Insets(5, 5, 5, 5));
        hb1.setAlignment(Pos.CENTER);
        hb1.setSpacing(10);

        VBox vb = new VBox();
        vb.getChildren().addAll(question, hb1 , back);
        vb.setSpacing(5);
        vb.setAlignment(Pos.CENTER);
        vb.setStyle("-fx-background-image: url('images/background.jpeg');"
                + "-fx-background-size: 100% 100%;" + "-fx-background-attachment: fixed;"
                + "fx-background-position: center;");

        Scene sc = new Scene(vb, 700, 500);
        st.setScene(sc);
        st.setTitle("Register New User");

        //BUTTON FUNCTIONS
        yes.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent arg0) {
                (new Quiz()).show(st);
                st.show();
            }
        });

        no.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent arg0) {
                (new RegisterView()).show(st);
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

    }
}
