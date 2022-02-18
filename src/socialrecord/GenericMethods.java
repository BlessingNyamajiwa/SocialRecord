package socialrecord;

import java.io.IOException;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.stage.Stage;


public class GenericMethods 
{
    
    private Parent root;
    private Scene scene;
    private Stage stage;
    
    public static void errorBox(String headerText, String title, String message)
    {
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setContentText(message);
        alert.setTitle(title);
        alert.setHeaderText(headerText);
        alert.showAndWait();
    }
    
    public static void infoBox(String headerText, String title, String message)
    {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setContentText(message);
        alert.setTitle(title);
        alert.setHeaderText(headerText);
        alert.showAndWait();
    }
    
    public static void warningBox(String headerText, String title, String message)
    {
        Alert alert = new Alert(Alert.AlertType.WARNING);
        alert.setContentText(message);
        alert.setTitle(title);
        alert.setHeaderText(headerText);
        alert.showAndWait();
    }
}
