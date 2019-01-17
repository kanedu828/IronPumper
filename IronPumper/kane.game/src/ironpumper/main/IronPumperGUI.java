package ironpumper.main;
import ironpumper.buttons.BenchButton;
import ironpumper.buttons.CurlButton;
import ironpumper.buttons.MainButton;
import ironpumper.utility.ButtonUtility;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;
import javafx.scene.paint.ImagePattern;
import javafx.scene.shape.Circle;
import javafx.stage.Stage;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Timer;


public class IronPumperGUI extends Application {

    public static void main(String[] args) {
        IronPumperGUI connect = new IronPumperGUI();
        connect.createConnection();
        Timer timer = new Timer();
        timer.schedule(new ironpumper.buttons.BenchButton(), 0, 5000);
        timer.schedule(new CurlButton(),0, 5000);
        launch(args);
    }

    private void createConnection() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver"); //This statement may be different depending on driver version
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }


        @Override
        public void start (Stage primaryStage) throws FileNotFoundException {
            Stage gameWindow = primaryStage;
            gameWindow.setTitle("IRON PUMPER");

            //Create the bicep button
            String mainURL = "C:\\Users\\kaned\\OneDrive\\Desktop\\code\\Personal\\IronPumper\\IronPumperImages\\bicep.jpg";
            Button mainButton = ButtonUtility.createButton(mainURL,100,100);
            MainButton mainClick = new MainButton();
            mainButton.setOnAction(mainClick);



            //Create the curls button
            String curlUrl = "C:\\Users\\kaned\\OneDrive\\Desktop\\code\\Personal\\IronPumper\\IronPumperImages\\bicepcurl.png";
            Button curlButton = ButtonUtility.createButton(curlUrl, 30, 20);
            CurlButton curlClick = new CurlButton();
            curlButton.setOnAction(curlClick);


            //Create the bench button
            String benchURL = "C:\\Users\\kaned\\OneDrive\\Desktop\\code\\Personal\\IronPumper\\IronPumperImages\\bench-press.png";
            Button benchButton = ButtonUtility.createButton(benchURL,30,20);
            BenchButton benchClick = new BenchButton();
            benchButton.setOnAction(benchClick);

            //Creating Menu
            ChoiceBox<String> menu = new ChoiceBox<>();
            menu.getItems().addAll("New Game", "Resume Game");

            //Layout for buttons
            FlowPane flow = new FlowPane();
            flow.setPadding(new Insets(5, 0, 5, 0));
            flow.setVgap(4);
            flow.setHgap(4);
            flow.setPrefWrapLength(170); // preferred width a
            flow.getChildren().addAll(curlButton,benchButton);

            String backgroundUrl = "C:\\Users\\kaned\\OneDrive\\Desktop\\code\\Personal\\IronPumper\\IronPumperImages\\gymbackground.jpg";
            BorderPane layout = new BorderPane(mainButton);
            layout.setTop(menu);
            layout.setRight(flow);

            Scene scene = new Scene(layout);


            gameWindow.setScene(scene);
            gameWindow.show();

        }


    }

