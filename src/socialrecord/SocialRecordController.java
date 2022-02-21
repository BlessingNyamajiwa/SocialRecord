package socialrecord;

import java.io.IOException;
import static java.lang.System.out;
import java.net.URL;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import static socialrecord.GenericMethods.errorBox;
import static socialrecord.GenericMethods.infoBox;
import static socialrecord.GenericMethods.warningBox;

/**
 * FXML Controller class
 *
 * @author Munyaradzi Nyamajiwa
 */
public class SocialRecordController implements Initializable {

    @FXML
    private TextField txtUsername;
    @FXML
    private PasswordField pwdPassword;
    @FXML
    private Button btnSignin;
    @FXML
    private Button btnForgot;
    
    private Parent root;
    private Scene scene;
    private Stage stage;
    
    private static Connection conn;
    private static final String DB_URL = "jdbc:mysql://localhost:3306/social_record";

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) 
    {
        boolean status = createConnection();
        if(status)
        {
            infoBox("INFORMATION", "Connection Status","Database connection created successfully");
        }
        else
        {
            errorBox("ERROR","Database Connection Failed","Failed to create database connection");
            System.exit(0);
        }
    }

    public boolean createConnection()
    {
        try
        {
            conn = DriverManager.getConnection(DB_URL, "root", "");
            
            if(conn != null)
            {
                return true;
            }
            else
            {
                return false;
            }
        }
        catch(SQLException e)
        {
            return false;
        }
    }

    @FXML
    private void limitInput(ActionEvent event) 
    {
        
    }

    @FXML
    private void signIn(ActionEvent event) throws IOException
    {
        String uname = txtUsername.getText(), pword = pwdPassword.getText();
        
        if(uname.equals("") || pword.equals(""))
        {
            warningBox("WARNING","Incomplete fields","Please fill your credentials in order to login.");
        }
        else
        {
            try
            {
                Connection conn = DBConnection.getConnection();
                String sql = "SELECT * FROM users WHERE uname = ? AND pword = ?";
                PreparedStatement ps = conn.prepareStatement(sql);
                
                ps.setString(1, uname);
                ps.setString(2, pword);
                
                ResultSet rs = ps.executeQuery();
                
                if(rs.next())
                {
                    URL fxmlLocation = getClass().getResource("design/Dashboard.fxml");
//                    out.println(fxmlLocation);
                    FXMLLoader loader = new FXMLLoader(fxmlLocation);
                    root = loader.load();

                    // LoginController loginController = loader.getController();
                    stage = (Stage)((Node)event.getSource()).getScene().getWindow();
                    scene = new Scene(root);
                    stage.setTitle("Social Record | Admin Dashboard");
                    stage.setScene(scene);
                    stage.show();
                    stage.centerOnScreen();
                }
                else
                {
                    errorBox("ERROR", "Login Failure", "User not found. Please verify your login credentials.");
                }
                conn.close();
            }
            catch(SQLException e)
            {
                e.printStackTrace();
            }
        }
    }

    @FXML
    private void forgotPassword(ActionEvent event) 
    {
        
    }
}
