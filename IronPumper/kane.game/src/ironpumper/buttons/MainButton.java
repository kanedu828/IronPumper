package ironpumper.buttons;

import ironpumper.utility.DataUtility;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;

import java.sql.*;

public class MainButton implements EventHandler<ActionEvent> {

    @Override
    public void handle(ActionEvent event) {
        try {
            int strength = DataUtility.extractData("strength");
            strength++;
            DataUtility.updateData("strength", strength);
            System.out.println(strength);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


}
