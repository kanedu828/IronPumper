package ironpumper.buttons;

import ironpumper.utility.ButtonUtility;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;

import java.util.TimerTask;

public class CurlButton extends TimerTask implements EventHandler<ActionEvent> {


    @Override
    public void run() {
        ButtonUtility.runButton("curl",1);

    }

    @Override
    public void handle(ActionEvent event) {
        ButtonUtility.handleButton(100,"curl");
    }
}
