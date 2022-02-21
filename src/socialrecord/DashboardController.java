package socialrecord;

import java.io.IOException;
import static java.lang.System.out;
import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;
import static socialrecord.GenericMethods.infoBox;

/**
 * FXML Controller class
 *
 * @author Munyaradzi Nyamajiwa
 */
public class DashboardController implements Initializable 
{

    @FXML
    private TextField txtSearch;
    @FXML
    private Button btnSearch;
    @FXML
    private TableView<QuickSearch> tblQuickSearch;
    @FXML
    private Button btnAddNew;
    @FXML
    private Button btnEditRecord;
    @FXML
    private Button btnAttendance;
    @FXML
    private Button deleteRecord;
    @FXML
    private Button viewReport;
    @FXML
    private ImageView imgLoggedUser;
    @FXML
    private Button btnLogout;
    @FXML
    private Button btnActivityLog;
    @FXML
    private Button btnSettings;
    @FXML
    private Label lblUsername;
    @FXML
    private TableColumn<QuickSearch, Integer> colID;
    @FXML
    private TableColumn<QuickSearch, String> colFullName;
    @FXML
    private Button btnViewStudent;
    
    private Parent root;
    private Stage stage;
    private Scene scene;
    @FXML
    private Button btnClear;
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) 
    {
//        loadTableData();
    }
    
    private void search(String item)
    {
        String custQuery = "";
    }

    private void loadTableData()
    {
        String query = "SELECT full_name, last_name FROM student AS fullname";
        out.println(query);
        Connection conn = DBConnection.getConnection();
        ObservableList<QuickSearch> list = FXCollections.observableArrayList();
        
        colID.setCellValueFactory(new PropertyValueFactory<>("id"));
        colID.setCellValueFactory(new PropertyValueFactory<>("fullName"));
        
        try
        {
            PreparedStatement ps = conn.prepareStatement(query);
            ResultSet rs = ps.executeQuery();
            
            while(rs.next())
            {
                list.add(new QuickSearch(rs.getInt("id"), rs.getString("fullname")));
            }
            
            tblQuickSearch.setItems(list);
            conn.close();
        }
        catch(SQLException e)
        {
            e.printStackTrace();
        }
    }

    @FXML
    private void filterTable(ActionEvent event) 
    {
        
    }

    @FXML
    private void addRecord(ActionEvent event) throws IOException
    {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("design/AddNewRecord.fxml"));
        
        root = loader.load();
        
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setTitle("Social Record | Add New Record");
        stage.setScene(scene);
        stage.show();
        stage.centerOnScreen();
    }

    @FXML
    private void viewStudent(ActionEvent event) 
    {
        
    }

    @FXML
    private void editRecord(ActionEvent event) 
    {
        
    }

    @FXML
    private void viewAttendance(ActionEvent event) 
    {
        
    }

    @FXML
    private void deleteRecord(ActionEvent event) 
    {
        
    }

    @FXML
    private void viewReports(ActionEvent event) 
    {
        
    }

    @FXML
    private void logout(ActionEvent event) throws IOException
    {
//        infoBox("INFORMATION","Logging out...","You're being signed out of your account.");
        FXMLLoader loader = new FXMLLoader(getClass().getResource("design/SocialRecord.fxml"));
        root = loader.load();
        
        // LoginController loginController = loader.getController();
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setTitle("Social Record | Login");
        stage.setScene(scene);
        stage.show();
        stage.centerOnScreen();
    }

    @FXML
    private void activityLog(ActionEvent event) {
    }

    @FXML
    private void settings(ActionEvent event) 
    {
        
    }

    @FXML
    private void clearText(ActionEvent event) 
    {
        txtSearch.setText("");
    }
}
