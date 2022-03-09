import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

/**
 * @author Vasco Gomes 19921
 * @date 02/03/2022
 */
public class VBoxdemo extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    Label label1;
    Label label2;
    Button button1;
    Button button2;
    int counterLabel1 = 0;
    int counterLabel2 = 0;

    @Override
    public void start(Stage primaryStage) {
        label1= new Label(counterLabel1+"");
        label2 = new Label(counterLabel2+"");

        button1 = new Button("Increment Label 1");
        button2 = new Button("Increment Label 2");

        ButtonHandler buttonHandler = new ButtonHandler();
        button1.setOnAction(buttonHandler);
        button2.setOnAction(buttonHandler);
        VBox vBox = new VBox();
        vBox.getChildren().addAll(label1, button1, label2, button2);

        Scene scene = new Scene(vBox, 200, 100);
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    private class ButtonHandler implements EventHandler<ActionEvent> {
        @Override
        public void handle(ActionEvent event) {
            //Creates a button and casts the event.get source to a button to be used in the Alert
            Button eventSource = ((Button) event.getSource());
            //Alert alert = new Alert(Alert.AlertType.INFORMATION, eventSource.getText());
            //alert.showAndWait();

            //Checks witch Button was clicked
            //System.out.println(eventSource.getText().charAt(eventSource.getText().length() - 1));
            //Compares the object Id
            if(eventSource == button1) {
                label1.setText(++counterLabel1 + "");
            }
            else {
                label2.setText(++counterLabel2 + "");
            }
        }
    }
}
