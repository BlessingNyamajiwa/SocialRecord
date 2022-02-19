package socialrecord;

import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.ImageView;

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
    private Button btnViewQuickSearch;
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
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) 
    {
        // TODO
    }

    private void loadTableData(String query)
    {
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
                list.add(new QuickSearch(rs.getInt("id"), rs.getString("fullName")));
            }
            
            tblQuickSearch.setItems(list);
            conn.close();
        }
        catch(SQLException e)
        {
            e.printStackTrace();
        }
    }
}
