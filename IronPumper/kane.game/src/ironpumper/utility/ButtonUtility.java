package ironpumper.utility;

import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.sql.SQLException;

public class ButtonUtility {
    public static Button createButton(String url, int width, int height) throws FileNotFoundException {
        Image bicepImage = new Image(new FileInputStream(url));
        ImageView buttonView = new ImageView(bicepImage);
        buttonView.setFitWidth(width);
        buttonView.setFitHeight(height);
        buttonView.setPreserveRatio(true);
        Button button = new Button(null, buttonView);
        return button;
    }
    public static void runButton(String quantityOf,int value){
        try {
            int quantity = DataUtility.extractData(quantityOf);
            int strength = DataUtility.extractData("strength");
            strength+=quantity*value;
            DataUtility.updateData("strength",strength);
            System.out.println(strength);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public static void handleButton(int price, String quantityOf){
        try {
            int strength = DataUtility.extractData("strength");
            if(strength>=price){
                strength -= price;
                DataUtility.updateData("strength", strength);
                int quantity = DataUtility.extractData(quantityOf);
                quantity++;
                DataUtility.updateData(quantityOf, quantity);
                System.out.println(strength);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

}
