package socialrecord;

import java.io.IOException;
import static java.lang.System.out;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author Munyaradzi Nyamajiwa
 */
public class AddNewRecordController implements Initializable 
{

    @FXML
    private Button btnSave;
    @FXML
    private Button btnClear;
    @FXML
    private Button btnBack;
    
    private Parent root;
    private Stage stage;
    private Scene scene;
    @FXML
    private TextField txtFirstName;
    @FXML
    private TextField txtLastName;
    @FXML
    private DatePicker dtpBirth;
    @FXML
    private TextField txtHomeAddress;
    @FXML
    private TextField txtKnownConditions;
    @FXML
    private TextField txtPosFamily;
    @FXML
    private TextField txtNoChildren;
    @FXML
    private TextField txtPhoneNumber;
    @FXML
    private TextField txtParentName;
    @FXML
    private TextField txtOccupation;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) 
    {
        // TODO
    }    

    @FXML
    private void saveRecord(ActionEvent event) 
    {
        
    }

    @FXML
    private void clear(ActionEvent event) 
    {
        txtFirstName.setText("");
        txtLastName.setText("");
        dtpBirth.setPromptText("DD-MM-YYYY");
        txtHomeAddress.setText("");
        txtKnownConditions.setText("");
        txtPosFamily.setText("");
        txtNoChildren.setText("");
        txtPhoneNumber.setText("");
        txtParentName.setText("");
        txtOccupation.setText("");
    }

    @FXML
    private void back(ActionEvent event) throws IOException
    {
        URL fxmlLocation = getClass().getResource("design/Dashboard.fxml");
        out.println(fxmlLocation);
        FXMLLoader loader = new FXMLLoader(fxmlLocation);
//        infoBox("INFORMATION","Logging out...","You're being signed out of your account.");
//        FXMLLoader loader = new FXMLLoader(getClass().getResource("design/SocialRecord.fxml"));
        root = loader.load();
        
        // LoginController loginController = loader.getController();
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setTitle("Social Record | Add New Record");
        stage.setScene(scene);
        stage.show();
        stage.centerOnScreen();
    }
    
}
