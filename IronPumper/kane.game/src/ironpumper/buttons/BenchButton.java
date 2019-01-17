package ironpumper.buttons;

import ironpumper.utility.ButtonUtility;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;

import java.util.TimerTask;

public class BenchButton extends TimerTask implements EventHandler<ActionEvent> {
    @Override
    public void handle(ActionEvent event) {
        ButtonUtility.handleButton(400,"bench");
    }
    @Override
    public void run() {
        ButtonUtility.runButton("bench", 5);
    }
}
