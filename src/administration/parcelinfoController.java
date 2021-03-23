package administration;

import java.net.URL;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;

public class parcelinfoController implements Initializable{
    
    @FXML
    private AnchorPane parcel_info_anchor;

    @FXML
    private Button parcelorder_info;

    @FXML
    private Button return_info;
    
    @FXML
    private TableView<Modeltable> parcel_info;
    
    @FXML
    private TableColumn<Modeltable, String> pickup_point;

    @FXML
    private TableColumn<Modeltable, String> destination_send;

    @FXML
    private TableColumn<Modeltable, String> weight;

    @FXML
    private TableColumn<Modeltable, String> token_send;

    @FXML
    private TableColumn<Modeltable, String> cost;

    Connection con;
    PreparedStatement pst;
    ResultSet rs;

    ObservableList<Modeltable> oblist = FXCollections.observableArrayList();

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://localhost/courier_db", "root", "");

            pst = con.prepareStatement("select Pickup_point, Destination_point, Weight, token_no, cost from users_info");

            rs = pst.executeQuery();
            while(rs.next()) {
                oblist.add(new Modeltable(rs.getString("Pickup_point"), rs.getString("Destination_point"), rs.getString("Weight"), rs.getString("token_no"), rs.getString("cost")));
            }
        } catch (ClassNotFoundException e) {
            //TODO: handle exception
            e.printStackTrace();
        } catch(SQLException e) {
            e.printStackTrace();
        }

        pickup_point.setCellValueFactory(new PropertyValueFactory<>("pickup"));
        destination_send.setCellValueFactory(new PropertyValueFactory<>("destination"));
        weight.setCellValueFactory(new PropertyValueFactory<>("weight"));
        token_send.setCellValueFactory(new PropertyValueFactory<>("token"));
        cost.setCellValueFactory(new PropertyValueFactory<>("cost"));

        parcel_info.setItems(oblist);
    }

}
