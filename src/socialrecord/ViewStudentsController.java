package socialrecord;

import java.net.URL;
import java.sql.Date;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;

/**
 * FXML Controller class
 *
 * @author Munyaradzi Nyamajiwa
 */
public class ViewStudentsController implements Initializable 
{

    @FXML
    private TableView<Student> tblDisplay;
    @FXML
    private TableColumn<Student, Integer> colID;
    @FXML
    private TableColumn<Student, String> colFirstName;
    @FXML
    private TableColumn<Student, String> colLastName;
    @FXML
    private TableColumn<Student, Date> colDate;
    @FXML
    private TableColumn<Student, String> colHomeAddress;
    @FXML
    private TableColumn<Student, String> colKnownAddress;
    @FXML
    private TableColumn<Student, Integer> colPosition;
    @FXML
    private TableColumn<Student, Integer> colChildren;
    @FXML
    private TableColumn<Student, Integer> colPhoneNumber;
    @FXML
    private TableColumn<Student, String> colParentName;
    @FXML
    private TableColumn<Student, String> colOccupation;
    @FXML
    private TextField txtSearch;
    @FXML
    private Button btnClear;
    @FXML
    private Button btnDashboard;
    @Override
    public void initialize(URL url, ResourceBundle rb) 
    {
        // TODO
    }        
}
