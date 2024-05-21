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
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;
import model.base.User;

public class Quiz {

    private User PersonalizedUser;

    public Quiz(User pharm) {
        this.PersonalizedUser = pharm;
    }

    public Quiz() {
        super();
    }

    public void show(Stage st) {

        Label q1 = new Label("Are you travelling for work or for pleasure?");
        q1.setFont(Font.font("Book Antiqua",
                FontWeight.BOLD, 18));
        q1.setTextFill(Color.GREEN);

        Label q2 = new Label("Are you travelling with family or alone?");
        q2.setFont(Font.font("Book Antiqua",
                FontWeight.BOLD, 18));
        q2.setTextFill(Color.GREEN);

        Label q3 = new Label("Do you have kids?");
        q3.setFont(Font.font("Book Antiqua",
                FontWeight.BOLD, 18));
        q3.setTextFill(Color.GREEN);

        Label q4 = new Label("Do you like adventure or tradition?");
        q4.setFont(Font.font("Book Antiqua",
                FontWeight.BOLD, 18));
        q4.setTextFill(Color.GREEN);

        Label q5 = new Label("Do you like mexican,chinese,italian or albanian food?");
        q5.setFont(Font.font("Book Antiqua",
                FontWeight.BOLD, 18));
        q5.setTextFill(Color.GREEN);

        RadioButton work = new RadioButton("For work");
        work.setFont(Font.font("Book Antiqua",
                FontWeight.BOLD, 16));
        work.setTextFill(Color.GREEN);

        RadioButton pleasure = new RadioButton("For pleasure");
        pleasure.setFont(Font.font("Book Antiqua",
                FontWeight.BOLD, 16));
        pleasure.setTextFill(Color.GREEN);

        RadioButton family = new RadioButton("With family");
        family.setFont(Font.font("Book Antiqua",
                FontWeight.BOLD, 16));
        family.setTextFill(Color.GREEN);

        RadioButton alone = new RadioButton("Alone");
        alone.setFont(Font.font("Book Antiqua",
                FontWeight.BOLD, 16));
        alone.setTextFill(Color.GREEN);

        RadioButton yes = new RadioButton("Yes");
        yes.setFont(Font.font("Book Antiqua",
                FontWeight.BOLD, 16));
        yes.setTextFill(Color.GREEN);

        RadioButton no = new RadioButton("No");
        no.setFont(Font.font("Book Antiqua",
                FontWeight.BOLD, 16));
        no.setTextFill(Color.GREEN);

        RadioButton adventure = new RadioButton("Adventure");
        adventure.setFont(Font.font("Book Antiqua",
                FontWeight.BOLD, 16));
        adventure.setTextFill(Color.GREEN);

        RadioButton tradition = new RadioButton("Tradition");
        tradition.setFont(Font.font("Book Antiqua",
                FontWeight.BOLD, 16));
        tradition.setTextFill(Color.GREEN);

        RadioButton both = new RadioButton("Both");
        both.setFont(Font.font("Book Antiqua",
                FontWeight.BOLD, 16));
        both.setTextFill(Color.GREEN);

        RadioButton mexican = new RadioButton("Mexican");
        mexican.setFont(Font.font("Book Antiqua",
                FontWeight.BOLD, 16));
        mexican.setTextFill(Color.GREEN);

        RadioButton chinese = new RadioButton("Chinese");
        chinese.setFont(Font.font("Book Antiqua",
                FontWeight.BOLD, 16));
        chinese.setTextFill(Color.GREEN);

        RadioButton italian = new RadioButton("Italian");
        italian.setFont(Font.font("Book Antiqua",
                FontWeight.BOLD, 16));
        italian.setTextFill(Color.GREEN);

        RadioButton albanian = new RadioButton("Albanian");
        albanian.setFont(Font.font("Book Antiqua",
                FontWeight.BOLD, 16));
        albanian.setTextFill(Color.GREEN);

        Button back = new Button("Go back");
        back.setFont(Font.font("Book Antiqua",
                FontWeight.BOLD, 16));
        back.setTextFill(Color.GREEN);
        albanian.setTextFill(Color.GREEN);

        Button register = new Button("Register");
        register.setFont(Font.font("Book Antiqua",
                FontWeight.BOLD, 16));
        register.setTextFill(Color.GREEN);

        HBox bx1 = new HBox();
        bx1.getChildren().addAll(work, pleasure);
        bx1.setSpacing(5);
        bx1.setAlignment(Pos.CENTER);
        
        VBox v1 = new VBox();
        v1.getChildren().addAll(q1, bx1);
        v1.setSpacing(7);
        v1.setAlignment(Pos.CENTER);

        HBox bx2 = new HBox();
        bx2.getChildren().addAll(family, alone);
        bx2.setSpacing(5);
        bx2.setAlignment(Pos.CENTER);
        
        VBox v2 = new VBox();
        v2.getChildren().addAll(q2, bx2);
        v2.setSpacing(7);
        v2.setAlignment(Pos.CENTER);

        HBox bx3 = new HBox();
        bx3.getChildren().addAll(yes, no);
        bx3.setSpacing(5);
        bx3.setAlignment(Pos.CENTER);
        
        VBox v3 = new VBox();
        v3.getChildren().addAll(q3, bx3);
        v3.setSpacing(7);
        v3.setAlignment(Pos.CENTER);

        HBox bx4 = new HBox();
        bx4.getChildren().addAll(q4, adventure, tradition, both);
        bx4.setSpacing(5);
        bx4.setAlignment(Pos.CENTER);
        
        VBox v4 = new VBox();
        v4.getChildren().addAll(q4, bx4);
        v4.setSpacing(7);
        v4.setAlignment(Pos.CENTER);
        
        HBox bx5 = new HBox();
        bx5.getChildren().addAll(q5, mexican, chinese, italian, albanian);
        bx5.setSpacing(5);
        bx5.setAlignment(Pos.CENTER);
        
        VBox v5 = new VBox();
        v5.getChildren().addAll(q5, bx5);
        v5.setSpacing(7);
        v5.setAlignment(Pos.CENTER);
        
        VBox v6 = new VBox();
        v6.getChildren().addAll(back,register);
        v6.setSpacing(7);
        v6.setAlignment(Pos.CENTER);

        GridPane mainPane = new GridPane();
        mainPane.addColumn(0, v1, v2, v3, v4, v5 , v6);
        mainPane.setId("actiontarget");
        mainPane.setAlignment(Pos.CENTER);
        mainPane.setStyle("-fx-background-image: url('images/quiz.jpg');"
                + "-fx-background-size: 100% 100%;" + "-fx-background-attachment: fixed;"
                + "fx-background-position: center;");
        Scene scene = new Scene(mainPane, 800, 700);
        st.setTitle("Quiz");
        st.setScene(scene);

//        button functions


        back.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent arg0) {
                (new WantQuiz()).show(st);
                st.show();
            }
        });
        register.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent arg0) {
                (new RegisterView()).show(st);
                st.show();
            }
        });
    }
}
